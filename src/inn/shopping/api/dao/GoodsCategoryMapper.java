package inn.shopping.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.GoodsCategory;
@Repository
public interface GoodsCategoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);
    
    /**
     * 查询所有商品
     * @return
     * @throws 
     * @date 2017年9月22日 上午9:45:38
     */
    List<GoodsCategory> selectAllCategory();
}