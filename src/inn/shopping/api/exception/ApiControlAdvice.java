package inn.shopping.api.exception;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.enums.APICode;
import net.sf.json.JSONObject;

@ControllerAdvice
public class ApiControlAdvice {
	private Logger logger = Logger.getLogger(ApiControlAdvice.class);
	
	@ResponseBody
	@ExceptionHandler(value = ApiException.class)
	public JSONObject handle(ApiException e) {
		// *记入异常日志
		logger.error(((ApiException) e).getErrcode().getCodeMessage(), e);
		JSONObject result = ((ApiException) e).getErrcode().toJSONObject();
		return result;
	}

	@ResponseBody
	@ExceptionHandler(value = RuntimeException.class)
	public JSONObject handle(RuntimeException e) {
		// *记入异常日志
		logger.error(e.getMessage(), e);
		JSONObject result = APICode.SYS_ERR_CODE.toJSONObject();
		return result;
	}

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public JSONObject handle(Exception e) {
		logger.error(e.getMessage(), e);
		// *记入异常日志
		JSONObject result = APICode.SYS_ERR_CODE.toJSONObject();
		return result;
	}
}
