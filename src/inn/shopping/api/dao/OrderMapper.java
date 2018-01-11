package inn.shopping.api.dao;

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
}
