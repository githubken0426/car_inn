package inn.shopping.api.service.search;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Search;

public interface SearchService {

	int updateStatusByPrimaryKey(@Param("deleteFlag")String deleteFlag,@Param("id")String id);

    int insertOrUpdate(Search record);

    Map<String,Object> selectAllSearch(Map<String,Object> map);
}
