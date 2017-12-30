package inn.shopping.api.controller.advertisement;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Advertisement;
import inn.shopping.api.enums.ErrorCode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.service.advertisement.AdvertisementService;
import inn.shopping.api.view.JsonList;

@Controller
@RequestMapping(value="v1/open/advertisement")
public class AdvertisementController {
	@Autowired
	private AdvertisementService advertisementService;
	
	/**
	 * 获取广告列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonList<Advertisement> appAddressList(HttpServletRequest request)
			throws ApiException {
		JsonList<Advertisement> jsonView = new JsonList<Advertisement>();
		String cityCode=request.getParameter("city_code");
		if (!StringUtils.isNotBlank(cityCode)) {
			throw new ApiException(ErrorCode.SYS_CITY_CODE_NULL);
		}
		List<Advertisement> list=advertisementService.selectAllAdvertisement(cityCode);
		jsonView.setResult(list);
		return jsonView;
	}
	
}
