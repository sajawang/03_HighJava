package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

public class AdmUserDaoImpl implements IAdmUserDao{
	
	private static AdmUserDaoImpl dao;
	
	private AdmUserDaoImpl() {}
	
	public static AdmUserDaoImpl getInstance() {
		if(dao==null) dao = new AdmUserDaoImpl();
		return (AdmUserDaoImpl) dao;
	}


	//cus
	@Override
	public int insertCusStudent(CustomerVO vo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("student.insertCusStudent", vo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}
		return cnt;
	}
	
	//member
	@Override
	public int insertMemStudent(MemberVO svo) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		
		try {
			cnt = session.insert("student.insertMemStudent", svo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}
		return cnt;
	}

	//cus
	@Override
	public int deleteCusStudent(String cusId) {
		SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
		int cnt = 0;
		
		try {
			cnt = session.delete("student.deleteCusStudent", cusId);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	//mem
	@Override
	public int deleteMemStudent(String cusId) {
		SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
		int cnt = 0;
		
		try {
			cnt = session.delete("student.deleteMemStudent", cusId);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	
	@Override //customervo에서 membervo로 바꿈
	// 학생들의 리스트를 보여주는 곳
	public List<MemberVO> getAllStudent(String cusId) {
		SqlSession session = MybatisUtil.getSqlSession(); 
		List<MemberVO> studentList = null;
		
		try {
			studentList = session.selectList("student.getAllStudent", cusId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}
		return studentList;
	}

	@Override
	public MemberVO getAllMemVo(String cusId) {
		SqlSession session = MybatisUtil.getSqlSession(); 
		MemberVO studentList = null;
		
		try {
			studentList = session.selectOne("student.getAllMemVo", cusId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}
		return studentList;
	}
	
	@Override
	public int countStudent(String cusId) {
		SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
		
		int count = 0;
		try {
			count = session.selectOne("student.countStudent", cusId);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		} 
		
		return count;
	}



	
	@Override
	public int updateMemStudent(MemberVO memvo) {
	    SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
	    int cnt = 0;
	    
	    try {
	        System.out.println(" 멤버cus_id 있니: " + memvo.getCus_id());  // cus_id 출력
	        cnt = session.update("student.updateMemStudent", memvo);
	        if(cnt > 0) session.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if(session != null) session.close();
	    }
	    return cnt;
	}
	
	@Override
	public int updateCusStudent(CustomerVO cusvo) {
		SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
		int cnt = 0;
		
		try {
	        System.out.println(" 커스 cus_id 있니: " + cusvo.getCus_id());  // cus_id 출력
			cnt = session.update("student.updateCusStudent", cusvo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}	
		
		return cnt;
	}

	

	@Override
	public CustomerVO getAllCusVo(String cusId) {
		SqlSession session = MybatisUtil.getSqlSession(); 
		CustomerVO getCustomer = null;
		
		try {
			getCustomer = session.selectOne("student.getAllCusVo", cusId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return getCustomer;
	}

	@Override
	public List<MemberVO> memAuth() {
	    SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
	    List<MemberVO> memAuthList = null;  // 결과를 담을 리스트

	    try {
	        // mem_auth가 있는 회원 목록을 가져오는 쿼리 실행
	        memAuthList = session.selectList("student.memAuth");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.commit();  // 필요한 경우 commit
	            session.close();   // 세션 닫기
	        }
	    }
	    return memAuthList;  // 결과 반환
	}

	@Override
	public int updateUpgrade(CustomerVO cusvo) {
		SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
		int cnt = 0;
		
		try {
	        System.out.println(" 커스 cus_id 있니: " + cusvo.getCus_id());  // cus_id 출력
			cnt = session.update("student.updateUpgrade", cusvo);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.commit();
			if(session!=null) session.close();
		}	
		
		return cnt;
	}
	}

	





