package inn.shopping.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Shop;
import inn.shopping.api.form.ShopForm;
@Repository
public interface ShopMapper {
    Shop selectByPrimaryKey(String id);

    /**
     * 查询店铺
     * @param cityCode
     * @return
     * @throws 
     * @date 2017年9月22日 上午9:24:32
     */
    List<Shop> selectShopByCategory(ShopForm shopForm);
    
}