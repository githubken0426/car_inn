package inn.shopping.api.service.goods;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.GoodsMapper;
import inn.shopping.api.entity.Goods;

@Service(value = "goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper dao;
	
	@Override
	public Goods selectByPrimaryKey(Map<String, Object> map) {
		return dao.selectByPrimaryKey(map);
	}

	@Override
	public List<Goods> selectHotGoods(Map<String, Object> map) {
		return dao.selectHotGoods(map);
	}

	@Override
	public List<Goods> selectGoodsSortByAll(String cityCode) {
		return dao.selectGoodsSortByAll(cityCode);
	}

	@Override
	public List<Goods> selectGoodsSortByNumber(String cityCode) {
		return dao.selectGoodsSortByNumber(cityCode);
	}

	@Override
	public List<Goods> selectGoodsSortByPrice(Map<String, Object> map) {
		return dao.selectGoodsSortByPrice(map);
	}

	@Override
	public List<Goods> selectGoodsByBrand(Map<String, Object> map) {
		return dao.selectGoodsByBrand(map);
	}


}
