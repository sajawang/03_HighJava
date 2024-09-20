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

import kr.or.ddit.service.IMaterialService;
import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.vo.MaterialVO;

@WebServlet("/material/goMaterial.do")
public class GoMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		IMaterialService service = MaterialServiceImpl.getInstance();
		Map<String, Object> map = new HashMap<String, Object>();
		String school = (String) request.getParameter("school");
		if(school.equals("element")) {
			school = "초등";
		} else if (school.equals("middle")) {
			school = "중등";
		} else if (school.equals("high")) {
			school = "고등";
		}
		
		String grade = (String) request.getParameter("grade");
		String cate = "1";
		String level = "기본";
		
		map.put("school", school);
		map.put("grade", grade);
		map.put("cate", cate);
		map.put("level", level);
		
		List<MaterialVO> list = service.selectMaterial(map);
		int cnt = service.countMaterial(map);
		
		request.setAttribute("materList", list);
		request.setAttribute("cnt", cnt);
		request.setAttribute("school", school);
		request.setAttribute("grade", grade);
		request.setAttribute("cate", cate);
		request.setAttribute("level", level);
		
		request.getRequestDispatcher("/WEB-INF/view/material/materialList.jsp").forward(request, response);
	}
}
