package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmMyMathBoardServiceImpl;
import kr.or.ddit.vo.PostVO;

@WebServlet("/adminMymathBoardUpdate.do")
public class AdminMymathBoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		AdmMyMathBoardServiceImpl service =AdmMyMathBoardServiceImpl.getInstance();
		
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		String post_title = request.getParameter("post_title");
		String post_content = request.getParameter("post_content");
		String post_delyn = request.getParameter("post_delyn");
		
		PostVO  pvo = new PostVO();
		pvo.setPost_no(post_no);
		pvo.setPost_title(post_title);
		pvo.setPost_content(post_content);
		pvo.setPost_delyn(post_delyn);
		
		int result = service.updatePost(pvo);
		
		request.setAttribute("pvo", pvo);
		
		response.sendRedirect(request.getContextPath() + "/adminMymathBoardList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
