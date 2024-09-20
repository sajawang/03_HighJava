package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmUserServiceImpl;
import kr.or.ddit.service.IAdmUserService;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/AdminStudentUpdate.do")
public class AdminStudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 회원ID에 맞는 회원 정보를 검색해서 회원 정보 수정폼에 보낸다.
		request.setCharacterEncoding("utf-8");
				
		IAdmUserService service = AdmUserServiceImpl.getInstance();
		
		String cusId = request.getParameter("cus_id");
		
		System.out.println("cusid: " +cusId);
		
		MemberVO memberVo = service.getAllMemVo(cusId);
		CustomerVO cusVo =service.getAllCusVo(cusId);
		
		request.setAttribute("memberVo", memberVo);
		request.setAttribute("cusVo", cusVo);
		
		request.getRequestDispatcher("/WEB-INF/view/adminStudent/StudentUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		    request.setCharacterEncoding("utf-8");
		    IAdmUserService service = AdmUserServiceImpl.getInstance();

		    // 회원 정보를 받는다.
		    String id = request.getParameter("cus_id");
		    System.out.println("cus_id doPost에 왔어?: " + id);
		    if (id == null || id.isEmpty()) {
		        System.out.println("cus_id가 없어.");
		        // 에러 처리 또는 반환
		    }
		    String pw = request.getParameter("cus_pass");

		    // 필수값 검증
		    if (id == null || id.isEmpty() || pw == null || pw.isEmpty()) {
		        request.setAttribute("error", "필수 값이 누락되었습니다.");
		        // 기존의 회원 정보를 다시 가져와서 설정
		    	MemberVO memberVo = service.getAllMemVo(id);
				CustomerVO cusVo =service.getAllCusVo(pw);

		        request.setAttribute("memberVo", memberVo);
		        request.setAttribute("cusVo", cusVo);

		        request.getRequestDispatcher("/WEB-INF/view/adminStudent/StudentUpdate.jsp").forward(request, response);
		        return;
		    }

		    String name = request.getParameter("mem_name");
		    String tel = request.getParameter("mem_tel");
		    String bir = request.getParameter("mem_bir");
		    String zip = request.getParameter("mem_zip");
		    String add1 = request.getParameter("mem_add1");
		    String add2 = request.getParameter("mem_add2");
		    String mail = request.getParameter("mem_mail");

		    // 받아온 회원 정보 vo에 저장
		    CustomerVO cusVo = new CustomerVO();
		    cusVo.setCus_id(id);
		    cusVo.setCus_pw(pw);


		    int cnt = service.updateCusStudent(cusVo);

		    if (cnt == 1) {
		        MemberVO memVo = new MemberVO();
		        memVo.setCus_id(id); 
		        memVo.setMem_name(name);
		        memVo.setMem_tel(tel);
		        memVo.setMem_bir(bir);
		        memVo.setMem_zip(zip);
		        memVo.setMem_add1(add1);
		        memVo.setMem_add2(add2);
		        memVo.setMem_mail(mail);

		        service.updateMemStudent(memVo);
		        response.sendRedirect(request.getContextPath() + "/AdminStudentList.do");
		    } else {
		        request.setAttribute("error", "회원 정보 수정에 실패했습니다.");
		        request.getRequestDispatcher("/WEB-INF/view/adminStudent/StudentUpdate.jsp").forward(request, response);
		    }
		}
}