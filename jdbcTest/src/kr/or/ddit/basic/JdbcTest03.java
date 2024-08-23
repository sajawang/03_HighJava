package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//문제 : 사용자로부터 lprod_id값을 2개 입력받아서 두 값 중 작은 값부터 큰 값 까지의 자료들을 출력하시오
public class JdbcTest03 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"csh93","java");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디 번호 입력 : ");
			String id1 = sc.nextLine();
			System.out.print("아이디 번호 입력 : ");
			String id2 = sc.nextLine();
			
			String sql = "select * from lprod where lprod_id between "+id1+" and " +id2;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("== 처리 결과 출력 ==");
			/*
			 * 처리결과를 출력하기 위해서 Set에서는 
			 * 1.향상된 for문 
			 *  -> for(String fruit : fruits){ System.out.println(fruit)}
			 * 2.iterator 
			 *  -> Iterator<String> iterator = fruits.iterator();
			 *  -> while(iterator.hasNext()){
			 *  ->     String fruit = iterator.next();
			 *  		System.out.poringln(fruit);
			 *  		}
			 * 3.forEach메소드 사용한다.
			 *  -> fruits.forEach(fruit -> System.out.println(fruit));
			 */
			while(rs.next()) {
				/*
				 * 1.Set
				 * -java.util
				 * -purpose : store a collection of unique elements
				 * 
				 * 2.ResultSet
				 * -java.sql
				 * -purpose : represent the result set of a database query executed(실행하다)
				 */
				System.out.println("lprod_id : "+rs.getInt("lprod_id"));
				System.out.println("lprod_gu :"+rs.getString(2));
				System.out.println("lprod_nm"+rs.getString("lprod_nm"));
				System.out.println("-------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try { if(rs != null) rs.close(); } catch (SQLException e) {}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
	}
}
