package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmUserServiceImpl;
import kr.or.ddit.service.IAdmUserService;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/AdminTeacherauth.do")
public class AdminTeacherauth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		 IAdmUserService service = AdmUserServiceImpl.getInstance();
		
		 request.setCharacterEncoding("utf-8");

	        // mem_auth가 있는 회원들만 가져오기
	        List<MemberVO> memAuthList = service.memAuth();

	        // 필터링된 회원 목록을 request에 설정
	        request.setAttribute("cusId", memAuthList);
	

		request.getRequestDispatcher("/WEB-INF/view/adminTeacher/TeacherAuth.jsp").forward(request, response);

		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//선생님 인증을 누르면 CUS_GU가 teacher로 바뀌는 곳
		
			request.setCharacterEncoding("utf-8");
		    IAdmUserService service = AdmUserServiceImpl.getInstance();
		    
		    String id = request.getParameter("cus_id");
		    CustomerVO cusvo = new CustomerVO();
		    cusvo.setCus_id(id); // cus_id 설정
		    cusvo.setCus_gu("teacher"); // cus_gu는 "teacher"로 하드코딩
		    
		    service.updateUpgrade(cusvo);
		    response.sendRedirect(request.getContextPath() + "/AdminTeacherList.do");
	}

}
