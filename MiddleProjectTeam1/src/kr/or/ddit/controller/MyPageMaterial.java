package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ViewListVO;



@WebServlet("/myPageMaterial.do")
public class MyPageMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//session에서 아이디 받기
		// String sw = (String)session.getAttribute("id");
		HttpSession session = request.getSession();
		
		String da= (String)session.getAttribute("userGu"); // 회원의 종류 - 학생 - 선생님 값 가져오기

		String sw = null;
		int eq = 0;

		MemberVO memVo=(MemberVO)session.getAttribute("memVo");
		if(memVo!=null){
			sw = memVo.getCus_id();
			eq = memVo.getMem_point();
		}
		//----------------------------------------------------------------
		
		//service실행해서 list가져오기 - getMyMaterial
		MaterialServiceImpl service = MaterialServiceImpl.getInstance();
		List<ViewListVO> list = service.getMyMaterial(sw);
		System.out.println("list 마이페이지매테리알리스트"+list);
		//저장하기
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/memberMypage/mypageMyMaterial.jsp").forward(request, response);
		}
		

}




















