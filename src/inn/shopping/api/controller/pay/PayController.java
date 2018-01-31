package inn.shopping.api.controller.pay;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import inn.shopping.api.exception.ApiException;

@Controller
@RequestMapping(value="v1/open/pay")
public class PayController {
	
	@ResponseBody
	@RequestMapping(value = "/alipay/notify", method = RequestMethod.GET)
	public ModelAndView goodsHot(ModelAndView view,HttpServletRequest request)
			throws ApiException {
		view.setViewName("resources/alipay/notify_url");
		return view;
	}
	
}
