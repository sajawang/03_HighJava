package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMaterialService;
import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.vo.MaterialVO;

@WebServlet("/material/admindetailMaterial.do")
public class AdminDetailMaterial2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		// 학습지 번호
		int mno = Integer.parseInt(request.getParameter("mno"));
		System.out.println(mno);
		
		IMaterialService service = MaterialServiceImpl.getInstance();
		
		MaterialVO vo = service.selectDetailMaterial(mno);
		
		request.setAttribute("materVo", vo);
		
		request.getRequestDispatcher("/WEB-INF/view/adminMaterial/admindetailMaterial.jsp").forward(request, response);
		
	}
}
