package inn.shopping.api.service.cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.CartMapper;
import inn.shopping.api.dao.GoodsMapper;
import inn.shopping.api.dao.SpecItemMapper;
import inn.shopping.api.dao.SpecMapper;
import inn.shopping.api.entity.Cart;
import inn.shopping.api.entity.Goods;
import inn.shopping.api.entity.Spec;
import inn.shopping.api.entity.SpecItem;
import inn.shopping.api.enums.APICode;
import inn.shopping.api.exception.ApiException;
import inn.shopping.api.form.CartForm;
import inn.shopping.api.utils.CommonUtil;
@Transactional
@Service(value = "cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartMapper dao;
	@Autowired
	private SpecItemMapper specItemDao;
	@Autowired
	private SpecMapper specDao;
	@Autowired
	private GoodsMapper goodsDao;

	@Override
	public int deleteByPrimaryKeyBatch(List<String> ids) {
		return dao.deleteByPrimaryKeyBatch(ids);
	}

	@Override
	public int meger(CartForm cartForm, String userId) {
		Cart cart = new Cart();
		// 获取参数值
		String goodsId = cartForm.getGoodsId();
		Goods goods=goodsDao.selectByPrimaryKey(goodsId);
		if(goods==null) 
			throw new ApiException(APICode.GOODS_NULL_ERROR);
		
		String specItemIds = cartForm.getSpecItemIds();
		int number=Integer.parseInt(cartForm.getNumber());
		Cart dbCarts = dao.selectSameSpeccGoodsInCart(userId, goodsId, specItemIds);
		if (dbCarts == null) {
			cart.setId(CommonUtil.getUID());
			cart.setGoodsId(goodsId);
			cart.setNumber(number);
			cart.setUserId(userId);
			cart.setSpecItemIds(specItemIds);
			return dao.insert(cart);
		} else {
			dbCarts.setNumber(dbCarts.getNumber()+ number);
			return dao.updateGoodsNumber(dbCarts);
		}
	}

	@Override
	public Cart selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Cart> selectGoodsInCart(String userId) {
		List<Cart> list = new ArrayList<Cart>();
		for (Cart cart : dao.selectGoodsInCart(userId)) {
			List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();
			if (StringUtils.isNotBlank(cart.getSpecItemIds())) {
				List<String> ids = Arrays.asList(cart.getSpecItemIds().split(","));
				for (String item : ids) {
					Map<String, String> map = new HashMap<String, String>();
					SpecItem specItem = specItemDao.selectByPrimaryKey(item);
					if(specItem==null)
						continue;
					// 查询出规格名
					String specId = specItem.getSpecId();
					Spec spec = specDao.selectByPrimaryKey(specId);
					map.put("key", spec.getName());
					map.put("value", specItem.getItem());
					mapList.add(map);
				}
				cart.setSpecItemList(mapList);
			}
			list.add(cart);
		}
		return list;
	}

	@Override
	public int updateGoodsNumber(Cart record) {
		return dao.updateGoodsNumber(record);
	}

}
