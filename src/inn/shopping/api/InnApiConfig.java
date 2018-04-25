package inn.shopping.api;

import inn.shopping.api.utils.FilePathBean;
import inn.shopping.api.utils.FileUtil;
import inn.shopping.api.utils.PropertiesManager;

/**
 * 项目配置文件，都应该放在这里
 * @author leodengye
 *
 */
public class InnApiConfig {
	
	/**
	 * 微信支付配置文件管理器，支持热加载
	 */
	public static final PropertiesManager WX_PAY = new PropertiesManager(FileUtil.getClassesPath(new FilePathBean()) +
			"resources/wxPay.properties");
	/**
	 * 短信服务
	 */
	public static final PropertiesManager SMS_PROPERTIES = new PropertiesManager(
			FileUtil.getClassesPath(new FilePathBean()) + "resources/aliSMS.properties");
	// 短信key
	public static final String MESSAGE_ACCESS_KEY = SMS_PROPERTIES.getValue("access_key");
	// 短信secret
	public static final String MESSAGE_ACCESS_SECRET = SMS_PROPERTIES.getValue("access_secret");
	// 短信签名
	public static final String MESSAGE_SIGN = "顺驾天下";
	// 短信模版
	public static final String MESSAGE_REGISTER_TEMPLATE = SMS_PROPERTIES.getValue("register_template");
	public static final String MESSAGE_PASSWORD_TEMPLATE = SMS_PROPERTIES.getValue("password_template");
	
	public static final String MESSAGE_ORDER_TEMPLATE = SMS_PROPERTIES.getValue("order_template");
	public static final String MESSAGE_DEALER_TEMPLATE = SMS_PROPERTIES.getValue("dealer_template");
	public static final String MESSAGE_DEALERSHIPPED_TEMPLATE = SMS_PROPERTIES.getValue("dealer_shipped_template");

	/**
	 * 支付宝支付配置文件管理器，支持热加载
	 
	public static final PropertiesManager ALI_PAY = new PropertiesManager(FileUtil.getClassesPath(new FilePathBean()) +
			"resources/aliPay.properties");*/

	/**
	 * 项目配置文件管理器，支持热加载
	 */
	public static final PropertiesManager INN_API = new PropertiesManager(FileUtil.getClassesPath(new FilePathBean()) +
			"resources/inn.properties");	
	
	/**
	 * 积分抵值
	 * 1积分抵值多少分钱
	 */
	public static final Integer SCORE_MONEY=Integer.valueOf(INN_API.getValue("score_money"));
	
	public static final Integer PAGE_SIZE=Integer.valueOf(INN_API.getValue("page_size"));
}