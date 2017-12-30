package inn.shopping.api.service;

import inn.shopping.api.entity.Product;

public interface ProductService {
	int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}
