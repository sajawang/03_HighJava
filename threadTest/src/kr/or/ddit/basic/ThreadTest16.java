package kr.or.ddit.basic;

//은행의 입출금을 쓰레드로 처리하는 예제
public class ThreadTest16 {
	private int balance; 	//잔액이 저장될 변수
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	//입금하는 메서드(구색용.....)
	public void deposti(int money) {
		balance += money;
	}
	
	//출금하는 메서드(출금이 성공하면 true, 실패하면 false 반환)
	//public synchronized boolean withdraw(int money) {
	public boolean withdraw(int money) {
		
		synchronized(this) {
			if(balance >= money) {
				
				for(int i=1; i<=100_000_000; i++) { //시간 지연용...
					int k = i;
				}
				
				balance -= money;
				System.out.println("출금 메서드 안에서 잔액 : "+balance);
				return true;
			} else {
				return false;
			}
		}
	}

	public static void main(String[] args) {
		ThreadTest16 account = new ThreadTest16(); //공통 객체 생성
		account.setBalance(10000); 	//잔액을 10000으로 설정
		
		//익명 구현체로 쓰레드 구현
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				boolean result = account.withdraw(6000);	//6000원 출금하기
				System.out.println("쓰레드에서  result = "+result+", 잔액 : "+account.getBalance());
			}
		};
		//------------------------여기까지가 익명구현체
		
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();
	}
}

