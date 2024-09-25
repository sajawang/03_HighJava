package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.PostVO;

public interface IAdminInquiriesDAO {
	
	/**
	 * 해당 게시판 게시글 갯수 계산
	 * @param map
	 * @return 게시글 갯수 반환
	 */
	public int countBoard(Map<String, Object> map);
	
	/**
	 * 클릭시 해당 게시글 상세보기
	 * @param  Map<String, Object> map(게시글 번호, 게시판번호)
	 * @return	성공 : List(PostVO)객체 / 실패 : 0
	 */
	public PostVO selectDetailPost(Map<String, Object> map);
	// 해당게시글 상세보기
	
	/**
	 * 게시글 작성
	 * @param PostVO객체 
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int insertPost(PostVO pvo);
	
	/**
	 * 게시글 수정 
	 * @param PostVO객체 
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int updatePost(PostVO vo);
	
	/**
	 * 게시글 삭제 - 관리자 기능 
	 * @param int postNo 게시글 번호 
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int deletePost(PostVO vo);
	
	
	
	/**
	 *  고객센터 내 파라미터값 게시판 보기
	 * @return	성공 : PostVO객체 / 실패 : 0
	 */
	public List<PostVO> selectPostList(Map<String, Object> map);
	
	/**
	 * 고객센터 게시글의 댓글 등록 - 파라미터 CommentVO 
	 * @param comVO
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int insertComment(CommentVO comVO);
	
	/**
	 * 고객센터 게시글 댓글 리스트 - 파라미터 없음
	 * @param Map<String, Object> map board_no와 post_no값이 들어있음
	 * @return	성공  : List(CommentVO)객체 / 실패 : 0
	 */
	public List<CommentVO> selectComment(Map<String, Object> map);
	
	/**
	 * 고객센터 게시글 댓글 상세보기 기능-  파라미터 댓글 번호
	 * @param comNo
	 * @return	성공  : 1 / 실패 : 0
	 */
	public CommentVO selectDetailComment(int comNo);

	/**
	 * 고객센터 게시글 댓글 수정기능 - 파라미터 CommentVO의 수정값
	 * @param comVO
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int updateComment(CommentVO comVO);
	
	/**
	 * 고객센터 게시글 댓글 삭제기능 - 파라미터 댓글번호값 
	 * @param int comNo
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int deleteComment(int comNo);
	
	/**
	 * 고객센터 게시글 파일 업로드
	 * @param fvo 파일VO객체
	 */
	public int insertFiles(FileVO fvo);
	
	/**
	 * 파일번호 업데이트
	 * @param saveFileName 저장된 파일명
	 * @return
	 */
	public int updatePostFileNo(String saveFileName);
	
	/**
	 * 파일명을 보내 파일VO 받아오기
	 * @param saveFileName
	 * @return
	 */
	public FileVO fileinfo(String saveFileName);
	
	/**
	 * 게시글 상세조회
	 * @param board_no
	 * @return
	 */
	public PostVO postView(int post_no);
	
	/**
	 * 댓글 상세조회
	 * @param board_no
	 * @return
	 */
	public List<CommentVO> commentView(int post_no);
		
}
