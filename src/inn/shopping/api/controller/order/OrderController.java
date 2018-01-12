package inn.shopping.api.controller.order;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.OrderForm;
import inn.shopping.api.service.order.OrderService;
import inn.shopping.api.utils.Encrypt;
import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping(value="v1/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	/**
	 * 购物车--去结算
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
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		if(form.checkeParam())
			throw new ApiException(APICode.SYS_PARAM_NULL);
		
		
		orderService.cartSettlement(form,userId);
		jsonView.setMessage("购物车结算中");
		return jsonView;
	}
	
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
		
		return jsonView;
	}
}
