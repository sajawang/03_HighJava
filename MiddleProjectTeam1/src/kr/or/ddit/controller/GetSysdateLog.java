package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IMathSettingService;
import kr.or.ddit.service.MathSettingServiceImpl;

/**
 * Servlet implementation class GetSysdateLog
 */
@WebServlet("/getSysdateLog.do")
public class GetSysdateLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
  	
		String id = (String)session.getAttribute("id");
		System.out.println(id+"getSysdateLog");
		
		IMathSettingService ser = MathSettingServiceImpl.getInstance();
		
		String date=ser.getSysdateLog(id);
		System.out.println(date+"getSysdateLog");
		
		session.setAttribute("sysdate", date);
		
  	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
