package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		/*
		 * Map ==> key값과 value값을 한 쌍으로 관리하는 객체
		 * 	- key값은 중복을 허용하지 않고 순서(index)가 없다. (set과 특징이 같다)
		 *  - value값은 중복을 허용한다.
		 */
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 ==> put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map >>"+map);
		
		
		//자료 수정 ==> 데이터를 추가할 때 'key값'이 같으면 나중에 추가한 값이 저장된다.
		map.put("addr", "서울");
		
		System.out.println("map >>"+map);
		System.out.println();
		
		//자료 삭제 ==> remove(key값) ==>'key값'이 같은 자료를 찾아서  삭제한다.
		//			==> 	반환값 : 삭제된 자료의 'value값'이 반환된다.
//		String removeTel = map.remove("tel");
//		System.out.println("map => "+map);
//		System.out.println("삭제된 데이터 >> "+removeTel);
		
		//자료 읽기 ==> get(key값과 짝이 되는 value값 반환)
		System.out.println("addr = "+map.get("addr"));
		System.out.println("=================");
		
		
		//key값이 존재하는지 여부를 나타내는 메서드 ==> containsKey(key값)
		//				==> 해당 'key'값이 있으면 true, 없으면 false 반환
		System.out.println("tel 키값의 존재 여부 : "+map.containsKey("tel"));
		System.out.println("age 키값의 존재 여부 : "+map.containsKey("age"));
		System.out.println();
		
		
		//Map에 저장된 모든 자료들을 차례로 사용하는 방법
		
		// 방법1) 모든 key값을 읽어와 자료를 처리하는 방법 ==>keySet()메서드 이용
		
		//keySet()메서드 ==> Map의 모든 key값들을 읽어와 Set형으로 반환
		Set<String> keySet = map.keySet();
		
			//방법 1-1) Iterator 이용하기
			Iterator<String> it = keySet.iterator();
			while(it.hasNext()) {
				String key = it.next();
				String value = map.get(key);
				System.out.println(key+":"+value);
			}
			System.out.println("----------");
			
				
			//방법 1-2) 향상된 for문 이용하기
			for (String key : keySet) {
				String value = map.get(key);
				System.out.println(key+":"+value);
			}
			System.out.println("----------");

			//방법2) value값만 읽어와서 처리하기
			for (String value : map.values()) {
				System.out.println(value);
			}
			System.out.println("----------");
			
			//방법3) Map에는 Entry라는 내부 클래스 있다.
			/*		이 Entry클래스는 key와 value라는 멤버변수로 구성되어있다.
			 * 		Map에서는 이 Entry클래스들을 Set형식으로 저장하여 관리한다.
			 * 
			 * - Map에 저장된 Entry객체 전체를 가져와 처리하기 ==>entrySet()메서드 
			 *  	==>가져온 Entry 객체들은 Set에 저장되어 반환된다.
			 */
			Set<Map.Entry<String, String>> mapEntrySet = map.entrySet();
			
			Iterator<Map.Entry<String, String>> entryIt = mapEntrySet.iterator();
			
			while (entryIt.hasNext()) {
				Map.Entry<String, String> entry = entryIt.next();
				System.out.println("key값: "+ entry.getKey());
				System.out.println("value값 : "+entry.getValue());
				System.out.println();
			}
			System.out.println("--------------");
	}
}
