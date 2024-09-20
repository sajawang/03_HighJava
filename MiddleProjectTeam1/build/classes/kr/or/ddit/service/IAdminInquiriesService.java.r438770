package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.PostVO;

public interface IAdminInquiriesService {
	
	//상세조회
	/**
	 * 이용문의 게시판 보기 - 전체 기능 
	 * @param int postNo(게시글 번호) 
	 * @return	성공 : PostVO객체 / 실패 : 0
	 */
	public PostVO detailInquiries(int postNo);
	/**
	 * 이용문의 게시판 리스트 전체 출력 - 전체 기능 
	 * @param  
	 * @return	성공 : List(PostVO)객체 / 실패 : 0
	 */
	public List<PostVO> selectInquiries(PostVO vo);
	
	/**
	 * 이용문의 게시판 작성 - 관리자 기능 
	 * @param PostVO객체 
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int insertAdminInquiries(PostVO vo);
	
	/**
	 * 이용문의 게시판 수정 - 관리자 기능 
	 * @param PostVO객체 
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int updateAdminInquiries(PostVO vo);
	
	/**
	 * 이용문의 게시판 삭제 - 관리자 기능 
	 * @param int postNo 게시글 번호 
	 * @return	성공 : 1 / 실패 : 0
	 */
	public int deleteAdminInquiries(int postNo);
	
	//조회수
	/**
	 * 게시판 조회수 상승 - 시스템 기능 
	 * @param int postNo 게시글 번호
	 * @return	성공 : 1(조회수 상승) / 실패 : 0
	 */
	public int updateHitAdminInquiries(int postNo);
	
	//페이징처리 필요
	
	public List<PostVO> getAllAdminInquiries(Map<String, Object> map);//검색,페이징처리도
	public int countAdminInquiries(Map<String, Object> map);

	//댓글 CRUD
	/**
	 * 문의 게시판의 댓글 기능 관리자 기능 - 파라미터 CommentVO 
	 * @param comVO
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int insertComment(CommentVO comVO);
	
	/**
	 * 문의 게시판 댓글 리스트 - 시스템 기능 - 파라미터 없음
	 * @param comVO
	 * @return	성공  : List(CommentVO)객체 / 실패 : 0
	 */
	public List<CommentVO> selectComment();
	
	/**
	 * 댓글 자세히보기(?) 시스템 기능-  파라미터 댓글 번호
	 * @param comNo
	 * @return	성공  : 1 / 실패 : 0
	 */
	public CommentVO selectDetailComment(int comNo);

	/**
	 * 댓글 수정기능 - 관리자 기능  - 파라미터 CommentVO의 수정값
	 * @param comVO
	 * @return	성공  : 1 / 실패 : 0
	 */
	public int updateComment(CommentVO comVO);
	
	/**
	 * 댓글 삭제기능  관리자 기능  - 파라미터 댓글번호값 
	 * @param int comNo
	 * @return	성공  : 1 / 실패 : 0
	 */
		public int deleteComment(int comNo);
}
