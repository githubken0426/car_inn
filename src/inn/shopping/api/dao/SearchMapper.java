package inn.shopping.api.dao;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Search;
@Repository
public interface SearchMapper {
    int deleteByPrimaryKey(String id);

    int insert(Search record);

    int insertSelective(Search record);

    Search selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Search record);

    int updateByPrimaryKey(Search record);
}