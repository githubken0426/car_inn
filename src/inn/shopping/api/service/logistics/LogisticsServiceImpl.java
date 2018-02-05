package inn.shopping.api.service.logistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.LogisticsMapper;
import inn.shopping.api.entity.Logistics;

@Service(value="logisticsService")
public class LogisticsServiceImpl implements LogisticsService {
	@Autowired
	private LogisticsMapper dao;
	
	@Override
	public Logistics selectLogisticsByOrder(String orderId) {
		return dao.selectLogisticsByOrder(orderId);
	}

}
