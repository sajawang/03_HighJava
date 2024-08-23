package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 이 쓰레드 클래스는 소켓을 통해서 메시지를 보내는 역할만 수행한다.
public class Sender extends Thread {
	private Socket socket;
	private DataOutputStream dout;
	
	private String name;
	private Scanner scan;

	//생성자
	public Sender(Socket socket) {
		super();
		this.socket = socket;
		scan = new Scanner(System.in);
		
		System.out.print("이름 입력 >> ");
		name = scan.nextLine();
		
		try {//문자열을 보내기 쉬운 스트림 DataOUtputStream
			dout = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		while(dout != null) {
			try {
				dout.writeUTF(name+":"+scan.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}













