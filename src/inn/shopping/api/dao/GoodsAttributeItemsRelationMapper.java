package inn.shopping.api.dao;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.GoodsAttributeItemsRelation;
@Repository
public interface GoodsAttributeItemsRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsAttributeItemsRelation record);

    int insertSelective(GoodsAttributeItemsRelation record);

    GoodsAttributeItemsRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsAttributeItemsRelation record);

    int updateByPrimaryKey(GoodsAttributeItemsRelation record);
}