package inn.shopping.api.controller.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	 * 获取广告列表
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
		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		String categoryId = request.getParameter("category_id");
		String cityCode = request.getParameter("city_code");
		List<GoodsBrand> list = goodsBrandService.selectCategoryBrand(categoryId);
		for (GoodsBrand brand : list) {
			String picture = brand.getPicture();
			if (StringUtils.isNotBlank(picture)) {
				String[] pics = picture.split(",");
				paramMap.put("brandId", brand.getId());
				paramMap.put("cityCode", cityCode);
				paramMap.put("size", pics.length);
				List<String> goodsIds = goodsService.selectHotIdsByBrand(paramMap);
				if (pics.length <= goodsIds.size()) {
					List<Map<String,String>> mapList=new ArrayList<Map<String,String>>();
					for (int i = 0; i < pics.length; i++) {
						Map<String,String> map=new HashMap<String,String>();
						map.put("goods_id", goodsIds.get(i));
						map.put("picture_url", pics[i]);
						mapList.add(map);
						brand.setPictureList(mapList);
						resultList.add(brand);
					}
				} else if (pics.length > goodsIds.size()) {
					List<Map<String,String>> mapList=new ArrayList<Map<String,String>>();
					for (int i = 0; i < goodsIds.size(); i++) {
						Map<String,String> map=new HashMap<String,String>();
						map.put("goods_id", goodsIds.get(i));
						map.put("picture_url", pics[i]);
						brand.setPictureList(mapList);
						resultList.add(brand);
					}
				}
			}else{
				resultList.add(brand);
			}
		}
		jsonView.setResult(list);
		return jsonView;
	}

}
