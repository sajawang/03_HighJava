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

@WebServlet("/AdminTenMathList.do")
public class AdminTenMathList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
     

	
	   request.getRequestDispatcher("/WEB-INF/view/adminTenMath/adminTenMathList.jsp").forward(request, response);

		

	}
	
}
