package inn.shopping.api.service.expert;

import java.util.List;

import inn.shopping.api.entity.ExpertType;


public interface ExpertTypeService {
	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public ExpertType getDataById(String id) throws Exception;
	/**
	 * 查询所有数据
	 * @return
	 * 2016-12-14 上午08:31:36
	 */
	public List<ExpertType> queryAllData();
	
}
