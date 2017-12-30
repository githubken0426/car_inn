package inn.shopping.api.service.cart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Cart;

public interface CartService {
	int deleteByPrimaryKey(String id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
    
    /**
     * 查询购物车商品
     * @return
     */
    List<Cart> selectGoodsInCart(@Param("userId")String userId);
}
