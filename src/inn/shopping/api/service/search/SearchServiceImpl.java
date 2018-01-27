package inn.shopping.api.service.search;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.SearchMapper;
import inn.shopping.api.entity.Search;

@Service(value = "searchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchMapper dao;

	@Override
	public int updateStatusByPrimaryKey(String deleteFlag,String id) {
		return dao.updateStatusByPrimaryKey(deleteFlag,id);
	}

	@Override
	public int insertOrUpdate(Search record) {
		Search search = dao.selectByDeviceUserId(record.getDeviceToken(),record.getUserId(),record.getUserId());
		if(search==null)
			dao.insert(record);
		else
			dao.updateStatusByPrimaryKey("0",record.getId());
		return 1;
	}

	@Override
	public List<Search> selectAllSearch(Map<String, Object> map) {
		return dao.selectAllSearch(map);
	}
}
