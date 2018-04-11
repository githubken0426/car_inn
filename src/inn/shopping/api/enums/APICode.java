package inn.shopping.api.enums;

import java.text.MessageFormat;

import inn.shopping.api.exception.ApiException;
import net.sf.json.JSONObject;

public enum APICode {
	// =======系统错误=======
	SYS_ERR_CODE(-1, "程序异常", "系统繁忙，请稍后再试。", null), 
	SYS_FILE_UNEXISTS(-2, "程序异常", "文件不存在。", null),
	SYS_CITY_CODE_NULL(-3, "程序异常", "城市编码为空。", null),
	SYS_PARAM_NULL(-4, "参数为空错误", "输入有误,请核对你输入的信息", null),
	SYS_PICTURE_UPLOAD_ERROR(-5, "图片上传失败", "图片上传失败,请稍后再试", null),
	SYS_BRANDID_NULL(-6, "程序异常", "品牌ID为空。", null),
	
	SYS_ADD_SUCCESS(1, "操作成功", "添加成功", null),
	SYS_UPDATE_SUCCESS(2, "操作成功", "修改成功", null),
	SYS_DELETE_SUCCESS(3, "操作成功", "删除成功", null),
	SYS_SET_SUCCESS(4, "操作成功", "设置成功", null),
	
	// =======API签名认证=======
	API_EXPIRED_CODE(13000, "请求过期", "系统繁忙，请稍后再试。", null), 
	API_FAILD_SINGNOMACH_CODE(13001, "签名不匹配", "系统繁忙，请稍后再试。",null),
	
	
	// =======订单模块=======
	ORDER_SETTLEMENT_ERROR(4000, "结算失败", "系统繁忙。",null),
	ORDER_STATUS_NULL_ERROR(4001, "订单状态为空", "订单状态不能为空。",null),
	ORDER_GOODS_NULL_ERROR(4002, "商品ID为空", "商品不能为空。",null),
	ORDER_ID_NULL_ERROR(4003, "订单ID为空", "订单ID不能为空。",null),
	ORDER_GOODS_OBJ_ERROR(4004, "商品对象为空", "商品对象为空。",null),
	ORDER_ADDRESS_NULL_ERROR(4004, "收货地址为空", "你还没有地址，快去添加收货地址吧。",null),

	// =======支付模块=======
	PAYMENT_ORDER_NON_EXISTENT_CODE(4000, "订单不存在", "您所支付的订单无效，请重新下单。", null), 
	PAYMENT_ORDER_PAY_TX_FAIL_CODE(4001,"微信支付通信失败", "系统繁忙，请稍后再试。",null), 
	PAYMENT_ORDER_PAY_PAID_CODE(4002, "订单已支付", "订单支付已完成，禁止重复支付。", null), 
	PAYMENT_ORDER_PAY_CLOSE_CODE(4003, "订单已关闭", "订单已关闭，请重新下单。", null), 
	PAYMENT_ORDER_PAY_OUT_TRADE_NO_USED_CODE(4004, "订单号重复","订单已失效，请重新下单。", null), 
	PAYMENT_ORDER_PAY_FAIL_CODE(4005, "支付失败", "支付失败，请稍后再试。", null),
	
	GOODS_NULL_ERROR(5000, "不存在的商品", "商品ID错误。",null),
	// =======用户模块=======
	USER_LOGIN_OTHER_ERROR(6022, "登录错误", "已在别的设备登录", null),
	// =======评论模块=======
	COMMENT_EXISTS_ERROR(6000, "你已经评论过了", "您已经评论过了。", null),
	COMMEND_EXISTS_ERROR(6001, "已经赞过了", "您已经赞过了。", null),
	
	EXPERT_CATEGORY_NULL(7000, "达人分类不能为空", "达人分类ID为空。", null),
	
	SHOP_ID_NULL_ERROR(8003, "经销商ID为空", "经销商ID不能为空。",null),
	;

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
	@SuppressWarnings("all")
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
		System.out.println(APICode.API_EXPIRED_CODE.toJSONObject());
	}

	public JSONObject toJSONObject() {
		//return "{\"err_code\":\"" + code + "\",\"err_message\":\"" + codeMessage + "\",\"message\":\"" + message+ "\"}";
		JSONObject obj=new JSONObject();
		obj.put("err_code", code);
		obj.put("err_message", codeMessage);
		obj.put("message", message);
		return obj;
	}

}