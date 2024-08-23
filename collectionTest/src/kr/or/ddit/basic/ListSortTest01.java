package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 정렬과 관련된 interface는 Comparable, Comparator 이렇게 두가지.
 * 
 * (내부정렬기준)
 * Comparable은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 떄
 * 구현하는 인터페이스.
 * 
 * (외부정렬기준)
 * Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을때
 * 구현하는 인터페이스.
 * 
 *  
 *  Comparable에서는 compareTo()메서드를 재정의
 *  Comparator에서는 compare()메서드를 재정의 
 *  
 *  
 *  String 클래스, Wrapper클래스들, Date클래스, File클래스에는 
 *  내부 정렬 기준이 이미 구현되어 있다.
 *  (구현된 내부 정렬 기준은 오름차순으로 처리 되도록)
 *  
 */


public class ListSortTest01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬전 : "+list);
		
		//정렬은 Collections.sort
		//Collections.sort() 메서드는 내부 정렬 기준으로 정렬
		Collections.sort(list);
		System.out.println("정렬 후: "+list);
		
		Collections.shuffle(list);//자료 섞기
		System.out.println("자료 섞기 후 "+list);
		
		//--------------------------------------
		//외부 정렬 기준 클래스를 이용하여 정렬하기
		
		Collections.sort(list,new Desc());
		System.out.println("내림차순 정렬 후 : "+list);
		
	}
}

//정렬 방식을 정해 주는 class를 만든다.(외부정렬기준)
//필요성 : String 같은건 이미 오름차순으로 되게 되어 있음(내부정렬기준)
//방법 : Comparator 인터페이스 구현해서 작성
class Desc implements Comparator<String>{
	
	//compare()메서드를 이용해서 정렬하고자 하는 기준을 정해줌
	
	//compare()메서드의 반환값의 의미
	//반환값이 0 : 두 값이 같다.
	//반환값이 양수 : 두 값의 순서를 바꾼다.
	//반환값이 음수 : 두 값의 순서를 바꾸지 않는다.
	//예)오름차순일 경우 ==> 앞의 값이 크면 양수, 
	//				     같으면 0, 
	//				     앞의 값이 작으면 음수를 반환하도록
	
	
	
	//compareTo를 재정의(단축키로 바로 호출 가능)
	@Override
	public int compare(String o1, String o2) {
		// 내림차순으로 구현하려고 한다.
		/*
		if(o1.compareTo(o2)>0) {
			return -1;
		} else if(o1.compareTo(o2)<0) {
			return 1;
		} else {
			return 0;
		}*/
		return o1.compareTo(o2)*-1;
		
	}
}




























