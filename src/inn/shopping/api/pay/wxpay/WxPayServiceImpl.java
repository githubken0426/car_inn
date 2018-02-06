package inn.shopping.api.pay.wxpay;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.InnApiConfig;
import inn.shopping.api.entity.Order;
import inn.shopping.api.pay.wxpay.entity.PayResultNotify;
import inn.shopping.api.pay.wxpay.entity.UnifiedOrderRequest;
import inn.shopping.api.pay.wxpay.entity.UnifiedOrderResponse;
import inn.shopping.api.pay.wxpay.utils.WxPayUtil;
import inn.shopping.api.service.order.OrderService;

@Service
public class WxPayServiceImpl implements WxPayService {
	@Autowired
	private OrderService orderService;
	/**
	 * 日志记录器
	 */
	private Logger logger = Logger.getLogger(WxPayServiceImpl.class);

	@Override
	public UnifiedOrderResponse unifiedOrderRequest(HttpServletRequest request,Order order) {
		logger.debug("<<<UnifiedOrder begin>>>");
		// 统一下单
		UnifiedOrderRequest unified = new UnifiedOrderRequest();
		String appid=InnApiConfig.WX_PAY.getValue("appid");
		String mchid=InnApiConfig.WX_PAY.getValue("mchid");
		String spbillCreateIp=WxPayUtil.getIpAddress(request);
		String notifyUrl=InnApiConfig.WX_PAY.getValue("notifyurl");
		
		unified.setAppid(appid);//应用号
		unified.setMch_id(mchid);
		unified.setNonce_str(System.currentTimeMillis() + "");// 16随机字符串(大小写字母加数字)
		unified.setBody("车驿站订单");
		unified.setOut_trade_no(order.getOrderNo());// 商户订单号
		unified.setTotal_fee(WxPayUtil.yuanToFen(order.getPayment()));
		unified.setSpbill_create_ip(spbillCreateIp);
		unified.setNotify_url(notifyUrl);
		unified.setTrade_type("APP");
		unified.setAttach(order.getId());//附加数据(选填)
		
		String sign = WxPayUtil.generateUnifiedOrderSign(unified);
		unified.setSign(sign);
		
		// 发送订单数据
		String requestData = unified.toXml();
		logger.debug("request data: \n" + requestData);
		String responseData = WxPayUtil.httpsRequest(InnApiConfig.WX_PAY.getValue("unifiedOrderUrl"), "POST",
				requestData);
		//返回订单数据 
		logger.debug("response data: \n" + responseData);
		UnifiedOrderResponse unifiedResponse = new UnifiedOrderResponse().fromXml(responseData);
		logger.info("response data to object: \n" + unifiedResponse);
		logger.debug("<<<UnifiedOrder end>>>");
		return unifiedResponse;
	}

	@Override
	public PayResultNotify unifiedOrderNotifyUrl(HttpServletRequest request, HttpServletResponse response) throws Exception
			{
		// 接收支付结果通知
		String requestData = WxPayUtil.getRequestContent(request);
		logger.debug("notify result: " + requestData);
		
		PayResultNotify payResultNotify = new PayResultNotify().fromXml(requestData);
		if ("FAIL".equalsIgnoreCase(payResultNotify.getReturn_code()))
			return payResultNotify;
		
		OutputStream out = response.getOutputStream();
		// 校验通知是否信任
		String appid=InnApiConfig.WX_PAY.getValue("appid");
		String mchid=InnApiConfig.WX_PAY.getValue("mchid");
		if (!(appid.equals(payResultNotify.getAppid()) && mchid.equals(payResultNotify.getMch_id())))
			return payResultNotify.sendReplay(out, "FAIL", "通知校验失败，不是合法的支付结果通知。");
		// 记录支付结果
		boolean isComplete = orderPayResultHandle(payResultNotify);
		logger.debug("save PayResultNotify: " + isComplete);
		if (!isComplete)
			return payResultNotify.sendReplay(out, "FAIL", "保存支付结果失败");
		// 处理完毕，立即回复
		return payResultNotify.sendReplay(out, "SUCCESS", "OK");
	}
	
	/**
	 * 支付结果通知处理
	 * 
	 * @param payResultNotify
	 *            支付结果通知
	 * @return true-处理成功 false-处理失败
	 */
	public boolean orderPayResultHandle(PayResultNotify payResultNotify) {
		Order order=new Order();
		order.setOrderStatus(2);
		order.setPayChannel("W");
		String transactionId=payResultNotify.getTransaction_id();
		order.setEscrowTradeNo(transactionId);
		String outTradeNo=payResultNotify.getOut_trade_no();//订单号
		order.setOrderNo(outTradeNo);
		int result = orderService.updateUnifiedOrder(order);
		if(result==1)
			return true;
		return false;
	}

}