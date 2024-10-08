package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminLogin.do")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userid");
		String userPass = request.getParameter("userpass");
		
		HttpSession session = request.getSession();
		
		if(	userId.equals("admin")&& userPass.equals("admin1")) { //로그인 성공
			session.setAttribute("loginId", userId);
	    	request.getRequestDispatcher("/WEB-INF/view/admin/AdminMain.jsp").forward(request, response);

		}	else {
			
			response.sendRedirect(request.getContextPath()+ "/WEB-INF/view/admin/AdminLogin.jsp");
			//로그인 성공 못할 시에 여기로 보내는거임
		}
		

	}
	
	
}
