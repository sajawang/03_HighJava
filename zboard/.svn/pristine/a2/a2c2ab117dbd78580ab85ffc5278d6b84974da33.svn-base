package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.QuestionVO;

public class QuestionDaoImpl implements IQuestionDao {
	private static QuestionDaoImpl dao = new QuestionDaoImpl();
	
	private QuestionDaoImpl() { }
	
	public static QuestionDaoImpl getInstance() { return dao; }

	
	@Override
	public int studyQuestion(String ans) {
		return 0;
	}

	@Override
	public int updateQuestion(QuestionVO queVo) {
		return 0;
	}

	@Override
	public int insertQuestion(QuestionVO queVo) {
		return 0;
	}

	@Override
	public QuestionVO selectQuestion(String find) {
		return null;
	}

	@Override
	public List<QuestionVO> getAnswerList(int mateNo) {
		SqlSession session = null;
		List<QuestionVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			list = session.selectList("question.getAnswerList", mateNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

}
