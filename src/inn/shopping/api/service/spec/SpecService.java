package inn.shopping.api.service.spec;

import java.util.List;
import java.util.Map;

import inn.shopping.api.entity.Spec;

public interface SpecService {

    /**
     * 查询商规格列表
     * @param map
     * @return
     */
    List<Spec> selectGoodsSpecItems(Map<String,Object> map);

	Spec selectByPrimaryKey(String id);
}
