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
	   response.setCharacterEncoding("utf-8");
	   IAdmMaterialService service = AdmMaterialServiceImpl.getInstance();
	   IQuestionService QService = QuestionServiceImpl.getInstance();
	   
	   int fileCnt = 0;
	   Integer mateFileNum=null;
	   int cnt=0;
	   
	   
	   for (int i = 0; i <= 4; i++) {
		   int questionNo = 0;
		   int 	materialNo =0;	
		   String questionContent =null; 
		   String questionAnswer  =null;
		   String questionSolve   =null;
		   int fileNum = 0;
		   
		   QuestionVO qVo = null;
		   
		   
		   qVo= new QuestionVO();

		
		   // 각 문제에 대한 데이터를 가져옴
		   questionNo 	  = Integer.parseInt(request.getParameter("question_no" + i));
		   System.out.println("questionNo값 = "+questionNo);
		   materialNo	  = Integer.parseInt(request.getParameter("material_no" + i));
		   System.out.println("materialNo값 = "+materialNo);
		   questionContent = request.getParameter("question_content" + i);
		   System.out.println("questionContent값 = "+questionContent);
		   questionAnswer  = request.getParameter("question_answer" + i);
		   System.out.println("questionAnswer값 = "+questionAnswer);
		   questionSolve   = request.getParameter("question_solve" + i);
		   System.out.println("questionSolve값 = "+questionSolve);
		   
		   fileNum   = Integer.parseInt(request.getParameter("files_no" + i));
		   System.out.println("fileNum 값 = "+fileNum);
		   
		   System.out.println("i 쓴 값들**************************************************************");
		   
		   qVo.setQuestion_no(questionNo);
		   qVo.setMaterial_no(materialNo);
		   qVo.setQuestion_content(questionContent);
		   qVo.setQuestion_answer(questionAnswer);
		   qVo.setQuestion_solve(questionSolve);
		   qVo.setFiles_no(fileNum);
		   
		   cnt = QService.updateQuestion(qVo);
		   
		   System.out.println(i + " 번쨰 cnt = "+ cnt );
		 
	   }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		 doGet(request, response);
		 
		}

}
