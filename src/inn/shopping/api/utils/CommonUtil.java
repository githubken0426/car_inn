package inn.shopping.api.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class CommonUtil {

	private static Logger logger = Logger.getLogger(CommonUtil.class);

	/**
	 * 获取uuid
	 * 
	 * @return
	 */
	public static String getUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 生成随机验证码
	 * 
	 * @return
	 */
	public static String getVerifyCode(int len) {
		String vcode = "";
		for (int i = 0; i < len; i++) {
			vcode = vcode + (int) (Math.random() * 9);
		}
		return vcode;
	}

	/**
	 * 生成订单号 G开头代码新增订单 R开头代表退单
	 * 
	 * @param length
	 * @param userId
	 * @param status
	 * @return
	 * @throws @date
	 *  2018年1月10日 下午8:11:02
	 */
	public static String generatorOrderNo(int length, String userId, String status) {
		if (StringUtils.isBlank(userId))
			return null;
		Random random = new Random();
		StringBuffer sb = new StringBuffer(status);
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(userId.length());
			sb.append(userId.charAt(number));
		}
		sb.append(System.currentTimeMillis());
		return sb.toString().toUpperCase();
	}

	/**
	 * md5加密
	 * 
	 * @param parm
	 * @return
	 */
	public static String gernateToMD5(String parm) {
		return DigestUtils.md5Hex(parm);
	}

	public static String stringCap(String str) {
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}

	/**
	 * 生成token
	 * 
	 * @param userName
	 * @return
	 */
	public static String generateToken(String userName) {
		return DigestUtils.md5Hex(userName + System.currentTimeMillis());
	}

	/**
	 * 生成签名
	 * 
	 * @param request
	 * @param token
	 * @return
	 */
	public static String generateSign(HttpServletRequest request, String token, String userId) {
		try {
			String url = request.getRequestURL().toString();
			String timestamp = request.getParameter("t");
			String input = url + userId + token + timestamp;
			logger.debug("url-> " + input);
			return DigestUtils.md5Hex(input.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String generateSign(String url, String userid, String timestamp, String token) {
		try {
			String input = url + userid + token + timestamp;
			logger.debug("url-> " + input);
			return DigestUtils.md5Hex(input.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String generateTokenFor16(String userName) {
		return generateToken(userName).substring(8, 24);
	}

	/**
	 * 获取后面的日期
	 * @param days
	 * @param format
	 * @return
	 * @throws 
	 * @date 2018年4月28日 下午1:21:22
	 */
	public static String getDaysAfterTime(int days, SimpleDateFormat format) {
		Calendar cal = Calendar.getInstance();
		// 把时间设置为当前时间-hours小时
		cal.add(Calendar.DAY_OF_MONTH, days);
		return format.format(cal.getTime());
	}
	/**
	 * 提取出手机号
	 * @param list
	 * @return
	 * @throws 
	 * @date 2018年4月28日 下午1:46:21
	 */
	public static String matcherPhone(String telephone) {
		if(StringUtils.isBlank(telephone))
			return "";
		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
		Pattern pattern = Pattern.compile(regExp);
		List<String> result = Arrays.asList(telephone.split(","));
		for (String str : result) {
			Matcher matcher = pattern.matcher(str);
			if (matcher.matches())
				return str;
		}
		return "";
	}
}