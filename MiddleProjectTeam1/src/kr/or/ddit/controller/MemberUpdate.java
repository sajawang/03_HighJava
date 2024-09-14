package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.CustomerServiceImpl;
import kr.or.ddit.service.ICustomerService;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/MemberUpdate.do")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//session에서 아이디 받기
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		//session에서 받은 아이디 넣기
		MemberVO vo = service.getMember("a001");
		
		request.setAttribute("MemberVO", vo);
		
		request.getRequestDispatcher("/WEB-INF/view/memberMypage/basicMemberInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 회원 정보를 받는다.
		String cus_id = request.getParameter("cus_id");
		String mem_name = request.getParameter("mem_name");
		String mem_tel = request.getParameter("mem_tel");
		String mem_bir = request.getParameter("mem_bir");
		String mem_zip = request.getParameter("mem_zip");
		String mem_add1 = request.getParameter("mem_add1");
		String mem_add2 = request.getParameter("mem_add2");
		String mem_mail = request.getParameter("mem_mail");
		String mem_auth = request.getParameter("mem_auth");
		
		String cus_pw = request.getParameter("new_mem_pass");
		
		
		// 받아온 회원 정보를 VO에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setCus_id(cus_id);
		memVo.setMem_tel(mem_tel);
		memVo.setMem_zip(mem_zip);
		memVo.setMem_add1(mem_add1);
		memVo.setMem_add2(mem_add2);
		memVo.setMem_mail(mem_mail);
		memVo.setMem_auth(mem_auth);
		
		System.out.println("memberUpdate"+cus_id);
		System.out.println("memberUpdate"+cus_pw);
		System.out.println("memberUpdate"+mem_tel);
		System.out.println("memberUpdate"+mem_bir);
		System.out.println("memberUpdate"+mem_zip);
		System.out.println("memberUpdate"+mem_add1);
		
		CustomerVO cusVo = new CustomerVO();
		cusVo.setCus_id(cus_id);
		cusVo.setCus_pw(cus_pw);
		
		IMemberService service = MemberServiceImpl.getInstance();
		ICustomerService service2=CustomerServiceImpl.getInstance();
		
		//쿼리 서비스 전달
		service2.updateCustomer(cusVo);
		service.updateMember(memVo);
		System.out.println(service2);
		System.out.println(service);
		
		//마이페이지 메인으로 가기
		request.getRequestDispatcher("/WEB-INF/view/memberMypage/mypageMain.jsp").forward(request, response);
		
		
		
		
		
	}

}




























