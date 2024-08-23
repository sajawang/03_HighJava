package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;

public interface IBoardDao {

	public List<BoardVO> getAllBoard();
	public int insertBoard(BoardVO boardVo);
	public int updateBoard(BoardVO boardVo);
	public int deleteBoard(String boardNo);
	
	//선생님만든
	//게시글보기
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 가져와 반환하는 메서드
	 * @param boardNO 가져올 게시글의 번호
	 * @return 게시글에 맞는 자료가 있으면 해당 자료가 저장된 BoardVO객체,
	 * 			게시글에 맞는 자료가 없으면 null반환
	 */
	public BoardVO getBoard(int boardNO);
	
	//선생님이 만든
	//검색
	/**
	 * 검색 단어를 매개변수로 받아서 제목에 검색 단어가 포함된 자료를 검색하는 메서드
	 * @param title 검색할 게시글 제목
	 * @return 검색된 결과가 저장된 List객체
	 */
	public List<BoardVO> getSearchBoard(String title);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 증가시키는 메서드
	 * @param boardNo 조회수를 증가할 게시글의 번호
	 * @return 작업성공 : 1. 작업실패:0
	 */
	public int setCountIncrement(int boardNo);
}
