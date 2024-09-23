package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmMaterialServiceImpl;
import kr.or.ddit.service.IAdmMaterialService;
import kr.or.ddit.service.IQuestionService;
import kr.or.ddit.service.QuestionServiceImpl;

/**
 * Servlet implementation class AdminMateDelete
 */
@WebServlet("/adminMateDelete.do")
public class AdminMateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		IAdmMaterialService service = AdmMaterialServiceImpl.getInstance();
		IQuestionService Qservice = QuestionServiceImpl.getInstance();
		
		
		
		
		
		int mateNo = Integer.parseInt(request.getParameter("mateNo"));
	
		System.out.println("서블릿에서 가져온 mateNo" + mateNo);
		
		
		int cnt = service.deleteMaterial(mateNo);
		int delCnt = 0;
		
		if(cnt==1) {
			//해당 학습지 번호에 해당하는 문제를 삭제한다.
			delCnt = Qservice.deleteQuestion(mateNo);
			
		}
		
		
		
		
		
		request.setAttribute("result1", delCnt);
		
		request.getRequestDispatcher("/WEB-INF/view/adminMaterial/result1.jsp").forward(request, response);

	
	}

}
