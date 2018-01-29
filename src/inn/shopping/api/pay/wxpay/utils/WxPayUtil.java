package inn.shopping.api.pay.wxpay.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import inn.shopping.api.InnApiConfig;
import inn.shopping.api.pay.wxpay.entity.UnifiedOrderRequest;
import inn.shopping.api.pay.wxpay.entity.UnifiedOrderResponse;

public class WxPayUtil {

	private static Logger logger = Logger.getLogger(WxPayUtil.class);

	/**
	 * 获取当前时间 yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}

	public static String yuanToFen(Object o) {
		if (o == null)
			return "0";
		String s = o.toString();
		int posIndex = -1;
		String str = "";
		StringBuilder sb = new StringBuilder();
		if (s != null && s.trim().length() > 0 && !s.equalsIgnoreCase("null")) {
			posIndex = s.indexOf(".");
			if (posIndex > 0) {
				int len = s.length();
				if (len == posIndex + 1) {
					str = s.substring(0, posIndex);
					if (str == "0") {
						str = "";
					}
					sb.append(str).append("00");
				} else if (len == posIndex + 2) {
					str = s.substring(0, posIndex);
					if (str == "0") {
						str = "";
					}
					sb.append(str).append(s.substring(posIndex + 1, posIndex + 2)).append("0");
				} else if (len == posIndex + 3) {
					str = s.substring(0, posIndex);
					if (str == "0") {
						str = "";
					}
					sb.append(str).append(s.substring(posIndex + 1, posIndex + 3));
				} else {
					str = s.substring(0, posIndex);
					if (str == "0") {
						str = "";
					}
					sb.append(str).append(s.substring(posIndex + 1, posIndex + 3));
				}
			} else {
				sb.append(s).append("00");
			}
		} else {
			sb.append("0");
		}
		str = removeZero(sb.toString());
		if (str != null && str.trim().length() > 0 && !str.trim().equalsIgnoreCase("null")) {
			return str;
		} else {
			return "0";
		}
	}

	/**
	 * 
	 * 功能描述：金额字符串转换：单位分转成单元
	 * 
	 * @param str
	 *            传入需要转换的金额字符串
	 * @return 转换后的金额字符串
	 */
	public static String fenToYuan(Object o) {
		if (o == null)
			return "0.00";
		String s = o.toString();
		int len = -1;
		StringBuilder sb = new StringBuilder();
		if (s != null && s.trim().length() > 0 && !s.equalsIgnoreCase("null")) {
			s = removeZero(s);
			if (s != null && s.trim().length() > 0 && !s.equalsIgnoreCase("null")) {
				len = s.length();
				int tmp = s.indexOf("-");
				if (tmp >= 0) {
					if (len == 2) {
						sb.append("-0.0").append(s.substring(1));
					} else if (len == 3) {
						sb.append("-0.").append(s.substring(1));
					} else {
						sb.append(s.substring(0, len - 2)).append(".").append(s.substring(len - 2));
					}
				} else {
					if (len == 1) {
						sb.append("0.0").append(s);
					} else if (len == 2) {
						sb.append("0.").append(s);
					} else {
						sb.append(s.substring(0, len - 2)).append(".").append(s.substring(len - 2));
					}
				}
			} else {
				sb.append("0.00");
			}
		} else {
			sb.append("0.00");
		}
		return sb.toString();
	}

	/**
	 * 
	 * 功能描述：去除字符串首部为"0"字符
	 * 
	 * @param str
	 *            传入需要转换的字符串
	 * @return 转换后的字符串
	 */
	public static String removeZero(String str) {
		char ch;
		String result = "";
		if (str != null && str.trim().length() > 0 && !str.trim().equalsIgnoreCase("null")) {
			try {
				for (int i = 0; i < str.length(); i++) {
					ch = str.charAt(i);
					if (ch != '0') {
						result = str.substring(i);
						break;
					}
				}
			} catch (Exception e) {
				result = "";
			}
		} else {
			result = "";
		}
		return result;
	}

	/**
	 * 生成统一下单签名
	 * 
	 * @return
	 */
	public static String generateUnifiedOrderSign(UnifiedOrderRequest unifiedOrderRequest) {
		Map<String, String> requestParmas = new TreeMap<String, String>();
		requestParmas.put("appid", unifiedOrderRequest.getAppid());
		requestParmas.put("body", unifiedOrderRequest.getBody());
		requestParmas.put("mch_id", unifiedOrderRequest.getMch_id());
		requestParmas.put("nonce_str", unifiedOrderRequest.getNonce_str());
		requestParmas.put("out_trade_no", unifiedOrderRequest.getOut_trade_no());
		requestParmas.put("total_fee", unifiedOrderRequest.getTotal_fee());
		requestParmas.put("spbill_create_ip", unifiedOrderRequest.getSpbill_create_ip());
		requestParmas.put("trade_type", unifiedOrderRequest.getTrade_type());
		requestParmas.put("notify_url", unifiedOrderRequest.getNotify_url());
		StringBuffer sb = new StringBuffer();
		for (String key : requestParmas.keySet()) {
			sb.append(key);
			sb.append("=");
			sb.append(requestParmas.get(key));
			sb.append("&");
		}
		sb.append("key=" + InnApiConfig.WX_PAY.getValue("wxPayApiKey"));
		logger.debug("SignRequestParmas-> " + sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8");
		return sign.toUpperCase();

	}

	/**
	 * 生成预支付订单签名
	 * 
	 * @return
	 */
	public static String generatePreparedOrderSign(UnifiedOrderResponse unifiedOrderResp, String currentTimeMillis) {
		Map<String, String> requestParmas = new TreeMap<String, String>();
		requestParmas.put("timestamp", currentTimeMillis);
		requestParmas.put("noncestr", unifiedOrderResp.getNonce_str());
		requestParmas.put("partnerid", unifiedOrderResp.getMch_id());
		requestParmas.put("prepayid", unifiedOrderResp.getPrepay_id());
		requestParmas.put("package", "Sign=WXPay");
		requestParmas.put("appid", unifiedOrderResp.getAppid());
		StringBuffer sb = new StringBuffer();
		for (String key : requestParmas.keySet()) {
			sb.append(key);
			sb.append("=");
			sb.append(requestParmas.get(key));
			sb.append("&");
		}
		sb.append("key=" + InnApiConfig.WX_PAY.getValue("wxPayApiKey"));
		logger.debug("SignResponseParmas-> " + sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), "UTF-8");
		return sign.toUpperCase();
	}

	/**
	 * post请求并得到返回结果
	 * 
	 * @param requestUrl
	 * @param requestMethod
	 * @param output
	 * @return
	 */
	public static String httpsRequest(String requestUrl, String requestMethod, String output) {
		try {
			URL url = new URL(requestUrl);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod(requestMethod);
			if (null != output) {
				OutputStream outputStream = connection.getOutputStream();
				outputStream.write(output.getBytes("UTF-8"));
				outputStream.close();
			}
			// 从输入流读取返回内容
			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
				buffer.append("\n");
			}
			buffer.replace(buffer.lastIndexOf("\n"), buffer.length(), "");
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			connection.disconnect();
			return buffer.toString();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

	public static String getRequestContent(HttpServletRequest request) {
		try {
			String line = null;
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			StringBuffer requestData = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				requestData.append(line);
			}
			return requestData.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
}