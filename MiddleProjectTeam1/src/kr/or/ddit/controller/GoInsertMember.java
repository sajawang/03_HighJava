package kr.or.ddit.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoInsertMember
 */
@WebServlet("/goInsertMember.do")
public class GoInsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   
	   request.getRequestDispatcher("/WEB-INF/view/LoginInsertUserMember/memberInsert.jsp").forward(request, response);
	   
   }
   //보드리스트 하는건데 보드 매퍼 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
