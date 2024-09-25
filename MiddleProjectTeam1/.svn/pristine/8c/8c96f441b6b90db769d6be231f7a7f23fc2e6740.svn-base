package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.AdminSamTalkServiceImpl;
import kr.or.ddit.service.IAdminSamTalkService;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.PostVO;


@WebServlet("/AdminTalkDelectComment.do")
public class AdminTalkDelectComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		
		
		//service 객체 얻기
		IAdminSamTalkService service = AdminSamTalkServiceImpl.getInstance();
		
		// CommentVO 객체 생성 및 값 설정
		CommentVO comment = new CommentVO();
		comment.setComment_no(comment_no); 
		
		int result =  service.delectTeacherComment(comment);
	
		// 처리 후, 성공 시 목록 페이지로 리다이렉트
				if (result > 0) {
					response.sendRedirect("AdminTeacherTalkList.do");
				} else {
					// 실패 시 에러 페이지나 알림 페이지로 이동
					request.setAttribute("error", "삭제 실패");
				}
			}
		

}
