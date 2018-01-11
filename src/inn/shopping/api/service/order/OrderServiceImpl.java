package inn.shopping.api.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.OrderMapper;
import inn.shopping.api.entity.Order;

@Service(value="orderService")
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderDao;
	
	@Override
	public int insert(Order order) {
		return orderDao.insert(order);
	}
	
}
