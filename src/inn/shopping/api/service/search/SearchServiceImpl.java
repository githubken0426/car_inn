package inn.shopping.api.service.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.InnApiConfig;
import inn.shopping.api.dao.SearchMapper;
import inn.shopping.api.entity.Search;

@Service(value = "searchService")
@Transactional
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchMapper dao;


	@Override
	public int insertOrUpdate(Search record){
		Search search = dao.selectByDeviceUserId(record.getDeviceToken(), record.getUserId(), record.getSearchTag());
		if (search == null)
			dao.insert(record);
		else
			dao.updateStatusByPrimaryKey("0", search.getId());
		return 1;
	}

	@Override
	public Map<String,Object> selectAllSearch(Map<String, Object> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Integer hotNumber = Integer.valueOf(InnApiConfig.INN_API.getValue("hot_number"));
		Integer searchCount = Integer.valueOf(InnApiConfig.INN_API.getValue("search_count"));
		List<String> hotSearch = dao.selectHotSearch(hotNumber, searchCount);
		resultMap.put("hot_search", hotSearch);
		List<Search> list = dao.selectAllSearch(map);
		resultMap.put("search_list", list);
		return resultMap;
	}

	@Override
	public int batchClearSearchTag(String deviceToken) {
		return dao.batchClearSearchTag(deviceToken);
	}
}
