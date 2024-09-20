package kr.or.ddit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmTeacherServiceImpl;
import kr.or.ddit.service.AdmUserServiceImpl;
import kr.or.ddit.service.IAdmTeacherService;
import kr.or.ddit.service.IAdmUserService;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/AdminTeacherImageView.do")
public class AdminTeacherImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 회원ID를 받는다.
		String cusId = request.getParameter("cusID");
		System.out.println("cusID: " + cusId);  // 고객 ID 확인
		
		
		IAdmUserService service = AdmUserServiceImpl.getInstance();
		MemberVO memVo =  service.getAllMemVo(cusId);
		
		String imageFile = memVo.getMem_auth();
		if(imageFile==null) imageFile = "noImage.png";
		
		// 이미지가 저장된 폴더 설정

		String filepath = "C:/Users/space/Desktop/이미지파일";
		File file = new File(filepath, imageFile);

		System.out.println("이미지 경로: " + file.getAbsolutePath());  // 파일 경로 확인
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		if(file.exists()) {	// 이미지 파일이 있을 때...
			try {
				// 출력용 스트림
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림
				bin = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				
				while( (len = bin.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
				
				
			} catch (Exception e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bin!=null) try { bin.close(); }catch(IOException e) {}
				if(bout!=null) try { bout.close(); }catch(IOException e) {}
			}
		}
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
