package inn.shopping.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.AddressMapper;
import inn.shopping.api.entity.Address;
import inn.shopping.api.entity.Advertisement;

@Service(value = "addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper dao;

	@Override
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Address record) {
		return dao.insert(record);
	}

	@Override
	public int insertSelective(Address record) {
		return dao.insertSelective(record);
	}

	@Override
	public Address selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Address record) {
		return dao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Address record) {
		return dao.updateByPrimaryKey(record);
	}

}
