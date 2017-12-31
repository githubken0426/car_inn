package inn.shopping.api.enums;

import java.text.MessageFormat;

import inn.shopping.api.exception.ApiException;

public enum ErrorCode {

	// =======系统错误=======
	SYS_ERR_CODE(-1, "程序异常", "系统繁忙，请稍后再试。", null), 
	SYS_FILE_UNEXISTS(-2, "程序异常", "文件不存在。", null),
	SYS_CITY_CODE_NULL(-3, "程序异常", "城市编码为空。", null),
	// =======API签名认证=======
	API_EXPIRED_CODE(13000, "请求过期", "系统繁忙，请稍后再试。", null), 
	API_FAILD_SINGNOMACH_CODE(13001, "签名不匹配", "系统繁忙，请稍后再试。",null),
	
	// =======主页模块=======
	HOME_NULL_CODE(1000, "没有数据，请联系后台管理员", "获取资源失败", null),

	// =======商品模块=======
	SEARCH_FLAG(2000, "参数flag为null", "请选择搜索类别", null),
	GOODS_ID_NULL_ERROR(2000, "参数goods_id为null", "亲，请点选商品", null),
	GOODS_DATA_ERROR(2001, "获取数据异常", "系统繁忙。。",null), 
	GOODS_TYPE_ID_NULL_ERROR(2002, "参数goods_type_id为null", "亲，请点选分类商品", null), 
	GOODS_NOT_EXIST(2003,"商品获取失败", "商品不存在。。", null), 
	GOODS_TYPE_SUB_NOT_EXIST(2004, "商品子类信息获取失败", "商品不存在。。",null), 
	GOODS_TYPE_NOT_EXIST(2005, "商品分类信息获取失败", "商品不存在。。", null), 
	GOODS_DESC_ASC_NULL_ERROR(2006, "参数desc_asc为null", "亲，请选择排序方式", null), 
	GOODS_SORT_ERROR(2007, "商品排序列表获取失败","系统繁忙。。", null), 
	GOODS_COMMENT_DATA_ERROR(2008, "获取数据异常", "系统繁忙。。", null),

	// =======购物车模块=======
	CART_GOODS_DATA_ERROR(3000, "获取数据异常", "系统繁忙。。", null), CART_PARAM_NULL_ERROR(3001, "参数为null或者空", "系统繁忙。。",
			null), CART_OUT_NUM(3002, "购物车商品数量大于库存量", "您所选购的 {0} 商品数量超出库存量", "您所选购的 {0} 商品数量超出库存量"), CART_GOODS_REPEAT(
					3003, "购物车中商品已添加", "购物车中商品已添加", null), CART_GOODS_EMPTY(3004, "购物车中无商品", "购物车中无商品",
							null), CART_GOODS_NO_EXIST(3005, "商品不存在", "系统繁忙。。", null), CART_USER_NO_EXIST(3006, "用户不存在",
									"系统繁忙。。", null), CART_ADDRESS_NO_EXIST(3007, "收获地址不存在", "请添加收获地址。。", null),

	// =======支付模块=======
	PAYMENT_ORDER_NON_EXISTENT_CODE(4000, "订单不存在", "您所支付的订单无效，请重新下单。", null), PAYMENT_ORDER_PAY_TX_FAIL_CODE(4001,
			"微信支付通信失败", "系统繁忙，请稍后再试。",
			null), PAYMENT_ORDER_PAY_PAID_CODE(4002, "订单已支付", "订单支付已完成，禁止重复支付。", null), PAYMENT_ORDER_PAY_CLOSE_CODE(
					4003, "订单已关闭", "订单已关闭，请重新下单。", null), PAYMENT_ORDER_PAY_OUT_TRADE_NO_USED_CODE(4004, "订单号重复",
							"订单已失效，请重新下单。", null), PAYMENT_ORDER_PAY_FAIL_CODE(4005, "支付失败", "支付失败，请稍后再试。", null),

	// =======个人中心模块=======
	MY_CODE(5000, "个人中心错误代码", "用户提示信息", null),

	// =======用户模块=======
	USER_PARAM_NULL_ERROR(6001, "参数为空错误", "输入有误,请核对你输入的信息", null), USER_OPERATION_ERROR(6002, "程序获取数据异常", "系统繁忙...",
			null),

	USER_AVATAR_FORMAT_ERROR(6005, "参数格式错误", "请选择头像", null), USER_PHONE_FORMAT_ERROR(6006, "手机号格式不正确", "请输入正确的手机号",
			null), USER_QQ_FORMAT_ERROR(6007, "QQ号格式不正确", "请输入正确的QQ号", null), USER_EMAIL_FORMAT_ERROR(6008, "邮箱格式不正确",
					"请输入正确的邮箱", null), USER_NICKNAME_FORMAT_ERROR(6010, "昵称格式不正确", "昵称不能包含特殊字符", null),

	USER_LOGIN_SUCCESS(6020, "登录成功", "欢迎回来", null), USER_LOGIN_PASSWORD_ERROR(6021, "登录错误", "请输入正确的密码",
			null), USER_LOGIN_OTHER_ERROR(6022, "登录错误", "已在别的设备登录", null),

