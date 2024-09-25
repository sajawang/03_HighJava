package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmNoticeServiceImpl;
import kr.or.ddit.service.AdminTeacherLibraryServiceImpl;
import kr.or.ddit.service.IAdmNoticeService;
import kr.or.ddit.service.IAdminTeacherLibraryService;
import kr.or.ddit.vo.PostVO;


@WebServlet("/AdminTeacherLibraryDelete.do")
public class AdminTeacherLibraryDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doPost(request, response);
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IAdminTeacherLibraryService service = AdminTeacherLibraryServiceImpl.getInstance();
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		// 서비스나 DAO를 통해 해당 게시물의 POST_DELYN 값을 'Y'로 업데이트
		PostVO pvo = new PostVO();
		pvo.setPost_no(post_no);
		
		int result = service.deleteLibrary(pvo);
		
		// 처리 후, 성공 메시지를 반환하거나 페이지를 리다이렉트
		response.sendRedirect(request.getContextPath() + "/AdminTeacherLibraryList.do");
}
	}
