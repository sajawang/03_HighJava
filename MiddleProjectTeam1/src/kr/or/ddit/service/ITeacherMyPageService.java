package kr.or.ddit.service;


import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.CustomerVO;

public interface ITeacherMyPageService {
	
	/**
	 * memId을 매개변수로 받아서 해당 선생님의 정보를 가져오는 메서드
	 * 
	 * @param memId 회원Id
	 * @return UserVO 회원정보를 가지고 있는 UserVO객체
	 */
	public CustomerVO getTeacher(String memId);
	
	/**
	 * UserVO에 저장된 자료를 DB에 update하는 메서드
	 * 
	 * @param CustomerVO DB에 update할 자료가 저장된 UserVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateTeacher(CustomerVO vo);
	
	/**
	 * memId을 매개변수로 받아 해당 선생님의 정보를  DB에서 delete하는 메서드
	 * 
	 * @param memId  회원Id
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteTeacher(String memId);
	
	/**
	 * PostVO을 매개변수로 받아 해당 선생님의 인증정보를  DB에서 update하는 메서드
	 * 
	 * @param PostVO 선생님 인증정보를 가지고 있는 PostVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int uploadTeacher(PostVO vo);
	
}
