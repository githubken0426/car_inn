package inn.shopping.api.service.goodsCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.GoodsCategoryMapper;
import inn.shopping.api.entity.GoodsCategory;
@Transactional
@Service(value = "goodsCategoryService")
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
	@Autowired
	private GoodsCategoryMapper dao;

	@Override
	public GoodsCategory selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public List<GoodsCategory> selectAllCategory() {
		return dao.selectAllCategory();
	}
}
