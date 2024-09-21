package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmUserServiceImpl;
import kr.or.ddit.service.IAdmUserService;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/AdminStudentView.do")
public class AdminStudentView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String cusId = request.getParameter("cus_id");
		
		IAdmUserService service = AdmUserServiceImpl.getInstance();
		
	        MemberVO studentList = service.getAllMemVo(cusId);
	        CustomerVO cusVo = service.getAllCusVo(cusId);
	        
		request.setAttribute("memberVo", studentList);
		request.setAttribute("cusVo", cusVo);
	
		
		request.getRequestDispatcher("/WEB-INF/view/adminStudent/StudentView.jsp")
		.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
