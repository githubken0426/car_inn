package inn.shopping.api.service.order;

import inn.shopping.api.exception.ApiException;
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
}
