package inn.shopping.api.service.address;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Address;

public interface AddressService {

	Address selectByPrimaryKey(String id);
    /**
     * 获取用户地址列表
     * @param userId
     * @return
     */
    List<Address> selectAddressByUserId(@Param("userId")String userId,@Param("defaultFlag")String defaultFlag);
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
    int setAddressDefault(@Param("userId")String userId,@Param("id")String id);
}
