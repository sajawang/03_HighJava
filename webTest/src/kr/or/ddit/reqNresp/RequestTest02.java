package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestTest02
 */
@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		int num1 = Integer.valueOf(request.getParameter("num1"));
		int num2 = Integer.valueOf(request.getParameter("num2"));
		String calc = request.getParameter("calc");

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		PrintWriter out = response.getWriter();

		out.println(num1 + calc + num2 + "=");
		//out.println(num1+num2); 
		
		 if(calc.equals("+")) out.println(num1+num2); 
		 else if(calc.equals("-")) out.println(num1-num2); 
		 else if(calc.equals("*")) out.println(num1*num2);
		 else if(calc.equals("/")) out.println((double)num1/num2); 
		 else if(calc.equals("%")) out.println(num1%num2);
	

	}

}
