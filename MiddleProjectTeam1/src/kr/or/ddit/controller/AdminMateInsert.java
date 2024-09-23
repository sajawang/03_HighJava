package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.service.AdmMaterialServiceImpl;
import kr.or.ddit.service.IAdmMaterialService;
import kr.or.ddit.service.IMaterialService;
import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.MaterialVO;

/**
 * Servlet implementation class MateInsert
 */
@WebServlet("/adminMateInsert.do")
@MultipartConfig		// 파일 업로드 처리용 (프로필 사진 업로드)
public class AdminMateInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//   		request.getRequestDispatcher("/WEB-INF/view/member/memberForm.jsp")
//		.forward(request, response);
   		
    		
   		
   	}
   	private String extractFilename(Part part) {
		String fileName = "";
		
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {  
				// filename="test1.txt"
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		return fileName;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uploadPath = "D:/D_Other/upload";
		
	
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		request.setCharacterEncoding("utf-8");
		
		// 파일 정보를 받는다.
		String title = (String)request.getParameter("material_title");
		String des = (String)request.getParameter("material_des");
		String grade = (String)request.getParameter("material_grade");
		String level = (String)request.getParameter("material_level");
//   		String mateFile = (String)request.getParameter("material_file");
//   		System.out.println(title);
//   		System.out.println(des);
//   		System.out.println(grade);
//   		System.out.println(level);
//   		System.out.println(mateFile);
//   		
		if("normal".equals(level)) {
			level="기본";
		}
		if("hard".equals(level)) {
			level="심화";
		}
		
		MaterialVO mateVo = new MaterialVO();
		
		mateVo.setMaterial_title(title);
		mateVo.setMaterial_des(des);
		mateVo.setMaterial_grade(grade);
		mateVo.setMaterial_level(level);
		
		Part part = request.getPart("material_file");
		
		String fileName = null;
		
		if(part!=null) {
			 fileName = extractFilename(part);
			
			if(!"".equals(fileName)) {
				try {
					part.write(uploadPath + File.separator + fileName);
					mateVo.setFiles_name(fileName);
					
//					memVo.setMem_photo(fileName);  // DB에 저장할 파일명을 VO객체에 저장
				} catch (Exception e) {
					mateVo.setFiles_name(null);
//					memVo.setMem_photo(null);  // 프로필 사진이 오류가 생기면...
				}
			}
		}
		
		IAdmMaterialService service = AdmMaterialServiceImpl.getInstance();
		
		//파일 이름을 매개변수로 넣어 동일파일 유무를 확인한다.
		int checkFileNum = service.adminSelectMateFileNum(fileName);
		int mat = 0;
		int nono = 0;
		
		//파일이 없으면 파일이름을 이용해 새로운 파일을 insert한다.
		if(checkFileNum==0) {
			mat = service.adminInsertMateFile(fileName);
		}
		
		//insert가 성공했으면 한번 더 파일번호를 확인한다.
		if(mat==1) {
			checkFileNum = service.adminSelectMateFileNum(fileName);
		}		
		
		//checkFileNum이 파일번호를 가져온다. [0보다 크면]
		if(checkFileNum>0) {
			//파일번호로 세팅
			mateVo.setFiles_no(checkFileNum);
			
		}
		
		
		int dww = service.adminInsertMate(mateVo);
		
		request.setAttribute("result1", dww);
		
		
		// 작업이 완료되면 List페이지로 이동
//		response.sendRedirect(request.getContextPath()+"/adminmaterialList.do");
//		request.getRequestDispatcher(request.getContextPath()+"/adminMateInsert.jsp");	
		request.getRequestDispatcher("/WEB-INF/view/adminMaterial/result1.jsp").forward(request, response);
		
		
		
	}

}
