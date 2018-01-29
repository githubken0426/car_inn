package inn.shopping.api.pay.alipay;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import inn.shopping.api.InnApiConfig;
import inn.shopping.api.entity.Order;
import inn.shopping.api.pay.alipay.config.AlipayConfig;
import inn.shopping.api.pay.alipay.sign.RSA;

@Service
public class AliPayService implements IAliPayService {

	/**
	 * 日志记录器
	 */
	private Logger logger = Logger.getLogger(AliPayService.class);

	@Override
	public String aliUnifiedOrderRequest(Order order) {
		logger.debug("<<<aliUnifiedOrder begin>>>");
		// 支付宝统一下单
		String sb = getOrderInfo(order.getPayment(), order.getOrderNo());
		String sign = "";
		try {
			// 仅需对sign 做URL编码
			sign = URLEncoder.encode(RSA.sign(sb.toString(), AlipayConfig.private_key, "utf-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb += "&sign=" + "\"" + sign + "\"";
		sb += "&sign_type=" + "\"" + AlipayConfig.sign_type + "\"";
		return sb;
	}

	/**
	 * 订单信息
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param body
	 * @param price
	 * @return
	 */
	public String getOrderInfo(BigDecimal price, String orderNo) {
		// 签约合作者身份ID
		String orderInfo = "partner=" + "\"" + InnApiConfig.ALI_PAY.getValue("pid") + "\"";
		// 签约卖家支付宝账号
		orderInfo += "&seller_id=" + "\"" + AlipayConfig.seller_id + "\"";
		// 商户网站唯一订单号
		orderInfo += "&out_trade_no=" + "\"" + orderNo + "\"";
		// 商品名称
		orderInfo += "&subject=" + "\"" + AlipayConfig.subject + "\"";
		// 商品详情
		orderInfo += "&body=" + "\"" + AlipayConfig.body + "\"";
		// 商品金额
		orderInfo += "&total_fee=" + "\"" + price + "\"";
		// 接口名称
		orderInfo += "&service=" + "\"" + AlipayConfig.service + "\"";
		// 参数编码字符集
		orderInfo += "&_input_charset=" + "\"" + AlipayConfig.input_charset + "\"";
		// 服务器异步通知页面路径
		orderInfo += "&notify_url=" + "\"" + AlipayConfig.notify_url + "\"";
		// 支付类型
		orderInfo += "&payment_type=" + "\"" + "1" + "\"";
		// appId
		orderInfo += "&app_id=" + "\"" + InnApiConfig.ALI_PAY.getValue("appid") + "\"";
		// 未付款交易的超时时间
		orderInfo += "&it_b_pay=" + "\"" + AlipayConfig.it_b_pay + "\"";
		return orderInfo;
	}
}