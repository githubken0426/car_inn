package inn.shopping.api.service.logistics;

import inn.shopping.api.entity.Logistics;

public interface LogisticsService {
	/**
	 * 查询订单物流
	 * @param orderId 订单id
	 * @return
	 * @date 2018年1月15日 下午7:06:31
	 */
	Logistics selectLogisticsByOrder(String orderId);
    
}
