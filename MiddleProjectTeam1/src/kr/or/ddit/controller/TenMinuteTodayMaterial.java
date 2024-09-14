package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.IMathSettingService;
import kr.or.ddit.service.MathSettingServiceImpl;
import kr.or.ddit.vo.MathSettingVO;

@WebServlet("/tenMinuteTodayMaterial.do")
public class TenMinuteTodayMaterial extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//세션에서 아이디 가져와서 매일 10분수학설정의 선택학년, 선택난이도 가져오기
		IMathSettingService service = MathSettingServiceImpl.getInstance();
		MathSettingVO mvo = service.getMathSetting("a001");
		
		String material_grade=mvo.getMathsetting_grade();
		String material_level=mvo.getMathsetting_level();
		
		String material_grade_first=material_grade.substring(3,4);
		String material_grade_second=material_grade.substring(7,8);
		
		System.out.println(material_grade_first);
		System.out.println(material_grade_second);
		
		material_grade = material_grade_first+"-"+material_grade_second;
		
		
		if(material_grade.equals("3-1")&&material_level.equals("기본")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
	    }
		if(material_grade.equals("3-1")&&material_level.equals("심화")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("3-2")&&material_level.equals("기본")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("3-2")&&material_level.equals("심화")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("4-1")&&material_level.equals("기본")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("4-1")&&material_level.equals("심화")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("4-2")&&material_level.equals("기본")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("4-2")&&material_level.equals("심화")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("5-1")&&material_level.equals("기본")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("5-2")&&material_level.equals("심화")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("6-1")&&material_level.equals("기본")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("6-1")&&material_level.equals("심화")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("6-2")&&material_level.equals("기본")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
		if(material_grade.equals("6-2")&&material_level.equals("심화")) {
			//jsp주소 입력
			//request.getRequestDispatcher("/WEB-INF/view/memberMypage/memberUpdateForm.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
