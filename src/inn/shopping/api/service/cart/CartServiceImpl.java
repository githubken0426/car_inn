package inn.shopping.api.service.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.CartMapper;
import inn.shopping.api.entity.Cart;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartMapper dao;

	@Override
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Cart record) {
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Cart record) {
		return dao.insertSelective(record);
	}

	@Override
	public Cart selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Cart record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Cart record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public List<Cart> selectGoodsInCart(String userId) {
		return dao.selectGoodsInCart(userId);
	}

}
