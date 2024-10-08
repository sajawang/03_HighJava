package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.CustomerVO;

@WebServlet("/goMypage.do")
public class GoMypage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * //로그인 관련 세션 있다고 가정 HttpSession session = request.getSession();
		 * session.setAttribute("loginCust", "intok");
		 * 
		 * //로그인 관련 세션 정보가져오기 int loginCustomer =
		 * (int)session.getAttribute("loginCust");
		 * 
		 * //로그인 안되었을때 if(loginCustomer==0) { //로그인페이지 } else {
		 */
		
		request.getRequestDispatcher("/WEB-INF/view/memberMypage/mypageMain.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
