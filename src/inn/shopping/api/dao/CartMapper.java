package inn.shopping.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Cart;
@Repository
public interface CartMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cart record);

    Cart selectByPrimaryKey(String id);

    int updateGoodsNumber(Cart record);

    /**
     * 查询某用户购物车的商品
     * @return
     */
    List<Cart> selectGoodsInCart(@Param("userId")String userId);
    /**
     * 查询用户购物车的同一规格的商品
     * @param userId
     * @param goodsId
     * @return
     */
    Cart selectSameSpeccGoodsInCart(@Param("userId")String userId,@Param("goodsId")String goodsId,@Param("specItemIds")String specItemIds);
}