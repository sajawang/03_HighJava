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
import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ViewListVO;

@WebServlet("/material/playMaterial.do")
public class PlayMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		HttpSession session = request.getSession();
		String cusId = null;

		MemberVO memVo=(MemberVO)session.getAttribute("memVo");
		if(memVo!=null){
			cusId = memVo.getCus_id();
		}
		
		IMaterialService service = MaterialServiceImpl.getInstance();
		System.out.println(cusId);
		MathSettingVO mSVo = service.getMathMinute(cusId);
		String mSMinute = null;
		int iMSMinute = 0;
		if(mSVo != null) {
			mSMinute = mSVo.getMathsetting_minute(); //1번째 오류
		}
		
		if(mSMinute != null && mSMinute.equals("10분")) { //2번째 오류
			iMSMinute = 600000;
		} else if (mSMinute != null && mSMinute.equals("20분")) {
			iMSMinute = 1200000;
		} else if (mSMinute != null && mSMinute.equals("30분")) {
			iMSMinute = 1800000;
		}
		
		int mno = Integer.parseInt(request.getParameter("mno"));
		int vgu = Integer.parseInt(request.getParameter("vgu"));
		
		String resOn = request.getParameter("resOn");
		List<ViewListVO> answerList = null;
		if(request.getParameter("resOn") != "N" || request.getParameter("resOn").equals("Y")) {
			ViewListVO viewVo = new ViewListVO();
			viewVo.setCus_id(cusId);
			viewVo.setView_gu(String.valueOf(vgu));
			answerList = service.getMyAnswer(viewVo);
		}
		
		List<MaterialVO> list = service.getMaterQuestionFile(mno);
		
		request.setAttribute("minute", iMSMinute);
		request.setAttribute("materList", list);
		request.setAttribute("mno", mno);
		request.setAttribute("vgu", vgu);
		request.setAttribute("resOn", resOn);
		request.setAttribute("answerList", answerList);
		
		System.out.println("resOn : " +resOn);
		
		request.getRequestDispatcher("/WEB-INF/view/material/playMaterial.jsp").forward(request, response);
	}
}
