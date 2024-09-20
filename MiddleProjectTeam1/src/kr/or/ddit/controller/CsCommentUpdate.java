package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.CSPostServiceImpl;
import kr.or.ddit.vo.CommentVO;

/**
 * 댓글업데이트
 */
@WebServlet("/csCommentUpdate.do")
public class CsCommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//전송데이터받기
		String reqData = StreamData.dataChange(request);
		//역직렬화 - 자바 객체로
		Gson gson = new Gson();
		CommentVO cvo = gson.fromJson(reqData, CommentVO.class);
		//service객체 얻기
		CSPostServiceImpl service = CSPostServiceImpl.getInstance();
		int cnt = service.updateComment(cvo);
		//request에 결과값을 저장
		request.setAttribute("result", cnt);
		//view페이지로 이동
		request.getRequestDispatcher("/WEB-INF/view/customerService/result.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
