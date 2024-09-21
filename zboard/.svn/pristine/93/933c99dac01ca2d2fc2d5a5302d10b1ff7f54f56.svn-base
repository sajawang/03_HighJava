package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PostVO;

public interface IAdmNoticeDao {
	
	/**
	 * postNo을 매개변수로 받아서 해당 공지사항의 정보를 가져오는 메서드
	 * 
	 * @param postNo 게시판No, 게시글No
	 * @return PostVO 게시글 정보를 가지고 있는 PostVO객체
	 */
	public PostVO detailNotice(int postNo);
	
	/**
	 * PostVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param PostVO DB에 insert할 자료가 저장된 PostVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertNotice(PostVO vo);
	
	/**
	 * PostVO에 저장된 자료를 DB에 update하는 메서드
	 * 
	 * @param PostVO DB에 update할 자료가 저장된 PostVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateNotice(PostVO vo);
	
	/**
	 * postNo을 매개변수로 받아 해당 공지사항의 정보를  DB에서 delete하는 메서드
	 * 
	 * @param postNo  게시글No
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteNotice(int postNo);
	
	// 페이징 처리
	/**
	 * Map객체(페이징처리변수)를 매개변수로 받아서 해당 공지사항의 정보를 가져오는 메서드
	 * 
	 * @param Map<String, Object> 페이징처리변수
	 * @return List<PostVO> PostVO객체가 저장된 List객체
	 */
	public List<PostVO> getAllNotice(Map<String, Object> map);
	
	/**
	 * Map객체(페이징처리변수)를 매개변수로 받아서 해당 공지사항의 개수를 가져오는 메서드
	 * 
	 * @param Map<String, Object> 페이징처리변수
	 * @return count 공지사항의 개수를 가지고있는 count
	 */
	public int countNotice(Map<String, Object> map);
}
