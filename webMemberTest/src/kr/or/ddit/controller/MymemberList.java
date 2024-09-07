package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MyMemberVO;

@WebServlet("/mymemberList.do")
public class MymemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//view(클라이언트,jsp), conroller(서버,서블렛) characterencoding 지정해주기
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//클라이언트가 요청한 list 가져오기(service.getinstance(), )
		IMemberService service = MemberServiceImpl.getInstance();
		List<MyMemberVO> list = service.memberList();
		
		//가져온 파일 목록 정보를 View페이지로 보낸다.
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/basic/memberList.jsp").forward(request, response);
	}
}













