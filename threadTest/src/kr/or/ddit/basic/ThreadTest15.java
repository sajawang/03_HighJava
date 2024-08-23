package kr.or.ddit.basic;

public class ThreadTest15 {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject(); 	// 공통 객체 생성
		
		TestThread th1 = new TestThread("1번쓰레드", sObj);
		TestThread th2 = new TestThread("2번쓰레드", sObj);
		
		th1.start();
		th2.start();
	}
}

//공통으로 사용할 객체
class ShareObject{
	private int sum = 0;
	
	//통기화 처리하기
	
	//public synchronized void add() { //방법1 ==> 메서드에 동기화설정을 한다
	public void add() {
		
		synchronized(this) {//방법2 ==> 동기화 블럭으로 동기화 설정을 한다

			int num = sum;
			
			num+=10;		//10 증가하기
			
			sum = num;
			
			System.out.println(Thread.currentThread().getName()+"합계 : "+sum);
			
		}
	}
}

class TestThread extends Thread{
	private ShareObject sObj;

	public TestThread(String name, ShareObject sObj) {
		super(name);		//Thread의 name값 설정
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			sObj.add();
		}
	}
	
}





























