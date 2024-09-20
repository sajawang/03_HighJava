package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdminInquiriesServiceImpl;
import kr.or.ddit.vo.PostVO;

/**
 * 관리자 이용문의 게시판 리스트 출력
 */
@WebServlet("/adminInquiriesList.do")
public class AdminInquiriesList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		AdminInquiriesServiceImpl service =AdminInquiriesServiceImpl.getInstance();
		
		List<PostVO> list = service.selectPostList();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/adminInquiries/adminInquiriesList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
