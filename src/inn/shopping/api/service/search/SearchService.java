package inn.shopping.api.service.search;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Search;

public interface SearchService {

    int insertOrUpdate(Search record);

    Map<String,Object> selectAllSearch(Map<String,Object> map);
    
    /**
     * 批量删除搜索记录(更新状态)
     * @param deleteFlag
     * @param id
     * @return
     * @throws 
     * @date 2018年1月31日 下午5:39:48
     */
    int batchClearSearchTag(@Param("deviceToken")String deviceToken);
}
