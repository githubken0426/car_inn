package inn.shopping.api.service.spec;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.SpecMapper;
import inn.shopping.api.entity.Spec;

@Service(value = "specService")
public class SpecServiceImpl implements SpecService {
	@Autowired
	private SpecMapper dao;


	@Override
	public List<Spec> selectGoodsSpecItems(Map<String, Object> map) {
		return dao.selectGoodsSpecItems(map);
	}
	@Override
	public Spec selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
}
