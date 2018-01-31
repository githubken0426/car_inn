package inn.shopping.api.controller.search;

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
import inn.shopping.api.entity.Search;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.SearchForm;
import inn.shopping.api.service.goods.GoodsService;
import inn.shopping.api.service.search.SearchService;
import inn.shopping.api.utils.CommonUtil;
import inn.shopping.api.utils.Encrypt;
import inn.shopping.api.view.JsonList;
import inn.shopping.api.view.JsonObjectView;
import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping(value="v1/open/search")
public class SearchController {
	@Autowired
	private SearchService searchService;
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * 获取搜索列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonObjectView list(HttpServletRequest request) throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		Map<String, Object> map = new HashMap<String, Object>();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		map.put("userId", userId);
		String deviceToken = request.getParameter("device_token");
		map.put("deviceToken", deviceToken);
		Map<String, Object> resultMap = searchService.selectAllSearch(map);
		jsonView.setResult(resultMap);
		return jsonView;
	}
	
	/**
	 * 筛选商品
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public JsonList<Goods> goodsSearchAll(HttpServletRequest request)
			throws ApiException {
		JsonList<Goods> jsonView = new JsonList<Goods>();
		Map<String, Object> map = new HashMap<String, Object>();
		String cityCode=request.getParameter("city_code");
		if (!StringUtils.isNotBlank(cityCode)) {
			throw new ApiException(APICode.SYS_CITY_CODE_NULL);
		}
		String searchTag=request.getParameter("search_tag");
		map.put("searchTag", searchTag);
		map.put("cityCode", cityCode);
		List<Goods> list=goodsService.selectGoodsBySearchTag(map);
		if(list.size()==0){
			jsonView.setMessage("没有数据");
		}
		jsonView.setResult(list);
		return jsonView;
	}
	
	/**
	 * 添加搜索记录
	 * @throws ApiException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public JsonView add(@RequestBody SearchForm form,HttpServletRequest request) throws ApiException{
		Map<String,Object> map = new HashMap<String,Object>();
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		Search search = new Search();
		search.setUserId(userId);
		search.setId(CommonUtil.getUID());
		search.setDeviceToken(form.getDeviceToken());
		search.setSearchTag(form.getSearchTag());
		int deviceType = 0;
		String type = form.getDeviceType();
		if (StringUtils.isNotBlank(type))
			deviceType = Integer.valueOf(deviceType);
		search.setDeviceType(deviceType);
		search.setDeleteFlag(0);
		
		searchService.insertOrUpdate(search);
		jsonView.setMessage("添加成功");
		jsonView.setResult(map);
		return jsonView;
	}
	/**
	 * 删除搜索记录
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public JsonView delete(HttpServletRequest request) throws ApiException{
		JsonView jsonView = new JsonView();
		String deviceToken = request.getParameter("device_token");
		searchService.batchClearSearchTag(deviceToken);
		jsonView.setMessage("删除成功");
		return jsonView;
	}
}
