package kr.or.ddit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 파일다운로드 서블릿
 */
@WebServlet("/csdownloadFile.do")
public class CsdownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 파일 이름을 받기
		String fileName = request.getParameter("fileName");
		
		// 파일 경로 설정
        String filePath = "d:/d_other/uploadFiles/"+fileName;

        // 파일 객체 생성
        File file = new File(filePath);
        
        // 파일이 존재하는지 확인
        if (file.exists()) {
            // 응답에 파일 MIME 타입 설정
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentLength((int) file.length());

            // 파일을 클라이언트로 스트림을 통해 전송
            FileInputStream in = new FileInputStream(file);
            OutputStream out = response.getOutputStream();
            
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            
            in.close();
            out.close();
        } 
        else {
            // 파일이 없을 경우 오류 처리
            response.getWriter().write("파일이 존재하지 않습니다.");
        }
    
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
