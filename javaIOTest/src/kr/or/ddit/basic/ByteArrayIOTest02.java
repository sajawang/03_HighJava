package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	
	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];
		
		//스트링 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			// available() ==> 남아있는 데이터 개수를 반환
			while ( input.available() > 0 ) {  //읽어올 자료가 있는지 확인
//				input.read(temp);
//				output.write(temp);

				int len = input.read(temp); //실제 읽어온 byte수를 반환
				
				//temp배열의 값들 중에서 0번째부터 len개만큼 출력한다
				output.write(temp, 0, len);
				
				System.out.println("반복문안에서 temp : "+ Arrays.toString(temp));
			}
			
			outSrc = output.toByteArray();
			
			System.out.println();
			System.out.println("inSrc => " +Arrays.toString(inSrc));
			System.out.println("outSrc => "+Arrays.toString(outSrc));
			
			input.close();
			output.close();
			
		} catch (IOException e) {
		}
		
	}
	
}



























