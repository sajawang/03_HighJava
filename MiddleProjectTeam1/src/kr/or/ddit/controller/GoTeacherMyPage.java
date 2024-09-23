package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.MyPagePostServiceImpl;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.PostVO;

@WebServlet("/goTeacherMyPage.do")
public class GoTeacherMyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//세션에서 아이디 받아오기
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
		
		//세션에서 받아온 아이디로 내 이용문의 목록 가져오기
		MyPagePostServiceImpl service = MyPagePostServiceImpl.getInstance();
		List<PostVO> list = service.getAllBoardThree(sw);
		/*
		 * for (PostVO postVO : list) { int post_no =postVO.getPost_no(); CommentVO cvo
		 * = service.selectComment(post_no); if(cvo!=null) {
		 * request.setAttribute("commentYN", "Y"); //배열에 담아서 가져간다... } }
		 */
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/memberMypage/teacherMyPageBoardThree.jsp").forward(request, response);
		
		
		
		//response.sendRedirect("/WEB-INF/view/memberMypage/teacherMyPageBoardThree.jsp");
	}

}
