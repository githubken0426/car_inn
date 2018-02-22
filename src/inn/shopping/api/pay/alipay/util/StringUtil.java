package inn.shopping.api.pay.alipay.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class StringUtil {
	/**
	 * 本方法封装了往前台设置的header,contentType等信息
	 * 
	 * @param message
	 *            需要传给前台的数据
	 * @param type
	 *            指定传给前台的数据格式，如"html","json"等
	 * @param response
	 *            HttpServletResponse对象
	 * @throws IOException
	 */
	public static void writeToWeb(String message, String type, HttpServletResponse response) throws IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/" + type + "; charset=utf-8");
		response.getWriter().write(message);
		response.getWriter().close();

	}

	/**
	 * 本方法用于分页页面数据json处理
	 * 
	 * @param list
	 * @param total
	 * @throws Exception
	 */
	/*
	public static void toBeJson(List list, int total) throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();

		JSONObject jobj = new JSONObject();
		jobj.accumulate("total", total);
		jobj.accumulate("rows", list);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jobj.toString());
		// log.info(jobj.toString());
	}*/
}
