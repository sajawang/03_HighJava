package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.ViewListVO;
import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.MemberVO;

public interface IMaterialService {
	
	//학습지 관련 CRUD 
	
	/**
	 * 학습지 삽입 - 관리자 기능   파라미터 MaterialVO 학습지 정보 
	 * @param  MaterialVO mateVo 
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int InsertMaterial (MaterialVO mateVo);
	
	/**
	 * 학습지 전체리스트 조회 - 전체 기능   - 파라미터 없음
	 * @param 
	 * @return	성공  : List(MaterialVO)객체 / 실패 : 0
	 */
	public List<MaterialVO> selectMaterial(Map<String, Object> map);
	
	/**
	 * 학습지 상세보기 학습지 - 전체 기능 - 파라미터 학습지 번호 
	 * @param int mateNo
	 * @return	성공  : 1 / 실패 : 0
	 */
	public MaterialVO selectDetailMaterial(int mateNo);
	
	/**
	 * 학습지 업데이트 -관리자 기능 -
	 * @param  MaterialVO mateVo 
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int UpdateMaterial (MaterialVO mateVo);
	
	/**
	 * 학습지 삭제 - 관리자 기능   - 파라미터 학습지 번호 값
	 * @param int mateNo
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int DeleteMaterial (int mateNo);
	
	/**
	 * 학습지 번호를 매개변수로 받아서 학습지의 문제와 파일을 불러오는 메서드
	 * 
	 * @param mateNo 학습지 번호
	 * @return List<MaterialVO> 해당 학습지에 대한 문제와 파일을 가진 MaterialVO객체를 담은 List객체
	 */
	public List<MaterialVO> getMaterQuestionFile(int mateNo);
	
	/**
	 * 회원아이디와 학습지번호를 매개변수로 받아서 회원의 학습지 내역리스트를 등록하는 메서드
	 * 
	 * @param cusId 회원아이디
	 * @param mateNo 학습지번호
	 * @return 성공 : 1 / 실패 : 0
	 */
	
	/**
	 * 회원아이디와 학습지번호를 매개변수로 받아서 회원의 학습지 내역리스트를 등록하는 메서드
	 * 
	 * @param map 회원아이디와 학습지번호를 가지고있는 map객체
	 * @return 성공 : 1 / 실패 : 0
	 */
	public int insertViewList(Map<String, Object> map);
	
	/**
	 * 학습지를 풀고, 내가 쓴 정답을 등록하는 메서드
	 * 
	 * @param map 회원아이디, 학습지번호, 회원의 입력답, 결과를 가지고 있는 map객체
	 * @return 성공 : 1 / 실패 : 0
	 */
	public int insertAttempt(AttemptVO vo);
	
	/**
	 * 해당 페이지 학습지의 개수를 구하는 메서드
	 * 
	 * @return 학습지의 개수
	 */
	public int countMaterial(Map<String, Object> map);
	
	// 페이지 정보 계산
	public PageVO pageInfo(int page, String school, String grade, String cate , String level);
	
	public List<MaterialVO> firstMaterial(Map<String, Object> map);
	
	//0914 추가
		/**
	 * 풀었던 학습지 제목 출력 
	 * @param cusid 회원아이디
	 * @return 회원이 푼 문제의 제목 출력
	 */
	public List<ViewListVO> getViewMaterial(String cusid);
	
	//0920 추가
	/**
	 * 풀었던 학습지 제목 출력 
	 * @param cusid 회원아이디
	 * @return 회원이 푼 문제의 제목 출력
	 */
	public List<ViewListVO> getMyMaterial(String cusid);
	//0921추가
	/**
	 * 오늘의 10분 수학 학습지 1개 출력하는
	 * @param map cus_id, material_grade, material_level
	 * @return material의 리스트 중 하나 출력
	 */
	public MaterialVO todayTenMinMaterial(Map<String, Object> map);
	
	public int updateMemberPoint(MemberVO mvo);
	
	public MathSettingVO getMathMinute(String cusId);
	
	public List<ViewListVO> getMyAnswer(ViewListVO vo);

}
