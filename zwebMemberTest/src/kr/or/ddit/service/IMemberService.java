package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.MyMemberVO;

public interface IMemberService {
	public List<MyMemberVO> memberList();
	public int insertList(MyMemberVO mvo);
	public int selectOneMember(String memid);
	public int updateMember(String memid);
	public int deleteMember(String memid);

}
