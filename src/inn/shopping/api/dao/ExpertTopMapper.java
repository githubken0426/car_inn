package inn.shopping.api.dao;

import java.util.List;
import java.util.Map;

import inn.shopping.api.entity.ExpertTop;


public interface ExpertTopMapper {
	/**
	 * 查询所有数据
	 * @return
	 * 2016-12-14 上午09:32:41
	 */
	public List<ExpertTop> queryExpertTopList(Map<String,Object> map);
	
    ExpertTop selectByPrimaryKey(String id);
   
}