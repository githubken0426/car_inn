package inn.shopping.api.service.goodsCategory;

import java.util.List;

import inn.shopping.api.entity.GoodsCategory;

public interface GoodsCategoryService {

    GoodsCategory selectByPrimaryKey(String id);
    /**
     * 查询所有商品
     * @return
     * @throws 
     * @date 2017年9月22日 上午9:45:38
     */
    List<GoodsCategory> selectAllCategory();
}
