package inn.shopping.api.controller.pay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Order;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.pay.wxpay.WxPayService;
import inn.shopping.api.pay.wxpay.entity.PayResultNotify;
import inn.shopping.api.pay.wxpay.entity.UnifiedOrderResponse;
import inn.shopping.api.pay.wxpay.utils.WxPayUtil;
import inn.shopping.api.service.order.OrderService;
import inn.shopping.api.view.JsonObjectView;
import inn.shopping.api.view.JsonView;


@Controller
@RequestMapping("v1/weixin")
public class WxPayController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private WxPayService wxPayService;
	
	@ResponseBody
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public JsonView orderSubmit(HttpServletRequest request) throws ApiException{
		JsonView view = new JsonView();
		String orderId = request.getParameter("order_id");
		Order order = orderService.selectByPrimaryKey(orderId);
		if (null == order)
			throw new ApiException(APICode.PAYMENT_ORDER_NON_EXISTENT_CODE);
		/**
		 * 返回订单数据 
		 * 统一下单接口返回正常的prepay_id，再按签名规范重新生成签名后，将数据传输给APP。
		 * 参与签名的字段名为appId，partnerId，prepayId，nonceStr，timeStamp，package。
		 * 注意：package的值格式为Sign=WXPay
		 */
		UnifiedOrderResponse unifiedResponse = wxPayService.unifiedOrderRequest(request,order);
		if ("FAIL".equalsIgnoreCase(unifiedResponse.getReturn_code()))
			throw new ApiException(APICode.PAYMENT_ORDER_PAY_TX_FAIL_CODE);
		if ("FAIL".equalsIgnoreCase(unifiedResponse.getResult_code()))
			throw new ApiException(unifiedResponse.getErrorCode());

		view.getResult().put("appid", unifiedResponse.getAppid());
		view.getResult().put("prepayid", unifiedResponse.getPrepay_id());
		view.getResult().put("partnerid", unifiedResponse.getMch_id());
		view.getResult().put("package", "Sign=WXPay");
		view.getResult().put("noncestr", unifiedResponse.getNonce_str());
		String currentTimeMillis = System.currentTimeMillis() / 1000 + "";
		view.getResult().put("timestamp", currentTimeMillis);
		view.getResult().put("sign", WxPayUtil.generatePreparedOrderSign(unifiedResponse, currentTimeMillis));
		return view;
	}
	/**
	 * 支付后回调路径
	 * @param request
	 * @param response
	 * @throws Exception 
	 * @throws 
	 * @date 2018年2月5日 上午11:22:44
	 */
	@ResponseBody
	@RequestMapping(value = "/notifyurl", method = RequestMethod.POST)
	public JsonObjectView notifyurl(HttpServletRequest request,HttpServletResponse response) throws Exception{
		JsonObjectView view = new JsonObjectView();
		//根据支付状态扣除积分?暂定
		PayResultNotify result =wxPayService.unifiedOrderNotifyUrl(request, response);
		view.setResult(result);
		return view;
	}
}