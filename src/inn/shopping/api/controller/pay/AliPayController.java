package inn.shopping.api.controller.pay;

import inn.shopping.api.entity.Order;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.pay.alipay.AliPayService;
import inn.shopping.api.pay.alipay.config.AlipayConfig;
import inn.shopping.api.pay.alipay.util.AlipayNotify;
import inn.shopping.api.service.order.OrderService;
import inn.shopping.api.view.JsonView;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "v1/open/ali")
public class AliPayController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private AliPayService aliPayService;

	/**
	 * 支付宝支付订单 订单状态1待付款,2已付款(待发货),3关闭订单(超时未付款),4已发货(待收货),
	 * 5已签收(待评价),6已评价(订单完成),7退货申请,8退货中,9已退货
	 * 
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public JsonView aliPayOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonView view = new JsonView();
		String orderId = request.getParameter("order_id");
		Order order = orderService.selectByPrimaryKey(orderId);
		if (null == order)
			throw new ApiException(APICode.PAYMENT_ORDER_NON_EXISTENT_CODE);
		String result = aliPayService.aliUnifiedOrderRequest(order);
		view.getResult().put("key", result);
		return view;
	}
	
	/**
	 * 支付结果
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/notifyurl", method = RequestMethod.POST)
	public void notify_url(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 从request中获得参数Map，并返回可读的Map
		Map<String, String> params = getParameterMap(request);
		// 验证支付宝签名
		boolean aliSign = AlipayNotify.verify(params);
		if (aliSign) {// 验证成功
			// 交易状态
			String tradeStatus = params.get("trade_status");
			// 订单编号
			String orderNo = params.get("out_trade_no");
			// 支付单号
			String payNo = params.get("trade_no");
			// 支付账号
			String buyerAccount = params.get("buyer_email");
			// 支付金额
			String totalFee = params.get("total_fee");
			// 收款支付宝账号
			String sellerId = params.get("seller_id");
			// 验证支付宝返回信息与请求信息一致,支付宝支付状态为成功,
			if (AlipayConfig.TRADE_SUCCESS.toString().equals(tradeStatus) 
					&& AlipayConfig.partner.equals(sellerId)) {
				// 验证订单未做支付处理
				Order order = orderService.selectByOrderNo(orderNo);
				if (null == order) {
					response.getWriter().print("fail");
					return;
				}
				// 订单已支付
				if (2 == order.getOrderStatus()) {
					response.getWriter().print("success");
					return;
				}
				// 验证金额是否和订单一致
				BigDecimal totalFeeD = new BigDecimal(totalFee);
				if (totalFeeD == order.getPayment()) {
					// 支付成功处理支付业务
					order.setOrderStatus(2);
					order.setPayChannel("A");
					order.setEscrowTradeNo(payNo);
					order.setBuyerAccount(buyerAccount);
					int result = orderService.updateByPay(order);
					// 成功后向支付宝返回成功标志
					if (result == 1) 
						response.getWriter().print("success");
				}
			}
		} else {// 验证失败
			response.getWriter().print("fail");
		}
	}

	/**
	 * 从request中获得参数Map，并返回可读的Map
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getParameterMap(HttpServletRequest request) {
		Map<String, String> returnMap = new HashMap<String, String>();
		// 参数Map
		Map<String, String[]> properties = request.getParameterMap();
		Iterator<Entry<String, String[]>> entries = properties.entrySet().iterator();
		String value = "";
		while (entries.hasNext()) {
			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) entries.next();
			String name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}
}
