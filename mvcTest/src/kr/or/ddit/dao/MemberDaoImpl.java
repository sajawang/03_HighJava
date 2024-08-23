package kr.or.ddit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.util.DBUtil;
import kr.or.ddit.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao{
	
	//싱글톤 만들기
	
	//1.정적필드
	private static MemberDaoImpl singleton = new MemberDaoImpl();
	
	//2.생성자
	private MemberDaoImpl() {}
	
	//3.정적메소드
	public static MemberDaoImpl getInstance() {
		return singleton;
	}
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;	//반환값이 저장될 변수
		
		try {
			conn = DBUtil.getConnection();
			
			String sql="insert into mymember values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());
			
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
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn=DBUtil.getConnection();
			
			String sql="delete from mymember where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
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
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
	    	//Establishing the connection!!!!!!!!!!!!!!!!!!!!!
	        conn = DBUtil.getConnection();
	        
	        //Preparing the SQL statement!!!!!!!!!!!!!!!!!!!!!!!!
	        String sql = "UPDATE mymember SET mem_pass = ?, mem_name = ?, mem_tel = ?, mem_addr = ? WHERE mem_id = ?";
	        pstmt = conn.prepareStatement(sql);
	        
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());
	        
	        //Executing the query and obtaining the result set!!!!!!!!!!!!!!!!!!!!!!!!!!
	        cnt = pstmt.executeUpdate();
	        
	        if (cnt > 0) {
	            System.out.println("수정 작업 성공!");
	        } else {
	            System.out.println("수정 작업 실패!");
	        }
	    } catch (SQLException e) {
	    	// 메소드임
	    	/*
	    	 * print하기 위해 사용됨. stack traced의 
	    	 * 
	    	 * e -> 나타내는데. 예외 객체를. catch에서 나온.
	    	 * 	 -> e 타입은 다양화되는데 의존하는 예외를. (보통 sqlexception, ioexception,exception)
	    	 * 
	    	 * pringtStackTrace() ->메소드이다. Throwable클래스에서 사용가능한
	    	 * 					  -> stack trace란 프로그램의 실행 과정에서 호출된 메서드들의 순서와 위치 정보를 나타내는 것.
	    	 */
	        e.printStackTrace();
	    } finally {
	        try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }
		return cnt;
	}
		
	

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> memList = null;//반환값이 저장될 변수

		try {
			conn = DBUtil.getConnection();
			String sql = "select * from mymember";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			memList = new ArrayList<MemberVO>(); //List객체 생성
			
			while(rs.next()) {
				//1개의 레코드 데이터를 VO객체에 저장한다.
				MemberVO memVo = new MemberVO();
				memVo.setMem_id(rs.getNString("mem_id"));
				memVo.setMem_pass(rs.getString("mem_pass"));
				memVo.setMem_name(rs.getNString("mem_name"));
				memVo.setMem_tel(rs.getNString("mem_tel"));
				memVo.setMem_addr(rs.getNString("mem_addr"));
				
				memList.add(memVo); //VO객체를 List에 추가한다.
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) {}
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
		
		return memList;
	}

	@Override
	public int getMemberIdCount(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;	//반환값 변수
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select count(*) cnt from mymember where mem_id=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) {}
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		//key값 ==> 회원 ID(MEMID), 수정할 컬럼명(FIELD), 수정할 데이터(DATA)
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymemeber set " +paramMap.get("FEILD")+"= ? where mem_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, paramMap.get("DATA"));
			pstmt.setString(2, paramMap.get("MEMID"));
					
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
		
		return 0;
	}

}





































































