package inn.shopping.api.service.goods;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.GoodsAttributeMapper;
import inn.shopping.api.entity.GoodsAttribute;
@Transactional
@Service(value = "goodsAttributeService")
public class GoodsAttributeServiceImpl implements GoodsAttributeService {
	@Autowired
	private GoodsAttributeMapper dao;

	
	@Override
	public GoodsAttribute selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}


	@Override
	public List<GoodsAttribute> selectGoodsAttributeItems(Map<String, Object> map) {
		return dao.selectGoodsAttributeItems(map);
	}

}
