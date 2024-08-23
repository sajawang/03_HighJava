package homework;

public class ThreadTest14 {
	public static void main(String[] args) {
		
	}
}

class ShareData{
	public double result;
	public boolean isOk;
}

class CalcPITHread extends Thread{
	private ShareData sd;

	public CalcPITHread(ShareData sd) {
		super();
		this.sd = sd;
	}
	
	@Override
	public void run() {
	}
}

class PrintPIThread extends Thread{
	private ShareData sd;

	public PrintPIThread(ShareData sd) {
		super();
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(true) {
			if(sd.isOk == true) {
				break;
			} else {
				Thread.yield();
			}
		}
		System.out.println();
		System.out.println("결과: "+sd.result);
	}
	
	
}
