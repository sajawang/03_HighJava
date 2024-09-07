package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MyMemberVO;

public class MemberDaoImpl implements IMemberdao {
	//생성자
	private MemberDaoImpl() {}
	
	//싱글톤2
	private static  MemberDaoImpl dao;
	
	public static IMemberdao getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	

	
	@Override
	public List<MyMemberVO> memberList() {
		List<MyMemberVO> list = null;
		SqlSession sql = null;
		
		try {
			sql=MybatisUtil.getSqlSession();
			list=sql.selectList("mymember.memberList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return list;
	}

	@Override
	public int insertList(MyMemberVO mvo) {
		int cnt=0;
		SqlSession sql = null;
		
		try {
			sql=MybatisUtil.getSqlSession();
			cnt=sql.insert("mymember.insertList",mvo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return cnt;
	}

	@Override
	public MyMemberVO selectOneMember(String memid) {
		MyMemberVO vo=null;
		SqlSession sql = null;
		
		try {
			sql=MybatisUtil.getSqlSession();
			vo=sql.selectOne("mymember.selectOneMember",memid);
			System.out.println("dao에"+memid+"도착했습니다!");
			
			//------------------null발생지점 vo
			System.out.println("dao에"+vo+"실행했습니다!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return vo;
	}

	@Override
	public int updateMember(String memid) {
		int cnt=0;
		SqlSession sql = null;
		
		try {
			sql=MybatisUtil.getSqlSession();
			cnt=sql.update("mymember.updateMember",memid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memid) {
		int cnt=0;
		SqlSession sql = null;
		
		try {
			sql=MybatisUtil.getSqlSession();
			cnt=sql.delete("mymember.deleteMember",memid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sql.close();
		}
		return cnt;
	}

}
