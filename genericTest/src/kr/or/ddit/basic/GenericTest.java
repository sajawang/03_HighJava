package kr.or.ddit.basic;

//제네릭을 사용하지 않을 경우
class NonGeneric{
	private Object value;
	
	public void setValue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return this.value;
	}
}

/*
 * 제네릭 클래스를 만드는 방법
 *  형식 ) class 클래스명<제네릭 문자> {
 *  		제네릭문자 변수명;	==> 멤버 변수 선언할때, 제네릭을 사용할 경우
 *  		...
 *  		제네릭문자 메서드명(매개변수들...){ //메서드의 반환값에 제네릭을 사용할 경우
 *  			...
 *  			return 값;
 *  		}
 *  
 *  		반환값타입 메서드명(제네릭문자 변수명, ...){ // ==>매개변수를 지정할 때 제네릭을 사용할 경우
 *  			...
 *  		}
 *  }
 *  
 *  제네릭문자(영어 대문자 1개 사용)
 *  T
 *  K
 *  V
 *  E
 */

class MyGeneric<T>{
	private T value;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}
}
public class GenericTest {
	public static void main(String[] args) {
		NonGeneric non1 = new NonGeneric();
		non1.setValue("안녕");
		
		NonGeneric non2 = new NonGeneric();
		non2.setValue(123);
		
		String rtn1 = (String)non1.getValue();
		System.out.println("문자열 반환값 : "+rtn1);
		
		int rtn2 = (int)non2.getValue();
		System.out.println("정수형 반환값 : "+rtn2);
		
		//int rtn3 = (int)non1.getValue();
		//System.out.println("rtn3 = "+rtn3);
		
		System.out.println("-------------");
		
		MyGeneric<String> my1 = new MyGeneric<>();
		my1.setValue("홍길동");
		
		MyGeneric<Integer> my2 = new MyGeneric<>();
		my2.setValue(500);
		//my2.setValue("ddd"); //제네릭에서 지정하지 않은 데이터를 사용할 수 없다.
	
		String myRtn1 = my1.getValue();
		System.out.println("제네릭 문자열 반환값 : "+myRtn1);
		
		int myRtn2 = my2.getValue();
		System.out.println("제네릭 정수형 반환값 : "+myRtn2);
	}
}
