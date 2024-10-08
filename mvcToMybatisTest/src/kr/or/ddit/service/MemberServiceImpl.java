package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	
	//정적필드
	private static MemberServiceImpl singleton = new MemberServiceImpl();
	
	//생성자
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance(); //DAO객체가 저장될 변수 선언
	}
	
	//정적 메소드
	public static MemberServiceImpl getInstance() {
		return singleton;
	}
	

	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVO) {
		return dao.updateMember(memVO);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberIdCount(String memId) {
		return dao.getMemberIdCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		return dao.updateMember2(paramMap);
	}

}






































