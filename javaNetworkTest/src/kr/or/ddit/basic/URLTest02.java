package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {
	public static void main(String[] args) throws IOException {
		//URLConnection 클래스 ==> 애플리케이션과 URL간의 통신 연결을 위한 클래스
		
		//특정 서버의 정보와 파일 내용 가져오기
		URL url = new URL("https://www.naver.com/index.html");
		
		//URL 객체를 이용하여  URLConnection객체를 구한다
		URLConnection urlCon = url.openConnection();
		
		//Header 정보 가져오기
		
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		
		//Header의 Key값(Header의 name값) 가져오기
		for(String headerKey : headerMap.keySet()) {
			
			//key값을 이용해서 HeaderValaue값 구하기
			System.out.println(headerKey + " : "+ headerMap.get(headerKey));
		}
		System.out.println("-------------------------------");
		
		
		//해당 문서의 내용 가져오기(index.html 문서의 내용 가져오기)
		
		/*
		 * //방법1) ==> URLConenction객체 이용 //파일내용을 읽어오기 위한 스트링 객체 생성 InputStream in =
		 * urlCon.getInputStream(); InputStreamReader isr = new
		 * InputStreamReader(in,"utf-8"); BufferedReader br = new BufferedReader(isr);
		 * 
		 * //파일 내용을 읽어와 화면에 출력하기 while(true) { String str = br.readLine(); if(str ==
		 * null) { break; } System.out.println(str); } br.close();
		 */
		
		//방법2) ==> URL객체의 openStream()메서드 이용하기
		InputStream in2 = url.openStream();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(in2, "utf-8"));
		String str2 = null;
		while((str2 = br2.readLine()) != null) {
			System.out.println(str2);
		}
		br2.close();
		
	}
}












