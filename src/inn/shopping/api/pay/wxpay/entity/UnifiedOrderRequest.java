package inn.shopping.api.pay.wxpay.entity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class UnifiedOrderRequest {

	private String appid; // 应用ID（32）
	private String mch_id; // 商户号（32）
	private String device_info; // 设备号（32）选填
	private String nonce_str; // 随机字符串（32）
	private String sign; // 签名（32）
	private String body; // 商品描述（128）
	private String detail; // 商品详情（8192）
	private String attach; // 附加数据（127）选填
	private String out_trade_no; // 商户订单号（32）
	private String fee_type; // 货币类型（16）选填
	private String total_fee; // 总金额（单位：分）
	private String spbill_create_ip;// 终端IP（16）
	private String time_start; // 交易起始时间（14），格式：yyyyMMddHHmmss，选填
	private String time_expire; // 交易结束时间（14），格式：yyyyMMddHHmmss，选填
	private String goods_tag; // 商品标记（32）选填
	private String notify_url; // 通知地址（256）
	private String trade_type; // 交易类型（16）
	private String limit_pay; // 指定不能使用信用卡支付（32）选填
	
	public String toXml() {
	XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));  
	xStream.alias("xml", UnifiedOrderRequest.class);
	return xStream.toXML(this);	
	
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String feeType) {
		fee_type = feeType;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String totalFee) {
		total_fee = totalFee;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbillCreateIp) {
		spbill_create_ip = spbillCreateIp;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String timeStart) {
		time_start = timeStart;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String timeExpire) {
		time_expire = timeExpire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goodsTag) {
		goods_tag = goodsTag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notifyUrl) {
		notify_url = notifyUrl;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String tradeType) {
		trade_type = tradeType;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limitPay) {
		limit_pay = limitPay;
	}

	@Override
	public String toString() {
		return "UnifiedOrderRequest [appid=" + appid + ", attach=" + attach
				+ ", body=" + body + ", detail=" + detail + ", device_info="
				+ device_info + ", fee_type=" + fee_type + ", goods_tag="
				+ goods_tag + ", limit_pay=" + limit_pay + ", mch_id=" + mch_id
				+ ", nonce_str=" + nonce_str + ", notify_url=" + notify_url
				+ ", out_trade_no=" + out_trade_no + ", sign=" + sign
				+ ", spbill_create_ip=" + spbill_create_ip + ", time_expire="
				+ time_expire + ", time_start=" + time_start + ", total_fee="
				+ total_fee + ", trade_type=" + trade_type + "]";
	}

}