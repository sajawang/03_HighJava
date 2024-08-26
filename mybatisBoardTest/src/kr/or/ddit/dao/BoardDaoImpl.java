package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao {
		// 1번
		private static BoardDaoImpl dao;
		
		// 2번
		private BoardDaoImpl() { }
		
		// 3번
		public static BoardDaoImpl getInstance() {
			if(dao==null) dao = new BoardDaoImpl();
			return dao;
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@Override
		public int insertBoard(BoardVO boardVo) {
			SqlSession session = null;
			int cnt=0;
			try {
				session=MybatisUtil.getSqlSession();
				cnt=session.insert("board.insertBoard",boardVo);
				if(cnt>0) {
					session.commit();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return cnt;
		}

		@Override
		public int deleteBoard(int boardNo) {
			SqlSession session = null;
			int cnt = 0;
			try {
				session=MybatisUtil.getSqlSession();
				cnt=session.delete("board.deleteBoard",boardNo);
				if(cnt>0) session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cnt;
		}

		@Override
		public int updateBoard(BoardVO boardVo) {
			SqlSession session = null;
			int cnt=0;
			try {
				session=MybatisUtil.getSqlSession();
				cnt=session.update("board.updateBoard",boardVo);
				if(cnt>0) session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return cnt;
		}

		@Override
		public BoardVO getBoard(int boardNo) {
			SqlSession session=null;
			BoardVO boardVo=null;
			try {
				session=MybatisUtil.getSqlSession();
				boardVo=session.selectOne("board.getBoard",boardNo);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return boardVo;
		}

		@Override
		public List<BoardVO> getAllBoard() {
			SqlSession session = null;
			List<BoardVO> boardList = null;
			try {
				session = MybatisUtil.getSqlSession();
				boardList=session.selectList("board.getAllBoard");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return boardList;
		}

		@Override
		public List<BoardVO> getSearchBoard(String title) {
			SqlSession session = null;
			List<BoardVO> boardList = null;
			try {
				session = MybatisUtil.getSqlSession();
				boardList=session.selectList("board.getSearchBoard");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return boardList;
		}

		@Override
		public int setCountIncrement(int boardNo) {
			SqlSession session = null;
			int cnt = 0;
			try {
				session = MybatisUtil.getSqlSession();
				cnt = session.update("mymember.setCountIncrement",boardNo);
				if(cnt>0) session.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				session.close();
			}
			return cnt;
		}

	}



































