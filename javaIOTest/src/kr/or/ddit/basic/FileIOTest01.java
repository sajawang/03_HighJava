package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {
	public static void main(String[] args) {
		//FileInputStream을 이용한 파일 내용 읽기
		try {
			//읽어올 파일 정보를 매개변수로 갖는 FileInputStream 객체 생성
			
			//방법1)
			//FileInputStream fin = new FileInputStream("d:/d_other/test.txt");
			
			//방법2)
			File file = new File("d:/d_other/test.txt");
			FileInputStream fin = new FileInputStream(file);
			
			int c;		//읽어온 자료가 저장될 변수
			while ( (c= fin.read()) != -1) {
				//읽어온 문자를 화면에 출력하기
				System.out.print( (char)c );
			}
			
			fin.close();  	//작업 완료 후 스트림 닫기
			
		} catch (IOException e) {
			System.out.println("입출력오류입니다.");
		}
	}
}





























