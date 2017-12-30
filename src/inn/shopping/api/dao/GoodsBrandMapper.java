package inn.shopping.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.GoodsBrand;
@Repository
public interface GoodsBrandMapper {
    
    /**
     * 查询分类品牌
     * @param categoryId
     * @return
     */
    List<GoodsBrand> selectCategoryBrand(@Param("categoryId")String categoryId);
}