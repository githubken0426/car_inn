package inn.shopping.api.service;

import inn.shopping.api.entity.Address;

public interface AddressService {

	int deleteByPrimaryKey(String id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}
