package kr.or.ddit.basic.tcp;

import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TcpClient03 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		TcpClient03 test = new TcpClient03();

		// 원본 파일의 정보를 갖는 File 객체 생성
		// File file = new File("d:/d_other/펭귄.jpg");
		File file = test.selectFile("OPEN");
		
		//전송할 파일 정보를 갖는 File객체 생성
//		File file = new File("d:/D_other/펭귄.jpg");
		
		//전송할 파일이 없으면 '오류 메시지'를 출력하고 종료한다.
		if(!file.exists()) {
			System.out.println(file.getAbsolutePath()+"파일이 없습니다..");
			System.out.println("전송 작업을 중단합니다..");
			return;
		}
		
		try {
			Socket socket = new Socket("localhost",7777);
			System.out.println("전송작업 시작..");
			
			//파일이름 전송을 위한 스트림 객체 생성
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF(file.getName()); 	//파일 이름 전송...
			
			//파일을 읽어서 소켓으로 출력하기
			
			//파일을 읽어올 스트링 객체 생성
			BufferedInputStream bin = new BufferedInputStream
					(new FileInputStream(file));
			
			//서버로 전송할 출력용 스트림 객체 생성(소켓 이용)
			BufferedOutputStream bout = 
					new BufferedOutputStream(socket.getOutputStream());
			
			byte[] temp = new byte[1024];
			int length = 0;
			
			//파일을 읽어서 소켓으로 출력하기
			while((length = bin.read(temp))>0) {
				bout.write(temp, 0, length);
			}
			
			bout.flush();
			
			System.out.println("파일 전송 완료");
			
			bout.close();
			bin.close();
			dout.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패");
			e.printStackTrace();
		}
	}
	
	
	
	public File selectFile(String option) {
		// SWING에서 제공하는 파일 열기, 저장 창 연습
		JFileChooser chooser = new JFileChooser();

		// 선택할 파일의 확장자 설정
		FileNameExtensionFilter txt = new FileNameExtensionFilter("text파일(*.txt)", "txt"); // 매개변수 첫번째는 표시할 텍스트, 두번째는
																							// 확장자
		FileNameExtensionFilter doc = new FileNameExtensionFilter("MS Word File", "doc", "docx"); // 매개변수 두번째는 확장자(확장자
																									// 여러개 콤마 분리로 나열 가능)
		FileNameExtensionFilter img = new FileNameExtensionFilter("Image File", new String[] { "png", "jpg", "gif" }); // 배열로
																														// 만들
																														// 수도
																														// 있음

		// 확장자 목록을 FileChooser에 등록한다.
		chooser.addChoosableFileFilter(txt);
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);

		// Dialog창 열기
		int result;
		if ("SAVE".equals(option.toUpperCase())) {
			result = chooser.showSaveDialog(new Panel()); // 저장 창
		} else if ("OPEN".equals(option.toUpperCase())) {
			result = chooser.showOpenDialog(new Panel()); // 열기 창
		} else {
			System.out.println("메소드를 호출할 때 매개변수에 'SVAE' 또는 'OPEN'을 지정하세요");
			return null;
		}
		// int result = chooser.showSaveDialog(new Panel()); // 저장 창

		File selectedFile = null;
		// 창에서 '열기' 또는 '저장' 버튼을 눌렀는지 확인
		if (result == JFileChooser.APPROVE_OPTION) {
			selectedFile = chooser.getSelectedFile();
		}
		return selectedFile;
	}
	
	
}


















