package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * -Statement 객체를 사용하면 SQL injection해킹을 당할 수 있는  예제
 * 1. 정상검색 ==>(계좌번호) 입력...
 */
public class JdbcTest06 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*
		 * conn변수는 데이터베이스로의 연결을 뜻한다
		 * JDBC작업에서는 DriverManager.getConnection()을 사용해서 데이터베이스에 연결한다.
		 */
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","csh93","java");
			System.out.println("계좌번호 정보 검색하기");
			System.out.println();
			System.out.println("검색할 계좌번호 입력 >> ");
			String bankNo = scan.nextLine();
			
			//Statement 객체를 이용한 경우
			String sql = "select * from bankinfo where bank_no='"+bankNo+"'";
			
			System.out.println("sql==>"+sql);
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			/*
			//PrepareStatement 객체를 이용한 경우
			String sql = "select * from bankinfo where bank_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bankNo);
			
			rs = pstmt.executeQuery();
			*/
			System.out.println();
			System.out.println("\t===검색결과===");
			System.out.println("계좌번호\t은행명\t예금주명\t개설날짜");
			System.out.println("-----------------------------");
			while(rs.next()) {
				String bNo = rs.getString("bank_no");
				String bName = rs.getNString("bank_name");
				String bUser = rs.getString("bank_user_name");
				String bDate = rs.getNString("bank_date");
				
				
				System.out.println(bNo+"\t"+bName+"\t"+bUser+"t"+bDate);
			}
			System.out.println("-----------------------");
		} catch (SQLException e) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();}catch(SQLException e) {}
			if(conn !=null) try {conn.close();}catch(SQLException e) {}
		}
	}
}





















