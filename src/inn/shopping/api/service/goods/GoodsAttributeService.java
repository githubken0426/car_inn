package inn.shopping.api.service.goods;

import java.util.List;
import java.util.Map;

import inn.shopping.api.entity.GoodsAttribute;

public interface GoodsAttributeService {

    GoodsAttribute selectByPrimaryKey(String id);

    /**
     * 查询商品属性列表
     * @param map
     * @return
     */
    List<GoodsAttribute> selectGoodsAttributeItems(Map<String,Object> map);
}
