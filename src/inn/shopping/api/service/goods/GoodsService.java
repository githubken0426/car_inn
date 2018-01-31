package inn.shopping.api.service.goods;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Goods;
import inn.shopping.api.form.GoodsSearchForm;

public interface GoodsService {
	/**
	 * 商品详情
	 * @param map
	 * @return
	 */
    Goods selectByPrimaryKey(String id);
    
    /**
     * 查询商品
     * @param map
     * @return
     * @throws 
     * @date 2017年9月22日 下午3:42:40
     */
    List<Goods> selectHotGoods(Map<String,Object> map);
    
    /**
     * 根据品牌
     * 销量排序
     * 价格排序
     * 综合排序
     * 好评、销量、价格
     * @param map
     * @return
     */
    List<Goods> selectGoodsSort(Map<String,Object> map);
    
    /**
     * 商品筛选
     * 价格、属性、规格、品牌
     * @param search
     * @return
     */
    List<Goods> goodsSearch(@Param("search") GoodsSearchForm search);
    
    List<String> selectHotIdsByBrand(Map<String,Object> map);
    
    /**
	 * 搜索标签，搜索商品
	 * @param map
	 * @return
	 * @throws 
	 * @date 2018年1月31日 下午3:09:41
	 */
	List<Goods> selectGoodsBySearchTag(Map<String,Object> map);
    
    @Deprecated
    List<Goods> selectGoodsByBrand(Map<String,Object> map);
}
