package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
문제) 'd:/d_other'폴더에 있는 '펭귄.jpg'파일을
	'd:/d_other/연습용'폴더에 '복사본_펭귄.jpg'파일로 
	복사하는 프로그램을 작성하시오.

*/
public class FileCopyTest {

	public static void main(String[] args) {
		// 원본 파일의 정보를 갖는 File객체 생성
		File file = new File("d:/d_other/펭귄.jpg");
		
		// 원본 파일이 없는지 검사
		if(!file.exists()) {
			System.out.println(file.getAbsolutePath() + "파일이 없습니다...");
			System.out.println("복사 작업을 중지합니다...");
			return;
		}
		
		FileInputStream fin = null;
		FileOutputStream fout = null;
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		try {
			// 원본 파일을 읽어올 스트림 객체 생성
			fin = new FileInputStream(file);
			bin = new BufferedInputStream(fin);
			
			// 대상 파일에 저장할 스트림 객체 생성
			fout = new FileOutputStream("d:/d_other/연습용/복사본_펭귄.jpg");
			bout = new BufferedOutputStream(fout);
			
			System.out.println("복사 시작...");
			
			int data;   // 읽어온 데이터를 저장할 변수
			
//			while((data = ()) != -1) {
//				fout.write(data);
//			}
			
			
			while((data = ()) != -1) {
				bout.write(data);
			}
			bout.flush();
			
			System.out.println("복사 작업 끝...");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 사용했던 스트림 닫기...
//			if(fin!=null) try { fin.close(); }catch(IOException e) {}
//			if(fout!=null) try { fout.close(); }catch(IOException e) {}
			if(bin!=null) try { bin.close(); }catch(IOException e) {}
			if(bout!=null) try { bout.close(); }catch(IOException e) {}
		}

	}

}