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
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/AdminStudentInsert.do")
public class AdminStudentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// GET방식으로 요청할 때는 회원 입력 폼이 나타나도록 구현한다.
		request.getRequestDispatcher("/WEB-INF/view/adminStudent/Studentinsert.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		//회원 정보 받기
		String id = request.getParameter("cus_id");
		String pw = request.getParameter("cus_pass");
		String name = request.getParameter("mem_name");
		String tel = request.getParameter("mem_tel");
		String bir = request.getParameter("mem_bir");
		String zip = request.getParameter("mem_zip");
		String add1 = request.getParameter("mem_add1");
		String add2 = request.getParameter("mem_add2");
		String mail = request.getParameter("mem_mail");
		
		//받아온 회원 정보 vo에 저장
		CustomerVO cusVo = new CustomerVO();
		cusVo.setCus_id(id);
		cusVo.setCus_pw(pw);
		
		IAdmUserService service = AdmUserServiceImpl.getInstance();
		int cnt = service.insertCusStudent(cusVo);
		
		
		if(cnt==1) {
		
			MemberVO memVo = new MemberVO();
			memVo.setCus_id(id);
			memVo.setMem_name(name);
			memVo.setMem_tel(tel);
			memVo.setMem_bir(bir);
			memVo.setMem_zip(zip);
			memVo.setMem_add1(add1);
			memVo.setMem_add2(add2);
			memVo.setMem_mail(mail);
			
			service.insertMemStudent(memVo);
			
			//작업이 완료 되면 list페이지로 이동
			response.sendRedirect(request.getContextPath()+"/AdminStudentList.do");
			
			
		}

}
}
