package kr.or.ddit.dao;


import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MaterialVO;

public interface IAdmMaterialDao {
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
	public List<MaterialVO> getAllMaterial(Map<String, Object> map);
	
	/**
	 * Map객체(board_no, 페이징처리변수)를 매개변수로 받아서 해당 학습지의 개수를 가져오는 메서드
	 * 
	 * @param MaterialVO 조회할 학습지 게시판No
	 * @return count 학습지의 개수를 가지고있는 count
	 */
	public int countMaterial(Map<String, Object> map);
}
