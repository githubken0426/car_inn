package inn.shopping.api.service.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderDao;
	@Autowired
	private OrderDetailMapper orderDetailDao;
	@Autowired
	private CartMapper cartDao;
	@Autowired
	private GoodsMapper goodsDao;

	@Override
	public String cartSettlement(OrderForm form, String userId) {
		try {
			List<OrderDetail> detailList = new ArrayList<OrderDetail>();
			Order order = Order.class.newInstance();
			String cartIds = form.getCartIds();
			String addressId = form.getAddressId();
			String mark = form.getCustomerMark();
			String totalPrice = form.getTotalPrice();
			String orderId=CommonUtil.getUID();
			String orderNo=CommonUtil.generatorOrderNo(4, userId, "G");
			order.setId(orderId);
			order.setOrderNo(orderNo);
			order.setUserId(userId);
			order.setAddressId(addressId);
			order.setCustomerMark(mark);
			order.setItemCount(cartIds.split(",").length);
			order.setTotalAmount(new BigDecimal(totalPrice));
			order.setOrderStatus(1);//待付款
			order.setPayment(new BigDecimal(totalPrice));
			// 查询购物车
			List<Cart> cartList = cartDao.selectCartByIds(Arrays.asList(cartIds.split(",")));
			for (Cart cart : cartList) {
				String goodsId = cart.getGoodsId();
				Goods goods = goodsDao.selectByPrimaryKey(goodsId);
				if (null == goods) //判断商品是否 被下架或被人为删除
					continue;
				OrderDetail detail = OrderDetail.class.newInstance();
				detail.setId(CommonUtil.getUID());
				detail.setOrderId(orderId);
				detail.setOrderNo(orderNo);
				detail.setGoodsId(goodsId);
				detail.setNumber(cart.getNumber());
				BigDecimal price = goods.getPromotionPrice();
				detail.setGoodsPrice(price);
				BigDecimal number = new BigDecimal(cart.getNumber());
				detail.setSubtotal(price.multiply(number));
				detail.setSpecItemIds(cart.getSpecItemIds());
				detailList.add(detail);
			}
			if (detailList.size() > 0) {
				int orderResult = orderDao.insert(order);
				int detailResult = orderDetailDao.insertBatch(detailList);
				if (orderResult > 0 && detailResult > 0)
					return orderId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Order> selectUserOrders(String userId, String status) {
		return orderDao.selectUserOrders(userId, status);
	}

	@Override
	public String buyGoodsNow(OrderForm form, String userId) {
		try {
			Order order = Order.class.newInstance();
			String goodsId = form.getGoodsId();
			Goods goods = goodsDao.selectByPrimaryKey(goodsId);
			if (null == goods)  // 判断商品是否 被下架或被人为删除
				return null;
			String number = form.getNumber();
			int goodsNumber = 1;
			if (StringUtils.isNotBlank(number))
				goodsNumber = Integer.valueOf(number);
			String addressId = form.getAddressId();
			String mark = form.getCustomerMark();
			String totalPrice = form.getTotalPrice();
			String specItemsIds = form.getSpecItemIds();
			String orderId = CommonUtil.getUID();
			String orderNo = CommonUtil.generatorOrderNo(4, userId, "G");
			
			order.setId(orderId);
			order.setOrderNo(orderNo);
			order.setUserId(userId);
			order.setAddressId(addressId);
			order.setCustomerMark(mark);
			order.setItemCount(1);
			order.setTotalAmount(new BigDecimal(totalPrice));
			order.setOrderStatus(1);// 待付款
			order.setPayment(new BigDecimal(totalPrice));

			OrderDetail detail = OrderDetail.class.newInstance();
			detail.setId(CommonUtil.getUID());
			detail.setOrderId(orderId);
			detail.setOrderNo(orderNo);
			detail.setGoodsId(goodsId);
			detail.setNumber(goodsNumber);
			BigDecimal price = goods.getPromotionPrice();
			detail.setGoodsPrice(price);
			BigDecimal goodsNum = new BigDecimal(goodsNumber);
			detail.setSubtotal(price.multiply(goodsNum));
			detail.setSpecItemIds(specItemsIds);
			
			int orderResult = orderDao.insert(order);
			int detailResult = orderDetailDao.insert(detail);
			if (orderResult > 0 && detailResult > 0) {
				return orderId;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
