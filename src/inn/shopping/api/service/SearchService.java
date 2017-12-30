package inn.shopping.api.service;

import inn.shopping.api.entity.Search;

public interface SearchService {

	int deleteByPrimaryKey(String id);

    int insert(Search record);

    int insertSelective(Search record);

    Search selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Search record);

    int updateByPrimaryKey(Search record);
}
