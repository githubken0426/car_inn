package inn.shopping.api.service.goods;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Goods;

public interface GoodsService {
	/**
	 * 商品详情
	 * @param map
	 * @return
	 */
    Goods selectByPrimaryKey(Map<String,Object> map);
    
    /**
     * 查询商品
     * @param map
     * @return
     * @throws 
     * @date 2017年9月22日 下午3:42:40
     */
    List<Goods> selectHotGoods(Map<String,Object> map);
    
    /**
     * 综合排序
     * 好评、销量、价格
     * @param map
     * @return
     */
    List<Goods> selectGoodsSortByAll(@Param("cityCode") String cityCode);
    /**
     * 销量排序
     * @param map
     * @return
     */
    List<Goods> selectGoodsSortByNumber(@Param("cityCode") String cityCode);
    /**
     * 价格排序
     * @param map
     * @return
     */
    List<Goods> selectGoodsSortByPrice(Map<String,Object> map);
    
    /**
     * 根据品牌查找商品
     * @param map
     * @return
     */
    List<Goods> selectGoodsByBrand(Map<String,Object> map);
}
