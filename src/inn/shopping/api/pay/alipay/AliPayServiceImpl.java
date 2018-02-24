package inn.shopping.api.pay.alipay;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;

import inn.shopping.api.entity.Order;
import inn.shopping.api.pay.alipay.config.AlipayConfig;
import inn.shopping.api.pay.alipay.sign.RSA;
import inn.shopping.api.pay.alipay.util.AlipayCore;
import inn.shopping.api.pay.alipay.util.UtilDate;

@Service
public class AliPayServiceImpl implements AliPayService {

	/**
	 * 日志记录器
	 */
	private Logger logger = Logger.getLogger(AliPayServiceImpl.class);

	@Override
	@Deprecated
	public String aliUnifiedOrderRequest(Order order) {
		logger.debug("<---- AliPay begin ---->");
		try {
			// 支付宝统一下单
			// 公共请求参数
			Map<String, String> publicParam = new HashMap<String, String>();
			publicParam.put("app_id", AlipayConfig.appid);// 商户订单号
			publicParam.put("charset", AlipayConfig.input_charset);
			publicParam.put("format", "json");
			publicParam.put("method", AlipayConfig.method);
			publicParam.put("notify_url", AlipayConfig.notify_url);
			// 异步通知页面
			publicParam.put("sign_type", AlipayConfig.sign_type);
			publicParam.put("timestamp", UtilDate.getDateFormatter());
			publicParam.put("version", "1.0");

			// 支付业务请求参数
			Map<String, String> bussParam = new HashMap<String, String>();
			bussParam.put("body", AlipayConfig.body);// 对交易或商品的描述
			bussParam.put("out_trade_no", order.getOrderNo()); // 商户订单号
			// 销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
			bussParam.put("product_code", "QUICK_MSECURITY_PAY");
			bussParam.put("subject", AlipayConfig.subject); // 订单标题
			// 订单关闭时间
			bussParam.put("timeout_express", AlipayConfig.timeout_express);
			// 交易金额
			bussParam.put("total_amount", String.valueOf(order.getPayment()));
			Map<String, String> busSortedMap = AlipayCore.sortedMap(bussParam);
			// 业务请求参数 不需要对json字符串转义
			publicParam.put("biz_content", JSONObject.toJSONString(busSortedMap));
			
			//1.剔除参数名(和参数值)前后的空格：(正常业务下，参数值前后不应含有空格)
			//2.剔除空值参数：
			//3.排序：
			Map<String, String> sortedMap = AlipayCore.sortedMap(publicParam);
			Map<String, String> resultMap = RSA.buildRequestPara(sortedMap);
			return AlipayCore.createLinkStringEncode(resultMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 统一支付
	 * 支付宝SDK加签(RSA2)
	 */
	public String aliUnifiedOrderSDKRequest(Order order) {
		logger.debug("<---- AliPay begin ---->");

		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gateway, AlipayConfig.appid,
				AlipayConfig.private_key, "json", AlipayConfig.input_charset, AlipayConfig.alipay_public_key,
				AlipayConfig.SIGN_RSA2);
		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
		// SDK已经封装掉了公共参数，这里只需要传入业务参数。
		// 以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
		model.setSubject(AlipayConfig.subject);
		model.setBody(AlipayConfig.body);
		model.setOutTradeNo(order.getOrderNo());
		model.setTimeoutExpress(AlipayConfig.timeout_express);
		model.setSellerId(AlipayConfig.seller_id);
		model.setTotalAmount(String.valueOf(order.getPayment()));
		model.setProductCode("QUICK_MSECURITY_PAY");
		request.setBizModel(model);
		request.setNotifyUrl(AlipayConfig.notify_url);// 回调地址
		
		String orderInfo = null;
		try {
			// 这里和普通的接口调用不同，使用的是sdkExecute
			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
			// response.getBody()就是orderString 可以直接给客户端请求，无需再做处理。
			orderInfo = response.getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		logger.debug("<---- AliPay end:[" + orderInfo + "]---->");
		return orderInfo;
	}
}