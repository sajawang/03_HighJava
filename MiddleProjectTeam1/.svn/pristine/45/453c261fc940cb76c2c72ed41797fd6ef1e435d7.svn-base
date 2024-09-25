package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dao.AdminMathSettingDaoImpl;
import kr.or.ddit.dao.IAdminMathSettingDao;


@WebServlet("/Adminmathdelete.do")
public class Adminmathdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=UTF-8");
		IAdminMathSettingDao service = AdminMathSettingDaoImpl.getInstance();
		// 클라이언트에서 보낸 cusId를 받아옴
        String cusId = request.getParameter("cusId");

        
        int result = service.deleteAdminMath(cusId);
      
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        
        // 성공 여부를 JSON으로 변환
        Map<String, String> resultMap = new HashMap<>();
        if (result > 0) {
            resultMap.put("status", "success");
        } else {
            resultMap.put("status", "error");
        }
        
        String json = gson.toJson(resultMap);
        out.print(json);
        out.flush();
    }

}
