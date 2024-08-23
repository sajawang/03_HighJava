package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TeacherLotto {
	private Scanner scan = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		new TeacherLotto().lottoStart();
	}

	//시작메서드
	private void lottoStart() {
		while (true) {
			int choice = displayMenu();
			switch (choice) {
			case 1:
				buyLotto();
				break;
			case 2:
				System.out.println("감사합니다");
				return;
			default:
				System.out.println("메뉴번호를 잘못입력했어영.");
				System.out.println("( '1'또는 '2' 입력)");
			}
			
		}
	}
	
	//로또 구매를 처리하는 메서드
	private void buyLotto() {
		System.out.println();
		System.out.println("로또 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또 번호 하나입니다.)");
		System.out.println("금액입력 : ");
		int money = scan.nextInt();
		
		System.out.println();
		if(money<1000) {
			System.out.println("입력금액이 너무 적습니다. 로또 번호 구입 실패");
			return;
		}
		if(money>101000) {
			System.out.println("입력 금액이 너무 많습니다. 로또 번호 구입 실패");
			return;
		}
		
		Set<Integer> lottoSet = new HashSet<Integer>();
		
		int count = money / 1000; //구매할 로또의 매수
		
		System.out.println("행운의 로또 번호는 아래와 같습니다.");
		for (int i = 1; i < count; i++) {
			while (lottoSet.size()<6) {
				lottoSet.add((int)(Math.random()*45+1));
			}
			ArrayList<Integer> lottoList = new ArrayList<Integer>(lottoSet);
			Collections.sort(lottoList);
			
			System.out.println("로또 번호"+i+" >> "+lottoList);
			
			lottoSet.clear(); //Set에 저장된 이전 자료 삭제하기
		}
		System.out.println();
		System.out.println("받은 금액은 "+money+"원이고, 거스름돈은 "+(money%1000)+"원 입니다.");
		
	}

	//메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("==================");
		System.out.println("Lotto 프로그램");
		System.out.println("------------------");
		System.out.println("1.Lotto 구입");
		System.out.println("2.프로그램 종료");
		System.out.println("==================");
		System.out.println("메뉴선택 : ");
		return scan.nextInt();
		
	}
	
	
}
