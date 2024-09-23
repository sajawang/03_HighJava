package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmMyMathBoardServiceImpl;

/**
 * 답변 삭제 
 */
@WebServlet("/adminMymathBoardDeleteComment.do")
public class AdminMymathBoardDeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		AdmMyMathBoardServiceImpl service =AdmMyMathBoardServiceImpl.getInstance();
		
		String commentno_str = request.getParameter("comment_no");
		int comment_no = Integer.parseInt(commentno_str);
		
		int cnt = service.deleteComment(comment_no);
		
		if(cnt>0) {
			System.out.println("댓글 삭제 성공");
		}
		
		response.sendRedirect(request.getContextPath() + "/adminMymathBoardList.do");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
