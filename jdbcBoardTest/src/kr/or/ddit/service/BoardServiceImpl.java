package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.BoardDaoImpl;
import kr.or.ddit.dao.IBoardDao;
import kr.or.ddit.vo.BoardVO;

public class BoardServiceImpl implements IBoardService{
	private IBoardDao dao;
	
	//정적필드
	private static BoardServiceImpl singleton = new BoardServiceImpl();
	
	//생성자
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance(); //DAO객체가 저장될 변수 선언
	}
	
	//정적 메소드
	public static BoardServiceImpl getInstance() {
		return singleton;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		// TODO Auto-generated method stub
		return dao.getAllBoard();
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return dao.insertBoard(boardVo);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return dao.updateBoard(boardVo);
	}

	@Override
	public int deleteBoard(String boardNo) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> searchBoard(String str) {
		// TODO Auto-generated method stub
		return null;
	}


}
