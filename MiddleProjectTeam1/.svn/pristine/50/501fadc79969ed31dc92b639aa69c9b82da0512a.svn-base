package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdminInquiriesServiceImpl;
import kr.or.ddit.vo.PostVO;

/**
 * 관리자 이용문의 삭제
 */
@WebServlet("/adminInquiriesDelete.do")
public class AdminInquiriesDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		AdminInquiriesServiceImpl service =AdminInquiriesServiceImpl.getInstance();
		
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		PostVO pvo = new PostVO();
		
		pvo.setPost_no(post_no);
		
		int cnt = service.deletePost(pvo);
		
		if(cnt>0) {
			System.out.println("삭제성공");
		}
		 response.sendRedirect(request.getContextPath() + "/adminInquiriesList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
