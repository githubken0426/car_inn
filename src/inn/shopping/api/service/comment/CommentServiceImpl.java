package inn.shopping.api.service.comment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.CommentMapper;
import inn.shopping.api.dao.OrderMapper;
import inn.shopping.api.dao.SpecItemMapper;
import inn.shopping.api.dao.SpecMapper;
import inn.shopping.api.entity.Commend;
import inn.shopping.api.entity.Comment;
import inn.shopping.api.entity.CommentAppend;
import inn.shopping.api.entity.CommentAttr;
import inn.shopping.api.entity.Reply;
import inn.shopping.api.entity.Spec;
import inn.shopping.api.entity.SpecItem;

@Service(value="commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentMapper dao;
	@Autowired
	private OrderMapper orderDao;
	@Autowired
	private SpecItemMapper specItemDao;
	@Autowired
	private SpecMapper specDao;
	
	@Override
	public List<Comment> selectByGoodsId(String goodsId) {
		return dao.selectByGoodsId(goodsId);
	}

	@Override
	public CommentAttr selectSyntheticalCommentByGoodsId(String goodsId) {
		List<Comment> resultlist = new ArrayList<Comment>();
		CommentAttr comment=dao.selectSyntheticalCommentByGoodsId(goodsId);
		for (Comment comm : dao.selectByGoodsId(goodsId)) {
			List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
			if (StringUtils.isNotBlank(comm.getSpecItemIds())) {
				List<String> ids = Arrays.asList(comm.getSpecItemIds().split(","));
				for (String item : ids) {
					Map<String, String> map = new HashMap<String, String>();
					SpecItem specItem = specItemDao.selectByPrimaryKey(item);
					// 查询出规格名
					String specId = specItem.getSpecId();
					Spec spec = specDao.selectByPrimaryKey(specId);
					map.put("key", spec.getName());
					map.put("value", specItem.getItem());
					mapList.add(map);
				}
				comm.setSpecItemList(mapList);
			}
			resultlist.add(comm);
		}
		comment.setCommentList(resultlist);
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

	@Override
	public int appendComment(CommentAppend append) {
		dao.updateIsAppend(append.getCommentId());
		return dao.appendComment(append);
	}

}
