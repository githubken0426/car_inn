package inn.shopping.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.SearchMapper;
import inn.shopping.api.entity.Search;

@Service(value = "searchService")
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchMapper dao;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Search record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Search record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Search selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Search record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Search record) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
