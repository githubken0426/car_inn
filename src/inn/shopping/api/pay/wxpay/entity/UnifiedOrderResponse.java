package inn.shopping.api.pay.wxpay.entity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

import inn.shopping.api.enums.APICode;

public class UnifiedOrderResponse {

	private String return_code; // 返回状态码（16）
	private String return_msg; // 返回信息（128）选填
	private String appid; // 应用APPID（32）
	private String mch_id; // 商户号（32）
	private String device_info; // 设备号（32）选填
	private String nonce_str; // 随机字符串（32）
	private String sign; // 签名（32）
	private String result_code; // 业务结果（16）
	private String err_code; // 错误代码（32）选填
	private String err_code_des;// 错误代码描述（128）选填
	private String trade_type; // 交易类型（16）
	private String prepay_id; // 预支付交易会话标识（64），微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时

	public UnifiedOrderResponse fromXml(String xmlData) {
		XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
		xStream.alias("xml", UnifiedOrderResponse.class);
		return (UnifiedOrderResponse) xStream.fromXML(xmlData);

	}

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String returnCode) {
		return_code = returnCode;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String returnMsg) {
		return_msg = returnMsg;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mchId) {
		mch_id = mchId;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String deviceInfo) {
		device_info = deviceInfo;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonceStr) {
		nonce_str = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String resultCode) {
		result_code = resultCode;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String errCode) {
		err_code = errCode;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String errCodeDes) {
		err_code_des = errCodeDes;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String tradeType) {
		trade_type = tradeType;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepayId) {
		prepay_id = prepayId;
	}

	public APICode getErrorCode() {
		if ("ORDERPAID".equalsIgnoreCase(this.err_code)) {
			return APICode.PAYMENT_ORDER_PAY_PAID_CODE;
		} else if ("ORDERCLOSED".equalsIgnoreCase(this.err_code)) {
			return APICode.PAYMENT_ORDER_PAY_CLOSE_CODE;
		} else if ("OUT_TRADE_NO_USED".equalsIgnoreCase(this.err_code)) {
			return APICode.PAYMENT_ORDER_PAY_OUT_TRADE_NO_USED_CODE;
		} else {
			return APICode.PAYMENT_ORDER_PAY_FAIL_CODE;
		}
	}

	@Override
	public String toString() {
		return "UnifiedOrderResponse [appid=" + appid + ", device_info=" + device_info + ", err_code=" + err_code
				+ ", err_code_des=" + err_code_des + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", prepay_id="
				+ prepay_id + ", result_code=" + result_code + ", return_code=" + return_code + ", return_msg="
				+ return_msg + ", sign=" + sign + ", trade_type=" + trade_type + "]";
	}

}