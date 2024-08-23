package kr.or.ddit.basic;

import java.util.Arrays;

/*10마리 말들이 경주하는 경마 프로그램을 작성하시오.
 * 말은 Horse라는 이름의 쓰레드 클래스로 작성, 이 클래스는 말이름(String), 등수(int), 
 * 현재위치(int)를 멤버 변수로 갖는다.
 * 그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.(Comparable인터페이스 구현)
 * 
 * 경기 구간은 1-50구간으로 되어 있다.
 * 
 * 그리고 경기 중간 중간에 각 말들의 현재 위치를 나타내시오.
 * 예)
 * 말이름01------->----------------------------------------
 * 말이름02---->-------------------------------------------
 * .....
 * ..... 
 * 말이름10------------>-----------------------------------
 * 
 * 경기가 모두 끝나면 등수 순으로 출력
 */
public class ThreadTest12 {
	public static void main(String[] args) {
		Horse[] horseArr = new Horse[] {
				new Horse("01번말"),new Horse("02번말"),new Horse("03번말"),
				new Horse("04번말"),new Horse("05번말"),new Horse("06번말"),
				new Horse("07번말"),new Horse("08번말"),new Horse("09번말"),
				new Horse("10번말")
		};
		
		GameState state = new GameState(horseArr);
		
		//말들의 경주 시작
		for(Horse h: horseArr) {
			h.start();
		}
		
		state.start();  //말의 현재 위치를 출력하는 쓰레드 시작
		
		//모든 말들의 경기가 끝날 때까지 기다린다
		for(Horse h: horseArr) {
			try {h.join();}
			catch(InterruptedException e) {}
		}
		
		try {state.join();}
		catch(InterruptedException e) {}
		
		System.out.println();
		System.out.println("경기 끝");
		System.out.println();
		
		//등수의 오름차순으로 정렬
		Arrays.sort(horseArr);	//배열 데이터 정렬하기
		
		//결과 출력하기
		System.out.println("==경기 결과==");
		for(Horse h : horseArr) {
			System.out.println(h);
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
	public static int currentRank =0; //각 말들의 등수를 구할 때 사용하는 변수
	
	private String horseName; //말이름
	private int location;	  //현재위치
	private int rank;		  //등수
	
	//생성자
	public Horse(String horseName) {
		super();
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return horseName + "경주마의 등수는" + rank + "등 입니다.";
	}
	
	//등수의 오름차순 처리를 위한 내부 정렬 기준
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.rank);
	}
	
	// 쓰레드 처리 ==> 각각의 말들이 1-50구간을 달린다. 달리기가 끝나면 등수를 구한다.
	@Override
	public void run() {
		for(int i=1; i<=50; i++) {
			try {Thread.sleep((int)(Math.random()*500));} 
			catch (InterruptedException e) {}
			
		this.location = i; //말의 현재 위치 저장
		}
		
		//한마리의 경주마가 경주를 끝내면 등수를 구해서 저장한다.
		currentRank++;
		this.rank = currentRank;
	}
}
//말들의 현재 위치를 나타내는 쓰레드
/*
예)
	말이름01-------->------
	말이름02-->------------
	...
*/
class GameState extends Thread{
	private Horse[] horseArr;

	public GameState(Horse[] horseArr) {
		super();
		this.horseArr = horseArr;
	}
	
	@Override
	public void run() {
		while (true) {
			//모든 말들의 경주가 종료되었는지 여부를 검사
			if(Horse.currentRank==horseArr.length) {
				break;
			}
			
			//빈 줄 출력하기
			for(int i=1; i<=5; i++) {
				System.out.println();
			}
			
			for(int i=0; i<horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName()+" : ");
				for(int j=1; j<=50; j++) { //구간을 나타내는 반복문
					//말의 현재 위치와 구간 번호가 같으면 '>'문자로 출력한다.
					if(horseArr[i].getLocation()==j) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();//줄바꿈
			}
			try {Thread.sleep(100);} 
			catch (InterruptedException e) {}
		}
	}
}
























