package inn.shopping.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import inn.shopping.api.dao.UserLoginlogMapper;
import inn.shopping.api.entity.UserLoginlog;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.utils.CommonUtil;
import inn.shopping.api.utils.Encrypt;

/**
 * 用户认证 接口签名解决方案，通过Spring拦截器方式实现。
 * 
 * @author leodengye
 * 
 */
public class ApiSignInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserLoginlogMapper logMapper;

	/**
	 * 接口过期时间
	 */
	private static final long OVERDUE_TIME = 30 * 1000;

	/**
	 * 日志记录器
	 */
	private Logger logger = Logger.getLogger(ApiSignInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws ApiException {
		logger.debug("ApiSignInterceptor.preHandle()");
		String token = request.getParameter("token");
		// 解密出userid
		String userId = Encrypt.getEncryptUserId(token);
		String timestamp = request.getParameter("t");
		String sign = request.getParameter("sign");

		// 获取最近一次登录信息
		UserLoginlog loginInfo = logMapper.getLastLogByUserId(userId);
		// 和传入的token比对
		if (loginInfo == null || (loginInfo.getToken() == null) || (!loginInfo.getToken().equals(token))) {
			throw new ApiException(APICode.USER_LOGIN_OTHER_ERROR);
		}
		/*
		 * 接口调用过期检查，为防止机器重复调用接口 服务器时间-app接口调用时间 >过期时间
		 */
		if (System.currentTimeMillis() - Long.parseLong(timestamp) > OVERDUE_TIME) {
			throw new ApiException(APICode.API_EXPIRED_CODE);
		}
		/*
		 * 首先用userid，找出用户token 然后通过MD5生成签名，签名规则为 MD5(ApiUri+userid+token+timestamp)
		 */
		String generatedSign = CommonUtil.generateSign(request, token, userId);
		logger.debug("generatedSign-> " + generatedSign);
		/*
		 * 验证接口调用身份是否合法 URL签名与服务器生成的签名进行比对
		 */
		if (!generatedSign.equals(sign)) {
			throw new ApiException(APICode.API_FAILD_SINGNOMACH_CODE);
		}
		return true;
	}
}