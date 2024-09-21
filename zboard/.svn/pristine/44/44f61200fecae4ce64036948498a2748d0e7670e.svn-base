package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import kr.or.ddit.service.AdmMaterialServiceImpl;
import kr.or.ddit.service.IAdmMaterialService;
import kr.or.ddit.vo.QuestionVO;

/**
 * Servlet implementation class GetQuestionList
 */
@WebServlet("/getQuestionList.do")
public class GetQuestionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("application/json;charset=utf-8");

	List<QuestionVO> qVo = null;

	try {
		IAdmMaterialService service = AdmMaterialServiceImpl.getInstance();
	
		qVo=service.getQuestionList();
		
		Gson gson = new Gson();
		
		String data = gson.toJson(qVo);
		
		PrintWriter out = response.getWriter();
		out.print(data);
		response.flushBuffer();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
