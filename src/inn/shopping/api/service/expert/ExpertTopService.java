package inn.shopping.api.service.expert;

import java.util.List;
import java.util.Map;

import inn.shopping.api.entity.ExpertTop;


public interface ExpertTopService {

	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<ExpertTop> queryExpertTopList(Map<String, Object> map);


	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public ExpertTop getDataById(String id) throws Exception;

	
}
