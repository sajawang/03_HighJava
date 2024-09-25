package kr.or.ddit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/teacher/fileDownload.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//String file_repo="C:/D드라이브/D_Other/uploadFiles1231";
		String file_repo="d:/d_other/uploadFiles";
		
		File file = new File(file_repo);
		
		// 저장될 폴더가 없으면 새로 생성한다.
		if(!file.exists()) {
			file.mkdirs();
		}
		String fileName = (String)request.getParameter("fileName"); // 매개변수로 전송된 파일 이름을 읽어옴
		
		
		response.setContentType("application/octet-stream; charset=utf-8");
		
		// Response객체의 Header에 'content-disposition' 속성을 설정한다.
		String headerKey = "content-disposition";
		
		// 이 헤더 속성에 다운 받을 파일 이름을 설정한다. (클라이언트에 저장될 이름을 설정한다.)
		String headerValue = "attachment; filename*=UTF-8''" 
				+ URLEncoder.encode(fileName, "utf-8")
						.replaceAll("\\+", "%20");
		
		response.setHeader(headerKey, headerValue);
				
		System.out.println("fileName="+fileName);
		OutputStream out = response.getOutputStream(); // response에서 OutputStream 객체를 가져옴
		String downFile = file_repo+"/"+fileName;
		File f=new File(downFile);
		FileInputStream in=new FileInputStream(f);
		
		// 버퍼 기능을 이용해 파일에서 버퍼로 데이터를 읽어와 한꺼번에 출력함
        byte[] buffer=new byte[1024*8];
		while(true) {
			int count=in.read(buffer);
			if(count==-1)
				break;
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}
}
