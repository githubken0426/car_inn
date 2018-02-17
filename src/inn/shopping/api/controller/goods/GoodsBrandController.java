package inn.shopping.api.controller.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Goods;
import inn.shopping.api.entity.GoodsBrand;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.service.goods.GoodsService;
import inn.shopping.api.service.goodsBrand.GoodsBrandService;
import inn.shopping.api.view.JsonList;

/**
 * 商品品牌
 * 
 * @ClassName: GoodsBrandController
 * @Description:
 * @author ken
 * @date 2017年9月22日 上午9:58:06
 */
@Controller
@RequestMapping(value = "v1/open/goods/brand")
public class GoodsBrandController {
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private GoodsService goodsService;

	/**
	 * 获取品牌列表
	 * 
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonList<GoodsBrand> brandList(HttpServletRequest request)
			throws ApiException {
		JsonList<GoodsBrand> jsonView = new JsonList<GoodsBrand>();
		List<GoodsBrand> resultList=new ArrayList<GoodsBrand>();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String categoryId = request.getParameter("category_id");
		String cityCode = request.getParameter("city_code");
		List<GoodsBrand> list = goodsBrandService.selectCategoryBrand(categoryId);
		for (GoodsBrand brand : list) {
			int size = 3;// 默认展示三张图片
			paramMap.put("brandId", brand.getId());
			paramMap.put("cityCode", cityCode);
			paramMap.put("size", size);
			List<Goods> goodsList = goodsService.selectHotIdsByBrand(paramMap);
			List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
			for (Goods goods : goodsList) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("goods_id", goods.getId());
				List<String> picList = goods.getSmallPictureList();
				String url = (picList != null && picList.size() > 0) ? picList.get(0) : "";
				map.put("picture_url", url);
				mapList.add(map);
				brand.setPictureList(mapList);
				resultList.add(brand);
			}
		}
		jsonView.setResult(list);
		return jsonView;
	}

}
