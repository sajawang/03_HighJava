package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc02Teacher {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Lprod_id값 입력 >> ");
		int num = scan.nextInt();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.oracleDrivaer");
			
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe","csh93","java");
			
			String sql = "select * from lprod where lprod_id>"+num;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("lprod_id : "+rs.getInt("lprod_id"));
				System.out.println("lprod_gu : "+rs.getNString("lprod_gu"));
				System.out.println("lprod_nm : "+rs.getNString("lprod_nm"));
				System.out.println("--------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
		//뒤에 더 써야함
			}
	}
}
