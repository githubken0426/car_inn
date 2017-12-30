package inn.shopping.api.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Spec;

@Repository
public interface SpecMapper {
	/**
     * 查询商规格列表
     * @param map
     * @return
     */
    List<Spec> selectGoodsSpecItems(Map<String,Object> map);
    
    Spec selectByPrimaryKey(String id);
}