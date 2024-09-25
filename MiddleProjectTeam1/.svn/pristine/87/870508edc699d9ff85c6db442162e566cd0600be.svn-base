package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.MathSettingVO;

public class AdminMathSettingDaoImpl implements IAdminMathSettingDao {

	private static AdminMathSettingDaoImpl dao;
	
	private AdminMathSettingDaoImpl() {
		
	}
	public static AdminMathSettingDaoImpl getInstance() {
		if(dao == null)
			dao = new AdminMathSettingDaoImpl();
		return (AdminMathSettingDaoImpl) dao;
	}
	
	@Override
	public List<MathSettingVO> getAllStudent() {
		// 1. 변수 선언
		List<MathSettingVO> studentList = null;
		SqlSession sql = null;

		// 2. 실행
		try {
		sql = MybatisUtil.getSqlSession();
		studentList = sql.selectList("tenmath.getAllStudent");

		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		if (sql != null) {
			sql.close();
			}
		}
			return studentList;
	}
	

	@Override
	public int updateAdminMath(MathSettingVO vo) {
		 // 1. 변수 선언
	    int cnt = 0;
	    SqlSession sql = null;
	    
	    // 2. 실행
	    try {
	        sql = MybatisUtil.getSqlSession();
	        cnt = sql.update("tenmath.updateAdminMath", vo);  // 업데이트된 레코드 수 반환

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (sql != null) {
	            sql.commit();  // 커밋
	            sql.close();   // 세션 종료
	        }
	    }
	    
	    // 3. cnt 리턴
	    return cnt;  // 업데이트된 레코드 수 반환
	}
	@Override
	public int deleteAdminMath(String cusId) {
		SqlSession session = MybatisUtil.getSqlSession();  // MyBatis 처리용 객체 생성
		int cnt = 0;
		
		try {
			cnt = session.delete("tenmath.deleteAdminMath", cusId);
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}	
		
		return cnt;
	}
	@Override
	public MathSettingVO getCusId(String cusId) {
		 	SqlSession sql = null;
	        MathSettingVO mathSetting = null;
	        
	        try {
	            sql = MybatisUtil.getSqlSession();
	            // MyBatis 매퍼의 select 쿼리 실행
	            mathSetting = sql.selectOne("tenmath.getCusId", cusId);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (sql != null) {
	                sql.close();
	            }
	        }
	        
	        return mathSetting;
	    }
	@Override
	public int saveOrUpdateMathSetting(MathSettingVO vo) {
	    // 1. 변수 선언
	    int cnt = 0;
	    SqlSession sql = null;
	    
	    try {
	        sql = MybatisUtil.getSqlSession();
	        
	        // 2. 먼저 해당 cus_id가 mathsetting 테이블에 있는지 확인
	        MathSettingVO existingMathSetting = sql.selectOne("tenmath.getCusId", vo.getCus_id());
	        
	        if (existingMathSetting == null) {
	            // 3. 데이터가 없으면 삽입 (INSERT)
	            cnt = sql.insert("tenmath.insertStudent", vo);
	        } else {
	            // 4. 데이터가 있으면 업데이트 (UPDATE)
	            cnt = sql.update("tenmath.updateAdminMath", vo);
	        }
	        
	        if (cnt > 0) {
	            sql.commit();  // 변경사항 커밋
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (sql != null) {
	            sql.close();  // 세션 종료
	        }
	    }
	    
	    // 5. 처리된 행 수 리턴
	    return cnt;
	}
	
	@Override
	public int insertStudent(MathSettingVO vo) {
		// 1. 변수 선언
	    int cnt = 0;
	    SqlSession sql = null;
	    
	    // 2. 실행
	    try {
	        sql = MybatisUtil.getSqlSession();
	        cnt = sql.update("tenmath.insertStudent", vo);  // 업데이트된 레코드 수 반환

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (sql != null) {
	            sql.commit();  // 커밋
	            sql.close();   // 세션 종료
	        }
	    }
	    
	    // 3. cnt 리턴
	    return cnt;
	}
	
	
	
	
}
