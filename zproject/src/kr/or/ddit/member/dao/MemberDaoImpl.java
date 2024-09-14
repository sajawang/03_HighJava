package kr.or.ddit.member.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	private static MemberDaoImpl dao;
	private MemberDaoImpl() {}
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public MemberVO getMember(String memId) {
		SqlSession session = MybatisUtil.getSqlSession();  
		MemberVO vo = null;
		try {
			System.out.println(memId);
			vo = session.selectOne("member.getMember", memId);
			System.out.println(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session!=null) session.close();
		} 
		return vo;
	}
}
