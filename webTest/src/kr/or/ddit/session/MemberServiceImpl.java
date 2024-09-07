package kr.or.ddit.session;

import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	//싱글톤
	private static MemberServiceImpl service;
	public static MemberServiceImpl getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	//dao얻어오기
	private MemberDaoImpl dao;
	private MemberServiceImpl() {
		dao=MemberDaoImpl.getInstance();
	}
	
	@Override
	public MemberVO getLoginMember(MemberVO memVo) {
		// TODO Auto-generated method stub
		return dao.getLoginMember(memVo);
	}

}
