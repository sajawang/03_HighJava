package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MyMemberVO selectOneMember(String memid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(String memid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
