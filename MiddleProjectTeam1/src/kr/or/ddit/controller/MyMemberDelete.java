package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.CustomerServiceImpl;
import kr.or.ddit.service.ICustomerService;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/myMemberDelete.do")
public class MyMemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session에서 아이디 받기
		//session에서 아이디 받기
		// String sw = (String)session.getAttribute("id");
		HttpSession session = request.getSession();
		
		String da= (String)session.getAttribute("userGu"); // 회원의 종류 - 학생 - 선생님 값 가져오기

		String sw = null;
		int eq = 0;

		MemberVO memVo=(MemberVO)session.getAttribute("memVo");
		if(memVo!=null){
			sw = memVo.getCus_id();
			eq = memVo.getMem_point();
		}
		//----------------------------------------------------------------
		
		
		ICustomerService service = CustomerServiceImpl.getInstance();
		
		//session에서 받은 아이디 넣기
		service.deleteCustomer(sw);
		
		
		
		///---------------------------------
		
		
		//세션을 삭제한 후 로그인 페이지로 이동
		   
	   System.out.println("세션삭제");
	   session.invalidate();
	   
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
		//---
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
