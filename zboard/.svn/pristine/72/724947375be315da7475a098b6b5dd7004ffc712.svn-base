package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PostVO;

public interface IAdminTeacherLibraryService {

	//상세조회
	/**
	 * 선생님 자료실 리스트를 호출하는 메소드 - 관리자 기능
	 * @param 
	 * @return	성공 : List(PostVO) / 실패 : 0
	 */
	public List<PostVO> selectAllLibrary();

	/**
	 * 선생님 자료실의 상세내용을 호출하는 메소드 - 관리자 기능
	 * @param int PostNo [게시글 번호]
	 * @return	성공 : PostVO객체 / 실패 : 0
	 */
	public PostVO detailLibrary(int PostNo);
	

	/**
	 * 선생님 자료실에 게시글 등록 메소드 - 관리자 기능
	 * @param PostVO vo [게시글 객체]
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int insertAdminTeacherLib(PostVO vo);

	/**
	 * 선생님 자료실에 게시글 수정 메소드 - 관리자 기능
	 * @param PostVO vo [게시글 객체]
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int updateAdminTeacherLib(PostVO vo);

	/**
	 * 선생님 자료실에 게시글 삭제 메소드 - 관리자 기능
	 * @param PostVO vo [게시글 객체]
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int deleteAdminTeacherLiv(int postNo);
	
	//조회수

	/**
	 * 선생님 자료실 게시글의 조회수 상승  메소드 - 관리자 기능
	 * @param int postNo [게시글 번호]
	 * @return	성공 : 1[조회수 상승] / 실패 : 0
	 */
	public int updateHitAdminTeacherLiv(int postNo);
	
	//페이징처리 필요
	public List<PostVO> getAllAdminTeacherLib(Map<String, Object> map);//검색,페이징처리도
	public int countAdminTeacherLiv(Map<String, Object> map);
}
