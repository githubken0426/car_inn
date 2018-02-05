package inn.shopping.api.dao;

import org.springframework.stereotype.Repository;

import inn.shopping.api.entity.Score;

@Repository
public interface ScoreMapper {
	
	int insert(Score score);
	
	int selectTotalScore(String userId);
}