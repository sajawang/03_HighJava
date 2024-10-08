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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.service.CSPostServiceImpl;
import kr.or.ddit.vo.PListVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.PostVO;

/**
 * 고객센터 게시판 이동 서블릿
 */
@WebServlet("/customerService.do")
public class CustomerService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");

	        // 전송 데이터 가져오기 - 페이지 번호, 검색어(sword)
	        String reqData = StreamData.dataChange(request);
	        
	        // 역직렬화 - PListVO json 형식을 PListVO 객체 형식으로 변환
	        Gson gson = new Gson();
	        PListVO plvo = gson.fromJson(reqData, PListVO.class);

	        // 기본값 설정
	        String target = request.getParameter("target");

	        // 서비스 객체 얻기
	        CSPostServiceImpl service = CSPostServiceImpl.getInstance();
	        PageVO pvo = service.pageInfo(plvo.getBoard_no(), plvo.getPage(), plvo.getStype(), plvo.getSword());

	        // 리스트 가져오기
	        Map<String, Object> map = new HashMap<>();
	        map.put("start", pvo.getStart());
	        map.put("end", pvo.getEnd());
	        map.put("stype", plvo.getStype());
	        map.put("sword", plvo.getSword());
	        map.put("board_no", plvo.getBoard_no());
	        
	        List<PostVO> list = service.selectPostList(map);

	        // setAttribute로 결과값 저장
	        request.setAttribute("list", list);
	        request.setAttribute("startPage", pvo.getStartPage());
	        request.setAttribute("endPage", pvo.getEndPage());
	        request.setAttribute("totalPage", pvo.getTotalPage());

	        // target 값이 있으면 해당 페이지로 포워딩, 없으면 기본 페이지로 이동
	        if (target != null && !target.isEmpty()) {
	            request.getRequestDispatcher(target).forward(request, response);
	        } else {
	        	//list로 이동
	            request.getRequestDispatcher("/WEB-INF/view/customerService/CspostList.jsp").forward(request, response);
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	}
