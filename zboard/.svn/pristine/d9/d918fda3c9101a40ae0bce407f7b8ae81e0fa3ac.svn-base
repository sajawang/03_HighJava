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

import kr.or.ddit.service.CSPostServiceImpl;
import kr.or.ddit.vo.CommentVO;

/**
 * 게시판번호와 게시글번호를 받아 댓글리스트 출력 서블릿
 */
@WebServlet("/csCommentList.do")
public class CsCommentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송 데이터 받기
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		Map<String, Object> map = new HashMap<>();
		map.put("board_no", board_no);
		map.put("post_no", post_no);
		
		//service객체 얻기
		CSPostServiceImpl service = CSPostServiceImpl.getInstance();
		//service메소드 호출 - 결과값 받기
		List<CommentVO> list = service.selectComment(map);
		//결과값을 저장
		request.setAttribute("list", list);
		//view페이지로 이동
		request.getRequestDispatcher("/WEB-INF/view/customerService/CscommentList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
