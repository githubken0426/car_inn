package inn.shopping.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.AddressMapper;
import inn.shopping.api.entity.Address;

@Service(value = "addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper dao;

	@Override
	public Address selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public List<Address> selectAddressByUserId(String userId) {
		return dao.selectAddressByUserId(userId);
	}

	@Override
	public Address selectUserDefaultAddress(String userId) {
		return dao.selectUserDefaultAddress(userId);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Address record) {
		return dao.insert(record);
	}

	@Override
	public int updateByPrimaryKey(Address record) {
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int setAddressUNdefault(String userId) {
		return dao.setAddressUNdefault(userId);
	}

	@Override
	public int setAddressDefault(Map<String, Object> map) {
		return dao.setAddressDefault(map);
	}
}
