package inn.shopping.api.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Shop;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.ShopForm;
import inn.shopping.api.service.shop.ShopService;
import inn.shopping.api.view.JsonList;

@Controller
@RequestMapping(value="v1/open/shop")
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	/**
	 * 获取店铺列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public JsonList<Shop> appAddressList(@RequestBody ShopForm form,HttpServletRequest request)
			throws ApiException {
		JsonList<Shop> jsonView = new JsonList<Shop>();
		if (!form.validateParam()) {
			throw new ApiException(APICode.SYS_PARAM_NULL);
		}
		List<Shop> list=shopService.selectShopByCategory(form);
		jsonView.setResult(list);
		return jsonView;
	}
	
}
