package inn.shopping.api.controller.expert;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.ExpertTop;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.service.expert.ExpertTopService;
import inn.shopping.api.view.JsonList;

@Controller
@RequestMapping(value="v1/open/expert")
public class ExpertController {
	@Autowired
	private ExpertTopService expertService;
	
	/**
	 * 获取广告列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonList<ExpertTop> appAddressList(HttpServletRequest request)
			throws ApiException {
		JsonList<ExpertTop> jsonView = new JsonList<ExpertTop>();
		String cityCode=request.getParameter("city_code");
		String categoryId=request.getParameter("category_id");
		if (!StringUtils.isNotBlank(cityCode)) {
			throw new ApiException(APICode.SYS_CITY_CODE_NULL);
		}
		if (!StringUtils.isNotBlank(categoryId)) {
			throw new ApiException(APICode.EXPERT_CATEGORY_NULL);
		}
		List<ExpertTop> list=expertService.selectExpertByCategory(categoryId, cityCode);
		jsonView.setResult(list);
		return jsonView;
	}
	
}
