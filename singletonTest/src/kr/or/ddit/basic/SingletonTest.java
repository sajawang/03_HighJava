package kr.or.ddit.basic;

public class SingletonTest {

	public static void main(String[] args) {
		//MySingleton test1 = new MySingleton();외부에서 new명령으로 호출 불가
		
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		System.out.println("test2==>"+test2.toString());
		System.out.println("test3==>"+test3);
		System.out.println();
		
		System.out.println(test2.equals(test3));
		System.out.println(test2==test3);
		
		test2.displayTest();
	}

}
