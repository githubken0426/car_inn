package inn.shopping.api.pay.wxpay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inn.shopping.api.entity.Order;
import inn.shopping.api.pay.wxpay.entity.PayResultNotify;
import inn.shopping.api.pay.wxpay.entity.UnifiedOrderResponse;

public interface WxPayService {

	/**
	 * 微信支付，统一下单
	 * 
	 * @param orderNo
	 *            商家订单号
	 * @return 统一下单后的消息返回
	 */
	UnifiedOrderResponse unifiedOrderRequest(HttpServletRequest request,Order order);

	/**
	 * 微信支付，支付结果接收并回复 接收通知校验消息的可靠性，避免接收假通知
	 * 
	 * @param request
	 * @param response
	 * @return 支付结果
	 * @throws Exception
	 */
	PayResultNotify unifiedOrderNotifyUrl(HttpServletRequest request, HttpServletResponse response)throws Exception;
}