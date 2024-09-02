package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionAdd
 */
@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Session 정보를 저장하는 방법
		
		//1. Session객체를 생성하거나 현재 Session가져오기
		//형식1) Request객체. getSession(); 또는 Request객체.getSession(true);
		//		==> 현재 Session이 존재하면 현재 Session을 반환하고, 존재하지 않으면
		// 			새로운 Session을 생성한다.
		//형식2) Request객체.getSession(false);
		//		==> 현재 Session이 존재하면 현재 Session을 반환하고, 존재하지 않으면
		// 			새로운 Session을 생성하지 않고 null을 반환한다.

		HttpSession session = request.getSession();
		
		//2. Session객체의 setAttribute()메서드를 이용하여 Session값을 저장한다.
		//형식) Session객체.setAttribute("key값", session값);
		//		==>'key값'은 문자열, 'session값'은 모든 종류의 데이터 사용 가능
		session.setAttribute("testSession", "연습용 세션입니다.");
		session.setAttribute("userName", "홍길동");
		session.setAttribute("age", 30);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=uft-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'><title>Session연슶</title></head>");
		out.println("<body>");
		
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

































