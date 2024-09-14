package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MyMemberVO;

@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
//		response.setContentType("text/html; charset=utf-8");
		
		String id=request.getParameter("id");
		
		IMemberService service = MemberServiceImpl.getInstance();

		MyMemberVO vo = service.selectOneMember(id);
		
		
		
//		request.setAttribute("result", vo);
//		
//		request.getRequestDispatcher("/basic/insert.jsp").forward(request, response);
		
//		Gson gson = new Gson();
//		
//		String jjj  = gson.toJson(vo);
		
		PrintWriter out = response.getWriter();
		
		if(vo==null) {
			out.println("ok");
		}else {
			out.println("no");
		}
		
//		out.write(jjj);
//		response.flushBuffer();
		
		//response.sendRedirect("");
	}

}
