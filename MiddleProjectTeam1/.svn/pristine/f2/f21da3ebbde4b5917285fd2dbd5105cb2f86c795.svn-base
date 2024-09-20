package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PopUp
 */
@WebServlet("/popUp.do")
public class PopUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   	request.setCharacterEncoding("utf-8");
	   	
	   	String dad = (String) request.getAttribute("on");
	   	String www = (String) request.getParameter("on");
	   	
	   	
	   	System.out.println("포스트 어트"+dad);
	   	System.out.println("포스트 파라"+dad);
   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
