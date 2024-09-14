package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.PostVO;

public interface IAdmMyMathBoardService {
	
	/**
	 * postNo을 매개변수로 받아서 해당 수학 학습 해결소의 정보를 가져오는 메서드
	 * 
	 * @param postNo 게시글No
	 * @return PostVO 게시글 정보를 가지고 있는 PostVO객체
	 */
	public PostVO detailMyMathBoard(int postNo);
	
	/**
	 * PostVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param PostVO DB에 insert할 자료가 저장된 PostVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertMyMathBoard(PostVO vo);
	
	/**
	 * PostVO에 저장된 자료를 DB에 update하는 메서드
	 * 
	 * @param PostVO DB에 update할 자료가 저장된 PostVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateMyMathBoard(PostVO vo);
	
	/**
	 * postNo을 매개변수로 받아 해당 수학 학습 해결소의 정보를  DB에서 delete하는 메서드
	 * 
	 * @param postNo  게시글No
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteMyMathBoard(int postNo);
	

	/**
	 * postNo을 매개변수로 받아서 해당 수학 학습 해결소의 답변을 가져오는 메서드
	 * 
	 * @param postNo 게시글No
	 * @return CommentVO 게시글의 답변 정보를 가지고 있는 CommentVO객체
	 */
	public CommentVO getReplyMyMathBoard(int postNo);
	
	/**
	 * CommentVO에 저장된 자료를 DB에 insert하는 메서드
	 * 
	 * @param CommentVO DB에 insert할 자료가 저장된 CommentVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertReplyMyMathBoard(CommentVO vo);
	
	/**
	 * CommentVO에 저장된 자료를 DB에 update하는 메서드
	 * 
	 * @param CommentVO DB에 update할 자료가 저장된 CommentVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateReplyMyMathBoard(CommentVO vo);
	
	/**
	 * comNo을 매개변수로 받아 해당 수학 학습 해결소의 정보를  DB에서 delete하는 메서드
	 * 
	 * @param comNo  답변No
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteReplyMyMathBoard(int comNo);
	
	// 페이징 처리
	/**
	 * Map객체(페이징처리변수)를 매개변수로 받아서 해당 수학 학습 해결소의 정보를 가져오는 메서드
	 * 
	 * @param Map<String, Object> 페이징처리변수
	 * @return List<PostVO> PostVO객체가 저장된 List객체
	 */
	public List<PostVO> getAllMyMathBoard(Map<String, Object> map);
	
	/**
	 * Map객체(페이징처리변수)를 매개변수로 받아서 해당 수학 학습 해결소의 개수를 가져오는 메서드
	 * 
	 * @param Map<String, Object> 페이징처리변수
	 * @return count 수학 학습 해결소의 개수를 가지고있는 count
	 */
	public int countMyMathBoard(Map<String, Object> map);
}
