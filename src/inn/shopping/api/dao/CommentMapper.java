package inn.shopping.api.dao;

import java.util.List;

import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAttr;
import inn.shopping.api.entity.Reply;

public interface CommentMapper {
	/**
	 * 查询商品评价
	 * @param goodsId
	 * @return
	 */
	public List<Comment> selectByGoodsId(String goodsId);
	
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
	
}
