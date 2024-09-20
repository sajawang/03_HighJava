package kr.or.ddit.dao;

import java.util.List;

import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ViewListVO;

public interface IMaterialDao {
	
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
	public List<MaterialVO> selectMaterial();
	
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
	
}
