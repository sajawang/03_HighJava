package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.ILprodService;
import kr.or.ddit.service.LprodServiceImpl;
import kr.or.ddit.vo.LprodVO;

@WebServlet("/lprodList2.do")
public class LprodList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		ILprodService service=LprodServiceImpl.getService();
		List<LprodVO> list = service.selectLprodList();
		
		//View로 보낼 데이터를 저장한다.
		request.setAttribute("lprodList", list);
		
		//경로의 첫 시작이 WebContent
		RequestDispatcher rd = request.getRequestDispatcher("/basic/json/lprodList.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


















































