package kr.or.ddit.member.dao;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.UserVO;

public interface IUserDao {
	
	//아이디와 로그인 정보 회원가입 처리
	
	//09-10 그냥 만든것 수정하기
	public int login(UserVO userVo);
	/**
	 * 회원 가입시 아이디 체크 기능 - 시스템 기능 -
	 * @param String id(입력받은 id값)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public int idCheck(String id);
	
	/**
	 * 회회원가입 이메일 인증 기능 - 시스템 기능 --
	 * @param String Email(입력받은 이메일값)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public int emailCheck(String Email);

	/**
	 * 아이디 찾기 기능 -회원 기능 -
	 * @param MemberVO memVo(MemberVO의 이름과 이메일 값)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public int idFind(MemberVO memVo);
	
	/**
	 * 회원가입 완료 기능 -회원 기능 
	 * @param MemberVO memVo(MemberVO 정보들)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public int insertMember(MemberVO memVo);
}
