package kr.or.ddit.session;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {
	//회원 ID와 패스워드가 저장된 MemberVO객체를 인수값으로 받아서 해당 회원을 검색하여 반환하는 메소드
	//파라미터 : 검색할 회원ID와 패스워드가 저장된 MemberVO객체
	//리턴값 : 검색된 히ㅗ원 정봅가 저장된 MemberVO객체(검색된 데이터가 없으면 null반환)
	public MemberVO getLoginMember(MemberVO memVo);
}
