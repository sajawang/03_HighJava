package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.CustomerServiceImpl;
import kr.or.ddit.service.ICustomerService;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class IdFindController
 */
@WebServlet("/idFindController.do")
public class IdFindController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
		//회원가입 html(사이트에서 보낸) 전송데이터 받기 이름과 이메일
    	
    	//로그인 페이지 아래에 아이디 찾기 버튼을 클릭
    	//jsp에서 클릭하면 모달창으로? 아이디와 패스워드 입력하는 창이 출력되고 값을 입력한다.
    	//모달창에서 submit 전송 버튼을 누르면 idFind로 값을 전달한다.
    	//값을 받아서 입력받은 값으로 쿼리를 돌려 id를 받고 다시 리턴해준다
    	System.out.println("idFindController 도착");
    	
		String userName=request.getParameter("name");
		String userEmail=request.getParameter("mail");
		
		System.out.println("1");
		
		System.out.println(userName+" 공백기가ㅏㄱ ");
		System.out.println(" 공백기가ㅏㄱ "+userEmail);
		
		MemberVO memVo = new MemberVO();
		
		memVo.setMem_name(userName);
		memVo.setMem_mail(userEmail);
		
		
		
		ICustomerService service = CustomerServiceImpl.getInstance();
		
		String userId = service.idFind(memVo);
		
		System.out.println("아읻디찾기"+userId);
		
		
		request.setAttribute("userId", userId);
		
		request.getRequestDispatcher("/WEB-INF/view/LoginInsertUserMember/idFind.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