	USER_ACCOUNT_UNREGISTER(6010, "账号错误", "手机号未注册", null), USER_ACCOUNT_REGISTER(6011, "账号错误", "手机号已注册",
			null), USER_PASSWORD_ERROR(6012, "原密码错误", "原密码输入有误", null),

	USER_VERIFY_ERROR(6030, "验证码错误", "请输入正确的验证码", null), USER_AVATAR_ERROR(6031, "获取头像错误", "用户头像不存在",
			null), USER_AVATAR_UPLOAD_ERROR(6032, "头像上传失败", "头像上传失败", null),

	ADDRESS_LIST_NULL_ERROR(6040, "获取地址错误", "你还没有添加收货地址哦", null),

	INTEGRAL_LIST_NULL_ERROR(6050, "获取积分详情错误", "你还没有积分记录哦", null),

	// =======分享模块=======
	SHARE_CODE(7000, "分享模块错误代码", "用户提示信息", null),

	// =======消息中心模块=======
	MESSAGE_CODE(8000, "消息中心错误代码", "用户提示信息", ""),

	// =======订单模块=======
	ORDERID_ISBLANK_ERROR(9000, "订单ID为空", "请您确认订单是否生成", null), 
	ORDERC_COMMENT_ISBLANK_ERROR(9001, "数据库没有该数据", "订单不存在",
			null), REASON_ISBLANK_ERROR(9002, "未获得订单取消原因", "请您选择订单取消原因", null), 
	SKIP_ERROR(9003, "取消的订单不是待付款订单",
					"系统繁忙。。", null), 
	NO_ORDERS_ERROR(9004, "没有全部订单的信息", "无订单", null), 
	NO_WAIT_PAYMENT_ORDERS_ERROR(9005,
							"没有待付款订单信息", "无待付款订单", null), 
	NO_WAIT_DELIVERY_ORDERS_ERROR(9006, "没有待发货订单信息", "无待发货订单",
									null), 
	NO_WAIT_GOODS_RECEIPT_ERROR(9007, "没有待收货订单信息", "无待收货订单",
											null), 
	FILE_UPLOAD_ERROR(9008, "文件上传失败", "文件上传失败",
													null), 
	NO_WAIT_EVALUATION_ERROR(9009, "没有待评价订单信息", "无待评价订单",
															null), 
	NO_INTEGRAL_ERROR(9010, "没有积分信息", "系统繁忙。。",
																	null), 
	STATE_IS_NOT_PAYMENT_ERROR(9011, "不是已付款状态","卖家已发货，暂时不能退货",null), 
	NO_RETURN_GOODS_ERROR(9012,"没有退货订单信息", "无退款订单",null), 
	ORDER_OUT_NUM(9013,"购买商品数量大于库存量",
																							"您所选购的 {0} 数量超出库存量",
																							"您所选购的 {0} 数量超出库存量"), OVER_TIME(
																									9014, "订单支付时间过期",
																									"订单已过期，请您重新下订单",
																									null), LINETYPE_ERROR(
																											9015,
																											"支付方式的编号不对",
																											"请选择正确的付款方式",
																											null), APPLY_ERROR(
																													9016,
																													"申请服务为空",
																													"请选择申请服务",
																													null), REASON_VALUE_ERROR(
																															9017,
																															"申请原因为空",
																															"请选择退货原因",
																															null),

	// =======收藏模块=======
	FAVORITE_USERID_CODE(10000, "user_id为空或者为NULL", "请您先登录", null), FAVORITE_GOODSID_CODE(10001, "goods_id为空或者为NULL",
			"请选择要收藏的商品", null),

	// =======推广模块=======
	EXTEND_CODE(11000, "推广模块错误代码", "用户提示信息", null),

	// =======意见反馈模块=======
	FEEDBACK_EMAIL_CODE(12000, "邮箱格式错误", "请您输入正确的邮箱格式", null), FEEDBACK_USERID_CODE(12001, "user_id为空或者为NULL", "请您先登录",
			null), FEEDBACK_CONTENT_CODE(12002, "content为空或者为NULL", "请输入您的宝贵意见", null);
	// ===========================

	private final int code;
	private final String codeMessage;
	private String message;
	private String message_cache;// 防止占位符消失

	public int getCode() {
		return code;
	}

	public String getCodeMessage() {
		return codeMessage;
	}

	public String getMessage() {
		return message;
	}

	public String getMessage_cache() {
		return message_cache;
	}

	// 替换占位符数据
	public ErrorCode setTemplateMsg(String... args) {
		message = MessageFormat.format(getMessage_cache(), args);
		return this;
	}

	private ErrorCode(int code, String codeMessage, String message, String message_cache) {
		this.code = code;
		this.codeMessage = codeMessage;
		this.message = message;
		this.message_cache = message_cache;
	}

	public static void main(String[] args) throws ApiException {
		System.out.println(ErrorCode.MESSAGE_CODE.setTemplateMsg("中国人00", "北京", "22", "rsp:{}").toJsonString());
	}

	public String toJsonString() {
		return "{\"err_code\":\"" + code + "\",\"err_message\":\"" + codeMessage + "\",\"message\":\""
				+ message + "\"}";
	}

}