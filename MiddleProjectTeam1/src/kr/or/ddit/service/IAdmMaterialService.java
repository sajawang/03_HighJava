package kr.or.ddit.service;


import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.QuestionVO;

public interface IAdmMaterialService {
	/**
	 * material_no를 매개변수로 받아서 해당 학습지의 정보를 가져오는 메서드
	 * 
	 * @param material_no 학습지No
	 * @return MaterialVO 학습지 정보를 가지고 있는 MaterialVO객체
	 */
	public MaterialVO detailMaterial(int material_no);
	
	/**
	 * MaterialVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param MaterialVO DB에 insert할 자료가 저장된 MaterialVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertMaterial(MaterialVO vo);
	
	/**
	 * MaterialVO에 저장된 자료를 DB에 update하는 메서드
	 * 
	 * @param MaterialVO DB에 update할 자료가 저장된 MaterialVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateMaterial(MaterialVO vo);
	
	/**
	 * material_no를 매개변수로 받아 해당 학습지의 정보를  DB에서 delete하는 메서드
	 * 
	 * @param material_no 학습지No
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteMaterial(int material_no);
	
	// 페이징 처리
	/**
	 * Map객체(board_no, 페이징처리변수)를 매개변수로 받아서 해당 학습지의 정보를 가져오는 메서드
	 * 
	 * @param MaterialVO 조회할 학습지 게시판No
	 * @return List<MaterialVO> MaterialVO객체가 저장된 List객체
	 */
	public List<MaterialVO> selectAllMaterial();

	public List<MaterialVO> selectAdminAllMaterialList();
	
	/**
	 * Map객체(board_no, 페이징처리변수)를 매개변수로 받아서 해당 학습지의 개수를 가져오는 메서드
	 * 
	 * @param MaterialVO 조회할 학습지 게시판No
	 * @return count 학습지의 개수를 가지고있는 count
	 */
	public int countMaterial(Map<String, Object> map);

	/**
	 * 파일이름을 매개변수로 받아 새로운 파일 정보를 insert하는 메소드
	 * @param fileName 파일이름
	 * @return 성공1 / 실패 0 
	 */
	public int adminInsertMateFile(String fileName);
	
	/**
	 * 학습지 VO 관련 정보를 받아 새로운 학습지를 insert하는 메소드
	 * @param 학습지 VO mateVo
	 * @return 성공 1/ 실패 0
	 */
	public int adminInsertMate(MaterialVO mateVo);
	
	/**
	 * 파일이름을 매개변수로 받아 같은 이름의 파일이 있는지 확인하는 메소드
	 * @param fileName 파일이름
	 * @return 해당 파일의 files_no [int] 
	 */
	public Integer adminSelectMateFileNum(String fileName);
	
	/**
	 * 파일번호를 매개변수로 받아 해당 파일의 이름을 반환하는 메소드
	 * @param fileNo 파일번호
	 * @return 해당 파일의 이름 String값
	 */
	public String adminSelectMateFileName(int fileNo);
	
	/**
	 * question 전체 정보를 가져오는 메소드
	 * @return 모든 QuestionVO가 담긴 List
	 */
	public List<QuestionVO> getQuestionList();
	
	/**
	 * 학습지 번호 mateNO를 매개변수로 이에 해당하는 문제들을 가져오는 에소드
	 * @param mateNo 학습지 번호
	 * @return 해당 학습지에 담긴 QuestionVO 리스트
	 */
	public List<QuestionVO> getMateQuestionList(int mateNo);
	
	/**
	 * 문제번호를 매개변수로 받아 해당 문제의 상세정보를 가져오는 메소드
	 * @param 문제 번호 queNo
	 * @return 성공 QuestionVO 객체 1개 / 실패 0
	 */
	public  QuestionVO selectDetailQuestion (int queNo);
	
	/**
	 * 파일이름을 매개변수로 받아 같은 이름의 문제 썸네일 파일이 있는지 확인하는 메소드
	 * @param fileName 파일이름
	 * @return 해당 파일의 files_no [int] 
	 */
	public  int adminSelectMateQueNum (String queFileName);
	
	/**
	 * 파일번호을 매개변수로 받아 같은 이름의 문제 썸네일 파일이 있는지 확인하는 메소드
	 * @param fileName 파일이름
	 * @return 해당 파일의 fileName [int] 
	 */
	public  String adminSelectMateQueName (int queFileNo);
	
	public int adminInsertMaterial(Map<String , Object> map);
	
	public  int selectMaxMaterial ();
	

	
}
