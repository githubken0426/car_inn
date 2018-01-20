package inn.shopping.api.dao;

import java.util.List;

import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAttr;

public interface CommentMapper {
	/**
	 * 查询商品评价
	 * @param goodsId
	 * @return
	 */
	public List<Comment> selectByGoodsId(String goodsId);
	
	/**
	 * 查询评论属性
	 * @param goodsId
	 * @return
	 * @throws 
	 * @date 2018年1月20日 下午5:47:49
	 */
	public List<CommentAttr> selectCommentAttrByGoodsId(String goodsId);
	
}
