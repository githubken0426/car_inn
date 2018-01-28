package inn.shopping.api.controller.comment;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import inn.shopping.api.entity.Commend;
import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAppend;
import inn.shopping.api.entity.CommentAttr;
import inn.shopping.api.entity.Reply;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.ReplyForm;
import inn.shopping.api.service.comment.CommentService;
import inn.shopping.api.utils.CommonUtil;
import inn.shopping.api.utils.Encrypt;
import inn.shopping.api.utils.FtpFileTools;
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
	public JsonObjectView commentList(HttpServletRequest request)
			throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String goodsId=request.getParameter("goods_id");
		String status=request.getParameter("status");
		CommentAttr comment=commentService.selectSyntheticalCommentByGoodsId(goodsId,status);
		jsonView.setResult(comment);
		return jsonView;
	}
	
	/**
	 * 评论详情
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws 
	 * @date 2018年1月26日 上午9:16:50
	 */
	@ResponseBody
	@RequestMapping(value = "open/comment/detail", method = RequestMethod.GET)
	public JsonObjectView commentDetail(HttpServletRequest request)
			throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String commentId=request.getParameter("comment_id");
		Comment detail =commentService.selectCommentDetail(commentId);
		CommentAppend append=commentService.selectCommentAppend(commentId);
		detail.setCommentAppend(append);
		jsonView.setResult(detail);
		return jsonView;
	}
	
	/**
	 * 添加评论
	 * @param attr
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws 
	 * @date 2018年1月23日 下午5:23:20
	 */
	@ResponseBody
	@RequestMapping(value = "comment/add", method = RequestMethod.POST)
	public JsonView commentAdd(Comment comment,HttpServletRequest request) throws ApiException {
		Map<String,Object> map=new HashMap<String,Object>();
		Map<String,Object> resultMap=new HashMap<String,Object>();
		JsonView jsonView = new JsonView();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		String token = multipartRequest.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		String goodsId =multipartRequest.getParameter("goods_id");
		String orderId=multipartRequest.getParameter("order_id");
		String commentId = CommonUtil.getUID();
		comment.setId(commentId);
		comment.setUserId(userId);
		comment.setGoodsId(goodsId);
		comment.setOrderId(orderId);
		List<Comment> list=commentService.selectCommentExists(comment);
		if(list.size()>0) {
			throw new ApiException(APICode.COMMENT_EXISTS_ERROR);
		}
		String describe = multipartRequest.getParameter("describe_status");
		int describeStatus = StringUtils.isNotBlank(describe) ? Integer.valueOf(describe) : 0;
		String attitude = multipartRequest.getParameter("service_attitude"); 
		int serviceAttitude = StringUtils.isNotBlank(attitude) ? Integer.valueOf(attitude) : 0;
		String logistics = multipartRequest.getParameter("service_logistics");
		int serviceLogistics = StringUtils.isNotBlank(logistics) ? Integer.valueOf(logistics) : 0;
		comment.setDescribeStatus(describeStatus);
		comment.setServiceAttitude(serviceAttitude);
		comment.setServiceLogistics(serviceLogistics);
		comment.setIsAppend("N");
		String[] savePath = { "carInn", "comment" };
		//获取上传文件的路径数组
		try {
			String picList = FtpFileTools.saveFileAndGetUrl(savePath, multipartRequest);
			if(StringUtils.isNotBlank(picList)) {
				comment.setIsPicture("Y");
				comment.setPicture(picList);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApiException(APICode.SYS_PICTURE_UPLOAD_ERROR);
		}
		map.put("orderId", orderId);
		map.put("status", 6);
		commentService.insertComment(comment,map);
		resultMap.put("comment_id", commentId);
		jsonView.setResult(resultMap);
		jsonView.setMessage("评论成功！");
		return jsonView;
	}
	
	/**
	 * 追加评论页面
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws 
	 * @date 2018年1月27日 上午9:13:51
	 */
	@ResponseBody
	@RequestMapping(value = "comment/appendpage", method = RequestMethod.GET)
	public JsonObjectView commentAppendPage(HttpServletRequest request) throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String commentId =request.getParameter("comment_id");
		Comment detail =commentService.selectCommentDetail(commentId);
		jsonView.setResult(detail);
		return jsonView;
	}
	
	/**
	 * 追加评论
	 * @param attr
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws 
	 * @date 2018年1月23日 下午5:23:20
	 */
	@ResponseBody
	@RequestMapping(value = "comment/append", method = RequestMethod.POST)
	public JsonObjectView commentAppend(CommentAppend append,HttpServletRequest request) throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		append.setId(CommonUtil.getUID());
		String commentId =multipartRequest.getParameter("comment_id");
		append.setCommentId(commentId);
		String[] savePath = { "carInn", "commentAppend" };
		//获取上传文件的路径数组
		try {
			String picList = FtpFileTools.saveFileAndGetUrl(savePath, multipartRequest);
			if(StringUtils.isNotBlank(picList)) {
				append.setPicture(picList);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new ApiException(APICode.SYS_PICTURE_UPLOAD_ERROR);
		}
		commentService.appendComment(append);
		jsonView.setResult("追加成功！");
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
	@RequestMapping(value = "comment/commend", method = RequestMethod.POST)
	public JsonView commentCommend(Commend commend,HttpServletRequest request) throws ApiException{
		Map<String,Object> map = new HashMap<String,Object>();
		JsonView jsonView = new JsonView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		String commentId=request.getParameter("comment_id");
		commend.setCommentId(commentId);
		commend.setUserId(userId);
		int result = commentService.insertCommend(commend);
		if(result==0)
			throw new ApiException(APICode.COMMEND_EXISTS_ERROR);
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
	
	/**
	 * 回复评论
	 * @param from
	 * @param request
	 * @return
	 * @throws ApiException
	 * @throws 
	 * @date 2018年1月27日 下午4:14:51
	 */
	@ResponseBody
	@RequestMapping(value = "reply/add", method = RequestMethod.POST)
	public JsonObjectView replyAdd(@RequestBody ReplyForm form, HttpServletRequest request)throws ApiException {
		JsonObjectView jsonView = new JsonObjectView();
		String token = request.getParameter("token");
		String userId = Encrypt.getEncryptUserId(token);
		Reply reply=new Reply();
		reply.setUserId(userId);
		reply.setId(CommonUtil.getUID());
		reply.setCommentId(form.getCommentId());
		reply.setContent(form.getContent());
		reply.setToUserId(form.getToUserId());
		commentService.insertReply(reply);
		jsonView.setResult("回复成功！");
		return jsonView;
	}
	
	
}
