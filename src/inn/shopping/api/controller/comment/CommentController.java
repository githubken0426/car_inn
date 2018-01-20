package inn.shopping.api.controller.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Comment;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.service.comment.CommentService;
import inn.shopping.api.view.JsonList;

@Controller
@RequestMapping(value="v1/open/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	/**
	 * 获取用论列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonList<Comment> appAddressList(HttpServletRequest request)
			throws ApiException {
		JsonList<Comment> jsonView = new JsonList<Comment>();
		String goodsId=request.getParameter("goods_id");
		List<Comment> list=commentService.selectByGoodsId(goodsId);
		if(list.size()==0){
			jsonView.setMessage("没有数据");
		}
		jsonView.setResult(list);
		return jsonView;
	}
	
}
