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
import kr.or.ddit.service.AdminTeacherLibraryServiceImpl;
import kr.or.ddit.service.IAdmNoticeService;
import kr.or.ddit.service.IAdminTeacherLibraryService;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

@WebServlet("/AdminTeacherLibarayUpdate.do")
@MultipartConfig // 파일 업로드 처리를 위한 어노테이션
public class AdminTeacherLibarayUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	}	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 정보 수정 폼에 보낸다.
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        IAdminTeacherLibraryService service = AdminTeacherLibraryServiceImpl.getInstance();

        // 요청으로부터 파라미터를 가져오기
        int post_no = Integer.parseInt(request.getParameter("post_no"));
        String post_title = request.getParameter("post_title");
        String post_content = request.getParameter("post_content");
        String post_delyn = request.getParameter("post_delyn");

        // 파일 처리 (새로 업로드된 파일이 있는지 확인)
        Part filePart = request.getPart("file");

        int fileNo = 0; // 파일 번호 초기화
        if (filePart != null && filePart.getSubmittedFileName() != null && !filePart.getSubmittedFileName().isEmpty()) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // 파일 업로드 경로 설정
            String uploadPath = "C:/Users/space/Desktop/이미지파일";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // 파일 저장 경로 및 파일 저장
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);

            // 파일 정보를 DB에 저장
            FileVO filevo = new FileVO();
            filevo.setFiles_name(fileName);
            filevo.setFiles_size(String.valueOf(filePart.getSize()));

            // DB에 파일 정보 저장 후 파일 번호 가져오기
            fileNo = service.insertFile(filevo);
        }

        // 기존 데이터를 업데이트
        PostVO pvo = new PostVO();
        pvo.setPost_no(post_no);
        pvo.setPost_title(post_title);
        pvo.setPost_content(post_content);
        pvo.setPost_delyn(post_delyn);

        // 파일 번호가 존재하면 PostVO에 설정
        if (fileNo > 0) {
            pvo.setFiles_no(fileNo);
        }

        // 데이터베이스 업데이트
        service.updateLibrary(pvo);

        // 수정 후 목록 페이지로 리다이렉트
        response.sendRedirect(request.getContextPath() + "/AdminTeacherLibraryList.do");
    }
}
