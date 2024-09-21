package kr.or.ddit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.CSPostServiceImpl;
import kr.or.ddit.vo.PostVO;

/**
 * a태그 눌렀을 때 해당 게시글번호와 게시판번호를 파라미터값으로 받아
 * 해당 게시글 내용을 보여주는 뷰로 이동하는 서블릿
 */
@WebServlet("/csDetailPost.do")
public class CsDetailPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//서비스객체
		CSPostServiceImpl service = CSPostServiceImpl.getInstance();
		// 파라미터값 담을 맵
		Map<String, Object> map = new HashMap<>();
		//jsp에서 날아온 파라미터값 꺼내서 맵에 담기
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_no =  Integer.parseInt(request.getParameter("board_no"));
		
		map.put("post_no", post_no);
		map.put("board_no", board_no);
		// dao통해 상세보기정보 받기
		PostVO pvo = service.selectDetailPost(map);
		if(pvo!=null) {
			service.updateHitAdminInquiries(pvo);
		}
		request.setAttribute("pvo", pvo);
		System.out.println(pvo);
		
		request.getRequestDispatcher("/WEB-INF/view/customerService/CsPostDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//서비스객체
		CSPostServiceImpl service = CSPostServiceImpl.getInstance();
		// 파라미터값 담을 맵
		Map<String, Object> map = new HashMap<>();
		//jsp에서 날아온 파라미터값 꺼내서 맵에 담기
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_no =  Integer.parseInt(request.getParameter("board_no"));
		
		map.put("post_no", post_no);
		
		
		map.put("board_no", board_no);
		// dao통해 상세보기정보 받기
		PostVO pvo = service.selectDetailPost(map);
		
		request.setAttribute("pvo", pvo);
		
		request.getRequestDispatcher("/WEB-INF/view/customerService/CsupdatePost.jsp").forward(request, response);
	}

}
