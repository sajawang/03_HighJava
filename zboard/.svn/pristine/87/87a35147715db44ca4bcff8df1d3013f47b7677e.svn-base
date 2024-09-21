package kr.or.ddit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.service.AdmMaterialServiceImpl;
import kr.or.ddit.service.IAdmMaterialService;
import kr.or.ddit.service.IMaterialService;
import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.QuestionVO;

/**
 * Servlet implementation class GoAdminMateUpdate
 */
@WebServlet("/goAdminMateUpdate.do")
public class GoAdminMateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");
		
	  request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 학습지 번호
		int mno = Integer.parseInt(request.getParameter("mno"));
		System.out.println(mno);
		
		IMaterialService service = MaterialServiceImpl.getInstance();
		IAdmMaterialService admService = AdmMaterialServiceImpl.getInstance();
		
		
		MaterialVO vo = service.selectDetailMaterial(mno);
		List<QuestionVO> pVoList = admService.getMateQuestionList(mno);
		
		if(vo!=null) {
			System.out.println("vo 정상");
		}
		if(pVoList!=null) {
			System.out.println("list 정상");
		}
		
		for(QuestionVO qvo : pVoList) {
			System.out.println(qvo.getQuestion_content());
		}
		
		
		request.setAttribute("mateVo", vo);
		request.setAttribute("qVoList", pVoList);
		
		
	  
	request.getRequestDispatcher("/WEB-INF/view/adminMaterial/adminMateUpdate.jsp").forward(request, response);
//		   request.getRequestDispatcher("/WEB-INF/view/login2.jsp").forward(request, response);

  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
