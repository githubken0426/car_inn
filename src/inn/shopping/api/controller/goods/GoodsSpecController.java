package inn.shopping.api.controller.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.GoodsBrand;
import inn.shopping.api.entity.Spec;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.GoodsSearchCondition;
import inn.shopping.api.service.goodsBrand.GoodsBrandService;
import inn.shopping.api.service.spec.SpecService;
import inn.shopping.api.view.JsonObjectView;

/**
 * 商品规格
 * 
 * @ClassName: GoodsSpecController
 * @Description:
 * @author ken
 * @date 2017年9月22日 上午9:44:29
 */
@Controller
@RequestMapping(value = "v1/open/goods/spec")
public class GoodsSpecController {
	@Autowired
	private SpecService specService;
	@Autowired
	private GoodsBrandService goodsBrandService;

	/**
	 * 商品筛选条件
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonObjectView goodsSelectItems(HttpServletRequest request, JsonObjectView jsonView,
			GoodsSearchCondition condition) throws ApiException, Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		String categoryId = request.getParameter("category_id");
		map.put("categoryId", categoryId);

		List<Spec> specList = specService.selectGoodsSpecItems(map);
		List<GoodsBrand> brandList = goodsBrandService.selectCategoryBrand(categoryId);
		map.put("categoryId", 0);
		List<Spec> priceList=specService.selectGoodsSpecItems(map);
		condition.setSpecList(specList);
		condition.setBrandList(brandList);
		condition.setPriceList(priceList);
		
		jsonView.setResult(condition);
		return jsonView;
	}
}
