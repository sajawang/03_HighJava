package homework;

/*
	10마리의 말들이 경주하는 경마 프로그램을 작성하시오.
	
	말은 Horse라는 이름의 쓰레드 클래스로 작성하는데, 이 클래스는 말 이름(String), 등수(int), 현재위치(int)를 멤버 변수로 갖는다.
	그리고 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다. (Comparable인터페이스 구현)
	
	경기 구간은 1 ~ 50 구간으로 되어있다.
	
	그리고 경기 중간 중간에 각 말들의 현재 위치를 나타내시오.
	예)
	말이름01 ---->--------------------------
	말이름02 --->---------------------------
	...
	...
	말이름10 ------->-----------------------
	
	경기가 모두 끝나면 등수 순으로 출력한다.
*/
public class ThreadTest12 {
	// Horse 쓰레드, 말 구간 출력 쓰레드
	
	public static void main(String[] args) {
		Horse[] th = new Horse[] {
				new Horse("말이름01"),
				new Horse("말이름02"),
				new Horse("말이름03"),
				new Horse("말이름04"),
				new Horse("말이름05"),
				new Horse("말이름06"),
				new Horse("말이름07"),
				new Horse("말이름08"),
				new Horse("말이름09"),
				new Horse("말이름10")
		};
		
		for(Horse horse : th) {
			try {
				horse.start();
				Thread.sleep(100);
			} catch(InterruptedException e) {
				
			}
		}
		
		for(int i=0; i<th.length; i++) {
			try {
				th[i].join();
			} catch(InterruptedException e) {
				
			}
		}
		System.out.println();
		System.out.println("------ 결과 ------");
		System.out.println(Horse.result);
	}
}

class Horse extends Thread {
	private String name;
	public static int rank;
	private int location;
	public static String result="";
	
	public Horse(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		while(location<=50) {
			location += (int)(Math.random()*4);
			System.out.print(name+" ");
			
			for(int i=0; i<location; i++) {
				System.out.print("-");
			}
			
			System.out.print(">");
			
			for(int i=0; i<50-location; i++) {
				System.out.print("-");
			}
			
			System.out.println();
			
			try {Thread.sleep(300);} 
			catch(InterruptedException e) {}
		}
		rank++;
		result += name+" : "+rank+"등\n";
	}
}
