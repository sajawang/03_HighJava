package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
	문제) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에
		 이들 중에서 '김'씨 성의 이름을 모두 출력하시오.
		 
	문제2) 5명의 별명을 입력 받아 ArrayList에 저장한 후에
		 이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오.
		 (단, 각 별명의 길이는 모두 다르게 입력한다.) => ArrayListTest03.java
		 
	문제3) 5명의 별명을 입력 받아 ArrayList에 저장한 후에
		 이들 중에서 별명의 길이가 제일 긴 별명들을 출력하시오.
		 (단, 각 별명의 길이가 같을 수 있다.)		=> ArrayListTest04.java

*/
public class ArrayListTest02 {
	public static void main(String[] args) {
		//스캐너 객체 생성
		Scanner sc = new Scanner(System.in);
		
		//System.out.print(i+"번째 이름>> ") -> 이렇게 해주면 더 예쁨
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String str3 = sc.nextLine();
		String str4 = sc.nextLine();
		String str5 = sc.nextLine();
		
		//이름을 저장하는 -> 제너릭 String
		//ArrayList<String>
		ArrayList list1= new ArrayList();
		list1.add(str1);
		list1.add(str2);
		list1.add(str3);
		list1.add(str4);
		list1.add(str5);
		
		System.out.println(list1);
		
		for (int i = 0; i < list1.size(); i++) {			
			String subject=(String) list1.get(i);
			//charAt은 1개만 빼오는 메소드
			//반환값이 character
			String name = ""+subject.charAt(0);
			if(name.equals("김")) {
				System.out.println("성이 '김'인 사람은 바로바로 ~~~"+list1.get(i)+"!!!!!!!");
		}
		}
		
		//다른방법2
		//String name = nameList.get(i);
		//if(nameList.get(i).substring(0,1).equals("김"))
		
		
		//다른방법3 : 아이디어 -> '김'의 위치를 찾아, 0번쨰인지 확인
		//if(nameList.get(i).indexOf("김")===0)
		
		//다른방법4
		//if(nameList.get(i).startsWith("김")) -> 김으로 시작하느냐 라는 뜻->이게 true이면 if구문 실행
		
		
		
		
		
				
			
	}
}
