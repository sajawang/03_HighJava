package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.ITeacherLibraryService;
import kr.or.ddit.service.TeacherLibraryServiceImpl;
import kr.or.ddit.vo.PostVO;

@WebServlet("/teacher/detailTeacherLibrary.do")
public class DetailTeacherLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int pno = Integer.parseInt(request.getParameter("pno"));		
		
		ITeacherLibraryService service = TeacherLibraryServiceImpl.getInstance();
		
		service.updateHitTeacherLib(pno);
		PostVO pvo = service.detailTeacherLib(pno);
		
		request.setAttribute("pvo", pvo);
		
		request.getRequestDispatcher("/WEB-INF/view/teacher/detailTeacherLibrary.jsp").forward(request, response);
	}
}
