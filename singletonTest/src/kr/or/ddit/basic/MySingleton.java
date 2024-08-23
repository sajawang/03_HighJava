package kr.or.ddit.basic;

public class MySingleton {
	/*
	 * singleton패턴 ==> 객체가 1개만 만들어지게 하는 방법
	 * 				(외부에서 new 명령을 사용하지 못하게 한다)
	 * 
	 *- singleton 클래스 만드는 방법
	 *
	 */
	
	//정적필드
	//1. 자신class의 참조값이 저장될 변수를 private static으로 선언한다.
	private static MySingleton singleton; 
	
	//생성자
	//2. 모든 생성자의 접근 제한자를 private으로 한다.
	private MySingleton() {
		System.out.println("생성자 메서드 입니다.");
	}
	
	//정적 메소드
	//3. 자신 class의 인스턴스를 생성하고 반환하는 메서드를 public static으로 작성한다.
	public static MySingleton getInstance() {
		//1)1번의 변수값이 null이면 현재 class의 인스턴스를 생성하여 저장한다.
		if(singleton==null) singleton = new MySingleton();
		
		//2)1번의 변수값을 반환한다.
		return singleton;
	}
	
	//기타 이 클래스가 처리할 내용들을 작성하면 된다.
	public void displayTest() {
		System.out.println("이것은 Singleton 클래스의 메서드 처리 내용입니다.");
	}
}
