package inn.shopping.api.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.SpecItem;

@Repository
public interface SpecItemMapper {

    SpecItem selectByPrimaryKey(String id);

    /**
     * 查询商规格列表
     * @param map
     * @return
     */
    List<SpecItem> selectGoodsSpecItems(Map<String,Object> map);
}