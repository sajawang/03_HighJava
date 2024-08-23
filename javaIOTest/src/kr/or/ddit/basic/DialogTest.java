package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {

	public static void main(String[] args) {
		// SWING에서 제공하는 파일 열기, 저장 창 연습
		JFileChooser chooser = new JFileChooser();
		
		// 선택할 파일 유형 중 '모든 파일'메뉴의 설정 여부 (true : 보이기, false : 보이지 않기)
//		chooser.setAcceptAllFileFilterUsed(false);  
		chooser.setAcceptAllFileFilterUsed(true);
		
		// 선택할 파일의 확장자 설정
		FileNameExtensionFilter txt = 
			new FileNameExtensionFilter("text파일(*.txt)", "txt");
		FileNameExtensionFilter doc = 
				new FileNameExtensionFilter("MS Word File", "doc", "docx");
		FileNameExtensionFilter img = 
				new FileNameExtensionFilter("Image File", new String[] {"png", "jpg", "gif"});
		
		// 확장자 목록을 FileChooser에 등록한다.
		chooser.addChoosableFileFilter(txt);
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		
		// 전체 확장자 목록(파일유형) 중에 기본적으로 선택될 확장자 지정하기
		chooser.setFileFilter(txt);
		
		// Dialog창의 기본 위치 지정하기
		chooser.setCurrentDirectory(new File("d:/d_other"));
		
		
		// Dialog창 열기
//		int result = chooser.showOpenDialog(new Panel());   // 열기 창
		int result = chooser.showSaveDialog(new Panel());	// 저장 창
		
		// 창에서 '열기' 또는 '저장' 버튼을 눌렀는지 확인
		if(result==JFileChooser.APPROVE_OPTION) {  
			File selectedFile = chooser.getSelectedFile();
			System.out.println("선택한 파일 : " + selectedFile.getAbsolutePath());
		}
		
		
		
		
		

	}

}