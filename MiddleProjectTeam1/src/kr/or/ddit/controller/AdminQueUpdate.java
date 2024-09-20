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
import kr.or.ddit.vo.QuestionVO;

/**
 * Servlet implementation class AdminQueUpdate
 */
@WebServlet("/adminQueUpdate.do")
public class AdminQueUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("utf-8");
		IAdmMaterialService service = AdmMaterialServiceImpl.getInstance();
		IQuestionService QService = QuestionServiceImpl.getInstance();
	   
		 for (int i = 1; i <= 5; i++) {
			 int fileCnt = 0;
			 Integer mateFileNum=null;
			 int cnt=0;
			 int 	materialNo =0;	
			 String questionContent =null; 
			 String questionAnswer  =null;
			 String questionSolve   =null;
			 
			 QuestionVO qVo = null;
					 
			 qVo= new QuestionVO();
			 
	         // 각 문제에 대한 데이터를 가져옴
//	         int questionNo = Integer.parseInt(request.getParameter("question_no" + i));
	          materialNo	  = Integer.parseInt(request.getParameter("material_no" + i));
	          questionContent = request.getParameter("question_content" + i);
	          questionAnswer  = request.getParameter("question_answer" + i);
	          questionSolve   = request.getParameter("question_solve" + i);
	         
	         //사진
	         String filesName = request.getParameter("files_no" + i);
	    	
	         System.out.println(materialNo+" "+questionContent+" "+questionAnswer+" "+questionSolve+" "+filesName);
	         
		
		 
		 
		 
		 
		 
		 }
	   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
