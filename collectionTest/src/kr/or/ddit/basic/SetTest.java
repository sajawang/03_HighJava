package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {
		/*
		 * List와 Set의 차이점
		 * 1. List
		 * - 데이터의 순서(index)가 있다
		 * - 중복되는 데이터를 저장할 수 있다.
		 * 
		 * 2.Set
		 * - 데이터의 순서(index)가 없다.
		 * - 중복되는 데이터를 저장할 수 없다.
		 * 
		 * 
		 */
		
		HashSet hs1 = new HashSet();
		
			// Set에 데이터를 추가하기 ==> add()메서드를 사용
			hs1.add("DD");
			hs1.add("AA");
			hs1.add(2);
			hs1.add("CC");
			hs1.add("BB");
			hs1.add(1);
			hs1.add(3);
			
			System.out.println("set의 개수 "+hs1.size());
			System.out.println("Set 데이터 >> "+hs1); //내가 넣은 순서랑 안맞다.
			System.out.println();
			
			//Set에 중복되는 데이터를 추가하면 false를 반환하고, 데이터는 추가되지 않는다.
			boolean isAdd = hs1.add("FF");
			System.out.println("중복 되지 않을때 >>" + isAdd);
			System.out.println("Set 데이터  >> " +hs1);
			System.out.println();
			
			isAdd = hs1.add("CC");
			System.out.println("중복될 때 >> "+isAdd);
			System.out.println("Set 데이터  >> " +hs1);
			System.out.println();
			
			//새로운 데이터로 바꾸고자 한다면
			//list.set(index, 새로운데이터)
			//Set에는 index가 없는 문제?
			
			//Set의 데이터를 수정하려면 수정하는 명령이 따로 없기 때문에
			//해당 자료를 삭제한 후 추가해 주는 방법으로 처리해야 한다.
			
			//삭제하는 메서드 : remove(삭제할 자료)==> 반환값 : 삭제성공(true) / 삭제 실패(false)
			//clear()==> 전체 삭제
			hs1.remove("FF");
			System.out.println("삭제 후 Set 데이터: "	+hs1);
			hs1.add("EE");
			System.out.println("Set 데이터 : "+hs1);
			System.out.println();
			
			System.out.println("---------------");
//			hs1.clear();
//			System.out.println("clear 후 set 데이터 >> "+hs1);
			
			/*
			 * Set의 데이터는 순서(index)가 없기 때문에 List처럼 index로 데이터를 하나씩 불러 올 수 없다.
			 * 그래서 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해야 한다.
			 * 
			 * -Set형의 데이터들을 Iterator형 객체로 변환하는 메서드 ==> iterator()
			 */
			Iterator it = hs1.iterator(); //Set데이터를 Iterator로 변환하기
			
			//Iterator의 hasNext()메서드
			//			=> Iterator의 포인터가 가르키는 곳의 다음번째 위치에 데이터가 있는지 검사한다.
			//				있으면 true, 없으면 false를 반환함
			while(it.hasNext()) {
				//Iterator의 next()메서드
				//			=> Iterator의 포인터를 다음번쨰 위치로 이동 시킨 후(뭔가 사이사이로 이동하는 느낌)
				//			=> 이동한 위치에 있는 데이터를 반환한다.
				System.out.println(it.next());
				
			}
			System.out.println("---------------");
			
			//옛날엔 iterator을 썻지만
			//요새는 향상된 for문을 쓰면 더 간단함(hasNext랑 Next 안써도 되어서)
			for(Object obj:hs1) {
				System.out.println(obj);
			}
			
			System.out.println("---------------");
			
			//우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성
			//번호는 1번부터 29번까지 있고, 추첨할 인원은 3명.
			//당첨 번호를 출력하라.
			
			//최소값 ~ 최대값 사이이 정수형 난수 만들기
			//(int)(Math.random()*(최댓값-최솟값+1)) + 최소값
			//						개수< <=니까
			
			HashSet<Integer> testSet = new HashSet<Integer>();
			while(testSet.size()<3) {
				testSet.add((int)(Math.random()*(29-1+1)+1));
			}
			System.out.println("당첨자 번호 >> "+testSet);
			
			//Set유형의 자료를 List형 자료로 변환하기
			//List를 생성하면서 바로 Set자료를 담아줄 수 있다.
			//ArrayList<Integer>(testSet)
			ArrayList<Integer> testList = new ArrayList<Integer>(testSet);
			System.out.println("List의 데이터 출력");
			for (int i = 0; i < testList.size(); i++) {
				System.out.println(testList.get(i));
			}
			
	}
}
