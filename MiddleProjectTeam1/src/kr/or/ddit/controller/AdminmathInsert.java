package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dao.AdminMathSettingDaoImpl;
import kr.or.ddit.dao.IAdminMathSettingDao;
import kr.or.ddit.vo.MathSettingVO;


@WebServlet("/AdminmathInsert.do")
public class AdminmathInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("utf-8");
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("application/json");  // 응답 타입을 JSON으로 설정
	        
	        // 요청으로부터 입력 데이터 받기
	        String cusId = request.getParameter("cus_Id");
	        String minute = request.getParameter("mathsetting_minute");
	        String grade = request.getParameter("mathsetting_grade");
	        String level = request.getParameter("mathsetting_level");

	        // VO 객체 생성 및 값 설정
	        MathSettingVO mvo = new MathSettingVO();
	        mvo.setCus_id(cusId);
	        mvo.setMathsetting_minute(minute);
	        mvo.setMathsetting_grade(grade);
	        mvo.setMathsetting_level(level);

	        // 서비스 호출
	        IAdminMathSettingDao service = AdminMathSettingDaoImpl.getInstance();
	        int result = service.insertStudent(mvo);

	        // JSON 응답 작성
	        PrintWriter out = response.getWriter();
	        if (result > 0) {
	            out.print("{\"status\":\"success\"}");  // 성공 응답
	        } else {
	            out.print("{\"status\":\"failure\", \"message\":\"학생 등록에 실패했습니다.\"}");  // 실패 응답
	        }
	        out.flush();
	    }
	}

