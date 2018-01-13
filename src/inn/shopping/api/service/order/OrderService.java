package inn.shopping.api.service.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Order;
import inn.shopping.api.form.OrderForm;

public interface OrderService {
	/**
	 * 购物车去结算，生成订单
	 * @param order
	 * @return
	 * @throws 
	 * @date 2018年1月10日 下午6:28:33
	 */
	public int cartSettlement(OrderForm form,String userId);
	
	/**
	 * 立即购买
	 * @param order
	 * @return
	 * @throws 
	 * @date 2018年1月13日 上午11:56:43
	 */
	public int buyGoodsNow(OrderForm form,String userId);
	
	/**
	 * 获取订单
	 * @param userId 用户id
	 * @param status 订单状态1待付款,2已付款(待发货),3已发货,4已签收,5退货申请,6退货中,7已退货,8取消交易
	 * @return
	 * @throws 
	 * @date 2018年1月13日 上午11:38:02
	 */
	public List<Order> selectUserOrders(@Param("userId")String userId,@Param("status")String status);
}
