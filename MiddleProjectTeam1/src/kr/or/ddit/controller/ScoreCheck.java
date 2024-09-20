package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.IMaterialService;
import kr.or.ddit.service.IQuestionService;
import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.service.QuestionServiceImpl;
import kr.or.ddit.vo.AttemptVO;
import kr.or.ddit.vo.QuestionVO;

@WebServlet("/material/scoreCheck.do")
public class ScoreCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String test1 = request.getParameter("test1");
		String test2 = request.getParameter("test2");
		String test3 = request.getParameter("test3");
		String test4 = request.getParameter("test4");
		String test5 = request.getParameter("test5");
		List<String> testList = new ArrayList<String>();
		testList.add(test1);
		testList.add(test2);
		testList.add(test3);
		testList.add(test4);
		testList.add(test5);
		
		List<String> answerList = new ArrayList<String>();
		Map<String, String> checkMap = new HashMap<String, String>();
		int mno = Integer.parseInt(request.getParameter("mno"));
		int vgu = Integer.parseInt(request.getParameter("vgu"));
		int score = 0;
		IQuestionService Qservice = QuestionServiceImpl.getInstance();
		
		List<QuestionVO> list = Qservice.getAnswerList(mno);
		
		for(QuestionVO vo : list) {
			answerList.add(vo.getQuestion_answer());
		}
		for(int i=0; i<testList.size(); i++) {
			if(testList.get(i).equals(answerList.get(i)) == true) {
				checkMap.put("test"+i, "true");
				score = score + 20;
			} else {
				checkMap.put("test"+i, "false");
			}
		}
		// 학습지 내역리스트 등록
		IMaterialService Mservice = MaterialServiceImpl.getInstance();
		Map<String, Object> idmateNoMap = new HashMap<String, Object>();
		
		// 아이디값
		//idmateNoMap.put("cusId", cusId);
		idmateNoMap.put("cusId", "a001");
		idmateNoMap.put("mateNo", mno);
		idmateNoMap.put("viewGu", vgu);
		idmateNoMap.put("score", score);
		
		int cnt = Mservice.insertViewList(idmateNoMap);
		if(cnt > 0) {
			System.out.println("내역 등록 성공");			
		} else {
			System.out.println("내역 등록 실패");
		}
		
		int viewNo = (int) idmateNoMap.get("viewNo");
		
		// 내가 쓴 정답 등록
		AttemptVO vo = new AttemptVO();
		// 아이디값
		// vo.setUser_id(cusId);
		vo.setUser_id("a001");
		vo.setView_no(viewNo);
		String Result = null;
		String myAnswer = null;
		
		for(int i=0; i<testList.size(); i++) {
			if(testList.get(i).equals(answerList.get(i)) == true) {
				Result = "Y";
			} else {
				Result = "N";
			}
			vo.setAttempt_result(Result);
			myAnswer = testList.get(i);
			vo.setAttempt_myanswer(myAnswer);
			
			int cnt2 = Mservice.insertAttempt(vo);
			
			if(cnt2 > 0) {
				System.out.println("내가 쓴 문제 등록 성공");			
			} else {
				System.out.println("내가 쓴 문제 등록 실패");
			}
		}
		
		
		
		System.out.println(checkMap.toString());
		
		Gson gson = new Gson();
		
		String jsonData = gson.toJson(checkMap);

		// JSON문자열 확인용
		System.out.println("jsonData = " + jsonData);
		
		PrintWriter out = response.getWriter();
		out.write(jsonData);
		response.flushBuffer();
	}
}
