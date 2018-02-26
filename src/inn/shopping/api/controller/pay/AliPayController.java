package inn.shopping.api.controller.pay;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;

import inn.shopping.api.entity.Order;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.pay.alipay.AliPayService;
import inn.shopping.api.pay.alipay.AliPayServiceImpl;
import inn.shopping.api.pay.alipay.config.AlipayConfig;
import inn.shopping.api.pay.alipay.config.AlipaySandBoxConfig;
import inn.shopping.api.pay.alipay.util.AlipayCore;
import inn.shopping.api.service.order.OrderService;
import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping(value = "v1/ali")
public class AliPayController {
	private Logger logger = Logger.getLogger(AliPayController.class);
	@Autowired
	private OrderService orderService;
	@Autowired
	private AliPayService aliPayService;

	/**
	 * 支付宝支付订单 订单状态1待付款,2已付款(待发货),3关闭订单(超时未付款),4已发货(待收货),
	 * 5已签收(待评价),6已评价(订单完成),7退货申请,8退货中,9已退货
	 * 
	 * @return
	 * @throws IOException
	 */
	@ResponseBody 
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public JsonView aliPayOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonView view = new JsonView();
		String orderId = request.getParameter("order_id");
		Order order = orderService.selectByPrimaryKey(orderId);
		if (null == order)
			throw new ApiException(APICode.PAYMENT_ORDER_NON_EXISTENT_CODE);
		String value=aliPayService.aliUnifiedOrderSDKRequest(order);
        view.getResult().put("key", value);
		return view;
	}
	
	/**
	 * 支付结果
	 * 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
	 * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
	 * 3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email），
	 * 4、验证app_id是否为该商户本身。上述1、2、3、4有任何一个验证不通过，则表明本次通知是异常通知，务必忽略。
	 * 在上述验证通过后商户必须根据支付宝不同类型的业务通知，正确的进行不同的业务处理，并且过滤重复的通知结果数据。
	 * 在支付宝的业务通知中，只有交易通知状态为TRADE_SUCCESS或TRADE_FINISHED时，支付宝才会认定为买家付款成功
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws AlipayApiException 
	 */
	@ResponseBody
	@RequestMapping(value = "/notifyurl", method = RequestMethod.POST)
	public void notifyurl(HttpServletRequest request, HttpServletResponse response){
		logger.debug("****************** -- notifyurl begin-- ***************");
		PrintWriter write=null;
		try {
			write=response.getWriter();
			// 从request中获得参数Map，并返回可读的Map
			Map<String, String> params = AlipayCore.getParameterMap(request);
			logger.debug("*** request params:"+params);
			if(null == params || params.size()==0) {
				write.print("fail");
				return;
			}
			// 验证支付宝签名
			// boolean aliSign = AlipayNotify.verify(params);
			// 校验签名是否正确(RSA2方式)
			/*boolean aliSign = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.input_charset,
					AlipayConfig.SIGN_RSA2);*/
			boolean aliSign = AlipaySignature.rsaCheckV1(params, AlipaySandBoxConfig.PUBLIC_KEY, AlipaySandBoxConfig.CHARSET,
					AlipaySandBoxConfig.SIGN_RSA2);
			logger.debug("*** aliSign:"+aliSign);
			if (!aliSign) {// 验证失败
				write.print("fail");
				return;
			}
			// 验证成功
			// 交易状态
			String tradeStatus = params.get("trade_status");
			String aapid = params.get("app_id");
			// 订单编号
			String orderNo = params.get("out_trade_no");
			// 支付单号
			String payNo = params.get("trade_no");
			// 支付账号
			String buyerAccount = params.get("buyer_email");
			// 支付金额
			String totalFee = params.get("total_fee");
			// 收款支付宝账号
			String sellerId = params.get("seller_id");
			/**
			 * 3、校验通知中的seller_id(或者seller_email)是否为out_trade_no这笔单据的对应的操作方(有的时候，一个商户可能有多个seller_id/seller_email),
			 * 4、验证app_id是否为该商户本身 支付宝支付状态为成功,
			 */
			logger.debug("*** tradeStatus:" + tradeStatus + ",aapid:" + aapid + ",sellerId:" + sellerId);
			if (!((AlipayConfig.TRADE_SUCCESS.equals(tradeStatus) || AlipayConfig.TRADE_FINISHED.equals(tradeStatus))
					&& AlipayConfig.appid.equals(aapid) && AlipayConfig.partner.equals(sellerId))) {
				write.print("fail");
				return;
			}
			// 1、商户需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号
			Order order = orderService.selectByOrderNo(orderNo);
			logger.debug("*** orderNo:" + orderNo +",order:" + order );
			if (null == order) {
				write.print("fail");
				return;
			}
			// 订单已支付
			if (2 == order.getOrderStatus() || 6 == order.getOrderStatus()) {
				write.print("success");
				return;
			}
			// 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额）
			BigDecimal totalFeeD = new BigDecimal(totalFee);
			logger.debug("*** totalFeeD:" + totalFeeD +",order.getPayment:" + order.getPayment());
			if (totalFeeD != order.getPayment()) {
				write.print("fail");
				return;
			}
			// 支付成功处理支付业务
			if (AlipayConfig.TRADE_SUCCESS.equals(tradeStatus))
				order.setOrderStatus(2);
			else
				order.setOrderStatus(6);
			order.setPayChannel("A");
			order.setEscrowTradeNo(payNo);
			order.setBuyerAccount(buyerAccount);
			orderService.updateUnifiedOrder(order);
			// 成功后向支付宝返回成功标志.(支付成功,扣除积分?)暂定
			write.print("success");
		} catch (Exception e) {
			e.printStackTrace();
			write.print("fail");
		}
	}
	/**
     * 
     * @param request
     * @param response
     * @param tradeno
     *            支付宝订单交易编号
     * @param orderno
     *            商家交易编号
     * @param callback
     
    @RequestMapping(value = "/pay/query", method = RequestMethod.POST)
    public void orderPayQuery(HttpServletRequest request, HttpServletResponse response, String tradeno, String orderno,
            String callback) {
        if (StringUtil.isEmpty(tradeno) && StringUtil.isEmpty(orderno)) {
            WebUtil.response(response, WebUtil.packJsonp(callback, JSON
                    .toJSONString(new JsonResult(-1, "订单号不能为空", new ResponseData()), SerializerFeatureUtil.FEATURES)));
        }

        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest(); // 统一收单线下交易查询
        // 只需要传入业务参数
        Map<String, Object> param = new HashMap<>();
        param.put("out_trade_no", orderno); // 商户订单号
        param.put("trade_no", tradeno);// 交易金额
        alipayRequest.setBizContent(JSON.toJSONString(param)); // 不需要对json字符串转义 

        Map<String, String> restmap = new HashMap<String, String>();// 返回提交支付宝订单交易查询信息
        boolean flag = false; // 查询状态
        try {
            AlipayTradeQueryResponse alipayResponse = AlipayUtil.getAlipayClient().execute(alipayRequest);
            if (alipayResponse.isSuccess()) {
                // 调用成功，则处理业务逻辑
                if ("10000".equals(alipayResponse.getCode())) {
                    // 订单创建成功
                    flag = true;
                    restmap.put("order_no", alipayResponse.getOutTradeNo());
                    restmap.put("trade_no", alipayResponse.getTradeNo());
                    restmap.put("buyer_logon_id", alipayResponse.getBuyerLogonId());
                    restmap.put("trade_status", alipayResponse.getTradeStatus());
                    LOG.info("订单查询结果：" + alipayResponse.getTradeStatus());
                } else {
                    LOG.info("订单查询失败：" + alipayResponse.getMsg() + ":" + alipayResponse.getSubMsg());
                }
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        if (flag) {
            // 订单查询成功
            WebUtil.response(response,
                    WebUtil.packJsonp(callback,
                            JSON.toJSONString(new JsonResult(1, "订单查询成功", new ResponseData(null, restmap)),
                                    SerializerFeatureUtil.FEATURES)));
        } else { // 订单查询失败
            WebUtil.response(response, WebUtil.packJsonp(callback, JSON
                    .toJSONString(new JsonResult(-1, "订单查询失败", new ResponseData()), SerializerFeatureUtil.FEATURES)));
        }
    }
    */
    /**
     * 订单退款
     * 
     * @param request
     * @param response
     * @param tradeno
     *            支付宝交易订单号
     * @param orderno
     *            商家交易订单号
     * @param callback
     
    @RequestMapping(value = "/pay/refund", method = RequestMethod.POST)
    public void orderPayRefund(HttpServletRequest request, HttpServletResponse response, String tradeno, String orderno,
            String callback) {
        LOG.info("[/pay/refund]");
        if (StringUtil.isEmpty(tradeno) && StringUtil.isEmpty(orderno)) {
            WebUtil.response(response, WebUtil.packJsonp(callback, JSON
                    .toJSONString(new JsonResult(-1, "订单号不能为空", new ResponseData()), SerializerFeatureUtil.FEATURES)));
        }

        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest(); // 统一收单交易退款接口
        // 只需要传入业务参数
        Map<String, Object> param = new HashMap<>();
        param.put("out_trade_no", orderno); // 商户订单号
        param.put("trade_no", tradeno);// 交易金额
        param.put("refund_amount", 0.01);// 退款金额
        param.put("refund_reason", "测试支付退款");// 退款金额
        param.put("out_request_no", PayUtil.getRefundNo()); //退款单号
        alipayRequest.setBizContent(JSON.toJSONString(param)); // 不需要对json字符串转义 

        Map<String, Object> restmap = new HashMap<>();// 返回支付宝退款信息
        boolean flag = false; // 查询状态
        try {
            AlipayTradeRefundResponse alipayResponse = AlipayUtil.getAlipayClient().execute(alipayRequest);
            if (alipayResponse.isSuccess()) {
                // 调用成功，则处理业务逻辑
                if ("10000".equals(alipayResponse.getCode())) {
                    // 订单创建成功
                    flag = true;
                    restmap.put("out_trade_no", alipayResponse.getOutTradeNo());
                    restmap.put("trade_no", alipayResponse.getTradeNo());
                    restmap.put("buyer_logon_id", alipayResponse.getBuyerLogonId());// 用户的登录id
                    restmap.put("gmt_refund_pay", alipayResponse.getGmtRefundPay()); // 退看支付时间
                    restmap.put("buyer_user_id", alipayResponse.getBuyerUserId());// 买家在支付宝的用户id
                    LOG.info("订单退款结果：退款成功");
                } else {
                    LOG.info("订单查询失败：" + alipayResponse.getMsg() + ":" + alipayResponse.getSubMsg());
                }
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        if (flag) {
            // 订单查询成功
            WebUtil.response(response,
                    WebUtil.packJsonp(callback,
                            JSON.toJSONString(new JsonResult(1, "订单退款成功", new ResponseData(null, restmap)),
                                    SerializerFeatureUtil.FEATURES)));
        } else { // 订单查询失败
            WebUtil.response(response, WebUtil.packJsonp(callback, JSON
                    .toJSONString(new JsonResult(-1, "订单退款失败", new ResponseData()), SerializerFeatureUtil.FEATURES)));
        }
    }
*/
    /**
     * 
     * @param request
     * @param response
     * @param orderno
     *            商家订单号
     * @param tradeno
     *            支付宝订单号
     * @param callback
     
    @RequestMapping(value = "/pay/refund/query", method = RequestMethod.POST)
    public void orderPayRefundQuery(HttpServletRequest request, HttpServletResponse response, String orderno,
            String tradeno, String callback) {
        LOG.info("[/pay/refund/query]");
        if (StringUtil.isEmpty(orderno) && StringUtil.isEmpty(tradeno)) {
            WebUtil.response(response,
                    WebUtil.packJsonp(callback,
                            JSON.toJSONString(new JsonResult(-1, "商家订单号或支付宝订单号不能为空", new ResponseData()),
                                    SerializerFeatureUtil.FEATURES)));
        }

        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest(); // 统一收单交易退款查询
        // 只需要传入业务参数
        Map<String, Object> param = new HashMap<>();
        param.put("out_trade_no", orderno); // 商户订单号
        param.put("trade_no", tradeno);// 交易金额
        param.put("out_request_no", orderno);// 请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号
        alipayRequest.setBizContent(JSON.toJSONString(param)); // 不需要对json字符串转义 

        Map<String, Object> restmap = new HashMap<>();// 返回支付宝退款信息
        boolean flag = false; // 查询状态
        try {
            AlipayTradeFastpayRefundQueryResponse alipayResponse = AlipayUtil.getAlipayClient().execute(alipayRequest);
            if (alipayResponse.isSuccess()) {
                // 调用成功，则处理业务逻辑
                if ("10000".equals(alipayResponse.getCode())) {
                    // 订单创建成功
                    flag = true;
                    restmap.put("out_trade_no", alipayResponse.getOutTradeNo());
                    restmap.put("trade_no", alipayResponse.getTradeNo());
                    restmap.put("out_request_no", alipayResponse.getOutRequestNo());// 退款订单号
                    restmap.put("refund_reason", alipayResponse.getRefundReason()); // 退款原因
                    restmap.put("total_amount", alipayResponse.getTotalAmount());// 订单交易金额
                    restmap.put("refund_amount", alipayResponse.getTotalAmount());// 订单退款金额
                    LOG.info("订单退款结果：退款成功");
                } else {
                    LOG.info("订单失败：" + alipayResponse.getMsg() + ":" + alipayResponse.getSubMsg());
                }
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        if (flag) {
            // 订单查询成功
            WebUtil.response(response,
                    WebUtil.packJsonp(callback,
                            JSON.toJSONString(new JsonResult(1, "订单退款成功", new ResponseData(null, restmap)),
                                    SerializerFeatureUtil.FEATURES)));
        } else { // 订单查询失败
            WebUtil.response(response, WebUtil.packJsonp(callback, JSON
                    .toJSONString(new JsonResult(-1, "订单退款失败", new ResponseData()), SerializerFeatureUtil.FEATURES)));
        }
    }

}
*/
}
