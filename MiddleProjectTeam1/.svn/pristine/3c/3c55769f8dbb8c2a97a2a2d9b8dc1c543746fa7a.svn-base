package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dao.AdminMathSettingDaoImpl;
import kr.or.ddit.dao.IAdminMathSettingDao;
import kr.or.ddit.vo.MathSettingVO;

@WebServlet("/AdminTenList.do")
public class AdminTenlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=UTF-8");
		
		IAdminMathSettingDao service = AdminMathSettingDaoImpl.getInstance();
		
		List<MathSettingVO> studentList = service.getAllStudent();
		System.out.println("너 있니?"+ studentList);
		// JSON으로 변환
        Gson gson = new Gson();
        String json = gson.toJson(studentList);
		
        PrintWriter out = response.getWriter();
	    out.print(json);
	    out.flush();
        // 응답으로 JSON 반환
     

	
	//	request.getRequestDispatcher("/adminStudent/StudentList.jsp").forward(request, response);

		

	}
	
}
