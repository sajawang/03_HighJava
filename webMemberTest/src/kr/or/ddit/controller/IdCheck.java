package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MyMemberVO;

@WebServlet("/IdCheck.do")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전송데이터 가져오기 - id
		String id=request.getParameter("id");
		//System.out.println("ID: " + id);
		//오홍 아이디는 잘 가져왔네!!
		
		//service객체 가져오기
		IMemberService service = MemberServiceImpl.getInstance();
		//service메소드 호출하기
		MyMemberVO vo = service.selectOneMember(id);
		/*
		 * if (vo == null) { System.out.println("No member found with ID: " + id); }
		 * else { System.out.println("Member found: " + vo); }
		 */
		
		//ajax에서 요청이 왔을땐 Gson으로 처리하는게 편함
		//처리한 결과를 JSON형태의 문자열로 변환한 후 이 문자열을 응답으로 보낸다.
		String jsonData = null;	
		Gson gson = new Gson();
		gson.toJson(vo);
		
		//응답으로 보낼때 
		PrintWriter out = response.getWriter();	//PringWriter로 출력만했다
		out.write(jsonData);
		response.flushBuffer();

		
		
	}

}
