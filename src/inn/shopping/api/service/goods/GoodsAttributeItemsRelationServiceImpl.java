package inn.shopping.api.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.GoodsAttributeItemsRelationMapper;
import inn.shopping.api.entity.GoodsAttributeItemsRelation;
@Transactional
@Service(value = "goodsAttributeItemsRelationService")
public class GoodsAttributeItemsRelationServiceImpl implements GoodsAttributeItemsRelationService {
	@Autowired
	private GoodsAttributeItemsRelationMapper dao;

	@Override
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(GoodsAttributeItemsRelation record) {
		return dao.insert(record);
	}

	@Override
	public int insertSelective(GoodsAttributeItemsRelation record) {
		return dao.insertSelective(record);
	}

	@Override
	public GoodsAttributeItemsRelation selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodsAttributeItemsRelation record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(GoodsAttributeItemsRelation record) {
		return dao.updateByPrimaryKey(record);
	}

	

}
