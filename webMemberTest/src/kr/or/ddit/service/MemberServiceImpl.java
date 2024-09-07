package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.IMemberdao;
import kr.or.ddit.dao.MemberDaoImpl;
import kr.or.ddit.vo.MyMemberVO;

public class MemberServiceImpl implements IMemberService {

	//dao얻기, 생성자
	private IMemberdao dao;
	private MemberServiceImpl() {
		dao=MemberDaoImpl.getInstance();
	}
	
	//싱글톤2
	private static MemberServiceImpl service;
	public static MemberServiceImpl getInstance() {
		if(service==null) service= new MemberServiceImpl();
		return service;
	}
	@Override
	public List<MyMemberVO> memberList() {
		// TODO Auto-generated method stub
		return dao.memberList();
	}

	@Override
	public int insertList(MyMemberVO mvo) {
		// TODO Auto-generated method stub
		return dao.insertList(mvo);
	}

	@Override
	public MyMemberVO selectOneMember(String memid) {
		// TODO Auto-generated method stub
		System.out.println("service에"+memid+"도착했습니다!");
		return dao.selectOneMember(memid);
	}

	@Override
	public int updateMember(String memid) {
		// TODO Auto-generated method stub
		return dao.updateMember(memid);
	}

	@Override
	public int deleteMember(String memid) {
		// TODO Auto-generated method stub
		return dao.deleteMember(memid);
	}
	
}
