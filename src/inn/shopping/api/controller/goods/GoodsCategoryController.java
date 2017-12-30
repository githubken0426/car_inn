package inn.shopping.api.controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.GoodsCategory;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.service.goodsCategory.GoodsCategoryService;
import inn.shopping.api.view.JsonList;

/**
 * 商品分类
 * @ClassName: GoodsCategoryController 
 * @Description: 
 * @author ken 
 * @date 2017年9月22日 上午9:44:29
 */
@Controller
@RequestMapping(value="v1/open/goods/category")
public class GoodsCategoryController {
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	/**
	 * 获取广告列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonList<GoodsCategory> appAddressList(HttpServletRequest request)
			throws ApiException {
		JsonList<GoodsCategory> jsonView = new JsonList<GoodsCategory>();
		List<GoodsCategory> list=goodsCategoryService.selectAllCategory();
		jsonView.setResult(list);
		return jsonView;
	}
	
}
