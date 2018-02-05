package inn.shopping.api.service.score;

import inn.shopping.api.entity.Score;


public interface ScoreService {
	
	int insert(Score score);
	
	int selectTotalScore(String userId);
}