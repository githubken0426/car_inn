package inn.shopping.api.service.expert;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.ExpertTop;

public interface ExpertTopService {
	 /**
     * 查询所有达人
     * @param categoryId 分类id
     * @param cityCode 城市码
     * @return
     * @throws 
     * @date 2018年3月12日 下午8:22:44
     */
    List<ExpertTop> queryAllExpert(@Param("categoryId")String categoryId,@Param("cityCode")String cityCode);
}
