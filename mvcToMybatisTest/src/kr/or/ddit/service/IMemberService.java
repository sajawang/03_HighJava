package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;

/**
 * Service객체는 DAO에 만들어진 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고,
 * 받아온 결과를 Controller에게 보내주는 역할을 수행한다.
 * 
 * 보통 DAO의 메서드와 구조가 같게 만든다.
 * 
 */
public interface IMemberService {
	/**
	 * MemberVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo DB에  insert할 자료가 저장된 MemberVO객체
	 * @return insert작업이 성공하면 1, 실패하면 0이 반환되도록
	 */
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원ID를 매개변수로 받아 해당 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId 삭제할 회원ID
	 * @return 작업성공 : 1, 실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO자료를 이용하여 회원 정보를 수정하는 메서드
	 * 
	 * @param memVO update할 회원 정보가 저장된 MemberVO객체 
	 * @return 작업성공->1, 작업실패->0
	 */
	public int updateMember(MemberVO memVO);
	
	/**
	 * DB의 전체 회원 정보를 List에 담아서 반환하는 메서드
	 * 
	 * @return MemberVO객체가 저장된 List객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드
	 * 
	 * @param memId 검색할 회원ID
	 * @return 검색된 회원 ID의 개수
	 */
	public int getMemberIdCount(String memId);
	
	/**
	 * 수정할 정보가 저장된 Map객체를 매개변수로 받아서 원하는 컬럼을 수정하는 메서드
	 * 	key값 ==> 회원ID(MEMID), 수정할 컬럼명(FIELD), 수정할 데이터(DATA)
	 * 
	 * @param paramMap 수정할 컬럼명, 수정할 데이터, 회원ID가 저장된 Map객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateMember2(Map<String,String> paramMap);
}
