package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.AdmMaterialServiceImpl;
import kr.or.ddit.service.IAdmMaterialService;
import kr.or.ddit.service.IQuestionService;
import kr.or.ddit.service.QuestionServiceImpl;
import kr.or.ddit.vo.QuestionVO;

/**
 * Servlet implementation class AdminQueInsert
 */
@WebServlet("/adminQueInsert.do")
public class AdminQueInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	         
	         //파일 이름 체크용도.
	         mateFileNum = service.adminSelectMateFileNum(filesName);
	         
	         	System.out.println(mateFileNum+"mateFileNum");
	         
	         if(mateFileNum==null||mateFileNum==0) {
	        	 //파일이 없으면 파일을 새로 insert
	        	 fileCnt = service.adminInsertMateFile(filesName);
	         }
	         System.out.println("fileCnt"+fileCnt);
	         
	         // 삽입 후에 다시 번호 체크
	         if(fileCnt==1) {
	        	 mateFileNum = service.adminSelectMateFileNum(filesName);        	 
	         }
	         
	    	
	    	if(mateFileNum>0) {
	    		
	    		qVo.setFiles_no(mateFileNum);
//	    		qVo.setQuestion_no(questionNo);
	    		qVo.setMaterial_no(materialNo);
	    		qVo.setQuestion_content(questionContent);
	    		qVo.setQuestion_solve(questionSolve);
	    		qVo.setQuestion_answer(questionAnswer);
	    		
	    		cnt=QService.insertQuestion(qVo);
	    	
	    		System.out.println("cnt 출력 5개 되면 정상"+cnt);
	    		
	    	}
	         
		 }
			response.sendRedirect(request.getContextPath()+"/adminmaterialList.do");


	}

}
