package inn.shopping.api.service.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.CartMapper;
import inn.shopping.api.dao.GoodsMapper;
import inn.shopping.api.dao.OrderDetailMapper;
import inn.shopping.api.dao.OrderMapper;
import inn.shopping.api.entity.Cart;
import inn.shopping.api.entity.Goods;
import inn.shopping.api.entity.Order;
import inn.shopping.api.entity.OrderDetail;
import inn.shopping.api.form.OrderForm;
import inn.shopping.api.utils.CommonUtil;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderDao;
	@Autowired
	private OrderDetailMapper orderDetailDao;
	@Autowired
	private CartMapper cartDao;
	@Autowired
	private GoodsMapper goodsDao;

	@Override
	public int cartSettlement(OrderForm form,String userId) {
		try {
			List<OrderDetail> detailList=new ArrayList<OrderDetail>();
			Order order=Order.class.newInstance();
			String cartIds = form.getCartIds();
			String addressId =form.getAddressId();
			String mark=form.getCustomerMark();
			String totalPrice=form.getTotalPrice();
			
			order.setId(CommonUtil.getUID());
			order.setOrderNo(CommonUtil.generatorOrderNo(4, userId, "G"));
			order.setUserId(userId);
			order.setAddressId(addressId);
			order.setCustomerMark(mark);
			order.setItemCount(cartIds.split(",").length);
			order.setTotalAmount(new BigDecimal(totalPrice));
			//查询购物车
			List<Cart> cartList=cartDao.selectCartByIds(Arrays.asList(cartIds.split(",")));
			for (Cart cart : cartList) {
				OrderDetail detail=OrderDetail.class.newInstance();
				String goodsId=cart.getGoodsId();
				Goods goods=goodsDao.selectByPrimaryKey(goodsId);
				
				detail.setId(CommonUtil.getUID());
				detail.setGoodsId(goodsId);
				BigDecimal price=goods.getPromotionPrice();
				detail.setGoodsPrice(price);
				BigDecimal number=new BigDecimal(cart.getNumber());
				detail.setSubtotal(price.multiply(number));
				detail.setSpecItemIds(cart.getSpecItemIds());
				detailList.add(detail);
			}
			orderDetailDao.insertBatch(detailList);
			return orderDao.insert(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
