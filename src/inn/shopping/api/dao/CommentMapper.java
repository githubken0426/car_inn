package inn.shopping.api.dao;

import inn.shopping.api.entity.Comment;

public interface CommentMapper {
	public Comment selectByPrimaryKey(String id);
	
}
