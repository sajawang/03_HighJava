package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.CustomerServiceImpl;
import kr.or.ddit.vo.CustomerVO;


@WebServlet("/mypage/loginCheck.do")
public class MypageLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-1.전송데이터 받기 - pass
		String custPass = request.getParameter("password");
		//세션에 저장한 아이디 가져오기
		String custId = "a001";
		
		//vo에 넣어주기
		CustomerVO cusvo = new CustomerVO();
		cusvo.setCus_id(custId);
		cusvo.setCus_pw(custPass);
		
		//1-2.service객체 얻기
		CustomerServiceImpl service = CustomerServiceImpl.getInstance();
		
		//2-1.service메소드 호출 - 결과값 얻기
		CustomerVO cusVo = service.getCustomer(cusvo);
		
		//2-2.request에 결과값 저장
		request.setAttribute("result", cusVo);
		
		//view페이지 가기(고객에게) ( 공통 view페이지 만들어놓음!! flag페이지임 )
		request.getRequestDispatcher("/mypageView/mypageResult.jsp").forward(request, response);
	}

}
