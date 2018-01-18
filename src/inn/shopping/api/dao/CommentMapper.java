package inn.shopping.api.dao;

import java.util.List;

import inn.shopping.api.entity.Comment;

public interface CommentMapper {
	/**
	 * 查询商品评价
	 * @param goodsId
	 * @return
	 */
	public List<Comment> selectByGoodsId(String goodsId);
	
}
