package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmMyMathBoardServiceImpl;
import kr.or.ddit.vo.CommentVO;

/**
 * 답변작성 서블릿
 */
@WebServlet("/adminMymathBoardAddComment.do")
public class AdminMymathBoardAddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		AdmMyMathBoardServiceImpl service =AdmMyMathBoardServiceImpl.getInstance();
		
		String postno_str = request.getParameter("post_no");
		String cus_id = request.getParameter("cus_id");
		String comment_content = request.getParameter("comment_content");
		//수학학습해결소 답변이기때문에 board_no = 2
		int board_no = 2;
		int post_no = Integer.parseInt(postno_str);
		
		CommentVO cvo = new CommentVO();
		
		cvo.setBoard_no(board_no);
		cvo.setPost_no(post_no);
		cvo.setCus_id(cus_id);
		cvo.setComment_content(comment_content);
		
		int cnt = service.insertComment(cvo);
		if(cnt>0) {
			System.out.println("댓글 작성 성공");
		}
		
		response.sendRedirect(request.getContextPath() + "/adminMymathBoardList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
