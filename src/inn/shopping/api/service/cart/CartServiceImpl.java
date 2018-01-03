package inn.shopping.api.service.cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.CartMapper;
import inn.shopping.api.dao.SpecItemMapper;
import inn.shopping.api.dao.SpecMapper;
import inn.shopping.api.entity.Cart;
import inn.shopping.api.entity.Spec;
import inn.shopping.api.entity.SpecItem;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartMapper dao;
	@Autowired
	private SpecItemMapper specItemDao;
	@Autowired
	private SpecMapper specDao;

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
		List<Cart> list=new ArrayList<Cart>();
		List<Map<String,SpecItem>> mapList=new ArrayList<Map<String,SpecItem>>();
		Map<String,SpecItem> map=new HashMap<String, SpecItem>();
		for (Cart cart : dao.selectGoodsInCart(userId)) {
			List<String> ids=Arrays.asList(cart.getSpecItemIds().split(","));
			for (String item : ids) {
				SpecItem specItem= specItemDao.selectByPrimaryKey(item);
				//查询出规格名
				String specId=specItem.getSpecId();
				Spec spec=specDao.selectByPrimaryKey(specId);
				map.put(spec.getName(), specItem);
				mapList.add(map);
				cart.setSpecItemList(mapList);
			}
			list.add(cart);
		}
		return list;
	}

}
