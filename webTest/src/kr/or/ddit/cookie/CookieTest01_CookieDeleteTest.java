
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
 * Servlet implementation class CookieDeleteTest
 */
@WebServlet("/cookieDelete.do")
public class CookieTest01_CookieDeleteTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 저장된 쿠키 삭제하기
		
		// 1. 전체 쿠키 정보를 가져온다.
		Cookie[] cookieArr = request.getCookies();

		out.println("<html>");
		out.println("<head><meta charset=utf-8><title>Cookie 삭제 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>Cookie 데이터 삭제하기</h3>");
		
		// 2. 쿠키 배열에서 삭제하려는 쿠키를 구해온다. (예 : gender쿠키 삭제하기)
		if(cookieArr==null || cookieArr.length==0) {
			out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");
		} else {
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName();	//쿠키 이름 구하기
				
				if("gender".equals(name)) {	//삭제하겨는 쿠키 구하기
					
					// 3. 찾은 쿠키의 유지시간을 0으로 설정한 후 다시 저장한다.
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		out.println("<a href='" + request.getContextPath()
		+"/basic/cookie/cookieTest01.jsp'>시작문서로 이동</a>");
		
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

























