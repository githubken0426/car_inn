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
	 * 支付宝支付配置文件管理器，支持热加载
	 */
	public static final PropertiesManager ALI_PAY = new PropertiesManager(FileUtil.getClassesPath(new FilePathBean()) +
			"resources/aliPay.properties");

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
}