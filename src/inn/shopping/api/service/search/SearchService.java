package inn.shopping.api.service.search;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Search;

public interface SearchService {

	int updateStatusByPrimaryKey(@Param("deleteFlag")String deleteFlag,@Param("id")String id);

    int insertOrUpdate(Search record);

    List<Search> selectAllSearch(Map<String,Object> map);
}
