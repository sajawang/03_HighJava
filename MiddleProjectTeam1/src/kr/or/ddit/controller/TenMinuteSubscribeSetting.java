
package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.MathSettingServiceImpl;
import kr.or.ddit.vo.MathSettingVO;

@WebServlet("/tenMinuteSubscribeSetting.do")
public class TenMinuteSubscribeSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/memberMypage/tenMinuteSubscribeSetting.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//세션에서 아이디설정해주쇼
		
		String mathsetting_minute = request.getParameter("setGoalTime");
		String mathsetting_grade = request.getParameter("setGrade")+request.getParameter("setSemester");
		String mathsetting_level = request.getParameter("setLevel");
		String mathsetting_agree = request.getParameter("personalInfoConsent");
		
		if(mathsetting_agree != null) {
			mathsetting_agree="Y";	
		}
		
		MathSettingVO mathVo = new MathSettingVO();
		mathVo.setCus_id("a001");
		mathVo.setMathsetting_minute(mathsetting_minute);
		mathVo.setMathsetting_grade(mathsetting_grade);
		mathVo.setMathsetting_level(mathsetting_level);
		mathVo.setMathsetting_agree(mathsetting_agree);
		
		//서비스랑 연결
		MathSettingServiceImpl service = MathSettingServiceImpl.getInstance();
		service.selfUpdateMath(mathVo);
		
		//리스트 받고-> 메인으로 갈것임
		// Redirect to TenMinuteViewMaterialist servlet
	    response.sendRedirect("tenMinuteViewMaterialist.do");
		
		//매일10분수학 메인으로 가기
		//request.getRequestDispatcher("/WEB-INF/view/memberMypage/tenMinMathMain.jsp").forward(request, response);
		
	}

}
