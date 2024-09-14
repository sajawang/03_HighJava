package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionLogout.do")
public class SessionLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=uft-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("ID");
		
		session.invalidate();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Session연슶</title></head>");
		out.println("<body>");
		
		out.println("<h3>"+id+"님 반갑습니다</h3>");
		
		out.println("<a href='"+request.getContextPath()
		+"/basic/session/sessionLogin.jsp'>로그아웃</a>");
		
		out.println("</body></html>");
	}


}





























