package inn.shopping.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Commend;
import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAppend;
import inn.shopping.api.entity.CommentAttr;
import inn.shopping.api.entity.Reply;

public interface CommentMapper {
	/**
	 * 查询商品评价
	 * @param goodsId
	 * @return
	 */
	public List<Comment> selectByGoodsId(@Param("goodsId")String goodsId,@Param("status")String status);
	
	public List<Comment> selectCommentExists(Comment comment);
	/**
	 * 查看评论详情
	 * @param commentId
	 * @return
	 */
	public Comment selectCommentDetail(String commentId);
	
	public CommentAppend selectCommentAppend(String commentId);
	
	/**
	 * 新增评论
	 * @param comment
	 * @return
	 * @throws 
	 * @date 2018年1月23日 下午6:00:42
	 */
	public int insertComment(Comment comment);
	/**
	 * is_append
	 * @param commentId
	 * @return
	 */
	public int updateIsAppend(String commentId);
	
	public int appendComment(CommentAppend append);
	/**
	 * 综合查询商品评价
	 * @param goodsId
	 * @return
	 * @throws 
	 * @date 2018年1月20日 下午5:47:49
	 */
	public CommentAttr selectSyntheticalCommentByGoodsId(String goodsId);
	
	/**
	 * 查询评价的回复
	 * @param commentId
	 * @return
	 */
	public List<Reply> selectReplyByCommentId(String commentId);
	
	public int insertReply(Reply reply);
	
	/**
	 * 插入评论
	 * @param commend
	 * @return
	 * @throws 
	 * @date 2018年1月23日 下午4:10:05
	 */
	public int insertCommend(Commend commend);
	
	public List<Commend> selectCommendExists(Commend commend);
}
