package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MyMemberVO;


@WebServlet("/InsertMember.do")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//String registers[] = request.getParameterValues("registerSubmit");
		//registers[]배열에서 애들어떻게 꺼내냐고..
		
		//배열로 하지 마시고 하나씩 꺼내시죵
		String memid =request.getParameter("memid");
		String password =request.getParameter("password");
		String memname =request.getParameter("memname");
		String tel =request.getParameter("tel");
		String addr =request.getParameter("addr");
		
		//이제 이 값들을 memvo에 넣어볼까나~~-. set어쩌구
		//memvo를 불러오려면 뭘해야하나
		//vo의 getter, setter를 쓰려면?
		MyMemberVO vo = new MyMemberVO();
		vo.setMem_id(memid);
		vo.setMem_pass(password);
		vo.setMem_name(memname);
		vo.setMem_tel(tel);
		vo.setMem_addr(addr);
		
		//service단에서 일처리
		//insertmember
		//service객체
		IMemberService service = MemberServiceImpl.getInstance();
		
		//service단의 메소드 실행
		int cnt=0;
		cnt = service.insertList(mvo);
		
		
		
		//<insert id="insertList" parameterType="myMemberVo" >
		insert into MYMEMBER( mem_id, mem_pass, mem_name, mem_tel, mem_addr)
		values(#{mem_id},#{mem_pass},#{mem_name},#{mem_tel},#{mem_addr})
	</insert>
	}

}
