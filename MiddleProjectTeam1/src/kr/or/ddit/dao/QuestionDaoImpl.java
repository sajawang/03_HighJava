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
		SqlSession session = null;
		List<QuestionVO> list = null;
		int cnt = 0;
	
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("question.adminUpdateQue",queVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(session != null) {
				session.commit();
				session.close();
			}
			
		}
		
		return cnt;
	}

	@Override
	public int insertQuestion(QuestionVO queVo) {
		SqlSession session = null;
		List<QuestionVO> list = null;
		int cnt = 0;
	
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.insert("question.adminInsertQuestion",queVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(session != null) {
				session.commit();
				session.close();
			}
			
		}
		
		return cnt;
		
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

	@Override
	public int deleteQuestion(int mateNo) {
		SqlSession session = null;
		List<QuestionVO> list = null;
		int cnt = 0;
	
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.delete("question.deleteQuestion",mateNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(session != null) {
				session.commit();
				session.close();
			}
			
		}
		
		return cnt;
	}

}
