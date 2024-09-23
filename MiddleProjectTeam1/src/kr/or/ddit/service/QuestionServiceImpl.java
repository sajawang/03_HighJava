package kr.or.ddit.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dao.IQuestionDao;
import kr.or.ddit.dao.QuestionDaoImpl;
import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.QuestionVO;

public class QuestionServiceImpl implements IQuestionService {
	private static QuestionServiceImpl service;
	private IQuestionDao dao;
	
	private QuestionServiceImpl() {
		dao = QuestionDaoImpl.getInstance(); 
	}
	
	public static QuestionServiceImpl getInstance() {
		if(service == null) service = new QuestionServiceImpl();
		return service;
	}
	
	@Override
	public int studyQuestion(String ans) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateQuestion(QuestionVO queVo) {
		// TODO Auto-generated method stub
		return dao.updateQuestion(queVo);
	}

	@Override
	public int insertQuestion(QuestionVO queVo) {
		
		return dao.insertQuestion(queVo);
	}

	@Override
	public QuestionVO selectQuestion(String find) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuestionVO> getAnswerList(int mateNo) {
		return dao.getAnswerList(mateNo);
	}

	@Override
	public int deleteQuestion(int mateNo) {
		// TODO Auto-generated method stub
		return dao.deleteQuestion(mateNo);
	}

}
