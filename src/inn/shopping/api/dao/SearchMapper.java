package inn.shopping.api.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Search;
@Repository
public interface SearchMapper {
	/**
	 * 删除搜索记录
	 * @param id
	 * @return
	 * @throws 
	 * @date 2018年1月27日 下午5:04:37
	 */
    int updateStatusByPrimaryKey(@Param("deleteFlag")String deleteFlag,@Param("id")String id);
    /**
     * 新增或修改搜索记录
     * @param record
     * @return
     * @throws 
     * @date 2018年1月27日 下午5:04:49
     */
    int insert(Search record);
    
    Search selectByDeviceUserId(@Param("deviceToken")String deviceToken,@Param("userId")String userId,@Param("searchTag")String searchTag);
    
    List<Search> selectAllSearch(Map<String,Object> map);
    
    /**
     * 动态获取热门搜索
     * @param hotNumber
     * @param searchCount
     * @return
     * @throws 
     * @date 2018年1月31日 下午2:34:31
     */
    List<String> selectHotSearch(@Param("hotNumber")Integer hotNumber,@Param("searchCount")Integer searchCount);
}