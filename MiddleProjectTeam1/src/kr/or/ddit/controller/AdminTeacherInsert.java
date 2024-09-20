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

import com.google.gson.Gson;

import kr.or.ddit.service.AdmTeacherServiceImpl;
import kr.or.ddit.service.IAdmTeacherService;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/AdminTeacherInsert.do")
@MultipartConfig // 파일 업로드 처리용 (프로필 사진 업로드)
public class AdminTeacherInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GET방식으로 요청할 때는 회원 입력 폼이 나타나도록 구현한다.
		request.getRequestDispatcher("/WEB-INF/view/adminTeacher/Teacherinsert.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST방식으로 요청할 때는 입력한 회원 정보를 받아서 프로필 사진을 저장하고
		// 회원 정보는 DB에 저장하는 기능을 구현한다.
				
		// 사용자가 업로드한 파일이 저장될 서버쪽의 폴더 경로 설정
		String uploadPath = "C:/Users/space/Desktop/이미지파일";
		
		// 저장될 폴더가 없으면 폴더를 만들어 준다.
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
		uploadDir.mkdirs();
		}
		
		request.setCharacterEncoding("utf-8");
		
	
		//회원 정보 받기
		String id = request.getParameter("cus_id");
		String pw = request.getParameter("cus_pass");
		String name = request.getParameter("mem_name");
		String tel = request.getParameter("mem_tel");
		String bir = request.getParameter("mem_bir");
		String zip = request.getParameter("mem_zip");
		String add1 = request.getParameter("mem_add1");
		String add2 = request.getParameter("mem_add2");
		String mail = request.getParameter("mem_mail");
		
		//받아온 회원 정보 vo에 저장
		CustomerVO cusVo = new CustomerVO();
		cusVo.setCus_id(id);
		cusVo.setCus_pw(pw);
		
		IAdmTeacherService service = AdmTeacherServiceImpl.getInstance();
		int cnt = service.insertCusTeacher(cusVo);
		
		
		if(cnt==1) {
			
			MemberVO memVo = new MemberVO();
			memVo.setCus_id(id);
			memVo.setMem_name(name);
			memVo.setMem_tel(tel);
			memVo.setMem_bir(bir);
			memVo.setMem_zip(zip);
			memVo.setMem_add1(add1);
			memVo.setMem_add2(add2);
			memVo.setMem_mail(mail);
		
		// form의 file입력요소의 name값은 Part객체의 이름역할을 한다.
		// 이 이름을 이용하여 Part객체를 구한다.
		Part part = request.getPart("mem_auth");
		
		if(part!=null) {
			String fileName = extractFilename(part);
			
			if(!"".equals(fileName)) {
				try {
					part.write(uploadPath + File.separator + fileName);
					
					memVo.setMem_auth(fileName);  // DB에 저장할 파일명을 VO객체에 저장
				} catch (Exception e) {
					memVo.setMem_auth(null);  // 프로필 사진이 오류가 생기면...
				}
			}
		}
		
		
			
			service.insertMemTeacher(memVo);
			
			//작업이 완료 되면 list페이지로 이동
			response.sendRedirect(request.getContextPath()+"/AdminTeacherList.do");
			
			
		}
	}	

	// Part구조 안에서 파일명을 찾는 메서드
	private String extractFilename(Part part) {
		String fileName = "";

		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for (String item : items) {
			if (item.trim().startsWith("filename")) {
				// filename="test1.txt"
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}

		return fileName;
	}
}
