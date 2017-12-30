package inn.shopping.api.controller.expert;

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

import inn.shopping.api.entity.ExpertTop;
import inn.shopping.api.entity.ExpertType;
import inn.shopping.api.enums.ErrorCode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.ExpertForm;
import inn.shopping.api.service.expert.ExpertTopService;
import inn.shopping.api.service.expert.ExpertTypeService;
import inn.shopping.api.view.JsonList;

/**
 * 达人榜相关
 * 
 * @author ken
 * 2016-12-14 上午11:02:31
 */
@Controller
@RequestMapping("v1/open/expert")
public class ExpertController {
	@Autowired
	private ExpertTypeService expertTypeService;
	@Autowired
	private ExpertTopService expertTopService;
	/**
	 * 查询所有达人类别
	 * @param request
	 * @return
	 * 2016-12-14 上午08:38:04
	 */
	@ResponseBody
	@RequestMapping(value = "/type", method = RequestMethod.POST)
	public JsonList<ExpertType> queryTypeData(HttpServletRequest request) throws ApiException{
		JsonList<ExpertType> jv = new JsonList<ExpertType>();
		List<ExpertType> typeList=expertTypeService.queryAllData();
		jv.setResult(typeList);
		return jv;
	}
	/**
	 * 查询所有达人
	 * @param request
	 * @return
	 * 2016-12-14 上午08:38:04
	 */
	@ResponseBody
	@RequestMapping(value = "/top", method = RequestMethod.POST)
	public JsonList<ExpertTop> queryTopData(@RequestBody ExpertForm form,HttpServletRequest request) throws ApiException{
		JsonList<ExpertTop> view = new JsonList<ExpertTop>();
		Map<String,Object> map=new HashMap<String,Object>();
		String cityCode=form.getCityCode();
		if (!StringUtils.isNotBlank(cityCode)) {
			throw new ApiException(ErrorCode.SYS_CITY_CODE_NULL);
		}
		map.put("cityCode", cityCode);
		String type=form.getExpertType();
		map.put("type", type);
		List<ExpertTop> topList=expertTopService.queryExpertTopList(map);
		if(topList.size()==0){
			view.setMessage("没有数据");
		}
		view.setResult(topList);
		return view;
	}

}
