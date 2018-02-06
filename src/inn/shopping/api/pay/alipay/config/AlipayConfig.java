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
	//https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "2088921700888610";
	/**
	 * 商户的私钥,需要PKCS8格式，RSA公私钥生成：
	 * https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	 */
	public static String private_key = "MIIEugIBADANBgkqhkiG9w0BAQEFAASCBKQwggSgAgEAAoIBAQCD87JBraUgKstQZhyT7BzdypYirqYZnaNPhNeuqjvtAwY9Ve2SM3wnRNbV8RVp+0jWUE0UqQT8GVhQ4uVrZhD/2DI734Sn1+O7dH/Ov/oMxKGeTguLVIp8JEYdAxiFfOY2SX5akssnL11LRcVYordL5W6aeJXcGVQMblgXZI2VzYeoGusYotXSdjLytZ499d79EzH9/diywb9vq1P2jTYFyRzeRq47LLkibpcUzOZw5AxCfaSEfkNlUlo18P8/CPr4g5VAEeg57tI4sIs78g6Nbe1xHI/QeSshHyqkmjr7EwqeQc0+CYdHcm4+fIchEL2CWsq7gIilCzBO2BsB79YVAgMBAAECgf8g/MuTn9WoNQqfDugWEvEkgYEHKqJbxQ0O1CcXg3d3yUnGC7VY14YySwNqeNrho/CRo4GhqJ+WZr+teQvhzaJyU5o7XaXMUCyesIFDLrtUddPxv5EjQ/9bCbZ9ikiXFqJ27+imvAwNv8mTB95OSl+ImdMMyxir7akVcoCTWJAM4vjwZiOAPOW/GkUzDlMpdU377mLnPnXPRMBvF/bxjCyojhzAqbK5UPVOhSRLTr3xnvYJTrcGdh6JYxCDnpJQSyjmdrD9aZf6PFnz1jsTnN582iUcVeGYHSxAWTVAGv5snA5XAh02yD2m98LGp5GEpmnp53GQeDIs2qtJYoxNQwECgYEAxBIuGNafP/MtsFq6OpMmx4CVpkBAF0J9Nbyt5Yr919g/2ff9eP7dpRE/1Ar5rAOOUQ23QpdKGnzDEQFVlL9BtOl7X4OOyWNBe1YbGrxUFONAGSIo7l4D16yvnrK7WEMEZb4bR467omjzIQMSgu3ngnDjm29SYD/9fdBuPaiYU8MCgYEArEhwgqiB/e9IcWKtSsutObeMEGc4TTlaSuOb1kWC5VqeLasvZ7BAWZNE98gHFWviHJOzYJh/lOqI4ZnfEsRRYUiJ1+wYyUdcBiHUtNg+MUNLTHUHqbp6Qf5ZtYyd6JmkuRPktMu4EyGppkHAo4JJgNAxwWyHHdDaUe4yhpoaSUcCgYBGXb/tahj8+mkLQYRUQTtJnfwXDjfyIQqOnohKOPeg3xsLPtTY957T/rzJfKbd9Oi+bg22+FS/7MaU88Wi/IC4TJLaVHyKCfUWLnDLx4rldCks2/WUlmkKng7pBXv20RZi7TcdFzx/rOqUjmW2V2sehSUqQ2ls4Yo3/PWTa04/wQKBgDh9dC7Tc/RArn9HPM0mpcEkFxAV2Fcx9BJUOXfzyOzNXspYtC2KlD8K0/VvKCt0+WonYAzPVB4PHRzkKEnuB0Uf1Nrw9luhQ2JbW3SE5zed+iWyxfV4SLg031NxLSHkpydsh3RkzBGx2v/B1ZmHkfRjz7y9ijxTjBKLSRPrmaznAoGAA3vDMApWStc/6QRK7bREXVrkGTXfIMi2aNXYcdZTCsoHNAiQQ892YboaF1fmHy7yntSW8hMOynb9Dw4hf0g2ARbBlt6Al8opYCJDEp1laWUGsfpFTtMiHaLXwCSt+Qq8m9VyH1pQwIU/WtBNILWL/feAvAXE/IqGSUbfhF0ALSg=";

	// 支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlbk3s0Kl52cmj773Y2MPUpDFyhfs6G4Gfv1HO+3ALbyBtV//soer7yLEv9r0L4YoT154e4Wz9c6I6Tl+ZvPhF9p8XkGQLaOLMPvbANOErtwKEJ0Ts6g9zqISXlDb/dVF0fvkUm3FjqTUBHi3WNx6mEuIDC7xJaU78QW3XLZUYuq7cEtiQnJ2nQU+XGcbrzLt9JsPnB1o30h6A7IKgDTSLZezzCVQ6Aoj8K1aNicZL8NXaL7UW7+gIA0ePS0FKz9/CLYbXlALRRIRAtRVEPP6cqVfnDmgeSm+JdruVBgzwhavaobCAKdRzKtlR2/8g2I/oXBwKJa5Xg1uYwGK9yOLZQIDAQAB";
	// 签约卖家支付宝账号
	public static String seller_id = "m13941850400@163.com";
	
	public static String appid=" 2018011901977798";
	// 签名方式
	public static String sign_type = "RSA";

	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C://";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "UTF-8";

	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";

	//同步返回使用GET方式获取，异步通知使用POST方式获取；
	//同步返回验证有1分钟超时，异步通知验证没有时间限制。
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
