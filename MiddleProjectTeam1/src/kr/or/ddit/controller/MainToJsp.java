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
 * index에서 타겟값 받아서 해당 페이지로 이동시키는 서블릿
 */
@WebServlet("/mainToJsp.do")
public class MainToJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String target= request.getParameter("target");
		
		String back = request.getParameter("back");
		
		 
		//게시판 작성 또는 상세보기 후 목록보기 버튼 눌렀을 때 해당 게시판으로 돌아가게끔
		String board = request.getParameter("board_no");
		
		if(target.equals("/WEB-INF/view/customerService/cs_insertPost.jsp")) {
			request.setAttribute("back", back);
			request.setAttribute("board_no", board);
			
			request.getRequestDispatcher(target).forward(request, response);
			return;
		}
		
		if(board!=null&&board!="") {
			int board_no = Integer.parseInt(board);
			switch (board_no) {
			case 1:
				target = "/WEB-INF/view/customerService/customerService.jsp";
				break;
			case 2:
				target =  "/WEB-INF/view/customerService/mathSolution.jsp";
				break;
			case 3:
				target =  "/WEB-INF/view/customerService/inquiry.jsp";
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				target =  "/WEB-INF/view/customerService/FAQ.jsp";
				break;
	
			default:
				break;
			}
		}
		request.setAttribute("back", back);
		
		if (target == null || target.trim().isEmpty()) {
            target = "/index.jsp"; // 기본 페이지 설정
        }
		
		request.getRequestDispatcher(target).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post로 오면 수정폼으로 이동시키기 게시글
		request.setCharacterEncoding("utf-8");
		String board = request.getParameter("board_no");
		String post = request.getParameter("post_no");
		
		CSPostServiceImpl service = CSPostServiceImpl.getInstance();
		// 파라미터값 담을 맵
		Map<String, Object> map = new HashMap<>();
		//jsp에서 날아온 파라미터값 꺼내서 맵에 담기
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		int board_no =  Integer.parseInt(request.getParameter("board_no"));
		
		map.put("post_no", post_no);
		map.put("board_no", board_no);
		
		PostVO pvo = service.selectDetailPost(map);
		request.setAttribute("pvo", pvo);
		
		request.getRequestDispatcher("/WEB-INF/view/customerService/CsupdatePost.jsp").forward(request, response);
	}

}
