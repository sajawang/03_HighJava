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

import kr.or.ddit.service.AdminInquiriesServiceImpl;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.PostVO;

/**
 * 관리자 이용문의 게시판 리스트 출력
 */
@WebServlet("/adminInquiriesList.do")
public class AdminInquiriesList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 요청에서 페이지 번호 받아오기 (기본값 1)
        int currentPage = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

        AdminInquiriesServiceImpl service = AdminInquiriesServiceImpl.getInstance();

        // 페이징 정보 가져오기
        PageVO pageVO = service.pageInfo(currentPage, "stype", "sword");

        // map으로 페이징 정보 전송
        Map<String, Object> map = new HashMap<>();
        map.put("start", pageVO.getStart());
        map.put("end", pageVO.getEnd());
        map.put("board_no", 3); // board_no를 적절히 설정

        // 리스트 조회
        List<PostVO> list = service.selectPostList(map);

        // 결과를 요청 객체에 저장
        request.setAttribute("list", list);
        request.setAttribute("pageVO", pageVO);

        request.getRequestDispatcher("/WEB-INF/view/adminInquiries/adminInquiriesList.jsp").forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
