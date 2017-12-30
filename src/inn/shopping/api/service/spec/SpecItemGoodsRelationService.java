package inn.shopping.api.service.spec;

import inn.shopping.api.entity.SpecItemGoodsRelation;

public interface SpecItemGoodsRelationService {

	int deleteByPrimaryKey(String id);

	int insert(SpecItemGoodsRelation record);

	int insertSelective(SpecItemGoodsRelation record);

	SpecItemGoodsRelation selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SpecItemGoodsRelation record);

	int updateByPrimaryKey(SpecItemGoodsRelation record);

}
