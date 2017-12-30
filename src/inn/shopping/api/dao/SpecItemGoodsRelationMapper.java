package inn.shopping.api.dao;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.SpecItemGoodsRelation;
@Repository
public interface SpecItemGoodsRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(SpecItemGoodsRelation record);

    int insertSelective(SpecItemGoodsRelation record);

    SpecItemGoodsRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SpecItemGoodsRelation record);

    int updateByPrimaryKey(SpecItemGoodsRelation record);
}