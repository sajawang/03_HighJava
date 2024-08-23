package kr.or.ddit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.util.DBUtil3;
import kr.or.ddit.vo.BoardVO;



public class BoardDaoImpl implements IBoardDao{

	//싱글톤 만들기
	
		//1.정적필드
		private static BoardDaoImpl singleton = new BoardDaoImpl();
		
		//2.생성자
		private BoardDaoImpl() {}
		
		//3.정적메소드
		public static BoardDaoImpl getInstance() {
			return singleton;
		}

		@Override
		public List<BoardVO> getAllBoard() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<BoardVO> boardList = null;//반환값이 저장될 변수

			try {
				conn = DBUtil3.getConnection();
				String sql = "select * from jdbc_board";
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				boardList = new ArrayList<BoardVO>(); //List객체 생성
				
				while(rs.next()) {
					//1개의 레코드 데이터를 VO객체에 저장한다.
					BoardVO boardVo = new BoardVO();
					boardVo.setBoard_no(rs.getString("board_no"));
					boardVo.setBoard_title(rs.getString("board_title"));
					boardVo.setBoard_writer(rs.getString("board_writer"));
					boardVo.setBoard_date(rs.getString("board_date"));
					boardVo.setBoard_cnt(rs.getString("board_cnt"));
					boardVo.setBoard_content(rs.getString("board_content"));
					
					boardList.add(boardVo); //VO객체를 List에 추가한다.
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try { if(rs != null) rs.close(); } catch (SQLException e) {}
				try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
				try { if(conn != null) conn.close(); } catch (SQLException e) {}
			}
			
			return boardList;
		}

		@Override
		public int insertBoard(BoardVO boardVo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int cnt = 0;	//반환값이 저장될 변수
			
			try {
				conn = DBUtil3.getConnection();
				
				String sql=" insert into jdbc_board \r\n" + 
						   " values(board_seq.nextval, ? ,?,sysdate,0,?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, boardVo.getBoard_title());
				pstmt.setString(2, boardVo.getBoard_writer());
				pstmt.setString(3, boardVo.getBoard_content());
				
				cnt = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
				try { if(conn != null) conn.close(); } catch (SQLException e) {}
			}
			
			return cnt;
		}

		@Override
		public int updateBoard(BoardVO boardVo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int cnt = 0;
			
			try {
		        conn = DBUtil3.getConnection();
		        
		        String sql = " UPDATE jdbc_board \r\n" + 
		        			 " SET board_title = ?, board_content = ? \r\n" + 
		        			 " WHERE board_no = ?";
		        pstmt = conn.prepareStatement(sql);
		        
				pstmt.setString(1, boardVo.getBoard_title());
				pstmt.setString(2, boardVo.getBoard_content());
				pstmt.setString(3, boardVo.getBoard_no());
		        
		        cnt = pstmt.executeUpdate();
		        
		        if (cnt > 0) {
		            System.out.println("수정 작업 성공!");
		        } else {
		            System.out.println("수정 작업 실패!");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
		        try { if (conn != null) conn.close(); } catch (SQLException e) {}
		    }
			return cnt;
		}

		@Override
		public int deleteBoard(String boardNo) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int cnt = 0;
			
			try {
				conn=DBUtil3.getConnection();
				
				String sql="delete from jdbc_board \r\n" + 
						   "where board_no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setNString(1, boardNo);
				
				cnt = pstmt.executeUpdate();
				
				if(cnt>0) {
					System.out.println("삭제 작업성공!!!");
				} else {
					System.out.println("삭제 작업 실패~~~");
				} 

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
				try { if(conn != null) conn.close(); } catch (SQLException e) {}
			}
			
			return cnt;
		}

		@Override
		public List<BoardVO> searchBoard(String str) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<BoardVO> boardList = null;//반환값이 저장될 변수

			try {
				conn = DBUtil3.getConnection();
				String sql = "select * \r\n" + 
							 "from jdbc_board\r\n" + 
							 "where board_title like '%"+str+"%'";
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				boardList = new ArrayList<BoardVO>(); //List객체 생성
				
				while(rs.next()) {
					//1개의 레코드 데이터를 VO객체에 저장한다.
					BoardVO boardVo = new BoardVO();
					boardVo.setBoard_no(rs.getString("board_no"));
					boardVo.setBoard_title(rs.getString("board_title"));
					boardVo.setBoard_writer(rs.getString("board_writer"));
					boardVo.setBoard_date(rs.getString("board_date"));
					boardVo.setBoard_cnt(rs.getString("board_cnt"));
					boardVo.setBoard_content(rs.getString("board_content"));
					
					boardList.add(boardVo); //VO객체를 List에 추가한다.
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try { if(rs != null) rs.close(); } catch (SQLException e) {}
				try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
				try { if(conn != null) conn.close(); } catch (SQLException e) {}
			}
			
			return boardList;
		}

		@Override
		public List<BoardVO> getoneBoard(String str) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			List<BoardVO> boardList = null;//반환값이 저장될 변수

			try {
				conn = DBUtil3.getConnection();
				String sql = "select * \r\n" + 
							 "from jdbc_board\r\n" + 
							 "where board_title like '%"+str+"%'";
				
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				boardList = new ArrayList<BoardVO>(); //List객체 생성
				
				while(rs.next()) {
					//1개의 레코드 데이터를 VO객체에 저장한다.
					BoardVO boardVo = new BoardVO();
					boardVo.setBoard_no(rs.getString("board_no"));
					boardVo.setBoard_title(rs.getString("board_title"));
					boardVo.setBoard_writer(rs.getString("board_writer"));
					boardVo.setBoard_date(rs.getString("board_date"));
					boardVo.setBoard_cnt(rs.getString("board_cnt"));
					boardVo.setBoard_content(rs.getString("board_content"));
					
					boardList.add(boardVo); //VO객체를 List에 추가한다.
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try { if(rs != null) rs.close(); } catch (SQLException e) {}
				try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
				try { if(conn != null) conn.close(); } catch (SQLException e) {}
			}
			
			return boardList;
		}

		

}









































































































