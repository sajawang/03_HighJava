package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmUserServiceImpl;
import kr.or.ddit.service.IAdmUserService;


@WebServlet("/AdminStudentDelete.do")
public class AdminStudentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String cusId = request.getParameter("cus_id");
		
		IAdmUserService service = AdmUserServiceImpl.getInstance();
		//customer 
		service.deleteCusStudent(cusId);
		//member
		service.deleteMemStudent(cusId);
		 
	response.sendRedirect(request.getContextPath() + "/WEB-INF/view/adminStudent/StudentList.jsp");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
