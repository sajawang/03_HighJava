package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest03Teacher {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫번째 LPROD_ID값 입력 >> "	);
		int num1 = scan.nextInt();
		
		System.out.print("두번째 LPROD_ID값 입력 >> ");
		int num2 = scan.nextInt();
		
		int max, min;
		/*if(num1 > num2) {
			max = num1;
			min = num2;
		} else {
			max = num2;
			min = num1;
		}*/
		
		max = Math.max(num1, num2);
		min = Math.min(num1, num2);
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@lacalhost:1521:xe","chs93","java");
			/*String sql = "select * from lprod "
					+ "where lprod_id >=" +min+" and lprod_id<="+max;
			stmt = con.createStatement();
			rs=stmt.executeQuery(sql);*/
			
			//----------------------------------------------------------------
			
			//PreparedStatement객체 이용하기
			String sql = "select * from lpord where lprod_id beteween ? and ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, min);
			pstmt.setInt(2, max);
			rs=pstmt.executeQuery();
			//----------------------------------------
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}





































