package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.PostVO;

public interface IAdminSamTalkDao {
	
	/**
	 * 쌤 톡톡 게시판의 게시글을 전부 불러옴 - 선생, 관리자 기능
	 * @param 없음
	 * @return	성공 List(PostVO)객체 / 실패 : 0
	 */
	public List<PostVO> selectAllSamTalk();
	
	/**
	 * 쌤 톡톡 게시판의 게시글의 상세 내용을 보는 메소드 - 선생, 관리자 기능
	 * @param int postNo 게시글 번호
	 * @return	성공 List(PostVO)객체 / 실패 : 0
	 */
	public PostVO detailSamTalk(int postNo);

	/**
	 * 쌤 톡톡 게시판의 게시글 작성 - 선생, 관리자 기능
	 * @param PostVO객체 [게시판 정보]
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int insertAdminSamTalk(PostVO vo);

	/**
	 * 쌤 톡톡 게시판의 게시글 수정 - 선생, 관리자 기능
	 * @param PostVO객체 [게시판 정보]
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int updateAdminSamTalk(PostVO vo);

	/**
	 * 쌤 톡톡 게시판의 게시글 삭제 - 선생, 관리자 기능
	 * @param postNo[게시판 번호]
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int deleteAdminSamTalk(int postNo);
	
	//조회수

	/**
	 * 게시판의 조회수 상승 메소드 - 선생, 관리자 기능
	 * @param postNo[게시판 번호]
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int updateHitAdminSamTalk(int postNo);
	
	//페이징처리 필요
	public List<PostVO> getAllAdminSamTalk(Map<String, Object> map);//검색,페이징처리도
	public int countAdminSamTalk(Map<String, Object> map);
}
