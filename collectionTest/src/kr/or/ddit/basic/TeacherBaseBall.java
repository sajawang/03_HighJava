package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TeacherBaseBall {
	
	private ArrayList<Integer> numList; //난수를 저장할 List
	private ArrayList<Integer> userList; //사용자가 값을 저장할 List
	private Scanner scan = new Scanner(System.in);
	
	private int strike, ball; //스트라이크 개수와 볼의 개수를 저장할 변수 선언
	
	public static void main(String[] args) {
//		TeacherBaseBall test = new TeacherBaseBall();
//		test.gameStart();
		
		//한줄로 쓰면
		new TeacherBaseBall().gameStart();
	}
	
	//시작 메서드
	public void gameStart() {
		//난수 만드는 메서드 호출
		getNum();
		
		//확인용 난수 출력하기
		System.out.println("난수값>> "+numList);
		
		int cnt=0;
		do {
			cnt++;
			
			//사용자 입력용 메서드 호출
			inputData();
			
			//볼카운트 메서드 호출
			ballCount();
			
			
		} while (strike!=3);
		
		System.out.println();
		System.out.println("추카포카");
		System.out.println(cnt+"번째 만에 맞췄다요!");
	}
	
	//1~9 사이의 서로 다른 난수 3개를 만들어서 List에 저장하는 메서드(Set이용)
	private void getNum() {
		Set<Integer> numSet = new HashSet<Integer>();
		
		//Set을 이용하여 3개의 난수 만들기
		while(numSet.size()<3) {
			numSet.add((int)(Math.random()*9 +1));
		}
		
		//만들어진 난수를 List에 저장하기
		numList = new ArrayList<Integer>(numSet);
		
		//데이터섞기(컴퓨터에선 set임에도 불구하고 차례대로 나온다함)
		Collections.shuffle(numList);
		
	}
	
	//사용자로부터 3개의 정수를 입력 받아 List에 저장하는 메서드
	private void inputData() {
		int num1, num2, num3; //입력한 값이 저장될 변수 선언
		
		do {
			System.out.println("숫자입력>> ");
			num1 = scan.nextInt();
			num2 = scan.nextInt();
			num3 = scan.nextInt();
			
			if(num1==num2 || num1==num3 || num2==num3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다. 다시 입력하세요.");
			}
		} while (num1==num2 || num1==num3 || num2==num3);
		
		//입력한 데이터를 List에 저장한다.
		userList = new ArrayList<Integer>();
		userList.add(num1);
		userList.add(num2);
		userList.add(num3);
		
		//스트라이크와 볼을 판정하고 결과를 출력하는 메서드
	}
	
	private void ballCount() {
		strike = 0;
		ball = 0; //스트라이크와 볼의 개수 초기화
		
		for (int i = 0; i < numList.size(); i++) {
			for (int j = 0; j < userList.size(); j++) {
				if(numList.get(i)==userList.get(j)) {//값이 같은지 비교
					if(i==j) {//위치가 같은지 비교
						strike++;
					} else {
						ball++;
					}
					break;
				}			
			}
			
		}
		//판정 결과를 출력한다.
		System.out.println(userList.get(0)+ " "+userList.get(1)+ " " + userList.get(2)+"==> "+strike+"S  "+ball+"B");
	}
	

}

