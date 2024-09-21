package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.MypageCSPostServiceImpl;

/**
 * 댓글 삭제 서블릿
 */
@WebServlet("/mypagecsCommentDelete.do")
public class MypageCsCommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		//service객체 얻기
		MypageCSPostServiceImpl service = MypageCSPostServiceImpl.getInstance();
		
		int cnt = service.deleteComment(comment_no);
		
		request.setAttribute("result", cnt);
		
		//view페이지로 이동
		request.getRequestDispatcher("/WEB-INF/view/customerService/result.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
