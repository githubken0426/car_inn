package inn.shopping.api.service.score;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inn.shopping.api.dao.ScoreMapper;
import inn.shopping.api.entity.Score;

@Service(value="scoreService")
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreMapper dao;
	
	@Override
	public int insert(Score score) {
		return dao.insert(score);
	}

	@Override
	public int selectTotalScore(String userId) {
		return dao.selectTotalScore(userId);
	}

}
