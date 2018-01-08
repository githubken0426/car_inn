package inn.shopping.api.service.goods;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.GoodsMapper;
import inn.shopping.api.entity.Goods;
import inn.shopping.api.form.GoodsSearchForm;

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
	public List<Goods> goodsSearch(GoodsSearchForm search) {
		return dao.goodsSearch(search);
	}

	@Override
	public List<Goods> selectGoodsSort(Map<String, Object> map) {
		return dao.selectGoodsSort(map);
	}


}
