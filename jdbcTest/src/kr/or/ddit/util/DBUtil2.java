package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// JDBC드라이버를 로딩하고 Connection객체를 생성하여 반환하는 메서드로 구성된 Class 만들기
//(dbinfo.properties파일의 내용으로 설정하기)
public class DBUtil2 {
	static Properties prop; //Properties객체 변수 선언
	
	static {
		prop = new Properties();	//Properties객체 생성
		File file = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;
		
		try {
			
			fin = new FileInputStream(file); //입력용 스트림 객체 생성
			
			prop.load(fin); //파일 내용을 읽어와 Properties객체에 저장하기
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
			
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패~~~");
			e.printStackTrace();
		} finally {
			if(fin != null)try {fin.close();} catch(IOException e) {}
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
//			conn = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", "csh93", "java");
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("pass"));
					
		} catch (SQLException e) {
			System.out.println("DB연결실패!!");
			e.printStackTrace();
		}
		return conn;
	}
}




























