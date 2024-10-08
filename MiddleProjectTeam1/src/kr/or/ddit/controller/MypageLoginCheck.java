package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.CustomerServiceImpl;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/mypage/loginCheck.do")
public class MypageLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-1.전송데이터 받기 - pass
		String custPass = request.getParameter("password");
		//세션에 저장한 아이디 가져오기
		
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
		//String custId = "a001";
		
		//vo에 넣어주기
		CustomerVO cusvo = new CustomerVO();
		cusvo.setCus_id(sw);
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
