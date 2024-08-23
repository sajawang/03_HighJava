package kr.or.ddit.basic;
//문제3) 5명의 별명을 입력 받아 ArrayList에 저장한 후에
//이들 중에서 별명의 길이가 제일 긴 별명들을 출력하시오.
//(단, 각 별명의 길이가 같을 수 있다.)		=> ArrayListTest04.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String> list = new ArrayList();
		
		for (int i = 0; i < 5; i++) {
			list.add(sc.nextLine());
		}
		
		
		//방법2
		
		// 제일 긴 벼려명의 길이를 저장할 변수를 선언
		// 변수에 List의 첫번째 데이터 길이 저장
		//int maxLength = aliasList.get(0).length(0);
		//for(int i=1; i<aliasList.size(0; i++){
		// if(maxLength < aliasList.get(i).length()
		
		//길이를 이용해서 찾으면 됨
		
		
		int i=0;
		String s = "";
		for(int j=1; j<list.size(); j++) {
			if((list.get(i)).length()>=(list.get(j)).length()){
				s=list.get(i);
				
			} else {
				s=list.get(j);
				
				i++;
				
			}
		}
		for (int i1 = 0; i1 < list.size(); i1++) {
			if(s.length()==list.get(i1).length()) {
				System.out.println(list.get(i1));
			}
			
		}
		
		
		
	}
		

}

