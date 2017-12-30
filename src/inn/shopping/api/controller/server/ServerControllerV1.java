package inn.shopping.api.controller.server;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping("/v1/open/server")
public class ServerControllerV1 {
	

	@ResponseBody
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public JsonView syncServerTime(HttpServletRequest request) {
		JsonView jv = new JsonView();
		jv.getResult().put("server_time", System.currentTimeMillis() + "");
		return jv;
	}

}
