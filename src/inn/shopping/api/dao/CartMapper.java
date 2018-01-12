package inn.shopping.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Cart;
@Repository
public interface CartMapper {
    int deleteByPrimaryKeyBatch(List<String> ids);

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
    /**
     * 通过id查询购物车
     * @param ids,多个id逗号隔开
     * @return
     * @throws 
     * @date 2018年1月12日 下午6:15:53
     */
    List<Cart> selectCartByIds(@Param("ids")List<String> ids);
}