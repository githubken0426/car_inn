package inn.shopping.api.pay.alipay.config;

/* *
 *类名：AlipaySandBoxConfig
 *功能：基础配置类（沙箱环境）
 *详细：设置帐户有关信息及返回路径
 *版本：1.0
 *日期：2016-06-06
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipaySandBoxConfig {
	public static String APP_ID = "2016091200495645";
	/**
	 * 商户的私钥,需要PKCS8格式，RSA公私钥生成：
	 * https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
	 */
	public static String PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCwpaqLvdPFXqqDniAHzpfM+KAKfQF1lyxLxSSQCjpjnIXXuHfyv5pbYIlkbBkT54EZWOPQC+taSH95ONvNDUC+0YmzuyY6SjHrdsgBsKHa7BFkqKJwhqFIifPjabUOaKM+dOw3rdj6HAuuRhIHG0qb8E9KIkTmvV597OqR3/DM62sH2PfrK9Bx8vIFRvBqnEjvYZVN408z4nFrkFZ28X+u56eKeIZqRHlcuQh+rDqKrgCQkPH2zQhgP42KI9pJxkL4r0grj0rDfIyAOoQuoZWDKV/nlq3ARcttjDeFtKFtUtUQh26uJpkNRw1PKWLwjrmwfumM4xVqG3df5NqKBdLLAgMBAAECggEAeuzuP4x74C8+bZUOKSClFmg1xtayu0fV9WxdQzc65rK3mSSvo+ed3NTTB2UKFoXVmvP2pIKG5y7oNk1Q9+KvGZrrPn2P3qRfFMJ18GcgWx5IBEotsCyf88C8TZbz/fDnGMF42E5MXdBCeKYeSX++bcHPC4HJfOBu7yZ9HcI+6foHdeLkpYcD+OW+2pUOmPYw1UcoJtftT9m/5fXzuT2Vm/kyrrkqpiedX1hd5fOBB94t5tbbrXPzqUO6H5VRfNgrOYiuIpVSswmuKo69XZPdwvIdKcmaesihx3A+BuEH4lYAkCf2bB+l4V4sDaORj3jlMoRzNnLi/4vlMM0pZq5ZsQKBgQDukcckhftv++Ky034j8ltIcpgHemWpESziA3sNiZE5KBviwIDc5hBj/ZOPYoHJQAYfxFDtHfDuSMhYb6gI3p25Kk1dj+NpbsfIDy9EuMHyBKJT5OXdz6flr4OLWc9knfV8vqVddSvpyZ6UDRxEedu1F9EciRwMutDcBtQJ3LgG1wKBgQC9jbA64TBHUGk68BB8MDJ8sLL7BBcdmViMnN8Vq9EQdjWy++d3OZ+rqvvFQhqS6FZz80faKW9jeRtVGmWg1xe+MO4X8fkoKE2FVed4G6k3QQ0owErUEbIASBZQ2/qHtMfbnS1IPl4beMJ0iz1RuswYKusiG3cMLHxCBnVb//d5LQKBgElFPIRbIf4ivl1t1y/zH1YA2/BwBwkF3WMM7p4ZwiBr0SSzOuCdSCttlgRTnMjSgQ8AnFo29+g3MlD2+gS/WnGkLF6v8ohPHcyz3TCeDfLmuXRKuM6HGGnSnfQOgUPFv7+wTdmGQxZqdenCnQvq4S+dQPwioBrIxZzN/BGLWHnBAoGBALh6+IQlfB479V5mHDUxl0Fhm5/PmEu3XcXkOv3VbbBuy855egnALFUgIM8XidNmihVpNYnu/7i5Ok+2VCiYjkQNTPxDBPH/X4sgUxnDGgprpkn99BW3bxz1C7sAjTCcUlK8A0EnaeGkwuQ4S6KKgW4X/yX/wvo3JWwA6yFx2kG1AoGAD1NZRMQWJxvFwhvwy1wfmJCCBqjQxRWPdKeg7CBhWhFS5S2tqY19l0lXyFyw/qSBULSmlgeGLnLcoaF2NSt4JJroix0NqG0DrEXzuBcYI7mn5Wl7xG7qLnCkM42HKi0V6LnsleYD/52iB0MO0xQ6TDtGS7KWkJQdBJUi4a525WQ=";

	// 支付宝的公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
	public static String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA9SGGhk4snjbQ97mNw9ep6uHPwjgKSj2Udxeh+EhPUG1UlRYm857q4exhPdulJdkbUxuhYVfAOKHZ68s8SKz0ob+61SvFECJXkg5VbTSHSlieaoedmpFm+nvLr1YIX/hMNEHPpq+CLY9kjU659g0vHcDB3oJAmYPDkNj/7ZyykFjjyN14EQR99VsFd/owLIYtkqBeeBgvJokFMVs1ektQ/WvVAVMnWT8lX+P5m25fUH+ZPBaGnM/9KB9zl0RLBpcelfHzI8biC9aIzLvwYXA9HcisV+9Ra3C+sCWpH/7boPW5QxME0ij/BGG9/AyyDynWCGp95+2Sg5gf2wMWfkHjCwIDAQAB";
	
	public static String SIGN_RSA2 = "RSA2";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String CHARSET = "UTF-8";

	public static String METHOD="alipay.trade.app.pay";

	// 同步返回使用GET方式获取，异步通知使用POST方式获取；
	// 同步返回验证有1分钟超时，异步通知验证没有时间限制。
	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String NOTIFY_URL = "http://114.215.71.170/car_inn/v1/ali/notifyurl";

	// 未付款交易的超时时间
	public static String TIMEOUT_EXPRESS = "5m";

	// 商品名称
	public static String SUBJECT = "车驿站订单";

	// 商品详情
	public static String BODY = "车驿站订单";
	
	public static final String GATEWAY = "https://openapi.alipaydev.com/gateway.do";

	// 交易关闭
	public static final String TRADE_CLOSED = "TRADE_CLOSED";
	public static final String TRADE_FINISHED = "TRADE_FINISHED"; // 交易完结 0
	public static final String TRADE_SUCCESS = "TRADE_SUCCESS"; // 支付成功 1
	public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY"; // 交易创建 0
}
