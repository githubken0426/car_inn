package inn.shopping.api.service.goodsBrand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.GoodsBrandMapper;
import inn.shopping.api.entity.GoodsBrand;
@Transactional
@Service(value = "goodsBrandService")
public class GoodsBrandServiceImpl implements GoodsBrandService {
	@Autowired
	private GoodsBrandMapper dao;
	
	@Override
	public List<GoodsBrand> selectCategoryBrand(String categoryId) {
		return dao.selectCategoryBrand(categoryId);
	}

}
