package inn.shopping.api.controller.goods;

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

import inn.shopping.api.entity.Goods;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.GoodsSearchForm;
import inn.shopping.api.service.goods.GoodsService;
import inn.shopping.api.view.JsonList;
import inn.shopping.api.view.JsonObjectView;

/**
 * 商品
 * @ClassName: GoodsController 
 * @Description: 
 * @author ken 
 * @date 2017年9月22日 上午9:58:06
 */
@Controller
@RequestMapping(value="v1/open/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 获取热门商品列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/hot", method = RequestMethod.GET)
	public JsonList<Goods> goodsHot(HttpServletRequest request)
			throws ApiException {
		JsonList<Goods> jsonView = new JsonList<Goods>();
		Map<String,Object> map=new HashMap<String,Object>();
		String cityCode=request.getParameter("city_code");
		if (!StringUtils.isNotBlank(cityCode)) {
			throw new ApiException(APICode.SYS_CITY_CODE_NULL);
		}
		map.put("cityCode", cityCode);
		map.put("isHot", "Y");
		List<Goods> list=goodsService.selectHotGoods(map);
		if(list.size()==0){
			jsonView.setMessage("没有数据");
		}
		jsonView.setResult(list);
		return jsonView;
	}
	/**
	 * 
	 * 商品排序 销量排序 价格排序 0正序 1倒序
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	public JsonList<Goods> goodsSort(HttpServletRequest request)
			throws ApiException {
		Map<String,Object> map=new HashMap<String,Object>();
		JsonList<Goods> jsonView = new JsonList<Goods>();
		String cityCode=request.getParameter("city_code");
		if (!StringUtils.isNotBlank(cityCode)) {
			throw new ApiException(APICode.SYS_CITY_CODE_NULL);
		}
		String sql="sold_number desc,promotion_price";
		String statusStr=request.getParameter("status");
		int status=StringUtils.isNotBlank(statusStr)?Integer.valueOf(statusStr):0;
		String sort=request.getParameter("sort");
		if(status==1){//0综合排序 1销量 2价格
			sql=" sold_number desc";
		}else if(status==2){
			if("0".equals(sort)) 
				sql=" promotion_price desc";
			else 
				sql=" promotion_price asc";
		}
		map.put("cityCode", cityCode);
		map.put("sort", sql);
		String brandId=request.getParameter("brand_id");
		map.put("brandId", brandId);
		List<Goods> list=goodsService.selectGoodsSort(map);
		if(list.size()==0){
			jsonView.setMessage("没有数据");
		}
		jsonView.setResult(list);
		return jsonView;
	}
	/**
	 * 根据品牌选购商品
	 * @param request
	 * @return
	 * @throws ApiException
	 
	@Deprecated
	@ResponseBody
	@RequestMapping(value = "/brand/search", method = RequestMethod.GET)
	public JsonList<Goods> goodsBrandSearch(HttpServletRequest request)
			throws ApiException {
		Map<String,Object> map=new HashMap<String,Object>();
		JsonList<Goods> jsonView = new JsonList<Goods>();
		String cityCode=request.getParameter("city_code");
		if (!StringUtils.isNotBlank(cityCode)) {
			throw new ApiException(APICode.SYS_CITY_CODE_NULL);
		}
		map.put("cityCode", cityCode);
		String brandId=request.getParameter("brand_id");
		map.put("brandId", brandId);
		List<Goods> list=goodsService.selectGoodsByBrand(map);
		if(list.size()==0){
			jsonView.setMessage("没有数据");
		}
		jsonView.setResult(list);
		return jsonView;
	}*/
	/**
	 * 商品详情页
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public JsonObjectView selectGoodsByPrimaryKey(HttpServletRequest request)
			throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String id=request.getParameter("goods_id");
		Goods goods=goodsService.selectByPrimaryKey(id);
		jsonView.setResult(goods);
		return jsonView;
	}
	
	/**
	 * 筛选商品
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public JsonList<Goods> goodsSearchAll(@RequestBody GoodsSearchForm search,HttpServletRequest request)
			throws ApiException {
		JsonList<Goods> jsonView = new JsonList<Goods>();
		String cityCode=search.getCityCode();
		if (!StringUtils.isNotBlank(cityCode)) {
			throw new ApiException(APICode.SYS_CITY_CODE_NULL);
		}
		List<Goods> list=goodsService.goodsSearch(search);
		if(list.size()==0){
			jsonView.setMessage("没有数据");
		}
		jsonView.setResult(list);
		return jsonView;
	}
}
