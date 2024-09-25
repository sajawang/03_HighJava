package kr.or.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dao.AdminMathSettingDaoImpl;
import kr.or.ddit.dao.IAdminMathSettingDao;
import kr.or.ddit.vo.MathSettingVO;


@WebServlet("/AdminmathUpdate.do")
public class AdminmathUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=UTF-8");

        IAdminMathSettingDao service = AdminMathSettingDaoImpl.getInstance();

        // 특정 학생 설정 조회 (cusId 파라미터를 받아서 처리)
        String cusId = request.getParameter("cus_id");
        // 학생 수학 설정 정보를 리스트로 반환하지 않고, 개별 VO 객체를 반환하는 것이 적절
        MathSettingVO mvo = service.getCusId(cusId);  // 조회하는 DAO 메소드가 필요

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(mvo);

        out.print(json);
        out.flush();
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		    response.setCharacterEncoding("utf-8");
		    response.setContentType("application/json; charset=UTF-8");

		    // DAO 객체 생성
		    IAdminMathSettingDao service = AdminMathSettingDaoImpl.getInstance();

		    // 클라이언트로부터 업데이트할 데이터를 받음
		    String cusId = request.getParameter("cus_Id");
		    String minute = request.getParameter("mathsetting_minute");
		    String grade = request.getParameter("mathsetting_grade");
		    String level = request.getParameter("mathsetting_level");

		    // VO 객체에 업데이트할 정보 설정
		    MathSettingVO mvo = new MathSettingVO();
		    mvo.setCus_id(cusId);
		    mvo.setMathsetting_minute(minute);
		    mvo.setMathsetting_grade(grade);
		    mvo.setMathsetting_level(level);

		    // 데이터를 삽입하거나 업데이트하는 로직 실행 (존재 여부에 따라 처리)
		    int result = service.saveOrUpdateMathSetting(mvo);

		    // 결과 응답
		    PrintWriter out = response.getWriter();
		    Gson gson = new Gson();

		    // 성공 여부를 JSON 형식으로 응답
		    if (result > 0) {
		        out.print(gson.toJson("success"));
		    } else {
		        out.print(gson.toJson("error"));
		    }

		    out.flush();
		}
}