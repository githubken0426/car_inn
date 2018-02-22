package inn.shopping.api.pay.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：1.0
 *日期：2016-06-06
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：
	// https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088921700888610";
	/**
	 * 商户的私钥,需要PKCS8格式，RSA公私钥生成：
	 * https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	 */
	public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCc59utM4eme+D+dr0jrmW8Mo4jgh3cp6rarcsBbTcyEjZM6/DC/zcPmIzaPz3N27PEs7Nc5peZGWSNdalRfiHUiyo5CatmzzberIB4RJm0uJl+SQ6litUfRUhamguC2VTamweiI9MI2LjHsO2XVuclXmopi6o6H7rQxv5xOEklM8XQl1et1+oDODWgipKsbHSPwxcQA+olRU5cP/MxG/BNSMkPapYQ0Rdca52Aaw/mXv4Ka/QMK2jWQr+QDfGbn499iyOnISHZebYLCfouwc33T/37LtLYlO2A9RuuCVCBvUGOfeJIPdHuu14xAt7oAJVc4/ELi9Pp1THyquW9/GNvAgMBAAECggEAKb35EDPkQ6MzMR8vpD1yLUYZ0FJ+VUR5zKFtn1yJ0ZVMwtwF+iphYJHJ7wniDFEFmy/faLij3gQGXyfNOrPelifLvM7YvYok48pqhxRg+9YcZ59R+TJdDmulGw1eQJpG271go376VqEpT16/ZoKlDaj3f0P7rmjgj0hRSpeZxf58TFh5e5uzFkhJ5kVOHfaATATE0+FNSBLWXajzi3c+D9TJqtq91/riirP2WyYfeqXNM2N6Bs1ObLskjs9VCCx0HUm6wtTAaEhLHzdOby++16pOefMaXHbkTSA87yhOMt9YqovSAaqoUbR3OlVoqPoKOLL8EECFAznrGGxyI2TjiQKBgQDQEXyHOQNqch4L3pXp6Azhenk3m8NdRKXlO0xAU3uS77y9I5UCFgKKdSL0vmkABoL3QB/N9QM8AzK633XOh5ExG4TaKMe7nonYJZed9vPfIWEABvxupTGogpyYWnCSksAw2XH3+/Zs9fHTpAQB2s6MHpAq2+elDFm2t3jJ+XThvQKBgQDBDSJVpUgaV3rsENDP5MUW+VD3kaVVMY3jI1cz/18PqUym+uhn/kLoCGqMBXhLvaiMvc6O3XKKragHPtEFjtCBKAOOKIEVk03n+eEa+UQ0eLzY3FBIGoaKsami47FyyGSw0/3L8NojOvAV2jRl777b4GG2QF8cHlp0T3rXIGLumwKBgQCJ8V3m5HSQSLIE2n/3QEHx5tmgdWMTXaTCkgqehvphUxGFL6blaCQtGTWgnvBL9QU02M19JRgM3G3wmJ+o2hX3QbBVVj389EGdDGc1cfkCkEWX2AnZbSm790PMegEyG5rRiAfYCbK5UGEQGCgT9rWDDew0jfBIayS7T24EMZ883QKBgHWVN11s/z60G7WfBGArmfPFRRCVUFtUhHRdOSb9mvviBUMLPfThRAUp4yOHzV5slTWsAhy4OqTG4roPA6bb9plEMu4qM31drCzn4LjaLDW9eGCpx+gy59GgJo+FGbas4c9mP4YxG9wrcMIOlq2j2d74iutDx+pLfpKrOkm/eyKTAoGAVsXS6xc/2dnrUWwv8uq7dqs7xyUJSRTiBwIn75uWgwbqgGFtEEg62UIZ8r3gwYoLov6UjwIJ5uQvuMJIQkrEU4hKh8nQuPP6YLGcfGeYRws/qsKj7lReC5xd3yab6WDhVdogpstzvJu07g9OwMpUlBIdI8UJBVpoHmmruD7F8wQ=";

	// 支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlbk3s0Kl52cmj773Y2MPUpDFyhfs6G4Gfv1HO+3ALbyBtV//soer7yLEv9r0L4YoT154e4Wz9c6I6Tl+ZvPhF9p8XkGQLaOLMPvbANOErtwKEJ0Ts6g9zqISXlDb/dVF0fvkUm3FjqTUBHi3WNx6mEuIDC7xJaU78QW3XLZUYuq7cEtiQnJ2nQU+XGcbrzLt9JsPnB1o30h6A7IKgDTSLZezzCVQ6Aoj8K1aNicZL8NXaL7UW7+gIA0ePS0FKz9/CLYbXlALRRIRAtRVEPP6cqVfnDmgeSm+JdruVBgzwhavaobCAKdRzKtlR2/8g2I/oXBwKJa5Xg1uYwGK9yOLZQIDAQAB";

	// 签约卖家支付宝账号
	public static String seller_id = "m13941850400@163.com";

	public static String appid = "2018011901977798";
	// 签名方式
	public static String sign_type = "RSA";
	
	public static String SIGN_RSA2 = "RSA2";

	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C://";
	
    // 支付类型 必填，不能修改
	public static String payment_type = "1";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "UTF-8";

	// 调用的接口名，无需修改
	public static String service = "create_direct_pay_by_user";
	
	public static String method="alipay.trade.app.pay";

	// 同步返回使用GET方式获取，异步通知使用POST方式获取；114.215.71.170
	// 同步返回验证有1分钟超时，异步通知验证没有时间限制。
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://inn.ngrok.xiaomiqiu.cn/car_inn/v1/ali/notifyurl";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "";

	// 未付款交易的超时时间
	public static String timeout_express = "5m";

	// 商品名称
	public static String subject = "车驿站订单";

	// 商品详情
	public static String body = "车驿站订单";
	
	public static final String gateway = "https://mapi.alipay.com/gateway.do";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	// 交易关闭
	public static final String TRADE_CLOSED = "TRADE_CLOSED";
	public static final String TRADE_FINISHED = "TRADE_FINISHED"; // 交易完结 0
	public static final String TRADE_SUCCESS = "TRADE_SUCCESS"; // 支付成功 1
	public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY"; // 交易创建 0
}
