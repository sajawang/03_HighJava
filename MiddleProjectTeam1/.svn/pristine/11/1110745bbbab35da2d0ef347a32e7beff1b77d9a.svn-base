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
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class InsertMember
 */
@WebServlet("/insertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMember() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	response.getWriter().append("Served at: ").append(request.getContextPath());
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	//전송데이터 얻기
	String reqData=StreamData.dataChange(request);
	
	//역직렬화 - memberVO타입으로 변환
	Gson gson = new Gson();
	//memVo.setMem_id("kanedic") 등 set을 자동 처리
	MemberVO memVo= gson.fromJson(reqData, MemberVO.class);
	
	CustomerVO cusVo = gson.fromJson(reqData, CustomerVO.class);
	
	String pla = memVo.getCus_id();
	String plz = cusVo.getCus_pw();
	
	System.out.println(pla+" "+plz);
	
//	service 객체 얻기
	ICustomerService service = CustomerServiceImpl.getInstance();
	
	int cus = service.insertCustomer(cusVo);
	
	if(cus==1) {
		System.out.println("cus는 1 ");
		//service 메소드 호출 - 결과값 받기
		int cnt = service.insertMember(memVo);
		
		//결과값 저장
		request.setAttribute("result", cnt);
		
		//view페이지로 이동 - 응답데이터 생성
//		request.getRequestDispatcher("/LoginInsertUserMember/result.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/view/LoginInsertUserMember/result.jsp").forward(request, response);
	}
	
	
	
	}

}
