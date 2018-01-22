package inn.shopping.api.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.CommentMapper;
import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAttr;
import inn.shopping.api.entity.Reply;

@Service(value="commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper dao;
	
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

}
