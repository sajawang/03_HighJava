package kr.or.ddit.basic;

//문제2) 5명의 별명을 입력 받아 ArrayList에 저장한 후에
//이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오.
//(단, 각 별명의 길이는 모두 다르게 입력한다.) => ArrayListTest03.java

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {
	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		

		//멋지게 선언하는법~
		//ArrayList<String> aliasList = new ArrayList<String>();
		ArrayList list= new ArrayList();
		for (int i = 0; i < 5; i++) {
			list.add(sc.nextLine());
		}
		
		int i=0;
		
		//항상 비교 할때는 첫번째 자료로 초기화!
		//String maxAlias = aliasList.get(0);
		
		//for(int i=1; i<aliasList.size(); i++){
		//	  if(maxAlias.length(0 < aliasList.get(i).length()){
		//			maxAlias = aliasList.get(i);
		
		
		String s = "";
		for(int j=1; j<list.size(); j++) {
			if((""+list.get(i)).length()>(""+list.get(j)).length()){
				s=""+list.get(i);

			} else {
				s=""+list.get(j);
				i++;
				
			}
		}
		System.out.println(s);			
	}
}



































