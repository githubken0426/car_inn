package inn.shopping.api.service.expert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.ExpertTopMapper;
import inn.shopping.api.entity.ExpertTop;

@Service(value="expertService")
public class ExpertTopServiceImpl implements ExpertTopService {
	@Autowired
	private ExpertTopMapper dao;
	
	@Override
	public List<ExpertTop> selectExpertByCategory(String categoryId, String cityCode) {
		return dao.selectExpertByCategory(categoryId, cityCode);
	}

}
