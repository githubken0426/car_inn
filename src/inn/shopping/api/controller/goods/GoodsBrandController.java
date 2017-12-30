package inn.shopping.api.controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.GoodsBrand;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.service.goodsBrand.GoodsBrandService;
import inn.shopping.api.view.JsonList;

/**
 * 商品品牌
 * @ClassName: GoodsBrandController 
 * @Description: 
 * @author ken 
 * @date 2017年9月22日 上午9:58:06
 */
@Controller
@RequestMapping(value="v1/open/goods/brand")
public class GoodsBrandController {
	@Autowired
	private GoodsBrandService goodsBrandService;
	
	/**
	 * 获取广告列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonList<GoodsBrand> brandList(HttpServletRequest request)
			throws ApiException {
		JsonList<GoodsBrand> jsonView = new JsonList<GoodsBrand>();
		String categoryId = request.getParameter("category_id");
		List<GoodsBrand> list=goodsBrandService.selectCategoryBrand(categoryId);
		jsonView.setResult(list);
		return jsonView;
	}
	
}
