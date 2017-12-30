package inn.shopping.api.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.GoodsAttribute;
@Repository
public interface GoodsAttributeMapper {
    
    GoodsAttribute selectByPrimaryKey(String id);

    /**
     * 查询商品属性列表
     * @param map
     * @return
     */
    List<GoodsAttribute> selectGoodsAttributeItems(Map<String,Object> map);
    
}