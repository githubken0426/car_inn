package inn.shopping.api.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Order;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.OrderForm;
import inn.shopping.api.service.order.OrderService;
import inn.shopping.api.utils.Encrypt;
import inn.shopping.api.view.JsonList;
import inn.shopping.api.view.JsonObjectView;
import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping(value="v1/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	/**
	 * 获取订单列表
	 * @throws ApiException 
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonList<Order> orderList(HttpServletRequest request) throws ApiException {
		JsonList<Order> jsonView = new JsonList<Order>();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		String status = request.getParameter("status");
		if(StringUtils.isBlank(status))
			throw new ApiException(APICode.ORDER_STATUS_NULL_ERROR);
		List<Order> list=orderService.selectUserOrders(userId, status);
		jsonView.setResult(list);
		return jsonView;
	}
	/**
	 * 订单详情
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public JsonObjectView orderDetail(HttpServletRequest request) throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String orderId = request.getParameter("order_id");
		if(StringUtils.isBlank(orderId))
			throw new ApiException(APICode.ORDER_ID_NULL_ERROR);
		Order order=orderService.selectByPrimaryKey(orderId);
		jsonView.setResult(order);
		return jsonView;
	}
	
	/**
	 * 商品结算
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws 
	 * @date 2018年1月10日 下午7:33:26
	 */
	@ResponseBody
	@RequestMapping(value = "/settlement", method = RequestMethod.POST)
	public JsonView cartSettlement(@RequestBody OrderForm form,HttpServletRequest request) throws ApiException {
		JsonView jsonView = new JsonView();
		Map<String,Object> map=new HashMap<String,Object>();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		if (!form.checkeParam())
			throw new ApiException(APICode.SYS_PARAM_NULL);
		String result = orderService.orderSettlement(form, userId);
		if(StringUtils.isBlank(result)) 
			throw new ApiException(APICode.ORDER_SETTLEMENT_ERROR);
		map.put("orderId",result);
		jsonView.setResult(map);
		jsonView.setMessage("结算中");
		return jsonView;
	}
	/**
	 * 立即购买
	 * @param form
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws 
	 * @date 2018年1月13日 下午12:00:56
	
	@ResponseBody
	@RequestMapping(value = "/buynow", method = RequestMethod.POST)
	public JsonView buyGoodsNow(@RequestBody OrderForm form,HttpServletRequest request) throws ApiException {
		Map<String,Object> map=new HashMap<String,Object>();
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		if (!form.checkeGoods())
			throw new ApiException(APICode.ORDER_GOODS_NULL_ERROR);
		String result = orderService.buyGoodsNow(form, userId);
		if(StringUtils.isBlank(result)) 
			throw new ApiException(APICode.ORDER_SETTLEMENT_ERROR);
		map.put("orderId",result);
		jsonView.setResult(map);
		jsonView.setMessage("结算中");
		return jsonView;
	} */
	/**
	 * 支付
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws 
	 * @date 2018年1月10日 下午7:33:12
	 */
	@ResponseBody
	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	public JsonView goodsPay(HttpServletRequest request) throws ApiException {
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		//支付时，更新订单表，新增物流表(物流表填写地址)
		return jsonView;
	}
}
