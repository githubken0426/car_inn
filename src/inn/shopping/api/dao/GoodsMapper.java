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
    
}