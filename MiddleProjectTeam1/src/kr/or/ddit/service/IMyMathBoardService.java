package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PostVO;

public interface IMyMathBoardService {
	
	
	/**
	 * 수학 해결소 글 쓰기 - 학생 기능
	 * @param int boardNo(게시판번호) ,
	 * 		 PostVO pvo (게시글 VO), String id (유저 아이디) 
	 * @return 성공  : 1 / 실패 : 0
	 */
	
	public int InsertMyMath(int boardNo , PostVO pvo , String userId);
	/**
	 * //해결소 게시판 보기 - 전체기능  - 파라미터 없음
	 * @param 
	 * @return 성공  : List(BoardVO)객체 / 실패 : 0
	 */
	public List<BoardVO> SelectMyMath();
	
	/**
	 * 내용 보기 - 전체기능   - 
	 * @param int postNo - 게시글 번호
	 * @return BoardVO 정보 / 실패 : 0
	 */
	public BoardVO SelectDetailMyMath(int postNo);

	/**
	 * 수정하기 - 학생 및 관리자 기능  
	 * @param String userId,PostVO pvo
	 * @return 성공 : 1 / 실패 : 0
	 */
	public int UpdateMyMath(String userId,PostVO pvo);
	
	/**
	 * 삭제 - 작성 학생 및 관리자 기능 파라미터
	 * @param String userId,int postNo
	 * @return 성공 : 1 / 실패 : 0
	 */
	public int DeleteMyMath(String userId,int postNo);
	
	
}
