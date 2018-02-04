package inn.shopping.api.pay.wxpay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import inn.shopping.api.InnApiConfig;
import inn.shopping.api.entity.Order;
import inn.shopping.api.pay.wxpay.entity.PayResultNotify;
import inn.shopping.api.pay.wxpay.entity.UnifiedOrderRequest;
import inn.shopping.api.pay.wxpay.entity.UnifiedOrderResponse;
import inn.shopping.api.pay.wxpay.utils.WxPayUtil;

@Service
public class WxPayServiceImpl implements WxPayService {

	/**
	 * 日志记录器
	 */
	private Logger logger = Logger.getLogger(WxPayServiceImpl.class);

	@Override
	public UnifiedOrderResponse unifiedOrderRequest(Order order) {
		logger.debug("<<<UnifiedOrder begin>>>");
		// 统一下单
		UnifiedOrderRequest unifiedOrderReq = new UnifiedOrderRequest();
		unifiedOrderReq.setAppid(InnApiConfig.WX_PAY.getValue("appid"));
		unifiedOrderReq.setMch_id(InnApiConfig.WX_PAY.getValue("mchid"));
		unifiedOrderReq.setNonce_str(System.currentTimeMillis() + "");
		unifiedOrderReq.setBody(InnApiConfig.INN_API.getValue("order_info"));
		unifiedOrderReq.setOut_trade_no(order.getOrderNo());
		unifiedOrderReq.setTotal_fee(WxPayUtil.yuanToFen(order.getTotalAmount()));// getPaymentFreight()
		unifiedOrderReq.setSpbill_create_ip(InnApiConfig.WX_PAY.getValue("spbillCreateIp"));
		unifiedOrderReq.setNotify_url(InnApiConfig.WX_PAY.getValue("notifyUrl"));
		unifiedOrderReq.setTrade_type("APP");
		String sign = WxPayUtil.generateUnifiedOrderSign(unifiedOrderReq);
		logger.debug("wxpay sign: " + sign);
		unifiedOrderReq.setSign(sign);

		// 发送订单数据
		String requestData = unifiedOrderReq.toXml();
		logger.debug("request data: \n" + requestData);
		String responseData = WxPayUtil.httpsRequest(InnApiConfig.WX_PAY.getValue("unifiedOrderUrl"), "POST",
				requestData);

		// 返回订单数据
		logger.debug("response data: \n" + responseData);
		UnifiedOrderResponse unifiedOrderResp = new UnifiedOrderResponse().fromXml(responseData);
		logger.info("response data to object: \n" + unifiedOrderResp);
		logger.debug("<<<UnifiedOrder end>>>");
		return unifiedOrderResp;

	}

	@Override
	public PayResultNotify unifiedOrderPayResultNotify(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 接收支付结果通知
		String requestData = WxPayUtil.getRequestContent(request);
		logger.debug("notify result: " + requestData);
		PayResultNotify payResultNotify = new PayResultNotify().fromXml(requestData);
		logger.debug("notify result to object: " + payResultNotify);
		if ("FAIL".equalsIgnoreCase(payResultNotify.getReturn_code()))
			return payResultNotify;
		// 校验通知是否信任
		boolean isTrust = isTrustNotify(payResultNotify);
		logger.debug("check notify isTrust: " + isTrust);
		if (!isTrust)
			return payResultNotify.sendReplay(response.getOutputStream(), "FAIL", "通知校验失败，不是合法的支付结果通知。");
		// 记录支付结果
		boolean isComplete = payResultHandle(payResultNotify);
		logger.debug("save PayResultNotify: " + isComplete);
		if (!isComplete)
			return payResultNotify.sendReplay(response.getOutputStream(), "FAIL", "保存支付结果失败");
		// 处理完毕，立即回复
		logger.debug("send replay");
		return payResultNotify.sendReplay(response.getOutputStream(), "SUCCESS", "OK");

	}

	public boolean isTrustNotify(PayResultNotify payResultNotify) {
		return InnApiConfig.WX_PAY.getValue("appid").equals(payResultNotify.getAppid())
				&& InnApiConfig.WX_PAY.getValue("mchid").equals(payResultNotify.getMch_id());
	}

	public boolean payResultHandle(PayResultNotify payResultNotify) {
		return false;
	}

}