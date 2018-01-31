package inn.shopping.api.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Goods;
import inn.shopping.api.form.GoodsSearchForm;


@Repository
public interface GoodsMapper {
	/**
	 * 商品详情
	 * @param map
	 * @return
	 */
    Goods selectByPrimaryKey(String id);
    
    List<Goods> selectHotGoods(Map<String,Object> map);
    
    List<Goods> selectGoodsSort(Map<String,Object> map);
    
    /**
     * 商品筛选
     * 价格、属性、规格、品牌
     * @param search
     * @return
     */
    List<Goods> goodsSearch(@Param("search") GoodsSearchForm search);
    
    /**
     * 根据品牌筛选商品
     * @param map
     * @return
     * @throws 
     * @date 2018年1月20日 下午4:08:35
     */
    List<Goods> selectGoodsByBrand(Map<String, Object> map);
    
	List<String> selectHotIdsByBrand(Map<String,Object> map);
	
	/**
	 * 搜索标签，搜索商品
	 * @param map
	 * @return
	 * @throws 
	 * @date 2018年1月31日 下午3:09:41
	 */
	List<Goods> selectGoodsBySearchTag(Map<String,Object> map);
}