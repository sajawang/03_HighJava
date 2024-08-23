package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {
	public static void main(String[] args) {
		//ArrayList의 기본적인 사용법은 Vector와 같다.
		ArrayList list1 = new ArrayList();
		
		//add() 메소드를 이용해서 데이터를 추가한다.
		list1.add("aaaa");
		list1.add("bbbb");
		list1.add(123);
		list1.add('b');
		list1.add(true);
		list1.add(123.45);
		
		System.out.println("list1 =>" + list1);
		System.out.println("size : "+list1.size());
		System.out.println();
		
		//get 메서드로 데이터를 꺼내온다.
		System.out.println("3번째 자료 : "+list1.get(3));
		
		//데이터 끼워넣기도 같다.
		list1.add(3,"zzz");
		System.out.println("list1 =>"+list1);
		
		//데이터 변경하기
		String sTemp = (String)list1.set(3,"YYY");
		System.out.println("list1 => "+list1);
		System.out.println("sTemp : "+sTemp);
		System.out.println();
		
		//삭제도 같다
		list1.remove(3);
		System.out.println("삭제 후 list1 => " +list1);
		
		list1.remove("bbbb");
		System.out.println("삭제 후 list1 => " +list1);
		
		//제네릭을 사용할 수 있다.
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i+"=>"+list2.get(i));
		}
		System.out.println("-----------------------------------------------------------");
		
		//contains(비교객체) ==> 리스트에 저장된 데이터 중에서 '비교 객체'가 있으면 true 그렇지 않으면 flase를 반환
		System.out.println("DDDD의 존재여부 : " + list2.contains("DDDD"));
		System.out.println("ZZZZ의 존재 여부 : " + list2.contains("ZZZZ"));
		System.out.println();
		
		//indexOf(비교객체)
		//lastIndexOf(비교객체)
		// ==> 리스트에 '비교객체'를 찾아서 해당 '비교객체'가 있으면 '비교객체'가 저장된 index값을 반환하고
		//	           	없으면 -1을 반환한다.
		// ==> indexOf() 메서드는 검색방향이 앞쪽에서 뒤쪽 방향으로 검색하고
		//           		lastIndexOf() 메서드는 뒤쪽에서 앞ㅁ쪽 방향으로 검색한다.
		// ==>'비교객체'가 많으면 검색해서 첫번째로 찾아진 데이터의 index값을 반환한다.
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		System.out.println("list2=> "+list2);
		
		System.out.println("DDDD의 위치값: "+list2.indexOf("DDDD"));
		System.out.println("ZZZZ의 위치값: "+list2.indexOf("ZZZZ"));
		System.out.println("ZZZZ의 위치값: "+list2.lastIndexOf("DDDD"));
       		
		// - toArray() ==>리스트 안의 데이터들을 배열로 변환해서 반환한다.
		//			   ==>기본적으로 Object형 배열로 변환한다.
		
		// - toArray(new 제네릭타입[0]) ==> 제네릭 타입의 배열로 변환해서 반환한다.
		
		Object[] strArr = list2. toArray();//리스트를 배열로 바꾸는 메소드
		//String[] strArr2 = (String[])list2.toArray();//배열은 형변환 안됨
		System.out.println("List의 개수 : "+list2.size());
		System.out.println("배열의 개수 : "+strArr.length);
		
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(i+"번째 자료>>" + strArr[i]);
		}
		System.out.println("-----------------------------------------------------------");
		
		String[] strArr3 = list2.toArray(new String[0]);
		for (String s : strArr3) {
			System.out.println(s);
		}
	}
}
