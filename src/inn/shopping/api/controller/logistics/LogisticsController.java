package inn.shopping.api.controller.logistics;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Logistics;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.service.logistics.LogisticsService;
import inn.shopping.api.view.JsonObjectView;

@Controller
@RequestMapping(value="v1/logistics")
public class LogisticsController {
	@Autowired
	private LogisticsService logisticsService;
	
	/**
	 * 获取广告列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public JsonObjectView appAddressList(HttpServletRequest request)
			throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String orderId=request.getParameter("order_id");
		if (!StringUtils.isNotBlank(orderId)) 
			throw new ApiException(APICode.ORDER_ID_NULL_ERROR);
		
		Logistics logistics=logisticsService.selectLogisticsByOrder(orderId);
		jsonView.setResult(logistics);
		return jsonView;
	}
	
}
