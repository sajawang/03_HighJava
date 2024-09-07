package kr.or.ddit.session;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	
	//싱글톤
	private static MemberDaoImpl dao;
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	//생성자
	private MemberDaoImpl() {}
	
	@Override
	public MemberVO getLoginMember(MemberVO memVo) {
		SqlSession session = null;
		MemberVO loginMemVo = null;
		try {
			session = MybatisUtil.getSqlSession();
			loginMemVo = session.selectOne("member.getLoginMember",memVo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return loginMemVo;
	}

}
