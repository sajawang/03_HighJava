package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountServlet
 */
@WebServlet("/cookieCountServlet.do")
public class CookieTest02_CookieCountServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int count=0;	//count값이 저장될 변수 선언
		
		// 쿠키이름은  'count'로 하기로 한다.
		
		//'count'라는 쿠키가 있는지 검사
		Cookie[] cookieArr = request.getCookies();
	
		if(cookieArr != null) {
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName();	//쿠키 이름 구하기
				if("count".equals(name)) {	// 'count'라는 쿠키 이름을 갖는 쿠키 찾기
					//찾았으면 쿠키값(현재의 count값)	구하기
					count = Integer.parseInt( cookie.getValue() );
				}
			}
		}
		
		count++;	//count 증가
		
		//증가된 count값 저장하기
		
		//증가된 count값을 갖는 Cookie객체 생성
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		
		//쿠키 저장
		response.addCookie(countCookie);
		
		out.println("<html>");
		out.println("<head><meta charset=utf-8><title>Cookie 저장연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>어서오세요. 당신은"+count+"번쨰 방문입니다.</h3><br><br>");
		
		out.println("<a href='" + request.getContextPath()
		+"/cookieCountServlet.do'>카운트 증가하기</a>");
		
		out.println("<a href='" + request.getContextPath()
		+"/basic/cookie/cookieTest02.jsp'>시작문서로 이동하기</a>");
		
		out.println("</body></html>");
	}
}



































