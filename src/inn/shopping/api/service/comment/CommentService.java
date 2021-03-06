package inn.shopping.api.service.comment;

import java.util.List;
import java.util.Map;

import inn.shopping.api.entity.Commend;
import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAppend;
import inn.shopping.api.entity.CommentAttr;
import inn.shopping.api.entity.Reply;

public interface CommentService {
	/**
	 * 查询商品评价
	 * @param goodsId
	 * @return
	 */
	public List<Comment> selectByGoodsId(String goodsId,String status);
	
	public List<Comment> selectCommentExists(Comment comment);
	
	/**
	 * 综合查询商品评价
	 * @param goodsId
	 * @return
	 * @throws 
	 * @date 2018年1月20日 下午5:47:49
	 */
	public CommentAttr selectSyntheticalCommentByGoodsId(String goodsId,String status);
	
	/**
	 * 查询评价的回复
	 * @param commentId
	 * @return
	 */
	public List<Reply> selectReplyByCommentId(String commentId);
	/**
	 * 新增评论
	 * @param comment
	 * @return
	 * @throws 
	 * @date 2018年1月23日 下午6:00:42
	 */
	public int insertComment(Comment comment,Map<String,Object> map);
	/**
	 * 评论点赞
	 * @param commend
	 * @return
	 * @throws 
	 * @date 2018年1月23日 下午4:10:05
	 */
	public int insertCommend(Commend commend);
	
	/**
	 * 追加评论
	 * @param append
	 * @return
	 */
	public int appendComment(CommentAppend append);
	
	/**
	 * 查看评论详情
	 * @param commentId
	 * @return
	 */
	public Comment selectCommentDetail(String commentId);
	/**
	 * 查找某条评论的追加评论
	 * @param commentId
	 * @return
	 * @throws 
	 * @date 2018年1月27日 上午9:03:03
	 */
	public CommentAppend selectCommentAppend(String commentId);
	/**
	 * 新增回复
	 * @param reply
	 * @return
	 * @throws 
	 * @date 2018年1月27日 下午4:19:44
	 */
	public int insertReply(Reply reply);
}
