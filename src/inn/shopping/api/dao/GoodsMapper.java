package inn.shopping.api.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Goods;


@Repository
public interface GoodsMapper {
	/**
	 * 商品详情
	 * @param map
	 * @return
	 */
    Goods selectByPrimaryKey(Map<String,Object> map);
    
    List<Goods> selectHotGoods(Map<String,Object> map);
    
    List<Goods> selectGoodsSortByAll(@Param("cityCode") String cityCode);
    
    List<Goods> selectGoodsSortByNumber(@Param("cityCode") String cityCode);
    
    List<Goods> selectGoodsSortByPrice(Map<String,Object> map);
    
    /**
     * 根据品牌查找商品
     * @param map
     * @return
     */
    List<Goods> selectGoodsByBrand(Map<String,Object> map);
    
}