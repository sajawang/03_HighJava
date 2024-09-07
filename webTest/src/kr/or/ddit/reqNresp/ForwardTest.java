package kr.or.ddit.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardTest
 */
@WebServlet("/forwardTest.do")
public class ForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * -forward방식
		 * 	1)특정 서블릿이나 JSP문서에 대한 요청을 다른 서블릿이나  JSP로 넘겨준다.
		 * 		(이때 HttpServletRequest객체와 HttpServletResponse객체를 공유한다.ㅏ
		 * 		그래서 파라미터를 공유할 수 있다.)
		 * 
		 *  2)서버 내부에서만 접근이 가능하다.
		 *  
		 *  3)사용자의 URL주소는 첫번째 문서의 주소가 두번째 문서의 주소로 바뀌지 않는다.
		 *  	(즉, 첫번째 문서의 주소가 유지된다.)
		 *  -----------------------------------------------------
		 *  이동하는 페이지로 데이터를 넘기려면 Request객체의 setAttribute()메서드를 이용하여
		 *  데이터를 셋팅하여 보내고, 
		 *  받는 쪽에서는 Request객체의 getAttribute()메서드로 데이터를 읽어온다.
		 *  
		 *  - 데이터 세팅 형식) Request객체.setAttribute("key값", 데이터);
		 *  		==> 'key값'은 문자열로 지정하고, '데이터'는 Java의 모든 자료형을 사용할 수 있다.
		 *  		
		 *  - 셋팅된 데이터 받기 형식) Request객체.getAttribute("key값"); 
		 */
		request.setAttribute("tel", "010-1234-5678"); //보낼 데이터 세팅
		
		//forward방식으로 이동하기
		// ==>Request객체의 getRequestDispatcher()메서드에 이동할 서블릿이나 JSP를 지정해준다.
		//		이때 주소는 전체  URI경로 중에서 ContextPath이후의 경로를 지정해주면 된다.
		
		//예) http://localhost/webTest/forwardTargetTEst.do (전체 URL주소)
		//		==> /forwardTargetTest.do	(ContextPath이후의 경로)
		RequestDispatcher rd = request.getRequestDispatcher("/forwardTargetTest.do");
		rd.forward(request, response);
		
	}
}


















