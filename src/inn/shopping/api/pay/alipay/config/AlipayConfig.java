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
	public static String private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCemaZjOrrlXiDW" + 
			"Dbtog5eEmN98N8pGrk1SLzV3mAm8raym4jx7l2xzPMa1HRlegj5ZLF+rkSIDi++n" + 
			"IzudFaHCsvil1vwi6qKqaqT0az7UCbbgnPvYAqQkwFRwH2xDLQht+55ajrl4F39d" + 
			"LV8lgYZcs1Svit00FWxU1KlVrVDiKQDETwUfHP8uv7GDs2F5hq9hODKa7+hNl28L" + 
			"oxJjO8KxVrC7l4fFZKMWR/UTq2aXs/pDN/FpDtHDsCJWUqa86B3dZUdzl916zeyh" + 
			"dmTDodNcC6rwV8By9UCmBYPqHhhP28hewW1FeIXZ3lPnsNzYPArSaXIAOMySCkZH" + 
			"tGQ1Vj0zAgMBAAECggEACcZAaecps48ciPSpsyRBB0wAogAyOC7v1vvP2MIG/5jY" + 
			"hiR1Q8yuQ1/ggzL66EcwnoBMmR9FsGBEcdGLEABQStaK2nWobmJ1ifkul12wrpK2" + 
			"sZsbLlHjWdx8l7hoDK/O0DBsrvoS1iLkl5J/Ral45Wer9XGidl5HoebFVOFslbOG" + 
			"X2aHNwnPZJuIaOv9PlIIMIhynQg7StRPX89Ps6Efr9zZ5QWTZ4MccmnJibDgdt8O" + 
			"8Okchf+HBJ0clgyfBxyiiYj0PbrfiUOwJMmJL5kIhyhUmNSXC1l5a56ecYT3gbPQ" + 
			"BVav3Q9PXi8Ubvs/iPWsruGpG3VowTxalwf0uamz4QKBgQDOjUmA90AhV7xpS83k" + 
			"nHvu3FTPj74aouDRgE5Dh2we8hGcUsfwFSLGx9A7PFvlQpNU/w5btKEffopC74Ak" + 
			"VrsF/U7FfI+65txB68tWRUMYiKufbqYIBGXL1xNenc+DFUwuAOlCKtWUbdJrTk2u" + 
			"2QR9kO1lugh0zNCZlgdGrc2qkQKBgQDEkZnKiYhqE+16QuZNHf259HatbH7rMvJO" + 
			"8WVx8cCZGY4cd4ySGvW9yVm/1QCl63/76VUqAwTciXct27++T+MV1hsV2vJAW9Yy" + 
			"USojp54qz0OqVO9FttitVtWeqnd2cjCsnGvFtXfAtp5ooIGiOfV3iz1M6pGvIiLu" + 
			"dc8aguElgwKBgGerGBJHhoN1opYCuvMb60QGh/apQZPi3g2oZR+Vj5m0i0w3bCw+" + 
			"n3a/gO7KK6FUmdfWL+GtNhU1kLVpuZoDgdjOu0N5cjYveqsHasYA+10L83+QrHpn" + 
			"oqP9bbZWZHl5LgQE5w4Tq6DUwgCji2/PcmaHX+9nwKjGx4feegZqY0hRAoGAKPQE" + 
			"zJO23hLkyTIi9TIoaJOsHhman7nvjc7xSboKXFtcpkWp/c6sICxRDIx+JBNaiMtm" + 
			"OOiEHMZvFBjSa/4M28HNxtHk4s+/YqBSXTdQ1q5z9IrZhva/Ue3jd7kgRocn6O51" + 
			"7a0PFBF4E2hNWdUldRCHZvz/+TLtgCz/RxC5g60CgYEAxgX9YV2fLuD4HGdEAqTP" + 
			"aMttflmTkm5CziyVRv1eyz3WSKwMr7hARO4tzttk5hZv/0jcjLBGp6tnt3IzCkD/" + 
			"2WlxvNIs/m1GqcyNUr11C5W6q3UI/x0gCnPXYTu1QYs9F5BV1mda6hq5CepKhSLD" + 
			"Cxwl9KMO6zYOYuCEosYuaq4=";
	
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
