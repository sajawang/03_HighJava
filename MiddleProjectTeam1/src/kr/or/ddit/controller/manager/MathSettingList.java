package kr.or.ddit.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMathSettingService;
import kr.or.ddit.service.MathSettingServiceImpl;
import kr.or.ddit.vo.MathSettingVO;

@WebServlet("/mathSettingList.do")
public class MathSettingList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IMathSettingService service = MathSettingServiceImpl.getInstance();
		List<MathSettingVO> mathsettinglist = service.getAllMathSetting();
		
		request.setAttribute("mathsettinglist", mathsettinglist);
		
		request.getRequestDispatcher("/ManagerTenMinuteMath/managerTenMinuteMathMain.jsp").forward(request, response);
	}
}
















