package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

public class JdbcTest05Teacher {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DBUtil.getConnection();
			/*
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","csh93","java");
			*/
			//lprod_id는 현재의 lprod_id에서 제일 큰 값보다 1크게 한다.
			String sql = "select nvl(max(lprod_id),0)+1 maxid from lprod";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			int maxId = 0;
			if(rs.next()) {
				maxId = rs.getInt("maxId");//방법1 : alias명 이용
				//maxId = rs.getInt(1);	   //방법2 : 컬럼번호 이용
			}
			
			//입력받은 lprod_gu가 이미 등록되어 있는 값이면 새로운 값으로 다시 입력 받아서 처리한다.
			String gu;	//입력한 lprod_gu가 저장될 변수 
			int count = 0;	//입력한 lprod_gu의 개수가 저장될 변수
			
			String sql2="select count(*) cnt from lprod where lprod_gu=?";
			pstmt = conn.prepareStatement(sql2);
			do {
				System.out.println("Lprod_gu값 입력 >> ");
				gu = scan.next();
				
				//SQL문의 물음표 자리에 값 셋팅하기 
				pstmt.setNString(1, gu);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					count = rs.getInt(1);
					//count = rs.getInt("cnt");
				}
			
				if(count>0) {
					System.out.println("입력한 Lprod_gu인 "+gu+"는 이미 등록된 값입니다.");
					System.out.println("다시 입력하세요");
					System.out.println();
				}
			} while(count>0);
			
			System.out.print("LPROD_NM값 입력 >> ");
			String nm=scan.next();
			
			String sql3 = "insert into lprod(LPROD_ID, LPROD_GU,LPROD_NM) "
					+"values(?,?,?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, maxId);
			pstmt.setNString(2, gu);
			pstmt.setNString(3, nm);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("추가작업성공");
			} else {
				System.out.println("추가작업 실패!");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) {}
			try { if(pstmt != null) pstmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
	}
}




















