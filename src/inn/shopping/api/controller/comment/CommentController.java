package inn.shopping.api.controller.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAttr;
import inn.shopping.api.entity.Reply;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.CartForm;
import inn.shopping.api.service.comment.CommentService;
import inn.shopping.api.utils.Encrypt;
import inn.shopping.api.view.JsonObjectView;
import inn.shopping.api.view.JsonView;

@Controller
@RequestMapping(value="v1/")
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
	@RequestMapping(value = "open/comment/list", method = RequestMethod.GET)
	public JsonObjectView commentList(CommentAttr attr,HttpServletRequest request)
			throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String goodsId=request.getParameter("goods_id");
		CommentAttr comment=commentService.selectSyntheticalCommentByGoodsId(goodsId);
		jsonView.setResult(comment);
		return jsonView;
	}
	/**
	 * 为评论点赞
	 * @param request
	 * @param cartForm
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "/commend", method = RequestMethod.POST)
	public JsonView commentCommend(HttpServletRequest request) throws ApiException{
		Map<String,Object> map = new HashMap<String,Object>();
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		
		jsonView.setMessage("添加成功");
		jsonView.setResult(map);
		return jsonView;
	}
	/**
	 * 查询评价所有回复
	 * @param request
	 * @return
	 * @throws ApiException
	 */
	@ResponseBody
	@RequestMapping(value = "open/reply/list", method = RequestMethod.GET)
	public JsonObjectView replyList(HttpServletRequest request)
			throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String commentId=request.getParameter("comment_id");
		List<Reply> list=commentService.selectReplyByCommentId(commentId);
		jsonView.setResult(list);
		return jsonView;
	}
}
