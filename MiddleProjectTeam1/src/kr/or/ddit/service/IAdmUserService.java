package kr.or.ddit.service;


import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

public interface IAdmUserService {
	
	/**
	 * customerVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param CustomerVO DB에 insert할 자료가 저장된 vo객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertCusStudent(CustomerVO vo);
	
	
	/**
	 * MemberVo 에 저장된 자료를 DB에 insert하는 메서드
	 * @param MemberVO에 저장된 자료를 db에 insert할 자료가 저장된 svo
	 * @return 작업 성공 : 1, 작업 실패  : 0
	 */
	
	public int insertMemStudent(MemberVO svo);
	
	/**
	 * CustomerVO에 저장된 자료를 DB에 update하는 메서드
	 * 
	 * @param CustomerVO DB에 update할 자료가 저장된 cusvo객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	
	public int updateCusStudent(CustomerVO cusvo);

	/**
	 * MembermerVO에 저장된 자료를 DB에 update하는 메서드
	 * 
	 * @param MembermerVO DB에 update할 자료가 저장된 memvo객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	
	public int updateMemStudent(MemberVO memvo);
	
	
	/**
	 * memId를 매개변수로 받아 해당 회원의 정보를  DB에서 delete하는 메서드
	 * 
	 * @param memId 회원Id
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteCusUser(String cusId);
	
	/**
	 * memId를 매개변수로 받아 해당 회원의 정보를  DB에서 delete하는 메서드
	 * 
	 * @param memId 회원Id
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteMemStudent(String cusId);
	
	
	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아서 반환하는 메서드
	 * @param cusId
	 * @return MemberVO객체가 저장된 List객체
	 */
	public List<MemberVO> getAllStudent(String cusId);
	

	/**
	 * DB의 전체 회원 정보를 가져와서 MemberVo에 담아서 반환하는 메서드 (상세보기)
	 * @param cusId 검색할 회원 ID 
	 * @return 검색된 회원 ID의 개수 
	 */
	public MemberVO getAllMemVo(String cusId);
	
	/**
	 *	DB의 전체 회원 정보를 가져오는 메서드
	 * @param cusId 검색할 회원 ID
	 * @return 검색된 회원 IDㅇㅣ 개수
	 */
	public CustomerVO getAllCusVo(String cusId);
	/**
	 * 
	 * 회원 ID를 인수값으로 받아서 해당 회원 ID의 개수를 반환하는 메서드
	 * @param cusId 검색할 회원 ID
	 * @return 검색된 회원 ID의 개수
	 */
	public int countStudent(String cusId);
	public List<MemberVO> memAuth();
	
	public int updateUpgrade(CustomerVO cusvo);
	
	//학생 yn 가져오기 
	public List<CustomerVO> cusdelstudent();
}

