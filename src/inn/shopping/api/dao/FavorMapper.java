package inn.shopping.api.dao;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Favor;
@Repository
public interface FavorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Favor record);

    int insertSelective(Favor record);

    Favor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Favor record);

    int updateByPrimaryKey(Favor record);
}