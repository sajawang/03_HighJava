package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.AdminSamTalkServiceImpl;
import kr.or.ddit.service.IAdminSamTalkService;
import kr.or.ddit.vo.CommentVO;

@WebServlet("/AdminTeacherTalkComment.do")
public class AdminTeacherTalkComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");

		int postNo = Integer.parseInt(request.getParameter("post_no"));
		
		
		IAdminSamTalkService service = AdminSamTalkServiceImpl.getInstance();
		// 댓글 조회 서비스 호출
		List<CommentVO> commentList = service.selectTeacherCommentList(postNo);
		
		
		Gson gson = new Gson();
	    String json = gson.toJson(commentList);
	      
	    PrintWriter out = response.getWriter();
	    out.print(json);
	    out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
