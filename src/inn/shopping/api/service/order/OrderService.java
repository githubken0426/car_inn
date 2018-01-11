package inn.shopping.api.service.order;

import inn.shopping.api.entity.Order;

public interface OrderService {
	/**
	 * 去结算，生成订单
	 * @param order
	 * @return
	 * @throws 
	 * @date 2018年1月10日 下午6:28:33
	 */
	public int insert(Order order);
}
