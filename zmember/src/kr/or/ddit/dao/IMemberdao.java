package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.MyMemberVO;

public interface IMemberdao {

	public List<MyMemberVO> memberList();
	public int insertList(MyMemberVO mvo);
	public MyMemberVO selectOneMember(String memid);
	public int updateMember(String memid);
	public int deleteMember(String memid);
	

}
