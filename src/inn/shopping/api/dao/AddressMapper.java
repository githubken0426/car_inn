package inn.shopping.api.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Address;
@Repository
public interface AddressMapper {
    Address selectByPrimaryKey(String id);
    /**
     * 获取用户地址列表
     * @param userId
     * @return
     */
    List<Address> selectAddressByUserId(@Param("userId")String userId);
    /**
     * 获取用户默认收货地址
     * @param userId
     * @return
     */
    Address selectUserDefaultAddress(@Param("userId")String userId);
    /**
     * 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);
    /**
     * 新增
     * @param id
     * @return
     */
    int insert(Address record);
    /**
     * 修改
     * @param id
     * @return
     */
    int updateByPrimaryKey(Address record);
    /**
     * 设置地址为非默认
     * @param userId
     * @return
     */
    int setAddressUNdefault(@Param("userId")String userId);
    /**
     * 设置默认地址
     * @param map
     * @return
     */
    int setAddressDefault(Map<String,Object> map);
}