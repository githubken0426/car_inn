package inn.shopping.api.service.advertisement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.AdvertisementMapper;
import inn.shopping.api.entity.Advertisement;
@Transactional
@Service(value = "advertisementService")
public class AdvertisementServiceImpl implements AdvertisementService {
	@Autowired
	private AdvertisementMapper dao;

	@Override
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Advertisement record) {
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Advertisement record) {
		return dao.insertSelective(record);
	}
	
	@Override
	public Advertisement selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Advertisement record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Advertisement record) {
		return 0;
	}

	@Override
	public List<Advertisement> selectAllAdvertisement(String cityCode) {
		return dao.selectAllAdvertisement(cityCode);
	}

}
