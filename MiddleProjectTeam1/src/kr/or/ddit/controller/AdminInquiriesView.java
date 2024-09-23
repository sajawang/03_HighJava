package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmMyMathBoardServiceImpl;
import kr.or.ddit.service.AdminInquiriesServiceImpl;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.PostVO;

/**
 * 이용문의 해당 게시글 상세보기
 */
@WebServlet("/adminInquiriesView.do")
public class AdminInquiriesView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터값으로 날아온 post_no를 받아 해당 게시글의 PostVO를 통해 상세보기 및
		// 해당게시글의 댓글(답변) 출력 
		request.setCharacterEncoding("utf-8");
		
		String post_no_str=request.getParameter("post_no");
		int post_no = Integer.parseInt(post_no_str);
				
		AdminInquiriesServiceImpl service =AdminInquiriesServiceImpl.getInstance();
		
		PostVO pvo = service.postView(post_no);
		List<CommentVO> cvo = service.commentView(post_no);
		
		request.setAttribute("pvo", pvo);
		request.setAttribute("commentList", cvo);
				
		request.getRequestDispatcher("/WEB-INF/view/adminInquiries/adminInquiriesView.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
