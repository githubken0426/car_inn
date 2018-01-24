package inn.shopping.api.service.comment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.CommentMapper;
import inn.shopping.api.dao.OrderMapper;
import inn.shopping.api.entity.Commend;
import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAttr;
import inn.shopping.api.entity.Reply;

@Service(value="commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper dao;
	@Autowired
	private OrderMapper orderDao;
	
	@Override
	public List<Comment> selectByGoodsId(String goodsId) {
		return dao.selectByGoodsId(goodsId);
	}

	@Override
	public CommentAttr selectSyntheticalCommentByGoodsId(String goodsId) {
		CommentAttr comment=dao.selectSyntheticalCommentByGoodsId(goodsId);
		List<Comment> list=dao.selectByGoodsId(goodsId);
		comment.setCommentList(list);
		return comment;
	}

	@Override
	public List<Reply> selectReplyByCommentId(String commentId) {
		return dao.selectReplyByCommentId(commentId);
	}

	@Override
	public int insertCommend(Commend commend) {
		List<Commend> list = dao.selectCommendExists(commend);
		if (list.size() > 0)//已结点过赞了
			return 0;
		return dao.insertCommend(commend);
	}

	@Override
	public int insertComment(Comment comment,Map<String,Object> map){
		//更新订单状态，修改为6订单完成
		orderDao.updateOrderStatus(map);
		return dao.insertComment(comment);
	}

	@Override
	public List<Comment> selectCommentExists(Comment comment) {
		return dao.selectCommentExists(comment);
	}

}
