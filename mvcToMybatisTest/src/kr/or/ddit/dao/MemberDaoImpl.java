package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	//정적필드
	private static MemberDaoImpl singleton = new MemberDaoImpl();
		
	//생성자
	private MemberDaoImpl() {
		
	}
		
	//정적 메소드
	public static MemberDaoImpl getInstance() {
		return singleton;
	}

	@Override
	public int insertMember(MemberVO memVo) {
		SqlSession session = null; //마이바티스랑 연결하는 역살
		//마이바티스를 로딩하는 역할
		
		int cnt=0; //반환값이 저장될 변수
		try {
			session = MybatisUtil.getSqlSession();
			//MybatisUtil은 SqlSession을 얻어내는데 쓴다.
			//SqlSessiond을 얻어내는 방법은 getSqlSession을 이용하는 것이다
			
			//session은 쿼리를 실행하고, insert, update, delete, retreive하게 해준다
			cnt = session.insert("mymember.insertMember",memVo);
			
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}
	
	@Override
	public int deleteMember(String memId) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.delete("mymember.deleteMember",memId);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVO) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("mymember.updateMember",memVO);
			
			if(cnt>0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		SqlSession session = null;
		List<MemberVO> memList = null; //반환값이 저장될 변수
		
		try {
			session = MybatisUtil.getSqlSession();
			memList = session.selectList("mymember.getAllMember");
			//select일때는 왜 커밋 안함?ㅡㅡ
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return memList;
	}

	@Override
	public int getMemberIdCount(String memId) {
		SqlSession session = null;
		int count = 0; //반환값이 저장될 변수
		
		try {
			session = MybatisUtil.getSqlSession();
			
			count = session.selectOne("mymember.getMemIdCount",memId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("mymember.updateMember2",paramMap);
			
			if(cnt>0) session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return cnt;
	}

}




















































