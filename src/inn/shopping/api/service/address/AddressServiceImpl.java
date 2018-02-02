package inn.shopping.api.service.address;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inn.shopping.api.dao.AddressMapper;
import inn.shopping.api.entity.Address;

@Transactional
@Service(value = "addressService")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressMapper dao;

	@Override
	public Address selectByPrimaryKey(String id) {
		return dao.selectByPrimaryKey(id);
	}

	@Override
	public List<Address> selectAddressByUserId(String userId,String defaultFlag) {
		return dao.selectAddressByUserId(userId,defaultFlag);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return dao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Address record) {
		if("Y".equals(record.getDefaultFlag())) {
			setAddressUNdefault(record.getUserId());
		}
		return dao.insert(record);
	}

	@Override
	public int updateByPrimaryKey(Address record) {
		if("Y".equals(record.getDefaultFlag())) {
			setAddressUNdefault(record.getUserId());
		}
		return dao.updateByPrimaryKey(record);
	}

	@Override
	public int setAddressUNdefault(String userId) {
		return dao.setAddressUNdefault(userId);
	}

	@Override
	public int setAddressDefault(@Param("userId")String userId,@Param("id")String id) {
		setAddressUNdefault(userId);
		return dao.setAddressDefault(userId,id);
	}
}
