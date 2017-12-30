package inn.shopping.api.service.advertisement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Advertisement;

public interface AdvertisementService {
	int deleteByPrimaryKey(String id);

    int insert(Advertisement record);

    int insertSelective(Advertisement record);

    Advertisement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Advertisement record);

    int updateByPrimaryKey(Advertisement record);
    
    List<Advertisement> selectAllAdvertisement(@Param("cityCode")String cityCode);
}
