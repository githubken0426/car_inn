package inn.shopping.api.service.expert;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.ExpertTopMapper;
import inn.shopping.api.entity.ExpertTop;


@Service(value = "expertTopService")
public class ExpertTopServiceImpl implements ExpertTopService {
	@Autowired
	private ExpertTopMapper dao;

	@Override
	public List<ExpertTop> queryExpertTopList(Map<String, Object> map) {
		return dao.queryExpertTopList(map);
	}

	@Override
	public ExpertTop getDataById(String id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}
}
