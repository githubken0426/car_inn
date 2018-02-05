package inn.shopping.api.controller.pay;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Order;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.pay.wxpay.WxPayService;
import inn.shopping.api.pay.wxpay.entity.UnifiedOrderResponse;
import inn.shopping.api.pay.wxpay.utils.WxPayUtil;
import inn.shopping.api.service.order.OrderService;
import inn.shopping.api.view.JsonView;


@Controller
@RequestMapping("v1/open/weixin")
public class WxPayAppController {
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
		UnifiedOrderResponse unifiedResponse = wxPayService.unifiedOrderRequest(order);
		if ("FAIL".equalsIgnoreCase(unifiedResponse.getReturn_code()))
			throw new ApiException(APICode.PAYMENT_ORDER_PAY_TX_FAIL_CODE);
		if ("FAIL".equalsIgnoreCase(unifiedResponse.getResult_code()))
			throw new ApiException(unifiedResponse.getErrorCode());

		String currentTimeMillis = System.currentTimeMillis() / 1000 + "";
		view.getResult().put("sign", WxPayUtil.generatePreparedOrderSign(unifiedResponse, currentTimeMillis));
		view.getResult().put("timestamp", currentTimeMillis);
		view.getResult().put("noncestr", unifiedResponse.getNonce_str());
		view.getResult().put("partnerid", unifiedResponse.getMch_id());
		view.getResult().put("prepayid", unifiedResponse.getPrepay_id());
		view.getResult().put("package", "Sign=WXPay");
		view.getResult().put("appid", unifiedResponse.getAppid());
		return view;
	}
}