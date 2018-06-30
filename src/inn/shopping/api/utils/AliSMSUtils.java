package inn.shopping.api.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;

import inn.shopping.api.InnApiConfig;

public class AliSMSUtils {
	public static void main(String[] args) {
		String mobile = "18642690085";
		// String mobile = "15840602341";
		//sendUserDealerMsg(mobile, "order_002", "2018-04-25",  "小波货站","2018-04-29");
		//sendDelaerMsg(mobile,"lisi","order_002", "2018-04-25");
		sendDealerShippedMsg(mobile, "order_002", "2018-04-25",  "小波货站");
		//sendUserSelfMsg(mobile, "order_002", "2018-04-25");
	}
	/**
	 * 验证码短信
	 * @param mobile
	 * @param tempCode
	 * @param validateCode
	 * @throws 
	 * @date 2018年4月28日 下午12:56:25
	 */
	public static void sendVerifyCodeMsg(String mobile, String tempCode, String validateCode) {
		try {
			String signName = InnApiConfig.MESSAGE_SIGN;// 签名名称
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", InnApiConfig.MESSAGE_ACCESS_KEY,
					InnApiConfig.MESSAGE_ACCESS_SECRET);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
			IAcsClient client = new DefaultAcsClient(profile);
			SingleSendSmsRequest request = new SingleSendSmsRequest();
			request.setSignName(signName);// 控制台创建的签名名称
			request.setTemplateCode(tempCode);// 控制台创建的模板CODE
			// 短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。
			request.setParamString("{\"code\":\"" + validateCode + "\",\"product\":\"" + signName + "\"}");
			// request.setParamString("{}");
			request.setRecNum(mobile);// 接收号码
			SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
			System.out.println(httpResponse);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用户个人接收短息
	 * @param mobile
	 * @param orderNo
	 * @param arriveDate
	 * @param dealer
	 * @param serviceDate
	 */
	public static void sendUserSelfMsg(String mobile, String orderNo, String arriveDate) {
		try {
			String signName = InnApiConfig.MESSAGE_SIGN;// 签名名称
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", InnApiConfig.MESSAGE_ACCESS_KEY,
					InnApiConfig.MESSAGE_ACCESS_SECRET);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
			IAcsClient client = new DefaultAcsClient(profile);
			SingleSendSmsRequest request = new SingleSendSmsRequest();
			request.setSignName(signName);// 控制台创建的签名名称
			request.setTemplateCode(InnApiConfig.MESSAGE_USER_SELF);
			StringBuffer sb = new StringBuffer();
			sb.append("{\"danhao\":\"");
			sb.append(orderNo);
			sb.append("\",\"daohuo\":\"");
			sb.append(arriveDate);
			sb.append("\",\"product\":\"");
			sb.append(signName);
			sb.append("\"}");
			request.setParamString(sb.toString());
			request.setRecNum(mobile);// 接收号码
			SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
			System.out.println(httpResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户订单付款后,短信接收人：用户
	 * @param mobile
	 * @param orderNo 订单号
	 * @param arriveDate  到达日期
	 * @param serviceDate 服务日期
	 * @param dealer  服务商名称
	 * @param tempCode  短信模板
	 */
	public static void sendUserDealerMsg(String mobile, String orderNo, String arriveDate, String dealer, String serviceDate) {
		try {
			String signName = InnApiConfig.MESSAGE_SIGN;// 签名名称
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", InnApiConfig.MESSAGE_ACCESS_KEY,
					InnApiConfig.MESSAGE_ACCESS_SECRET);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
			IAcsClient client = new DefaultAcsClient(profile);
			SingleSendSmsRequest request = new SingleSendSmsRequest();
			request.setSignName(signName);// 控制台创建的签名名称
			request.setTemplateCode(InnApiConfig.MESSAGE_USER_DEALER);// 控制台创建的模板CODE
			StringBuffer sb = new StringBuffer();
			// 短信模板中的变量；数字需要转换为字符串；个人用户每个变量长度必须小于15个字符。
			sb.append("{\"danhao\":\"");
			sb.append(orderNo);
			sb.append("\",\"daohuo\":\"");
			sb.append(arriveDate);
			sb.append("\",\"fuwushang\":\"");
			sb.append(dealer);
			sb.append("\",\"fuwuriqi\":\"");
			sb.append(serviceDate);
			sb.append("\",\"product\":\"");
			sb.append(signName);
			sb.append("\"}");
			request.setParamString(sb.toString());
			request.setRecNum(mobile);// 接收号码
			SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
			System.out.println(httpResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 服务商接订单（用户付款后）短信接收人：服务商
	 * @param mobile
	 * @param userName
	 * @param orderNo
	 * @param arriveDate
	 */
	public static void sendDelaerMsg(String mobile, String userName, String orderNo, String arriveDate) {
		try {
			String signName = InnApiConfig.MESSAGE_SIGN;// 签名名称
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", InnApiConfig.MESSAGE_ACCESS_KEY,
					InnApiConfig.MESSAGE_ACCESS_SECRET);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
			IAcsClient client = new DefaultAcsClient(profile);
			SingleSendSmsRequest request = new SingleSendSmsRequest();
			request.setSignName(signName);// 控制台创建的签名名称
			request.setTemplateCode(InnApiConfig.MESSAGE_DEALER);// 控制台创建的模板CODE
			StringBuffer sb = new StringBuffer();
			sb.append("{\"name\":\"");
			sb.append(userName);
			sb.append("\",\"danhao\":\"");
			sb.append(orderNo);
			sb.append("\",\"daohuo\":\"");
			sb.append(arriveDate);
			sb.append("\",\"product\":\"");
			sb.append(signName);
			sb.append("\"}");
			request.setParamString(sb.toString());
			request.setRecNum(mobile);// 接收号码
			SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
			System.out.println(httpResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 货物到达服务商，短信接收人：用户
	 * @param mobile
	 * @param orderNo
	 * @param serviceDate
	 * @param dealer
	 * @throws 
	 * @date 2018年4月28日 下午1:02:54
	 */
	public static void sendDealerShippedMsg(String mobile, String orderNo, String serviceDate, String dealer) {
		try {
			String signName = InnApiConfig.MESSAGE_SIGN;// 签名名称
			IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", InnApiConfig.MESSAGE_ACCESS_KEY,
					InnApiConfig.MESSAGE_ACCESS_SECRET);
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Sms", "sms.aliyuncs.com");
			IAcsClient client = new DefaultAcsClient(profile);
			SingleSendSmsRequest request = new SingleSendSmsRequest();
			request.setSignName(signName);// 控制台创建的签名名称
			request.setTemplateCode(InnApiConfig.MESSAGE_DEALERSHIPPED);// 控制台创建的模板CODE
			StringBuffer sb = new StringBuffer();
			sb.append("{\"danhao\":\"");
			sb.append(orderNo);
			sb.append("\",\"fuwushang\":\"");
			sb.append(dealer);
			sb.append("\",\"fuwuriqi\":\"");
			sb.append(serviceDate);
			sb.append("\",\"product\":\"");
			sb.append(signName);
			sb.append("\"}");
			request.setParamString(sb.toString());
			request.setRecNum(mobile);// 接收号码
			SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
			System.out.println(httpResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
