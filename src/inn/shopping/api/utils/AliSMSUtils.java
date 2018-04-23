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
		//String mobile = "18642690085";
		String mobile = "15840602341";
		String tempCode = InnApiConfig.MESSAGE_REGISTER_TEMPLATE;
		sendPaySuccessMsg(mobile, tempCode, "1230");
	}

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
	 * 支付成功发送短信
	 * @param mobile
	 * @param tempCode
	 * @param validateCode
	 * @throws 
	 * @date 2018年4月23日 下午8:24:51
	 */
	public static void sendPaySuccessMsg(String mobile, String tempCode, String validateCode) {
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
}
