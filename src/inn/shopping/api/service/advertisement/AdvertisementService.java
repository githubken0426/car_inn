package inn.shopping.api.service.advertisement;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.Advertisement;

public interface AdvertisementService {

    Advertisement selectByPrimaryKey(String id);

    List<Advertisement> selectAllAdvertisement(@Param("cityCode")String cityCode);
}
