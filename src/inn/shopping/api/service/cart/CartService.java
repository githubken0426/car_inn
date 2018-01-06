package inn.shopping.api.service.cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Cart;
import inn.shopping.api.form.CartForm;

public interface CartService {
	int deleteByPrimaryKey(String id);

    int meger(CartForm cartForm,String userId);

    Cart selectByPrimaryKey(String id);
    
    /**
     * 查询购物车商品
     * @return
     */
    List<Cart> selectGoodsInCart(@Param("userId")String userId);
    /**
     * 修改商品数量
     * @param record
     * @return
     */
    
    int updateGoodsNumber(Cart record);
    
}
