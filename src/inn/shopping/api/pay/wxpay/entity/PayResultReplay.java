package inn.shopping.api.pay.wxpay.entity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class PayResultReplay {

	private String return_code;// SUCCESS/FAIL，SUCCESS表示商户接收通知成功并校验成功
	private String return_msg;// 返回信息，如非空，为错误原因：签名失败、参数格式校验错误
	
	public String toXml() {
	XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));
	xStream.alias("xml", PayResultReplay.class);	
	return xStream.toXML(this);		
	
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

	@Override
	public String toString() {
		return "PayResultReplay [return_code=" + return_code + ", return_msg="
				+ return_msg + "]";
	}

}