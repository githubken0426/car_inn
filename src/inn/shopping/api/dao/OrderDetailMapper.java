package inn.shopping.api.dao;

import java.util.List;

import inn.shopping.api.entity.OrderDetail;

public interface OrderDetailMapper {
	/**
	 * 新增订单明细
	 * @param order
	 * @return
	 * @throws 
	 * @date 2018年1月10日 下午6:28:33
	 */
	public int insert(OrderDetail detail);
	/**
	 * 批量插入
	 * @param details
	 * @return
	 * @throws 
	 * @date 2018年1月12日 下午5:51:36
	 */
	public int insertBatch(List<OrderDetail> details);
	
}
