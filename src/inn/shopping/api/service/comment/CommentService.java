package inn.shopping.api.service.comment;

import java.util.List;

import inn.shopping.api.entity.Comment;

public interface CommentService {
	/**
	 * 查询商品评价
	 * @param goodsId
	 * @return
	 */
	public List<Comment> selectByGoodsId(String goodsId);
}
