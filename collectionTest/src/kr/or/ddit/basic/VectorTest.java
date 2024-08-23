package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		//객체 생성
		Vector v1 = new Vector();
		
		System.out.println("v1의 크기 : " + v1.size());
		
		//데이터 추가하기1 : add(추가할 데이터)
		//반환값 : 추가성공(true), 추가실패(false)
		v1.add("AAAA");
		v1.add(new Integer(111));
		v1.add(123);			//autoboxing기능, autounboxing 기능 지원.
		v1.add('a');
		v1.add(true);
		boolean r = v1.add(3.14f);
		
		System.out.println("v1의 크기 : "+v1.size());
		System.out.println("반환값: "+r);
		
		//데이터 추가하기2 : addElement(추가할 데이터)
		//==> 이전 버전의 프로그램과의 호환성을 위해서 남아 있는 메소드
		v1.addElement("CCC");
		
		//toString하나 안하나 값 같음
		System.out.println("v1=>"+v1.toString());
		System.out.println("v1=>"+v1);
		
		//데이터 추가하기3 : add(index, 데이터)
		//			==> 'index'번째에 '데이터'를 끼워 넣는다.
		//			==> 'index'는 0 부터 시작한다.
		//			==> 반환값이 없다.
		v1.add(1, "KKKK");
		System.out.println("v1=>"+v1);
		
		System.out.println("------------------------------------");
		
		//데이터 꺼내오기 : get(index)
		//==>'index'번쨰 데이터를 꺼내서 반환한다.
		System.out.println("0번째 데이터 : " + v1.get(0));
		
		Integer iTemp = (int)v1.get(2);
		int iTemp_ = (Integer)v1.get(2);//오토언박싱기능
		int iTemp__=(int)v1.get(2);
		System.out.println("2번째 데이터: "+iTemp);
		
		System.out.println("------------------------------------");
		
		//데이터 수정하기 : set(index, 새로운데이터)
		// ==> 'index'번째의 데이터를 '새로운 데이터'로 변경한다
		// ==> 반환값 : 원래의 데이터
		String sTemp = (String)v1.set(0, "ZZZZ");
		System.out.println("v1=> "+v1);
		System.out.println("반환값: " + sTemp);
		
		System.out.println("------------------------------------");
		
		//데이터 삭제하기1 : remove(index)
		// ==> 'index'번째의 데이터를 삭제한다.
		// ==> 반환값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("삭제 후 v1 : "+v1);
		
		sTemp = (String)v1.remove(0);
		System.out.println("삭제 후 v1 : "+v1);
		System.out.println("원래의 데이터: "+sTemp);
		System.out.println();
		
		//데이터 삭제하기2 : remove(삭제할 데이터)
		// ==> '삭제할 데이터'를 찾아서 삭제한다.
		// ==> '삭제할 데이터'가 여러개이면 이들 중 첫번째 자료가 삭제된다.
		// ==> 반환값 : 삭제 성공(true), 삭제 실패(false)
		// ==> '삭제할 데이터'가 '정수형'이거나 'char형' 일 경우에는 반드시 객체로 변환해서 사용해야 함.
		v1.remove("CCC");
		System.out.println("삭제 후 v1 =>"+v1);
		
		//v1.remove(123);
		//v1.remove(new Integer(123)); //방법1 ==> 1.8 이전
		//v1.remove(Integer.valueOf(123)); //방법2 ==> 1.9 이후
		//v1.remove(Integer.parseInt(123)); //안됨(이유 : parseInt는 문자를 넣어야함)
		System.out.println("삭제 후 v1 =>"+v1);
		
		//v1.remove('a'); //사람 눈에는 문자이지만, 컴퓨터 내부에 들어가면 코드 값으로 바뀌어 들어감
		v1.remove(Character.valueOf('a'));
		System.out.println("삭제 후 v1 =>"+v1);
		
		v1.remove(3.14f);
		System.out.println("삭제 후 v1 => " +v1);
		
		v1.remove(true);
		System.out.println("삭제 후 v1 =>"+v1);
		
		//전체 데이터 삭제하기 : clear();
		v1.clear();
		System.out.println("삭제 후 v1 =>"+v1);
		System.out.println("v1 크기: "+v1.size());
		
		System.out.println("------------------------------------");
		/*
		 - 제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터의 타입을 객체를 생성할 때
		 		외부에서 지정해주는 기법으로, 객체를 선언할 때 < >괄호 안에 그 객체의 내부에서 사용할
		 		데이터의 타입을 지정해 주는 것을 말한다.
		 		
		 		- 이런 방법으로 선언하게 되면 지정한 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다.
		 		- 데이터를 꺼내올 때, 별도의 형 변환이 필요 없다.
		 		
		 		- 제네릭으로 선언될 수 있는 데이터 타입은 '클래스형'이어야 한다.
		 		 그래서 int는 Integer, boolean은 Boolean, char는 Character 등으로 대체해서 사용해야 한다.
		 */
		Vector<Integer> v2 = new Vector<Integer>(); //new Vector<>();도 가능
													//int형 자료만 저장할 수 있는 벡터
		Vector<String> v3 = new Vector<String>(); //String형만 저장할 수 있는 벡터
		
		v3.add("안녕하세요");
		//v3.add(100);
		
		String sTemp2 = v3.get(0); //형변환 없이 사용할 수 있다.
		
		
		
		Vector<Vector> vv = new Vector<Vector>();//2차원 배열과 비슷
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();//3차원 배열과 비슷
		
		v3.clear();
		System.out.println("------------------------------------");
		
		v3.add("AAAA");
		v3.add("BBBB");
		v3.add("CCCC");
		v3.add("DDDD");
		v3.add("EEEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBBB");
		v4.add("EEEE");
		
		System.out.println("v3 => "+v3);
		System.out.println("v4 => "+v4);
		
		//데이터 삭제하기3 : removeAll(Collection객체)
		// ==> 벡터의 데이터 중에서 'Collection 객체'가 가지고 있는 모든 데이터를 삭제한다.
		// ==> 반환값 : 삭제성공(true), 삭제 실패(false)
		v3.removeAll(v4);
		System.out.println("v3 => "+v3);
		v3.clear();
		//---------------------------------------------------------------------------
		
		v3.add("AAAA");
		v3.add("BBBB");
		v3.add("CCCC");
		v3.add("DDDD");
		v3.add("EEEE");
		
		//벡터의 전체 데이터를 순서대로 가져와 사용하고 싶으면 반복문을 사용하면 됨.
		//(주로 for문 사용)
		for (int i = 0; i < v3.size(); i++) {
			System.out.println(i+ "번째 데이터: " + v3.get(i));
		}
		System.out.println("------------------------------------");
		
		for (String str : v3) {
			System.out.println(str);
		}
		
	}
}

