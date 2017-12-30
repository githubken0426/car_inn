package inn.shopping.api.dao;

import inn.shopping.api.entity.SpecGroup;

public interface SpecGroupMapper {
    SpecGroup selectByPrimaryKey(String id);
    
}