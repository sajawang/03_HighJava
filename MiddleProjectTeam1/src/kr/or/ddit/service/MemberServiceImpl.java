package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IMemberDao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ViewListVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance(); // DAO객체 생성
	}
	private static MemberServiceImpl service;
	public static MemberServiceImpl getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public ViewListVO findViewList(String userId, int mateNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttemptVO wrongAns(List<Integer> myAnswer, int mateNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public int findPoint(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pointAilas(String userId, int point) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPoint(ViewListVO listVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MaterialVO> selectMaterial(String mateTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO getMember(String memId) {
		// TODO Auto-generated method stub
		return dao.getMember(memId);
	}

	@Override
	public MemberVO selectPoint(String cusId) {
		// TODO Auto-generated method stub
		return dao.selectPoint(cusId);
	}

	@Override
	public List<MemberVO> selectAllMember() {
		// TODO Auto-generated method stub
		return dao.selectAllMember();
	}
	
	
	
	
	
	
	
	
	


}
