package kr.or.ddit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmUserServiceImpl;
import kr.or.ddit.service.IAdmUserService;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/AdminStudentList.do")
public class AdminStudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdmUserService service = AdmUserServiceImpl.getInstance();
		List<MemberVO> studentList = service.getAllStudent("student");
		List<CustomerVO> cusdelstudent =service.cusdelstudent();
		
	
		request.setAttribute("studentList" , studentList);
		request.setAttribute("cusdelstudent", cusdelstudent);

		// cus_id를 기준으로 MemberVO와 CustomerVO를 매핑할 Map 객체 생성
				Map<String, CustomerVO> customerMap = new HashMap<>();
				for (CustomerVO cus : cusdelstudent) {
					customerMap.put(cus.getCus_id(), cus);  // cus_id 기준으로 매핑
				}
				
				// customerMap을 JSP에 전달
				request.setAttribute("customerMap", customerMap);	
		
		request.getRequestDispatcher("/WEB-INF/view/adminStudent/StudentList.jsp").forward(request, response);

		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
