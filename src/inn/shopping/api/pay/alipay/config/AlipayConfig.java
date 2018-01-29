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

	// 合作身份者ID，签约账号，以2088开头由16位纯数字组成的字符串，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String partner = "";

	/**
	 * 商户的私钥,需要PKCS8格式，RSA公私钥生成：
	 * https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	 */
	public static String private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBANuR9Ro31fQsVRNt"
			+ "7UGFqQ73YnPSybze4uwvXlp4cWvLDlJ30A9m0p0H9c8qrDzP12dA46r7aB5IM71l"
			+ "Y/6SdMiaR2xVu42RAGsRu/ylPCIcEgGcrmOK/96TzinA7f9aLVo1fyD3HaowyuTp"
			+ "n+HYSqbGNMBysPGJoH1IHvGHSyRTAgMBAAECgYEAtW4Ysq5ai2WqcuCNgGu6cxR1"
			+ "dLFDY15k8bZ+Z5FIX0KtNfWspV1YQMtYEPP42FMBcV9MAHe24/bTUfeatbs85RHN"
			+ "1RFz/5RR96XLKwUGJaWojiYR1KK0LXomnjbToPfOkXkpCmT/NFEZBpVdpnFTPK0U"
			+ "rLnm8bZpDsdgEN+DzLECQQDtrpmTV5IPy0cwLgMFxWOojRylWAMVqsB3AdM+6nzk"
			+ "HwWVZsKqZSty6ppC5axQAirEP5Vv3rSiu4c1LCbtPozrAkEA7H4D3Zw82qMOTBE7"
			+ "EnXil701HFMDJvQ3Mu+Xvj7d/W9o9+rbBpx+V9qJAzi2vE8hjGHXVsfNPrv6nW1j"
			+ "pZhMOQJAXwXT3kU/XtMdNdTfXnpI2oT3896Y9Rub8LgpFVk37xe76rv3jZn+4eWL"
			+ "IL2jwyTqpiTpgJ0fyIOCja6GLYk5WwJAIrmSKb0iNlxQ4hx5lwlWPz+aB9GsmdCs"
			+ "Nj92AYpLoEX2nMiQZpUd/Bprmdx/AIGCBJHtQ6HM4lRJxUnlotANCQJABr9NpVrT"
			+ "v2dC91k46A/c6OTwwEcEegIenS2ZU825vAcC9CnO6KUy6DeSKeVnWD5FaHOLqpBn" + "8lnjZQHWS1NZ5g==";

	// 支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDbkfUaN9X0LFUTbe1BhakO92Jz0sm83uLsL15aeHFryw5Sd9APZtKdB/XPKqw8z9dnQOOq+2geSDO9ZWP+knTImkdsVbuNkQBrEbv8pTwiHBIBnK5jiv/ek84pwO3/Wi1aNX8g9x2qMMrk6Z/h2EqmxjTAcrDxiaB9SB7xh0skUwIDAQAB";

	// 签名方式
	public static String sign_type = "RSA";

	// 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
	public static String log_path = "C://";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "UTF-8";

	// 接收通知的接口名
	public static String service = "mobile.securitypay.pay";

	// 签约卖家支付宝账号
	public static String seller_id = "open@gtercn.com";

	// 服务器异步通知页面路径
	public static String notify_url = "http://notify.msp.hk/notify.html";

	// 未付款交易的超时时间
	public static String it_b_pay = "5m";

	// 商品名称
	public static String subject = "车驿站订单";

	// 商品详情
	public static String body = "车驿站订单";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}
