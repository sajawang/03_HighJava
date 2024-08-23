package kr.or.ddit.basic;

import java.util.HashSet;
import java.util.Scanner;

public class Lotto {
	public static void main(String[] args) {
		lottoMain();
	}
	
	
	public static void lotto() {
		HashSet<Integer> testSet = new HashSet<Integer>();
		while(testSet.size()<6) {
			testSet.add((int)(Math.random()*(45)+1));
		}
		System.out.println("추천번호 >>"+testSet);
	}
	
	public static void lottoMain() {
		System.out.println("=========");
		System.out.println("로또 프로그램");
		System.out.println("---------");
		System.out.println("1.로또 구입");
		System.out.println("2.프로그램 종료");
		System.out.println("=========");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("번호 입력 :");
		int num=sc.nextInt();
		
		switch (num) {
			case 1:
				buyLotto();
				break;
			case 2:
				System.out.println("감사합니다.");
				break;
			default:
				break;
		}
		
	}

	private static void buyLotto() {
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("로또 구입 시작");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액입력 : ");
		int mon = sc.nextInt();
		
		if(mon>101000) {
			System.out.println("입력금액이 너무 많다. 구입실패다.");
			lottoMain();
		} else if(mon>900) {
			for (int i = 0; i < mon/1000; i++) {
				HashSet<Integer> testSet = new HashSet<Integer>();
				while(testSet.size()<6) {
					testSet.add((int)(Math.random()*(45)+1));
				}
				System.out.println("추천번호 >>"+testSet);
			}
			System.out.println("받은 금액은 "+mon+"원이고 거스름돈은 "+mon%1000+"원입니다.");
		} else System.out.println("입력금액이 너무 적다.");
		
		
	}
}











