package kr.or.ddit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.or.ddit.service.AdmNoticeServiceImpl;
import kr.or.ddit.service.IAdmNoticeService;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

@WebServlet("/AdminNoticeList.do")
public class AdminNoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		IAdmNoticeService service = AdmNoticeServiceImpl.getInstance();
		request.setCharacterEncoding("UTF-8");

		int boardNo = 1;
		// 게시글 목록 가져오기
	     List<PostVO> noticeList = service.selectNoticeList(boardNo);
	
	
		 List<FileVO> fileList = (List<FileVO>)service.selectFile();
		   
		
	        // 조회된 게시글과 파일 목록을 request에 담아서 JSP로 전달
	        request.setAttribute("noticeList", noticeList);
	        request.setAttribute("fileList", fileList);
	        request.getRequestDispatcher("/WEB-INF/view/adminNotice/AdminNoticeList.jsp").forward(request, response);
	    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
