package inn.shopping.api.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Logistics;

@Repository
public interface LogisticsMapper {
	/**
	 * 查询商物流列表
	 * @param orderId 订单id
	 * @return
	 * @date 2018年1月15日 下午7:06:31
	 */
    List<Logistics> selectLogisticsByOrder(String orderId);
    
    Logistics selectByPrimaryKey(String id);
}