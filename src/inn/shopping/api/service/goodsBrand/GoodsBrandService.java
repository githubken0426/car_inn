package inn.shopping.api.service.goodsBrand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import inn.shopping.api.entity.GoodsBrand;

public interface GoodsBrandService {
    
    List<GoodsBrand> selectCategoryBrand(@Param("categoryId")String categoryId);
}
