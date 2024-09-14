package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMaterialService;
import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/tenMinuteViewMaterialist.do")
public class TenMinuteViewMaterialist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IMaterialService service = MaterialServiceImpl.getInstance();
		
		//세션에 아이디 따오기
		List<MaterialVO> mlist = service.getViewMaterial("a001");
		

		
		request.setAttribute("mlist", mlist);
		
		request.getRequestDispatcher("/WEB-INF/view/memberMypage/tenMinMathMain.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
