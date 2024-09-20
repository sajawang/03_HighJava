package kr.or.ddit.dao;

import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ViewListVO;
import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.FavoriteVO;
import kr.or.ddit.vo.MathSettingVO;

public interface ICustomerDao {
	
	//아이디와 로그인 정보 회원가입 처리
	
	//09-10 그냥 만든것 수정하기
	public int login(CustomerVO userVo);
	/**
	 * 회원 가입시 아이디 체크 기능 - 시스템 기능 -
	 * @param String id(입력받은 id값)
	 * @return 성공  : 1 / 실패 : 0
	 */
	public String idCheck(String id);
	
	/**
	 * 회원가입 완료 기능 -회원 기능  멤버 이름과 이메일을 받으면 아이디를 반환
	 * @param MemberVO memVo(MemberVO 정보들)
	 * @return 성공  : String 아이디 / 실패 : 0
	 */
	public String idFind(MemberVO memVo);
	
	/**
	 * 회원가입 완료 기능 -회원 기능 
	 * @param MemberVO memVo(MemberVO 정보들)
	 * @return 성공  : 1 / 실패 : 0
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
	
	
	public int insertCustomer(CustomerVO cusVo);
	
	public CustomerVO getLoginUser(CustomerVO cusVo);

	public MemberVO getLoginMemberPoint(MemberVO memVo);
	/**
	 * 비밀번호 발급용 아이디 이메일 체크 메소드
	 * @param memVo
	 * @return 성공 - count(cus_pw) [1] / 실패 0 
	 */
	public int newPassIdCheck(MemberVO memVo);
	
	/**
	 * 회원비밀번호를 임시번호로 업데이트 하는 메소드
	 * @param cusVo
	 * @return 성공 비밀번호 업데이트 [1] / 실패 0 
	 */	
	public int newPassUpdate(CustomerVO cusVo);
	
	public FavoriteVO getFavoriteVO (String id);
	public ViewListVO getViewListVO (String id);
	public PostVO getPostVO (String id);
	public MathSettingVO getMathSettingVO (String id);
	public CommentVO getCommentVO (String id);
	public AttemptVO getAttemptVO (String id);
	
	public String getSysdateLog(String id);

	public int getCountMate ();
	public int getCountViewList(String id);
	
	
	

}
