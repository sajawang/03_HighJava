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
 * Servlet implementation class SessionLogin
 */
@WebServlet("/sessionLoginDb.do")
public class SessionLoginDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionLoginDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=uft-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userId=request.getParameter("userid");
		String userPass=request.getParameter("userpass");
		
		session.setAttribute("ID", userId);
		session.setAttribute("PASS", userPass);
		//로그인 성공 여부 확인
		if(userId !=null && userPass != null) {
			if(userId.equals("admin") && userPass.equals("1234")) {
				
				response.sendRedirect(request.getContextPath()
						+"/sessionLogout.do");
			} else {
				response.sendRedirect(request.getContextPath()
						+"/basic/session/sessionLogin.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
