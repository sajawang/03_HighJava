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

import com.google.gson.Gson;

import kr.or.ddit.service.ITeacherLibraryService;
import kr.or.ddit.service.TeacherLibraryServiceImpl;
import kr.or.ddit.vo.PListVO;
import kr.or.ddit.vo.PageVO;
import kr.or.ddit.vo.PostVO;

@WebServlet("/teacher/goSemTalkTalkList.do")
public class GoSemTalkTalkList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/teacher/semTalkTalkList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//service객체 얻기
		ITeacherLibraryService service = TeacherLibraryServiceImpl.getInstance();
		
		// 전송데이터 가져오기
		String reqData = StreamData.dataChange(request);
		
		// 역직렬화 - PListVO - json형식을 자바객체형식으로 변환
		Gson gson = new Gson();
		PListVO vo = gson.fromJson(reqData, PListVO.class);
		// vo.setPage(1), vo.setStype(""), vo.setSword("");
		
		//service객체 얻기
		
		// list를 가져오기 위한 Page정보 가져오기 
		PageVO pvo = service.pageInfo(vo.getPage(), vo.setStype(), vo.setSword());
		// start, end, startPage, endPage, totalPage
		
		// list 가져오기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start" , pvo.getStart());
		map.put("end"   , pvo.getEnd());
		
		// list 가져오기 - 메소드 호출
		List<PostVO> list = service.getAllTeacherLib(map);
		
		// 결과값을 request에 저장
		request.setAttribute("list", list);
		request.setAttribute("startPage", pvo.getStartPage());
		request.setAttribute("endPage", pvo.getEndPage());
		request.setAttribute("totalPage", pvo.getTotalPage());
		
		// view페이지로 이동
		request.getRequestDispatcher("/WEB-INF/view/teacher/teacherLibraryPage.jsp").forward(request, response);
	}

}
