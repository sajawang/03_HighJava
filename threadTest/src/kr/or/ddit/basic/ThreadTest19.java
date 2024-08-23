package kr.or.ddit.basic;

public class ThreadTest19 {
	public static void main(String[] args) {
		ShareDataBox databox = new ShareDataBox();
		
		ProducerThread th1 = new ProducerThread(databox);
		ConsumerThread th2 = new ConsumerThread(databox);
		
		th1.start();
		th2.start();
	}
}

//데이터를 공통으로 사용하는 class
class ShareDataBox{
	private String data;
	
	//data변수에 값이 있으면 data변수가 null이 될때까지 기다림
	//data변수가 null이 되면 새로운 데이터를 data 변수에 저장
	public synchronized void setData(String data) {
		if(this.data!=null) {
			try {wait();}
			catch(InterruptedException e) {}
		}
		this.data = data;
		System.out.println("Thread에서 새로 공급한 데이터 : " + data);
		notify();
	}
	
	//data변수가 null이면 data변수에 문자열이 채워질 때까지 기다림
	//data변수에 값이 있으면 해당 문자열을 반환
	//반환 후에는 data변수 값을 null로 변경
	public synchronized String getData() {
		if(data==null) {
			try {wait();}
			catch(InterruptedException e) {}
		}
		
		//data변수의 값을 임시변수에 저장
		String temp = data;
		data = null;
		
		System.out.println("쓰레드가 읽은 데이터 : "+temp);
		
		notify();
		
		return temp;
	}
}

//데이터를 넣어주는 역할만 하는 쓰레드
class ProducerThread extends Thread{
	private ShareDataBox databox;

	public ProducerThread(ShareDataBox databox) {
		super();
		this.databox = databox;
	}
	
	@Override
	public void run() {
		String[] dataArr = new String[] {"홍길동", "이수근", "강호동", "이승기"};
		for(int i=0; i<dataArr.length; i++) {
			databox.setData(dataArr[i]);
		}
	}
}

// 데이터를 꺼내서 사용하느 쓰레드
class ConsumerThread extends Thread{
	private ShareDataBox databox;

	public ConsumerThread(ShareDataBox databox) {
		super();
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for(int i=0; i<4; i++) {
			String returnData = databox.getData();
		}
	}
}


























































