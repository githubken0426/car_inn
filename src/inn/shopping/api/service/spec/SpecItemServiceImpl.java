package inn.shopping.api.service.spec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.SpecItemMapper;
import inn.shopping.api.entity.SpecItem;

@Service(value = "specItemService")
public class SpecItemServiceImpl implements SpecItemService {
	@Autowired
	private SpecItemMapper dao;

	
	@Override
	public SpecItem selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
}
