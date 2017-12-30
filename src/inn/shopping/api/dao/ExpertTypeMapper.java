package inn.shopping.api.dao;

import java.util.List;

import inn.shopping.api.entity.ExpertType;


public interface ExpertTypeMapper {
	/**
	 * 查询所有数据
	 * @return
	 * 2016-12-14 上午08:31:36
	 */
	public List<ExpertType> queryAllData();

    ExpertType selectByPrimaryKey(String id);
}