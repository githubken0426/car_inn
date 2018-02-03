package inn.shopping.api.pay.alipay.config;

public enum TradeStatusEnum {
	// 交易关闭
	TRADE_CLOSED, 
	TRADE_FINISHED, // 交易完结 0
	TRADE_SUCCESS, // 支付成功 1
	WAIT_BUYER_PAY // 交易创建 0
}
