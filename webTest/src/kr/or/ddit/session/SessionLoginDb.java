	package kr.or.ddit.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;


@WebServlet("/sessionLoginDb.do")
public class SessionLoginDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userId=request.getParameter("userid");
		String userPass=request.getParameter("userpass");
		
		////////////////////////////////////////////////////
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userId);
		memVo.setMem_pass(userPass);
		
		//service객체 생성
		IMemberService service = MemberServiceImpl.getInstance();
		
		//id와 password가 일치하는 회원을 검색하여 가져온다. 
		MemberVO loginMember = service.getLoginMember(memVo);
		
		if(loginMember != null) {	//로그인성공
			session.setAttribute("loginMemVo", loginMember);
		}
		
		response.sendRedirect(request.getContextPath()+"/basic/session/sessionLoginDb.jsp");
		////////////////////////////////////////////////////
		
	}

}
