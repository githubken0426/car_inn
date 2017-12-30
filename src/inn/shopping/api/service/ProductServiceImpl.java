package inn.shopping.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.ProductMapper;
import inn.shopping.api.entity.Product;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper dao;

	@Override
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Product record) {
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Product record) {
		return dao.insertSelective(record);
	}

	@Override
	public Product selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Product record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Product record) {
		return dao.updateByPrimaryKey(record);
	}

}
