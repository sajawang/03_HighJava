package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId=request.getParameter("memId");
		System.out.println("MemberUpdate.do"+memId);
		
		IMemberService service = MemberServiceImpl.getInstance();
		MemberVO vo = service.getMember(memId);
		System.out.println("MemberUpdate.do="+vo);
		
		request.setAttribute("MemberVO", vo);
		
		request.getRequestDispatcher("/mypage/basicMemberInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}




























