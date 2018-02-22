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
	public Advertisement selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public List<Advertisement> selectAllAdvertisement(String cityCode) {
		return dao.selectAllAdvertisement(cityCode);
	}
}
