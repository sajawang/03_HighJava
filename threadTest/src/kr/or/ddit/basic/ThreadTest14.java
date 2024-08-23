package kr.or.ddit.basic;

//쓰레드에서 객체를 공통으로 사용하는 예제

/*
 	원주율을 계산하는 쓰레드와
 	계산된 원주율을 출력하는 쓰레드가 있다.
 	
 	원주율을 관리하는 객체 필요
 	이 객체를 두 쓰레드에서 공통으로 사용해서 처리
 */
public class ThreadTest14 {
	public static void main(String[] args) {
		//공통으로 사용할 객체 생성
		ShareData sd = new ShareData();
		
		//쓰레드 객체를 생성하고 공통으로 사용할 객체를 각각 쓰레드에 주입한다.
		CalcPIThread ct = new CalcPIThread();
		ct.setSd(sd);
		
		PrintPIThread pt = new PrintPIThread(sd);
		
		ct.start();
		pt.start();
	}
}


//원주율을 관리하는 클래스(공통으로 사용할 클래스)
class ShareData{
	public double result; //계산된 원주율이 저장될 변수
	public boolean isOk;  //계산이 완료되었는지 여부를 나타내는 변수(완료되었으면 true값을 저장)
}

// 원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;	//공통으로 사용할 객체의 참조값이 저장될 변수
	
	//setter를 이용하여 참조값 저장(주입)
	public void setSd(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		//원주율 = (1/1 - 1/3 + 1/5 -1/7 + 1/9-.......)*4
		//          1  -3    +5   -7    +9...
		//			0   1     2    3    4
		double sum = 0.0;
		for(int i=1; i<1_000_000_000; i+=2) {
			if( (i/2) %2 ==0 ) { //i를 2로 나눈 몫이 짝수 일때
				sum += 1.0/i;
			} else {
				sum -= 1.0 /i;
			}
		}
		
		sd.result = sum * 4; //계산 완료
		sd.isOk = true;
	}
}

//계산이 완료되면 계산된 원주율을 출력하는 클래스
class PrintPIThread extends Thread{
	private ShareData sd;	//공통으로 사용할 객체의 참조값이 저장될 변수

	//생성자를 이용하여 공통으로 사용할 객체 주입
	
	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while (true) {
			if (sd.isOk ==true) {
				break;
			} else {
				Thread.yield();
			}
		}
		System.out.println();
		System.out.println("결과 : "+sd.result);
	}
}















