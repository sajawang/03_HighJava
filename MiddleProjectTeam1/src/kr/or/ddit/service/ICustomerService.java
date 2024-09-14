package kr.or.ddit.service;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.CustomerVO;

public interface ICustomerService {
	
	//아이디와 로그인 정보 회원가입 처리
	
	/**
	 * 회원 가입시 아이디 체크 기능 - 시스템 기능 -
	 * @param String id(입력받은 id값)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public String idCheck(String id);
	/**
	 * 로그인  기능 - 시스템 기능 -
	 * @param String id(입력받은 id값)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public int Login(CustomerVO userVo);
	
	/**
	 * 아이디 찾기 기능 -회원 기능 -
	 * @param MemberVO memVo(MemberVO의 이름과 이메일 값)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public String idFind(MemberVO memVo);
	
	/**
	 * 회원가입 완료 기능 -회원 기능  멤버 이름과 이메일을 받으면 아이디를 반환
	 * @param MemberVO memVo(MemberVO 정보들)
	 * @return 성공  : String 아이디 / 실패 : 0
	 */
	public int insertMember(MemberVO memVo);
	
	
	//0912목 추가
	/**
	 * 회원 1명 조회기능 - 회원정보 수정할때 비밀번호 확인용
	 * @param custVo CustomerVO 의 값들
	 * @return CustomerVO 출력
	 */
	public CustomerVO getCustomer(CustomerVO custVo);
	
	
	//0913금 추가
	/**
	 * customer테이블에 회원정보를 수정하는 능
	 * @param custVo 비밀번호, 아이디
	 * @return 성공  : 1 / 실패 : 0
	 */
	public int updateCustomer(CustomerVO custVo);

	//0914추가
	/**
	 * 회원의 개인정보 수정 - 학생,선생 기능  
	 * @param 파라미터 MemberVO
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int deleteCustomer(String cusid);	
	
	
}
