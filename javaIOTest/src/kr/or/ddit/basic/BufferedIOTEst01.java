package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.naming.NamingEnumeration;

public class BufferedIOTEst01 {
	public static void main(String[] args) {
		//입출력의 성능 향상을 위해서  BUFFERED스트림을 사용한다.

		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
		
			//버퍼의 크기가 5인 버퍼 스트링 객체 생성
			//버퍼의 크기를 저장하지 않으면 기본적으로 8KB(8192byte)크기로 지정한다.
			BufferedOutputStream bout = new BufferedOutputStream(fout,5);
			
			for(char c='1'; c<='9'; c++) {
				bout.write(c);
			}
			bout.flush();
			
			//fout.close();
			bout.close();     //close()메서드에서는 flush()메소드를 자동으로 호출한다
							  // 보조 스트림을 닫으면 기반이 되는 스트림도 같이 닫힌다.
			System.out.println("작업 중..");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
