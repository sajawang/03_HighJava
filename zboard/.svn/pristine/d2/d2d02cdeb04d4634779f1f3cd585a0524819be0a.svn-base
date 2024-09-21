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

@WebServlet("/material/playMaterial.do")
public class PlayMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
//		String da= (String)session.getAttribute("userGu"); // 회원의 종류 - 학생 - 선생님 값 가져오기
//
//		String sw = null;
//		int eq = 0;
//
//		MemberVO memVo=(MemberVO)session.getAttribute("memVo");
//		if(memVo!=null){
//		   sw = memVo.getCus_id();
//		   eq = memVo.getMem_point();
//		}
		
		int mno = Integer.parseInt(request.getParameter("mno"));
		int vgu = Integer.parseInt(request.getParameter("vgu"));
		
		IMaterialService service = MaterialServiceImpl.getInstance();
		
		List<MaterialVO> list = service.getMaterQuestionFile(mno);
		
		request.setAttribute("materList", list);
		request.setAttribute("mno", mno);
		request.setAttribute("vgu", vgu);
		
		request.getRequestDispatcher("/WEB-INF/view/material/playMaterial.jsp").forward(request, response);
	}
}
