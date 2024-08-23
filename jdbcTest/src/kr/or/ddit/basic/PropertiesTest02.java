package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest02 {
	public static void main(String[] args) {
		//읽어온 정보를 저장할 Properties객체 생성
		Properties props = new Properties();
		
		//읽어올 파일 정보를 갖는 File객체 생성
		File file = new File("res/kr/or/ddit/cofig/dbinfo.propperties");
		FileInputStream fin = null;
		
		try {
			//파일을 읽어올 입력용 스트림 객체 생성
			fin = new FileInputStream(file);
			
			//입력용 스트림을 이용하여 파일 내용을 읽어와 Properties객체에 저장하기
			//==>load()메서드를 이용한다.
			props.load(fin);
			
			//읽어온 정보 출력해보기
			System.out.println("DRIVER : "+props.getProperty("driver"));
			System.out.println("URL : "+props.getProperty("url"));
			System.out.println("USER : "+props.getProperty("user"));
			System.out.println("PASS : "+props.getProperty("pass"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fin!=null) try {fin.close();} catch(IOException e) {}
		}
	}
}
