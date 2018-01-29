package inn.shopping.api.pay.alipay;

import inn.shopping.api.entity.Order;

public interface IAliPayService {
	
	/**
	 * 支付宝支付，统一下单
	 * @param orderNo 商家订单号
	 * @return 统一下单后的消息返回
	 */
	String aliUnifiedOrderRequest(Order order);	
}