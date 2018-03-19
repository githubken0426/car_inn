package inn.shopping.api.service.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.ShopMapper;
import inn.shopping.api.entity.Shop;
import inn.shopping.api.form.ShopForm;
@Transactional
@Service(value = "shopService")
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopMapper dao;

	@Override
	public Shop selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public List<Shop> selectShopByCategory(ShopForm shopForm) {
		return dao.selectShopByCategory(shopForm);
	}
}
