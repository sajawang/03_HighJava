package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectIOTest02 {
	public static void main(String[] args) {
		//저장된 객체를 읽어와 그 내용을 화면에 출력하기
		try {
			//입력용스트림 객체 생성
			ObjectInputStream oin = new ObjectInputStream(
					new BufferedInputStream(
						
							new FileInputStream("d:/d_other/memObj.dat")
						)
					);
			Object obj = null;	//읽어올 객체를 저장할 변수
			
			System.out.println("객체 읽기 작업 시작...");
			
			//readObject()메서드는 데이터를 끝까지 다 읽어오면 EIFException이 발생한다.
			while( (obj
					= oin.readObject()) != null ) {
				//읽어온 데이터를 원래의 객체형으로 변환해서 사용한다.
				Member mem = (Member) obj;
				System.out.println("이름 : "+mem.getName());
				System.out.println("나이 : "+mem.getAge());
				System.out.println("주소 : "+mem.getAddr());
				System.out.println("-----------------------");
				
			}
		}/* catch (EOFException e) {
			System.out.println("읽기 작업 끝...");
		}*/ catch(IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

/*EOFEXception 이 안나게 하는 방법
 * 1.catch추가
 * 2. 객체를 다 저장하고 null값을 저장(while문에서 거짓 발생)
 * */
