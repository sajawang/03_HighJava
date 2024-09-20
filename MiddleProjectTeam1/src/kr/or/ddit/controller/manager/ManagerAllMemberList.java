package kr.or.ddit.controller.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/managerAllMemberList.do")
public class ManagerAllMemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		IMemberService service = MemberServiceImpl.getInstance();
		List<MemberVO> list = service.selectAllMember();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/ManagerTenMinuteMath/managerTenMinuteMathMemberAllList.jsp").forward(request, response);
	}
}






























