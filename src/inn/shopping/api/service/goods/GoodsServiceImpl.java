package inn.shopping.api.service.goods;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.GoodsMapper;
import inn.shopping.api.dao.SpecItemMapper;
import inn.shopping.api.dao.SpecMapper;
import inn.shopping.api.entity.Goods;
import inn.shopping.api.entity.Spec;
import inn.shopping.api.entity.SpecItem;
import inn.shopping.api.form.GoodsSearchForm;
import inn.shopping.api.form.GoodsSearchSpecForm;
@Transactional
@Service(value = "goodsService")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper dao;
	@Autowired
	private SpecItemMapper specItemDao;
	@Autowired
	private SpecMapper specDao;
	
	@Override
	public Goods selectByPrimaryKey(String id) {
		Goods goods = dao.selectByPrimaryKey(id);
		if (goods == null)
			return goods;
		String itemIds = goods.getSpecItemIds();
		if (StringUtils.isBlank(itemIds))
			return goods;

		List<String> ids = Arrays.asList(itemIds.split(","));
		StringBuffer sb = new StringBuffer();
		Iterator<String> it = ids.iterator();
		boolean hasNext = it.hasNext();
		while (hasNext) {
			String itemId = it.next();
			SpecItem specItem = specItemDao.selectByPrimaryKey(itemId);
			if (specItem == null)
				continue;
			// 查询出规格名
			String specId = specItem.getSpecId();
			Spec spec = specDao.selectByPrimaryKey(specId);
			sb.append(spec.getName());
			sb.append(":");
			sb.append(specItem.getItem());
			hasNext = it.hasNext();
			if (hasNext)
				sb.append(",");
		}
		goods.setSpecItemContent(sb.toString());
		return goods;
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

	@Override
	public List<Goods> selectGoodsByBrand(Map<String, Object> map) {
		return dao.selectGoodsByBrand(map);
	}

	@Override
	public List<Goods> selectHotIdsByBrand(Map<String,Object> map) {
		return dao.selectHotIdsByBrand(map);
	}

	@Override
	public List<Goods> selectGoodsBySearchTag(Map<String,Object> map) {
		return dao.selectGoodsBySearchTag(map);
	}

	@Override
	public List<Goods> goodsSearchBySpecs(GoodsSearchSpecForm search) {
		return dao.goodsSearchBySpecs(search);
	}
}
