package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 문제 : 사용자로부터 Lprod_id값을 입력받아 입력한 값보다 Lprod_id가 큰 자료들을 출력하시오.
public class JdbcTest02 {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		/*
		 * ResultSet은 java.sql의 인터페이스이다.
		 * 데이터베이스의 쿼리 결과를 표현할때 사용된다.
		 * 결과값은 resultset의 객체이다.
		 * resultset은 행들을 제공한다.
		 */
		ResultSet rs = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe",
					"csh93","java");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("아이디 번호 입력 : ");
			String id = sc.nextLine();
			
			String sql = "select * from lprod where lprod_id>"+id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("== 처리 결과 출력 ==");
			/*
			 * next() : resultset의 다음 행으로 커서를 움직인다.
			 * 			처음에 커서는 첫번째 행 이전에 위치하고 있다.
			 * 			다른 데이터들에 접근하기 위해선 꼭 next()를 써야한다!!!
			 * 			리턴값은 true, false이다.
			 * 			while문은 조건식이 true일 경웅에 계속해서 반복한다.
			 * 			조건식이 false가 되면 반복행위를 멈추고 while문 종료
			 */
			while(rs.next()) {
				/*
				 * Retrieving(검색) Data from the ResultSet
				 * ->getString, getInt, getDouble 등등
				 *   타입명을 쓰는 이유 -> 에러가 덜 나게 만들어준다.
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
			//5. 자원반납
			try { if(rs != null) rs.close(); } catch (SQLException e) {}
			try { if(stmt != null) stmt.close(); } catch (SQLException e) {}
			try { if(conn != null) conn.close(); } catch (SQLException e) {}
		}
	}
}
