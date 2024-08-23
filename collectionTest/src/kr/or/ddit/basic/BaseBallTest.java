package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/*
 * Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 * 1-9까지 숫자 중복되지 않게 주고(set으로)
 * 컴퓨터의 숫자는 난수를 이용하여 구한다.
 * (스트라이크는 S, 볼은 B로 출력한다.)
 * 
 * 
 * 예시) 
 * 
 * 컴퓨터의 난수==>9 5 7 
 * 
 * 실행 예시)
 * 숫자 입력 >> 3 5 6 
 * 3 5 6 ==> 1S 0B 출력하도록
 * 
 * 숫자 입력 >> 7 8 9
 * 7 8 9 ==> 0S 2B
 * 
 * 숫자 입력 >> 9 7 5
 * 9 7 5 ==> 1S 2B
 * 
 * 숫자 입력 >> 9 5 7 
 * 9 5 7 ==> 3S 0B
 * 
 * 당신은 4번째 만에 맞췄습니다.
 * 
 * 자료를 List에 저장하는게 좋다.
 * 
 */
public class BaseBallTest {
	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		while(hs.size()<3) {
			int num = (int)(Math.random()*9)+1;
			hs.add(num);
		}
		System.out.println("3개의 난수 >>"+hs);
		
		List<Integer> list = new ArrayList<Integer>(hs);
		
		System.out.println("list에 넣은것 출력 >>"+list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("list의 "+i+"번쨰 데이터 출력 >>"+list.get(i));			
		}
		
		Scanner sc = new Scanner(System.in);
		int cnt=1;
		
		
		
		
		
		
		
		while(true){
			
		int s=0;
		int b=0;
		
			
		System.out.println("숫자를 입력하세요 >>");
		int n1 = sc.nextInt();			
		System.out.println("숫자를 입력하세요 >>");
		int n2 = sc.nextInt();			
		System.out.println("숫자를 입력하세요 >>"
				+ ""
				+ "");
		int n3 = sc.nextInt();			
		
//		HashSet<Integer> hs2 = new HashSet<Integer>();
//		hs2.add(n1);
//		hs2.add(n2);
//		hs2.add(n3);
//		if(hs2.contains(list.get(0))) System.out.println(list.get(0)+"을 가지고 있습니다.");
//		if(hs2.contains(list.get(1))) System.out.println(list.get(1)+"을 가지고 있습니다.");
//		if(hs2.contains(list.get(2))) System.out.println(list.get(2)+"을 가지고 있습니다.");
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(n1);
		list2.add(n2);
		list2.add(n3);
		
		
		if(list2.contains(list.get(0))) {
			if(list.get(0)==list2.get(0)) s++;
			else b++;
			
		}
		if(list2.contains(list.get(1))) {
			if(list.get(1)==list2.get(1)) s++;
			else b++;
			
		}
		if(list2.contains(list.get(2))) {
			if(list.get(2)==list2.get(2)) s++;
			else b++;
		}
		
		System.out.println(s+"S  "+b+"B");
		
		
		System.out.println(cnt+" 번 시행중");
		
		if(s==3) {
			System.out.println("축하합니다! "+cnt+"번 만에 성공!");
			break;
		}
		cnt++;
		
		}
		
//		
//		int p=0;
//		int q=0;
//		
//		if(list2.get(0).contains())
//		if(list2.get(0)==list.get(0)) p++;
//		if(list2.get(1)==list.get(1)) p++;
//		if(list2.get(2)==list.get(2)) p++;
//			
//		System.out.println(p+"S  "+q+"B");
	}
}











