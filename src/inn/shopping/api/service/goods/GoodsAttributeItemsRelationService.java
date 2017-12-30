package inn.shopping.api.service.goods;

import inn.shopping.api.entity.GoodsAttributeItemsRelation;

public interface GoodsAttributeItemsRelationService {

	int deleteByPrimaryKey(String id);

    int insert(GoodsAttributeItemsRelation record);

    int insertSelective(GoodsAttributeItemsRelation record);

    GoodsAttributeItemsRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsAttributeItemsRelation record);

    int updateByPrimaryKey(GoodsAttributeItemsRelation record);
	
}
