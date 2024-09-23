package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmMyMathBoardServiceImpl;
import kr.or.ddit.service.AdminInquiriesServiceImpl;
import kr.or.ddit.vo.CommentVO;

/**
 * 답변 수정
 */
@WebServlet("/adminInquiriesEditComment.do")
public class AdminInquiriesEditComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		AdminInquiriesServiceImpl service =AdminInquiriesServiceImpl.getInstance();
		
		String commentno_str = request.getParameter("comment_no");
		String comment_content = request.getParameter("comment_content");
		
		int comment_no = Integer.parseInt(commentno_str);
		
		CommentVO cvo = new CommentVO();
		
		cvo.setComment_no(comment_no);
		cvo.setComment_content(comment_content);
		
		int cnt = service.updateComment(cvo);
		
		if(cnt>0) {
			System.out.println("댓글 수정 성공");
		}
		
		response.sendRedirect(request.getContextPath() + "/adminInquiriesList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
