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
	
   		MaterialVO mateVo = new MaterialVO();
   		request.setCharacterEncoding("utf-8");
   	
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
   		
   		String fileName=null;
   		
   		String uploadPath = "D:/D_Other/upload";
   		
   		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
   		
		Part part = request.getPart("material_file");
		
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
   		
//   		FileVO fileVo= new FileVO();
   		
//   		fileVo.setFiles_name(mateFile);

   		
   		IAdmMaterialService service = AdmMaterialServiceImpl.getInstance();
   		
   		int fileCnt = 0;
   		
   		//파일 이름 체크용도.
   		
   		Integer mateFileNum = service.adminSelectMateFileNum(fileName);
   		//만약 체크기능용 파일이름이 다르거나 없으면 새로운 파일을 저장한다.
   			if(mateFileNum==0) {
   				fileCnt = service.adminInsertMateFile(fileName);   				
   			}
   		
   		System.out.println("fileCnt"+fileCnt);
   		
   		//새로운 파일을 넣고 파일 이름을 넣어서 파일 번호를 들고오는 메소드를 실행하고 그 후에 학습지 넣기 진행.
   		
   		//생성이 완료되거나 이미 있는 파일이라면 학습지 삽입 실행
   		if(mateFileNum>0) {
   			
   			mateFileNum = service.adminSelectMateFileNum(fileName);
   			System.out.println("mateFileNum="+mateFileNum);
   			
   			if(mateFileNum>0) {
   				mateVo.setMaterial_title(title);
   				mateVo.setMaterial_des(des);
   				mateVo.setMaterial_level(level);
   				mateVo.setMaterial_grade(grade);
   				mateVo.setFiles_no(mateFileNum);
   				
   				int mateCnt = service.adminInsertMate(mateVo);
   				
   				System.out.println("mateCnt="+mateCnt);
   				
   				if(mateCnt==1) {
   					response.sendRedirect(request.getContextPath()+"/material/materialList.do");
   					
   				}
   			}  			
   		}
    		
   		
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
		doGet(request, response);
	}

}
