package inn.shopping.api.enums;

import java.text.MessageFormat;

import inn.shopping.api.exception.ApiException;

public enum APICode {

	// =======系统错误=======
	SYS_ERR_CODE(-1, "程序异常", "系统繁忙，请稍后再试。", null), 
	SYS_FILE_UNEXISTS(-2, "程序异常", "文件不存在。", null),
	SYS_CITY_CODE_NULL(-3, "程序异常", "城市编码为空。", null),
	SYS_PARAM_NULL(-4, "参数为空错误", "输入有误,请核对你输入的信息", null),
	
	SYS_ADD_SUCCESS(1, "操作成功", "添加成功", null),
	SYS_UPDATE_SUCCESS(2, "操作成功", "修改成功", null),
	SYS_DELETE_SUCCESS(3, "操作成功", "删除成功", null),
	SYS_SET_SUCCESS(4, "操作成功", "设置成功", null),
	
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
	CART_GOODS_DATA_ERROR(3000, "获取数据异常", "系统繁忙。。", null), 
	CART_PARAM_NULL_ERROR(3001, "参数为null或者空", "系统繁忙。。",
			null), 
	CART_OUT_NUM(3002, "购物车商品数量大于库存量", "您所选购的 {0} 商品数量超出库存量", "您所选购的 {0} 商品数量超出库存量"), 
	CART_GOODS_REPEAT(
					3003, "购物车中商品已添加", "购物车中商品已添加", null), 
	CART_GOODS_EMPTY(3004, "购物车中无商品", "购物车中无商品",
							null), 
	CART_GOODS_NO_EXIST(3005, "商品不存在", "系统繁忙。。", null), 
	CART_USER_NO_EXIST(3006, "用户不存在",
									"系统繁忙。。", null), 
	CART_ADDRESS_NO_EXIST(3007, "收获地址不存在", "请添加收获地址。。", null),

	// =======支付模块=======
	PAYMENT_ORDER_NON_EXISTENT_CODE(4000, "订单不存在", "您所支付的订单无效，请重新下单。", null), 
	PAYMENT_ORDER_PAY_TX_FAIL_CODE(4001,
			"微信支付通信失败", "系统繁忙，请稍后再试。",
			null), 
	PAYMENT_ORDER_PAY_PAID_CODE(4002, "订单已支付", "订单支付已完成，禁止重复支付。", null), 
	PAYMENT_ORDER_PAY_CLOSE_CODE(
					4003, "订单已关闭", "订单已关闭，请重新下单。", null), 
	PAYMENT_ORDER_PAY_OUT_TRADE_NO_USED_CODE(4004, "订单号重复",
							"订单已失效，请重新下单。", null), 
	PAYMENT_ORDER_PAY_FAIL_CODE(4005, "支付失败", "支付失败，请稍后再试。", null),

	// =======个人中心模块=======
	MY_CODE(5000, "个人中心错误代码", "用户提示信息", null),

	// =======用户模块=======
	USER_LOGIN_OTHER_ERROR(6022, "登录错误", "已在别的设备登录", null),

	// =======订单模块=======
	;
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
	public APICode setTemplateMsg(String... args) {
		message = MessageFormat.format(getMessage_cache(), args);
		return this;
	}

	private APICode(int code, String codeMessage, String message, String message_cache) {
		this.code = code;
		this.codeMessage = codeMessage;
		this.message = message;
		this.message_cache = message_cache;
	}

	public static void main(String[] args) throws ApiException {
		System.out.println(APICode.API_EXPIRED_CODE.setTemplateMsg("中国人00", "北京", "22", "rsp:{}").toJsonString());
	}

	public String toJsonString() {
		return "{\"err_code\":\"" + code + "\",\"err_message\":\"" + codeMessage + "\",\"message\":\""
				+ message + "\"}";
	}

}