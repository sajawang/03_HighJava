package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.service.AdminTeacherLibraryServiceImpl;
import kr.or.ddit.service.IAdminTeacherLibraryService;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

@MultipartConfig
@WebServlet("/AdminTeacherLibraryInsert.do")
public class AdminTeacherLibraryInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 요청할 때는 회원 입력 폼이 나타나도록 구현한다.
		request.getRequestDispatcher("/WEB-INF/view/adminTeacherLibrary/TeacherLibraryinsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 폼 데이터 가져오기
		String cusId = "admin";  // 작성자를 관리자(admin)로 고정
        String postTitle = request.getParameter("post_title");
        String postContent = request.getParameter("post_content");
        String postgu = request.getParameter("post_gu");
        
        // 파일 업로드 처리
        Part filePart = request.getPart("file_upload");
        String fileName = filePart.getSubmittedFileName();
     
        
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

        // 파일 VO 생성 및 설정
        FileVO fileVO = new FileVO();
        fileVO.setFiles_name(fileName);
        fileVO.setFiles_size(String.valueOf(filePart.getSize()));
       
        IAdminTeacherLibraryService service = AdminTeacherLibraryServiceImpl.getInstance();
        int cnt = service.insertFile(fileVO);
    
        int fileNo =  fileVO.getFiles_no();
        // 게시글 VO 생성 및 설정
        PostVO postVO = new PostVO();
        postVO.setCus_id(cusId);
        postVO.setPost_title(postTitle);
        postVO.setPost_content(postContent);
        postVO.setFiles_no(fileNo);
        postVO.setPost_gu(postgu);
        
        // 서비스 레이어를 통해 게시글 및 파일 정보 저장
        service.insertLibrary(postVO);
        service.insertFile(fileVO);

        // 저장 후 목록 페이지로 리다이렉트
        response.sendRedirect("AdminTeacherLibraryList.do");
        
	}

}
