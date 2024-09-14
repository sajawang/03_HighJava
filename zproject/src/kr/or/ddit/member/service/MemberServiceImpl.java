package kr.or.ddit.member.service;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
private static MemberServiceImpl service;
	
	private IMemberDao dao;	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance(); // DAO객체 생성
	}
	public static MemberServiceImpl getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public MemberVO getMember(String memId) {
		// TODO Auto-generated method stub
		return dao.getMember(memId);
	}

}
