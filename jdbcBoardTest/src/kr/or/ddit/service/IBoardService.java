package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.BoardVO;

public interface IBoardService {
	public List<BoardVO> getAllBoard();
	public int insertBoard(BoardVO boardVo);
	public int updateBoard(BoardVO boardVo);
	public int deleteBoard(String boardNo);
	public List<BoardVO> searchBoard(String str);
}
