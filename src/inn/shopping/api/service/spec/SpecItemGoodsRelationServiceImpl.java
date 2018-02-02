package inn.shopping.api.service.spec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.SpecItemGoodsRelationMapper;
import inn.shopping.api.entity.SpecItemGoodsRelation;
@Transactional
@Service(value = "goodsSpecRelationService")
public class SpecItemGoodsRelationServiceImpl implements SpecItemGoodsRelationService {
	@Autowired
	private SpecItemGoodsRelationMapper dao;

	@Override
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SpecItemGoodsRelation record) {
		return dao.insert(record);
	}

	@Override
	public int insertSelective(SpecItemGoodsRelation record) {
		return dao.insertSelective(record);
	}

	@Override
	public SpecItemGoodsRelation selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SpecItemGoodsRelation record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SpecItemGoodsRelation record) {
		return dao.updateByPrimaryKey(record);
	}
}
