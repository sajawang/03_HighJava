package kr.or.ddit.basic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesTest01 {
	
	public static void main(String[] args) {
		Properties props = new Properties();
		
		// 저장할 properties파일 정보를 갖는  File객체 생성
		File file = new File("res/kr/or/ddit/config/test.properties");
		FileOutputStream fout = null;
		
		try {
			//저장할 내용을 Properties객체에 추가하기
			props.setProperty("name", "홍길동");
			props.setProperty("age", String.valueOf(30));
			props.setProperty("addr", "대전시 중구 오류동");
			props.setProperty("tel", "010-4567-7894");
			
			//출력용 스트림 객체 생성
			fout = new FileOutputStream(file);
			
			props.store(fout, "이 내용은 주석 내용입니다.");
			
			System.out.println("출력작업완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fout != null)try {fout.close();} catch(IOException e) {}
		}
	}
}





































