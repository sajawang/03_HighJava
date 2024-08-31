package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountDelServlet.do")
public class CookieTest02_CookieCountDelServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	
		//'count'라는 이름을 갖는 쿠키를 찾아서 삭제한다.
		
		Cookie[] cookieArr = request.getCookies();
		
		if(cookieArr!=null) {
			for(Cookie cookie : cookieArr) {
				if("count".equals(cookie.getName())) {	//'count'라는 쿠키 찾기
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		
		out.println("<html>");
		out.println("<head><meta charset=utf-8><title>Cookie 저장연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>count가 초기화 되었습니다.</h3><br><br>");
		
		out.println("<a href='" + request.getContextPath()
		+"/basic/cookie/cookieTest02.jsp'>시작문서로 이동하기</a>");
		
		out.println("</body></html>");
	}
}




































