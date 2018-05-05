package inn.shopping.api.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Order;

public interface OrderMapper {
	/**
	 * 新增订单
	 * @param order
	 * @return
	 * @throws 
	 * @date 2018年1月10日 下午6:28:33
	 */
	public int insert(Order order);
	/**
	 * 修改订单状态
	 * @param status
	 * @return
	 * @throws 
	 * @date 2018年1月23日 下午6:18:32
	 */
	public int updateOrderStatus(Map<String,Object> map);
	
	public int cancelOrder(Map<String,Object> map);
	
	public int deleteOrder(String orderId);
	
	/**
	 * 支付成功，更新订单
	 * @param order
	 * @return
	 */
	public int updateUnifiedOrder(Order order);
	
	/**
	 * 获取订单
	 * @param userId 用户id
	 * @param status 订单状态1待付款,2已付款(待发货),3已发货,4已签收,5退货申请,6退货中,7已退货,8取消交易
	 * @return
	 * @throws 
	 * @date 2018年1月13日 上午11:38:02
	 */
	public List<Order> selectUserOrders(@Param("userId")String userId,@Param("status")String status);
	
	/**
	 * 订单详情
	 * @param orderId
	 * @return
	 */
	public Order selectByPrimaryKey(String orderId);
	
	/**
	 * 根据订单no查询订单
	 * @param orderNo
	 * @return
	 * @throws 
	 * @date 2018年2月2日 上午9:08:16
	 */
	public Order selectByOrderNo(String orderNo);
	
	public String selectCityIdByCode(String cityCode);
	
}
