package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * UDP방식 : 비연결지향, 데이터에 대한 신뢰성이 없다. 데이터가 순서대로 도착한다는 보장이 없다.
 * 			그렇지만 TCP방식보다 속도가 빠르다.
 *  DatagramSocket객체와 DatagramPacket객체를 이용하여 통신한다.
 * 	  - DatagramSocket 객체 ==> 데이터의 송수신과 관련된 작업을 수행한다. (우체부 역할과 비슷)
 * 	  - DatagramPacket 객체 ==> 주고 받는 데이터와 관련된 작업을 수행한다. (소포와 비슷)
 * 	  					  ==> 수신용 생성자와 송신용 생성자를 따로 제공한다.
 * 
 *  TCP방식은 스트림을 이용하여 데이터를 송수신하고 
 *  UDP방식은 데이터그램을 이용하여 데이터를 송수신한다.			
 */

public class UdpServer {

	public static void main(String[] args) {
		try {
			//통신포트를 지정하여 소켓 객체를 생성한다.
			DatagramSocket socket = new DatagramSocket(9999);
			System.out.println("서버 실행 중..");
			
			while(true) {
				//전송받은 메시지가 저장될 변수를 선언
				byte[] inMsg = new byte[1024];
				
				//수신용 패킷 객체 생성
				//	==> 데이터가 저장될 byte형 배열, 이 배열의 길이를 인수로 전달하여 생성한다.
				DatagramPacket inPacket = new DatagramPacket(inMsg, inMsg.length);
				
				//데이터를 수신한다. ==> 소켓 객체의 receive() 메서드를 이용한다.
				//			   ==> 이 케서드에 수신용 패킷 객체를 인수값으로 넣어준다.
				socket.receive(inPacket); // ==> 수신된 데이터의 패킷정보가 인수값으로 지정한 패킷변수(inPacket)에 저장된다.
				
				//수신한 정보를 갖는 패킷객체를 이용하여 상대방의 IP정보, 포트번호 등을 알 수 있다.
				InetAddress address = inPacket.getAddress();
				int port = inPacket.getPort();
				System.out.println("상대방의 IP정보 : "+address);
				System.out.println("상대방의 Port번호 : "+port);
				System.out.println("-------------------------");
				System.out.println();
				
				//상대방이 보낸 메시지 출력하기
				
				//상대방이 보낸 메시지 구하기
				// 방법1) 수신용 패킷 객체를 생성할 떄 생성자에 지정한 byte형 배열에 저장되어 있다.
				// 방법2) 수신용 패킷 객체의 getData()메서드를 이용한다. ==> 수신한 데이터를 byte형 배열로 반환한다.

				// - 수신용 패킷 객체의 getLength() ==> 실제 수신한 데이터의 길이를 반환한다. ( 단위 byte)
				
				// byte형 배열에 저장된 메시지 데이터를 문자열로 변환한다.
//				String msg = new String(inMsg, 0, inPacket.getLength(), "utf-8");
				String msg = new String(inPacket.getData(), 0, inPacket.getLength(), "utf-8");
				
				if("/end".equals(msg)) { //종료 메시지가 수신되면
					break;	//반복문 탈출...
				}
				
				System.out.println("상대방이 보낸 메시지>>> "+msg);
				System.out.println();
				
				//----------------------------------------------
				
				//상대방에게 메시지 보내기(예 : 수신받은 데이터를 그대로 송신하기)
				
				//송신할 메시지를 byte형 배열로 변환
				byte[] sendMsg = msg.getBytes("utf-8");
				
				//송신용  패킷 객체 생성하기
				//		==>전송할 데이터가 저장된 byte형 배열, 전송할 자료의 길이 (배열의 길이)
				//		   	상대방의 IP주소정보, Port번호 지정
				//			이렇게 4가지를 생성자에 지정하여 객체를 생성한다.
				DatagramPacket outPacket = new DatagramPacket(sendMsg, sendMsg.length, address, port);
				
				//송신 작업 == 소켓객체의 send()메서드를 이용한다. ==> 이 메서드의 매개변수에 송신용 패킷객체를  넣어준다.
				socket.send(outPacket);
				System.out.println("송신 완료..");
				System.out.println("-------------------");
				System.out.println();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}










































































