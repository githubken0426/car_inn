package inn.shopping.api.dao;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Address;
@Repository
public interface AddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}