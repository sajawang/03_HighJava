package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.CustomerServiceImpl;
import kr.or.ddit.service.ICustomerService;
import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.CommentVO;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.FavoriteVO;
import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PostVO;
import kr.or.ddit.vo.ViewListVO;

/**
 * Servlet implementation class SessionLogin
 */
@WebServlet("/sessionLoginDb.do")
public class SessionLoginDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인증번호 시스템
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		//입력값 가져오기
		String id = (String)request.getParameter("cus_id");
		String pass = (String)request.getParameter("cus_pw");
		
		System.out.println(id+"  "+pass);
		
		if("admin".equals(id)) {
			if("admin1".equals(pass)) {
				session.setAttribute("admin", id);
		    	request.getRequestDispatcher("/WEB-INF/view/admin/AdminMain.jsp").forward(request, response);
			}else {
				response.sendRedirect("/index.jsp");
			}
		}
		
		CustomerVO cusVo = new CustomerVO();
		cusVo.setCus_id(id);
		cusVo.setCus_pw(pass);
		
		MemberVO memVo = new MemberVO();
		memVo.setCus_id(id);
		
		//로그인을 해서 모든 아이디의 정보가 들어간 테이블의 VO를 세션에 집어넣고 필요한 페이지에서 getAttri를 해서 필요한 vo값을 가져온다.
		
		
		System.out.println("try전");
		try {
			//service 호출
			System.out.println("서비스 연결");
			ICustomerService service = CustomerServiceImpl.getInstance();
			//결과값 가져오기 = service -> dao로 이동함.
			System.out.println("결과 전");
			CustomerVO vo = service.getLoginUser(cusVo);
			if(vo==null) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			System.out.println("결과");
			
//			int lplp = service.getLoginMemberPoint(memVo);
//			MemberVO logVo = service.getLoginMember(memVo);
//			int lplp = service.getLoginMemberPoint(memVo);
			MemberVO logVo = service.getLoginMemberPoint(memVo);
			
//			int memberPoint = logVo.getMem_point();
			
			String del = vo.getCus_del();
					
			
			
			if("Y".equals(del)||vo==null) {
//				session.setAttribute("id", id);
//				response.sendRedirect(request.getContextPath()+"/index.jsp");
//				response.sendRedirect(request.getContextPath()+"/index.jsp");
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
			}
			String userId=vo.getCus_id();
			String userPass=vo.getCus_pw();
			String userGu=vo.getCus_gu();
			
//			String da = service.getSysdateLog(userId);
//			
//			//세션 작업하기
//			int countMate = service.getCountMate();
//			int countViewList = service.getCountViewList(userId);
			
			//로그인 처리
			if(id!=null&&pass!=null) {
//				if((userId.equals(id)&&userPass.equals(pass))||(userId.equals(id)&&pass.equals(ren))) {
				if(userId.equals(id)&&userPass.equals(pass)) {
					System.out.println("성공 세션에 값 저장");
					session.setAttribute("id", id);
					session.setAttribute("userGu", userGu);
					
					//vo저장 지울 수도 있음.
					session.setAttribute("memVo", logVo);
//					session.setAttribute("fVo", fVo);
//					session.setAttribute("vVo", vVo);
//					session.setAttribute("pVo", pVo);
//					session.setAttribute("mVo", mVo);
//					session.setAttribute("cVo", cVo);
//					session.setAttribute("aVo", aVo);
					
					//일일 그래프 출력용 데이터
//					session.setAttribute("sysdate", da);
//					//학습지 전체 그래프 출력용 데이터
//					session.setAttribute("countMate", countMate);
//					session.setAttribute("countViewList", countViewList);
					System.out.println(session.getId());
					response.sendRedirect(request.getContextPath()+"/index.jsp");
					
				}else{					
					
					session.setAttribute("id", id);
					System.out.println("실패");
					response.sendRedirect(request.getContextPath()+"/index.jsp");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
