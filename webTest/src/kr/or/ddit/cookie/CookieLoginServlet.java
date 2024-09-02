package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//userid, userpass,idchk 파라미터값 구하기
		String userId=request.getParameter("userid");
		String userPass=request.getParameter("userpass");
		String idChk=request.getParameter("idChk");
		
		//일단 입력한 id를 쿠키값으로 하는 Cookie객체 생성
		Cookie idCookie = new Cookie("LOGIN_ID",userId);
		
		//checkbox의 체크 여부를 검사한다.
		if(idChk != null) {//체크박스가 체크 되었을때
			//쿠키 저장
			response.addCookie(idCookie);
		} else { //체크박스가 체크되지 않았을때
			//삭제하기
			idCookie.setMaxAge(0);
			response.addCookie(idCookie);
			
		}
		
		//로그인 성공 여부 확인
		if(userId !=null && userPass != null) {
			if(userId.equals("test") && userPass.equals("1234")) {
				//로그인 성공시 'cookieMain.jsp'로 이동한다.
				response.sendRedirect(request.getContextPath()
						+"/basic/cookie/cookieMain.jsp");
			} else {
				//로그인 실패시 'cookieLogin.jsp'로 이동한다.
				response.sendRedirect(request.getContextPath()
						+"/basic/cookie/cookieLogin.jsp");
			}
		}
		
		

	}
}
