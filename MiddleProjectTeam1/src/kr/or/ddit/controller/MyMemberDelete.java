package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.CustomerServiceImpl;
import kr.or.ddit.service.ICustomerService;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/myMemberDelete.do")
public class MyMemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session에서 아이디 받기
		
		ICustomerService service = CustomerServiceImpl.getInstance();
		
		//session에서 받은 아이디 넣기
		service.deleteCustomer("a003");
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
