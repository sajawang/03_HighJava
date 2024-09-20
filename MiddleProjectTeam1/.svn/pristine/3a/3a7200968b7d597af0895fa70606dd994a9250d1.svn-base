package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmTeacherServiceImpl;
import kr.or.ddit.service.AdmUserServiceImpl;
import kr.or.ddit.service.IAdmTeacherService;
import kr.or.ddit.service.IAdmUserService;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;


@WebServlet("/AdminTeacherList.do")
public class AdminTeacherList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdmTeacherService service = AdmTeacherServiceImpl.getInstance();

		List<MemberVO> TeacherList = service.getAllTeacher("teacher");
		
	
		request.setAttribute("TeacherList" , TeacherList);
	

		request.getRequestDispatcher("/WEB-INF/view/adminTeacher/TeacherList.jsp").forward(request, response);

		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
