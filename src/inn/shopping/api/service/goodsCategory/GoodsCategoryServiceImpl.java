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
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(GoodsCategory record) {
		return dao.insert(record);
	}

	@Override
	public int insertSelective(GoodsCategory record) {
		return dao.insertSelective(record);
	}

	@Override
	public GoodsCategory selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodsCategory record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GoodsCategory record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<GoodsCategory> selectAllCategory() {
		return dao.selectAllCategory();
	}
}
