package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import kr.or.ddit.service.AdmNoticeServiceImpl;
import kr.or.ddit.service.IAdmNoticeService;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

@MultipartConfig // 파일 업로드를 위한 어노테이션
@WebServlet("/AdminNoticeInsert.do")
public class AdminNoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 요청할 때는 회원 입력 폼이 나타나도록 구현한다.
				request.getRequestDispatcher("/WEB-INF/view/adminNotice/AdminNoticeinsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    
		//공지사항 글 쓰기
		
		//회원 정보 받기
		//String id = request.getParameter("cus_id");
		String cusId = "admin";
		String title = request.getParameter("post_title");
		String content = request.getParameter("post_content");
	
		 // -----------------------------------
        // 파일 저장 기능 추가
        Part filePart = request.getPart("file"); // form에서 전달된 파일 파트
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // 파일 이름 가져오기
		
		
        // 파일 저장 경로 설정 (서버 경로 또는 로컬 경로)
        String uploadPath = "d:/d_other/uploadFiles";
        File file = new File(uploadPath);
        // 저장될 폴더가 없으면 새로 생성한다.
        if(!file.exists()) {
           file.mkdirs();
        }

        
        // 파일 저장
        String filePath = uploadPath + File.separator + fileName;
        filePart.write(filePath); // 파일을 지정된 경로에 저장
        

        // 파일 정보를 FileVO에 저장
        FileVO filevo = new FileVO();
        filevo.setFiles_name(fileName);
        filevo.setFiles_size(String.valueOf(filePart.getSize()));
      //  filevo.set(filePath); // 파일 경로를 저장 (필요하다면)
        
        
        // FileVO를 통해 파일 정보 저장 (DB 삽입)
        IAdmNoticeService service = AdmNoticeServiceImpl.getInstance();
        int cnt = service.insertFile(filevo); // 파일 정보를 DB에 삽입하고 파일 번호 반환
        
        int fileNo = filevo.getFiles_no();
		// ------------------------------
		//파일저장기능 추가할 자리
		//int Files_no = Integer.parseInt(request.getParameter("files_no"));
	//	String files_name = request.getParameter("files_name");
		
		///-------------------------------
		
		
		//받아온 회원 정보 vo에 저장
		PostVO vo = new PostVO();
		vo.setCus_id(cusId);
		vo.setPost_title(title);
		vo.setPost_content(content);
		vo.setFiles_no(fileNo);
		
		
	    // 게시글 정보를 DB에 저장
		 service.insertNotice(vo);
		service.insertFile(filevo);
	
		//작업이 완료 되면 list페이지로 이동
		response.sendRedirect(request.getContextPath()+"/AdminNoticeList.do");
			
			
		}

}

