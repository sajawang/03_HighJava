package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

public interface IAdmTeacherService {
	
public MemberVO getAllMemVo(String cusId);
	
	public CustomerVO getAllCusVo(String cusId);
	
	/**
	 * UserVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param CustomerVO DB에 insert할 자료가 저장된 UserVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertCusTeacher(CustomerVO cusvo);
	
	public int insertMemTeacher(MemberVO mvo);
	
	/**
	 * UserVO에 저장된 자료를 DB에 update하는 메서드
	 * 
	 * @param CustomerVO DB에 update할 자료가 저장된 UserVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateMemTeacher(MemberVO mvo) ;
	public int updateCusTeacher(CustomerVO cusvo);
	

	
	/**
	 * Map객체(페이징처리변수)를 매개변수로 받아서 해당 게시글의 정보를 가져오는 메서드
	 * 
	 * @param Map<String, Object> 페이징처리변수
	 * @return List<PostVO> PostVO객체가 저장된 List객체
	 */
	public  List<MemberVO> getAllTeacher(String cusId);
	
	//선생님 yn 가져오기 
		public List<CustomerVO> cusdelteacher();
}
	
	

