package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.AdmUserServiceImpl;
import kr.or.ddit.service.IAdmUserService;

@WebServlet("/AdminCusIdCheck.do")
public class AdminCusIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		// 검색할 회원ID를 받는다.
		String cusId = request.getParameter("cus_id");
		
		IAdmUserService service = AdmUserServiceImpl.getInstance();
		int cnt = service.countStudent(cusId);
		
		Gson gson = new Gson();
		String result = null;  // 결과가 JSON으로 저장될 변수
		
		if(cnt>0) {  // 회원ID가 중복
			result = gson.toJson("Fail");
		}else {		// 회원ID가 중복되지 않음
			result = gson.toJson("OK");
		}
		
		response.getWriter().write(result);
		response.flushBuffer();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
