package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.CommentVO;

public interface ICommentService {
	
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



















