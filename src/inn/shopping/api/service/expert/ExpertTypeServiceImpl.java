package inn.shopping.api.service.expert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.ExpertTypeMapper;
import inn.shopping.api.entity.ExpertType;


@Service(value = "expertTypeService")
public class ExpertTypeServiceImpl implements ExpertTypeService {
	@Autowired
	private ExpertTypeMapper dao;


	@Override
	public ExpertType getDataById(String id) throws Exception {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public List<ExpertType> queryAllData() {
		return dao.queryAllData();
	}

}
