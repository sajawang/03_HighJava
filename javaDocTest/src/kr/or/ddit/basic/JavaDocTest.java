package kr.or.ddit.basic;

//JavaDoc 파일 만들기 ==> 프로그램과 매뉴얼을 같이 ㅇ만드는 방법

/**
 * 이 영역에서는 HTML태그를 이용하여 문서를 작성할 수 있다.
 * 
 * @author PC-04
 * @version
 * <p>
 * 파일명 : JavaDocTest.java<br>
 * 설명 : JavaDoc문서를 작성하기 위한 연습용 interface<br><br>
 * 
 * 수정 이력<br>
 * ------------------------------------
 * 변경 일자 : 2024-08-20<br>
 * 변 경 인 : 홍길동<br>
 * 변경내용: 최초 생성<br>
 * --------------------------<br>
 * </p>
 *
 */
public interface JavaDocTest {
	/**
	 * 메소드명 : methodTest<br>
	 * 설명 : 반환값이 없는 메서드<br>
	 * 
	 * @param a 첫번째 매개변수(정수형)
	 * @param b 두번쨰 매개변수(정수형)
	 */
	public void methodTest(int a, int b);
	
	
	/**
	 * 메서드명: methodAdd<br>
	 * 설명 : 반환값이 int인 메서드<br>
	 * 
	 * @param x 정수형 첫번째 변수
	 * @param y 정수형 두번째 변수
	 * @return 처리된 결과를 정수형으로 반환한다.
	 * 
	 */
	public int methodAdd(int x, int y);
	
	/**
	 * 메서드명 : methodInput<br>
	 * 설명 : 매개변수가 없는 메서드<br>
	 * 
	 * @return 정수형 자료를 반환한다.
	 */
	public int methodInput();
}














































