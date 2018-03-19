package inn.shopping.api.service.shop;

import java.util.List;

import inn.shopping.api.entity.Shop;
import inn.shopping.api.form.ShopForm;

public interface ShopService {

    Shop selectByPrimaryKey(String id);

    List<Shop> selectShopByCategory(ShopForm form);
}
