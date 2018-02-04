package inn.shopping.api.pay.wxpay.entity;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class PayResultNotify {
	private String return_code;// SUCCESS/FAIL此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
	private String return_msg;// 返回信息，如非空，为错误原因签名失败参数格式校验错误
	private String appid;// 微信开放平台审核通过的应用APPID
	private String mch_id;// 微信支付分配的商户号
	private String device_info;// 微信支付分配的终端设备号
	private String nonce_str;// 随机字符串，不长于32位
	private String sign;// 签名
	private String result_code;// SUCCESS/FAIL
	private String err_code;
	private String err_code_des;
	private String openid;// 用户在商户appid下的唯一标识
	private String is_subscribe;// 用户是否关注公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效
	private String trade_type;// APP
	private String bank_type;// 银行类型
	private String total_fee;// 订单总金额，单位为分
	private String fee_type;// 货币类型
	private String cash_fee;// 现金支付金额订单现金支付金额
	private String cash_fee_type;// 货币类型
	private String coupon_fee;// 代金券或立减优惠金额<=订单总金额，订单总金额-代金券或立减优惠金额=现金支付金额
	private String coupon_count;// 代金券或立减优惠使用数量
	private String coupon_id_$n;// 代金券或立减优惠ID,$n为下标，从0开始编号
	private String coupon_fee_$n;// 单个代金券或立减优惠支付金额,$n为下标，从0开始编号
	private String transaction_id;// 微信支付订单号
	private String out_trade_no;// 商户系统的订单号，与请求一致。
	private String attach;// 商家数据包，原样返回
	private String time_end;// 支付完成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010

	public PayResultNotify sendReplay(OutputStream out, String returnCode, String returnMsg)
			throws UnsupportedEncodingException, IOException {
		PayResultReplay replay = new PayResultReplay();
		replay.setReturn_code(returnCode);
		replay.setReturn_msg(returnMsg);
		out.write(replay.toXml().getBytes("UTF-8"));
		out.flush();
		return this;
	}

	public PayResultNotify fromXml(String xmlData) {
		XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
		xStream.alias("xml", PayResultNotify.class);
		return (PayResultNotify) xStream.fromXML(xmlData);
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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String isSubscribe) {
		is_subscribe = isSubscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String tradeType) {
		trade_type = tradeType;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bankType) {
		bank_type = bankType;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String totalFee) {
		total_fee = totalFee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String feeType) {
		fee_type = feeType;
	}

	public String getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(String cashFee) {
		cash_fee = cashFee;
	}

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cashFeeType) {
		cash_fee_type = cashFeeType;
	}

	public String getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(String couponFee) {
		coupon_fee = couponFee;
	}

	public String getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(String couponCount) {
		coupon_count = couponCount;
	}

	public String getCoupon_id_$n() {
		return coupon_id_$n;
	}

	public void setCoupon_id_$n(String couponId_$n) {
		coupon_id_$n = couponId_$n;
	}

	public String getCoupon_fee_$n() {
		return coupon_fee_$n;
	}

	public void setCoupon_fee_$n(String couponFee_$n) {
		coupon_fee_$n = couponFee_$n;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transactionId) {
		transaction_id = transactionId;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String timeEnd) {
		time_end = timeEnd;
	}

	@Override
	public String toString() {
		return "PayResultNotify [appid=" + appid + ", attach=" + attach + ", bank_type=" + bank_type + ", cash_fee="
				+ cash_fee + ", cash_fee_type=" + cash_fee_type + ", coupon_count=" + coupon_count + ", coupon_fee="
				+ coupon_fee + ", coupon_fee_$n=" + coupon_fee_$n + ", coupon_id_$n=" + coupon_id_$n + ", device_info="
				+ device_info + ", err_code=" + err_code + ", err_code_des=" + err_code_des + ", fee_type=" + fee_type
				+ ", is_subscribe=" + is_subscribe + ", mch_id=" + mch_id + ", nonce_str=" + nonce_str + ", openid="
				+ openid + ", out_trade_no=" + out_trade_no + ", result_code=" + result_code + ", return_code="
				+ return_code + ", return_msg=" + return_msg + ", sign=" + sign + ", time_end=" + time_end
				+ ", total_fee=" + total_fee + ", trade_type=" + trade_type + ", transaction_id=" + transaction_id
				+ "]";
	}

}