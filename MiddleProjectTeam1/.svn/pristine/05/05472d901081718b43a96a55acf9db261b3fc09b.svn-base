package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.service.AdmMaterialServiceImpl;
import kr.or.ddit.service.IAdmMaterialService;
import kr.or.ddit.service.IAdmTeacherService;
import kr.or.ddit.service.IMaterialService;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

/**
 * Servlet implementation class AdminMateQueImageView
 */
@WebServlet("/adminMateQueImageView.do")
public class AdminMateQueImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMateQueImageView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		request.getRequestDispatcher("/adminTeacher/Teacherinsert.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		   // POST방식으로 요청할 때는 입력한 회원 정보를 받아서 프로필 사진을 저장하고
	      // 회원 정보는 DB에 저장하는 기능을 구현한다.
	            
	      // 사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로 설정
	      String uploadPath = "D:/D_Other/upload";
	      
	      // 저장될 폴더가 없으면 폴더를 만들어 준다.
	      File uploadDir = new File(uploadPath);
	      if(!uploadDir.exists()) {
	      uploadDir.mkdirs();
	      }

	      //mno 값 받기
	      int mno = Integer.parseInt(request.getParameter("mno"));
	      
	      //받은 값으로 학습지 번호에 대항하는 파일 이름 찾기.
	      IAdmMaterialService admService = AdmMaterialServiceImpl.getInstance();
	      
	      int cnt = admService.adminSelectMateFileNum(fileName);
	      
	      	         //작업이 완료 되면 list페이지로 이동
	         response.sendRedirect(request.getContextPath()+"/TeacherList.do");
	         

	}

}

	

	



