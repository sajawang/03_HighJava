package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer03 {
	public static void main(String[] args) throws IOException {
		//저장할 폴더 정보를 갖는 File객체 생성
		File file = new File("d:/d_other/upload");
		
		//저장할 폴더가 없으면 새로 만든다.
		if(!file.exists()) {
			file.mkdirs();
		}
		
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다..");
			
			Socket socket = server.accept(); //클라리언트의 요청을 기다린다.
			
			System.out.println("파일 수신작업 시작...");
			
			//클라이언트가 보낸 파일명을 받아올 스트림 객체 생성
			DataInputStream din = new DataInputStream(socket.getInputStream());
			
			String fileName = din.readUTF();
			
			//저장할 파일 위치와 파일명을 지정해서 새로운 File객체 생성
			File saveFile = new File(file, fileName);
			
			//소켓에서 읽어서 파일로 출력하기
			
			//소켓으로 읽어올 입력용 스트림 객체 생성
			BufferedInputStream bin = 
					new BufferedInputStream(socket.getInputStream());
			
			//파일로 저장할 출력용 스트림 객체 생성
			BufferedOutputStream bout = 
					new BufferedOutputStream(new FileOutputStream(saveFile));
			
			//소켓으로 읽어서 파일로 저장하기
			byte[] temp = new byte[1024];
			int length =  0;
			
			while((length = bin.read(temp))>0){
				bout.write(temp,0,length);
			}
			bout.flush();
			
			System.out.println("파일 수신 작업 완료");
			
			//사용했던 자원 반납하기
			bout.close();
			bin.close();
			din.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("파일 수신작업 실패");
			e.printStackTrace();
		}
	}
}


















