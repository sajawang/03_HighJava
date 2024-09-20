package kr.or.ddit.controller.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.MathSettingServiceImpl;
import kr.or.ddit.vo.MathSettingVO;

@WebServlet("/managerTenMinuteUpdate.do")
public class ManagerTenMinuteUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String cus_id=request.getParameter("cusid");
		String mathsetting_minute = request.getParameter("setGoalTime");
		String mathsetting_grade = request.getParameter("setGrade")+request.getParameter("setSemester");
		String mathsetting_level = request.getParameter("setLevel");
		String mathsetting_agree = request.getParameter("personalInfoConsent");
		
		MathSettingVO mathVo = new MathSettingVO();
		mathVo.setCus_id(cus_id);
		mathVo.setMathsetting_minute(mathsetting_minute);
		mathVo.setMathsetting_grade(mathsetting_grade);
		mathVo.setMathsetting_level(mathsetting_level);
		mathVo.setMathsetting_agree(mathsetting_agree);
		
		//서비스랑 연결
		MathSettingServiceImpl service = MathSettingServiceImpl.getInstance();
		service.selfUpdateMath(mathVo);
		
		// Redirect to TenMinuteViewMaterialist servlet
	    response.sendRedirect("mathSettingList.do");

	    //request.getRequestDispatcher("/WEB-INF/view/memberMypage/tenMinMathMain.jsp").forward(request, response);
		
	}
}
