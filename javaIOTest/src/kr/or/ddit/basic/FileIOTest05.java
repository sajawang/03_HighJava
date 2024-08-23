package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest05 {
	public static void main(String[] args) {
		// 한글이 저장된 파일 읽어오기
		
		try {
			//FileReader fr = new FileReader("d:/d_other/test_ansi.txt");
			//FileReader fr = new FileReader("d:/d_other/test_utf-8.txt");
			
			FileInputStream fin = 
					//new FileInputStream("d:/d_other/test_ansi.txt");
					new FileInputStream("d:/d_other/test_utf-8.txt");
			
			// 기본 인코딩 방식을 이용하여 읽어온다.
			//InputStreamReader isr = new InputStreamReader(fin);
			
			//인코딩 방식을 지정해서 읽어오기
			//인코딩 방식 에서
			//- MS949(또는 CP949) --> 윈도우에서 사용하는 기본 한글 인코딩 방식(ANSI 형식과 같다)
			//- UTF-8 --> 유니코드 UTF-8 인코딩 방식
			//- US_ASCII --> 영문 전용 인코딩 방식
			InputStreamReader isr = new InputStreamReader(fin,"ms949");
			
			int c;
			
			while((c=isr.read()) != -1) {
				System.out.print((char)c);
			}
			
			//보조스트림을 닫으면 보조스트림이 기반 스트림도 같이 닫힌다.
			isr.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}










