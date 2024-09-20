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

/**
 * Servlet implementation class IdCheckController
 */
@WebServlet("/IdCheckController.do")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//회원가입 html(사이트에서 보낸) 전송데이터 받기 id
		String userId=request.getParameter("id");
		System.out.println(userId);
		//service 객체 얻기
		ICustomerService service = CustomerServiceImpl.getInstance();
		
		//service 메소드 호출 - 결과값 얻기
		String resId=service.idCheck(userId);
		
		//request에 결과값 저장
		request.setAttribute("gwgw", resId);
		//view 페이지로 이동
		request.getRequestDispatcher("/WEB-INF/view/LoginInsertUserMember/idCheck.jsp").forward(request, response);
		
	}

	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
