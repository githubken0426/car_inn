package inn.shopping.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Advertisement;
@Repository
public interface AdvertisementMapper {
    int deleteByPrimaryKey(String id);

    int insert(Advertisement record);

    int insertSelective(Advertisement record);

    Advertisement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Advertisement record);

    int updateByPrimaryKey(Advertisement record);
    
    /**
     * 查询广告
     * @param cityCode
     * @return
     * @throws 
     * @date 2017年9月22日 上午9:24:32
     */
    List<Advertisement> selectAllAdvertisement(@Param("cityCode")String cityCode);
    
}