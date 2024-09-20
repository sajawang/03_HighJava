package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IMaterialService;
import kr.or.ddit.service.IMathSettingService;
import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.service.MathSettingServiceImpl;
import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ViewListVO;

@WebServlet("/tenMinuteViewMaterialist.do")
public class TenMinuteViewMaterialist extends HttpServlet {
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
		
		
		//세션에 있는 아이디가 mathsetting테이블에 없으면
		//mathsetting insert jsp로 가기
		IMathSettingService service2 = MathSettingServiceImpl.getInstance();
		MathSettingVO vo =  service2.getMathSetting(sw);
		
		if(vo==null) {
			request.getRequestDispatcher("/WEB-INF/view/memberMypage/firstTenMinMath.jsp").forward(request, response);
		} else {
			IMaterialService service = MaterialServiceImpl.getInstance();
			//세션에 아이디 따오기
			List<ViewListVO> mlist = service.getViewMaterial(sw);
			
			request.setAttribute("mlist", mlist);
			
			request.getRequestDispatcher("/WEB-INF/view/memberMypage/tenMinMathMain.jsp").forward(request, response);
		}
		
	}
}
