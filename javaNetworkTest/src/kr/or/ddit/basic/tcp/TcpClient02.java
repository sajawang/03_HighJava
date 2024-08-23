package kr.or.ddit.basic.tcp;

import java.net.Socket;

public class TcpClient02 {

	public static void main(String[] args) {
		try {
			// 소켓 객체를 생성하여 서버에 접속 요청을 보내고
			// 접속이 완료되면 생성된 소켓을 
			// 수신용 쓰레드와 송신용 쓰레드를 생성할때 주입하여 실행한다
			 Socket socket = new Socket("localhost", 7777);
			 System.out.println("서버에 연결되었습니다");
			 
			 Sender sender = new Sender(socket);
			 Receiver receiver = new Receiver(socket);
			 
			 sender.start();
			 receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
