package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionRead
 */
@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionRead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//저장된 Session 정보 읽어오기
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//1.Session객체를 생성하거나 현재 Session가져오기
		HttpSession session = request.getSession();
		
		//2.Session객체에 setAttribute()메서드로 저장한 값을 getAttribute()메서드를 이용하여 가져온다.
		// 형식) Session객체.getAttribute("key값");
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Session연슶</title></head>");
		out.println("<body>");
		
		//Session값 가져오기
		String sessionValue =(String)session.getAttribute("testSession");
		
		if(sessionValue==null) {
			out.println("<h3>testSession의 세션값이 없습니다.</h3>");
		} else {
			out.println("testSession의 세션값 : "+sessionValue+"<br>");
		}
		out.println("<hr>");
		
		out.println("<h3>전체 Session정보 확인하기</h3>");
		out.println("<ol>");
		
		//Session의 전체 key값 가져오기
		//Enumeration - iterate의 옛날버전 같은것
		Enumeration<String> sessionNames = session.getAttributeNames();
		
		int cnt = 0;	//session정보의 개수가 저장될 변수
		while(sessionNames.hasMoreElements()) {
			cnt++;
			String key = sessionNames.nextElement();
			out.println("<li>"+key+" : "+session.getAttribute(key)+"</li>");
		}
		
		if(cnt==0) {
			out.println("<li>Session 정보가 하나도 없습니다.</li>");
		}
		
		out.println("</ol>");
		out.println("<hr>");
		
		out.println("세션ID :"+session.getId()+"<br>");

		//생성시간 ==> 1970년 1월 1일 부터 경과한 시간(밀리 세컨드 단위)
		out.println("세션 생성 시간 : "+session.getCreationTime()+"<br>");
		
		//최근 접근 시간==> 1970년 1월 1일 부터 경과한 시간(밀리 세컨드 단위)
		out.println("세션 최근 접근 시간 : "+session.getLastAccessedTime()+"<br>");
		
		//세션 유효 시간 ==> 단위(초)
		out.println("세션 유효시간 : "+session.getMaxInactiveInterval()+"<br>");
		
		out.println("<a href='"+request.getContextPath()
		+"/basic/session/sessionTest.jsp'>시작문서로 이동</a>");
		
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

































