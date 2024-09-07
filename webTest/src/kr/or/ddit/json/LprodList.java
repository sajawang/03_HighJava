package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import kr.or.ddit.service.ILprodService;
import kr.or.ddit.service.LprodServiceImpl;
import kr.or.ddit.vo.LprodVO;

@WebServlet("/lprodList.do")
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		ILprodService service=LprodServiceImpl.getService();
		List<LprodVO> list = service.selectLprodList();
		
		Gson gson = new Gson();
		String jsonData = null;
		
		
		jsonData = gson.toJson(list);

		PrintWriter out = response.getWriter();
		out.write(jsonData);
		response.flushBuffer();
		
	}

}
