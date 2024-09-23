package kr.or.ddit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdminInquiriesServiceImpl;
import kr.or.ddit.vo.PostVO;

/**
 * 관리자 이용문의 작성
 */
@WebServlet("/adminInquiriesInsert.do")
public class AdminInquiriesInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String post_delyn = request.getParameter("post_delyn");
		String cus_id = request.getParameter("cus_id");
		
		String saveFileName = null;
		 // map객체 생성 포스트의 파일번호 업데이트용 
	    Map<String, Object> map = new HashMap<>();
		
		AdminInquiriesServiceImpl service =AdminInquiriesServiceImpl.getInstance();
		PostVO pvo = new PostVO();
		
		pvo.setPost_title(post_title);
		pvo.setPost_content(post_content);
		pvo.setPost_delyn(post_delyn);
		pvo.setCus_id(cus_id);
		
		
		int res = service.insertPost(pvo);
		
		if(res>0) {
			System.out.println("인서트성공");
		}
		
		response.sendRedirect(request.getContextPath() + "/adminInquiriesList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
