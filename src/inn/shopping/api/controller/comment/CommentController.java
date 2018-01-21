package inn.shopping.api.controller.comment;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAttr;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.service.comment.CommentService;
import inn.shopping.api.view.JsonObjectView;

@Controller
@RequestMapping(value="v1/open/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	/**
	 * 获取评论列表
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public JsonObjectView appAddressList(CommentAttr attr,HttpServletRequest request)
			throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String goodsId=request.getParameter("goods_id");
		CommentAttr comment=commentService.selectSyntheticalCommentByGoodsId(goodsId);
		jsonView.setResult(comment);
		return jsonView;
	}
	
}
