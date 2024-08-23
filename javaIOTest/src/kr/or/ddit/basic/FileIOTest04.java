package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileIOTest04 {
	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		
		//Scanner sc = new Scanner(System.in);
		//System.in이 뭘까요?
		//in에 마우스 올리면 inputStream객체가 나온다
		try {
			//System.in ==> 콘솔(표준 입출력장치) 입력장치
			
			/*
			 * System.out.println("자료 입력>>"); int c = System.in.read(); System.out.println(
			 * (char)c );
			 */		
			
			//바이트 기반의 입력용 스트림을 문자기반의 입력용 스트림으로 변환하기
			InputStreamReader isr = new InputStreamReader(System.in);
			
			//출력용 스트림 객체 생성
			FileWriter fw = new FileWriter("d:/d_other/charTest.txt");
			
			System.out.println("아무 내용이나 입력하세요.");
			System.out.println("Ctrl - Z 를 누르면 입력을 종료합니다.");
			
			int c;

			//사용자가 입력한 내용을 가져와 파일로 저장
			while ( (c = isr.read()) != -1) {
				fw.write(c); //콘솔로 입력 받은 데이터를 파일로 출력함
			}
			
			//스트림 닫기
			isr.close();
			fw.close();
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}






























