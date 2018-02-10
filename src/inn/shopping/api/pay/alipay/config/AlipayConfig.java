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
	public static String private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC9XWWiFRZSDBxDVSsh3x7SXNZcAucjPWhgG7dJW6LpVs/v6MtkbbEXeZKGQGYH1+3a6/5y2mJuj8NaUFSVIyQZhA/jC4uGyhyYjYJMfEidPM802kl0vHdZzCO1ZM1uk/qRIYBHX423XWeenOhKV4WdYWo+QVVlNrp6HSfBQFQv5IoN4MaH7edQeCZxhV2twdT4KEZqRJmR9S/2SD78gDy9rd5r/BGoKWpjO468t3QComqaApA9+dGhKYIFCQmfrTACu0qFXeSrem/V+xnqOPA6k66HeQYlecqL6LvUAkB+pCpsZ/XO5r6SMaJauczsR2VBity7pouImDQl99kkNkrbAgMBAAECggEAScF08npwJSjeYUNs91ZmNN1ACLqAuHMUkkp5SzNL8sKDXxg3EDjBPzl03qF6nBd4Z0p/4tA4goOwPR8IssXrK50Kaw52G9vg43JKi+vkhInI0vcqoTM+8VTXm7FVanpsn9aClkobco4I6/iFaV9JhZEJxpG/5xo365QrhdO+dqBLoUpwjNJ0ESRyRJtcsiZCsNHuoSCxajkfWtIAwg/NQqz7u1S5MOS0M4Drht34fNx4DA+j4EipR2NQ1wufwpIlcBxJi8l3psYDIPMdkUeKaUaziPQZEOfq9CPp3crT2cC8tBvfTn2qzXONaInKi+UFBmFItIMVvU5lDyNkG7e0sQKBgQDjlcNbaoEcpib3D8to/Uy0Gd8/6fAnERS6vsnFKwnpJJ5DIIczuumiUX9x+pxT14DbNTMMRalHVfkTMCm4u+j+HcjovTyUh1CH6pZYrXEDDYR/cEuO8XsJJHqU+XOsnK33xizyOQoqXtxTDXfTtw5KCNT1fpXa3gJTfAxcNvUiLQKBgQDVAgNI0r0x98vD66s4XqvrGiHMKXxRLYzw0Ir56GcmQxcLRnpB3AU4pxNGI9Ve12Eig4XDUFf8cXQvvt0zqcy9UJSniuxOMXcrleJK5DGddRiu7GrsT8P8rL3xPeCJxIK9UlzB5FGVjaF2F8+sFo8LqZ0kDm64KgMwnppH4eIuJwKBgFi/7Wf315Opg6ZzBVrS9JeDQ1k0TE+fzJqqjhqSlxHREtqQk8jrifKfn3h+R3o2nuxdCaQugj3sW+5MqOh+dvSp/tAsA7TUM+Zc5/Z65IhRPCtKSlza9KTzEc6InMBidUEbiimHbtxpE7hbly/7wdnDKfD2RVANpZCS3msTj3KdAoGAWx6ATy+vNWfeJ9JxrSx6eJj2KkL45jUJHJ7pRJyRO4Hpoq4kcHXxWdnG2fNMPEUATWZb20BMUzYpUJ9iOs6BQd7tqHo6OfzZELEOW6EgRE4qH/IMj0hT+4vduQwSOHzyvJA2E89awxISJtVqxh/kU0Xcbecqn+eA89R1BRjwy3MCgYEA1D3cXhvo1ZPg0+Jg7om98uvA1+o7F5KMmuuIoYuh+bui5OqpCIyp5kqObKrEskqE8FCEBILE7VhQ7SKQUj/f+LR/B6PWdk4bQMzoKoVoRgmBaXgr8ogYmYxknZ9DUselRde8aHVOeHLnanVxaII4hZ7ZohVFwEufMhaeKit+jiM=";
	
	// 支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlbk3s0Kl52cmj773Y2MPUpDFyhfs6G4Gfv1HO+3ALbyBtV//soer7yLEv9r0L4YoT154e4Wz9c6I6Tl+ZvPhF9p8XkGQLaOLMPvbANOErtwKEJ0Ts6g9zqISXlDb/dVF0fvkUm3FjqTUBHi3WNx6mEuIDC7xJaU78QW3XLZUYuq7cEtiQnJ2nQU+XGcbrzLt9JsPnB1o30h6A7IKgDTSLZezzCVQ6Aoj8K1aNicZL8NXaL7UW7+gIA0ePS0FKz9/CLYbXlALRRIRAtRVEPP6cqVfnDmgeSm+JdruVBgzwhavaobCAKdRzKtlR2/8g2I/oXBwKJa5Xg1uYwGK9yOLZQIDAQAB";
	// 签约卖家支付宝账号
	public static String seller_id = "m13941850400@163.com";

	public static String appid = "2018011901977798";
	// 签名方式
	public static String sign_type = "RSA";

	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C://";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "UTF-8";

	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";

	// 同步返回使用GET方式获取，异步通知使用POST方式获取；
	// 同步返回验证有1分钟超时，异步通知验证没有时间限制。
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://114.215.71.170/car_inn/v1/ali/notifyurl";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "";

	// 未付款交易的超时时间
	public static String it_b_pay = "5m";

	// 商品名称
	public static String subject = "车驿站订单";

	// 商品详情
	public static String body = "车驿站订单";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	// 交易关闭
	public static final String TRADE_CLOSED = "TRADE_CLOSED";
	public static final String TRADE_FINISHED = "TRADE_FINISHED"; // 交易完结 0
	public static final String TRADE_SUCCESS = "TRADE_SUCCESS"; // 支付成功 1
	public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY"; // 交易创建 0
}
