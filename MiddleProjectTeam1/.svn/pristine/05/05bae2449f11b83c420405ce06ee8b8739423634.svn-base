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

import kr.or.ddit.service.AdmTeacherServiceImpl;
import kr.or.ddit.service.IAdmTeacherService;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/AdminTeacherUpdate.do")
@MultipartConfig
public class AdminTeacherUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 회원ID에 맞는 회원 정보를 검색해서 회원 정보 수정폼에 보낸다.
		request.setCharacterEncoding("utf-8");
				
		
		String cusId = request.getParameter("cus_id");
		
		System.out.println("cusid: " +cusId);
		
		IAdmTeacherService service = AdmTeacherServiceImpl.getInstance();
		MemberVO memberVo = service.getAllMemVo(cusId);
		CustomerVO cusVo =service.getAllCusVo(cusId);
		
		request.setAttribute("memberVo", memberVo);
		request.setAttribute("cusVo", cusVo);
		
		request.getRequestDispatcher("/WEB-INF/view/adminTeacher/TeacherUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
			String uploadPath = "C:/Users/space/Desktop/이미지파일";
	        // 저장될 폴더가 없으면 폴더를 만들어 준다.
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs();
	        }

	        request.setCharacterEncoding("utf-8");
	        IAdmTeacherService service = AdmTeacherServiceImpl.getInstance();

	        // 회원 정보를 받는다.
	        String id = request.getParameter("cus_id");
	        System.out.println("cus_id doPost에 왔어?: " + id);
	        
	        if (id == null || id.isEmpty()) {
	            System.out.println("cus_id가 없어.");
	            // 에러 처리 또는 반환
	            request.setAttribute("error", "필수 값이 누락되었습니다.");
	            MemberVO memberVo = service.getAllMemVo(id);
	            CustomerVO cusVo = service.getAllCusVo(id);
	            request.setAttribute("memberVo", memberVo);
	            request.setAttribute("cusVo", cusVo);
	            request.getRequestDispatcher("/WEB-INF/view/adminTeacher/TeacherUpdate.jsp").forward(request, response);
	            return;
	        }

	        String pw = request.getParameter("cus_pass");

	        // 필수값 검증
	        if (id == null || id.isEmpty() || pw == null || pw.isEmpty()) {
	            request.setAttribute("error", "필수 값이 누락되었습니다.");
	            MemberVO memberVo = service.getAllMemVo(id);
	            CustomerVO cusVo = service.getAllCusVo(id);
	            request.setAttribute("memberVo", memberVo);
	            request.setAttribute("cusVo", cusVo);
	            request.getRequestDispatcher("/WEB-INF/view/adminTeacher/TeacherUpdate.jsp").forward(request, response);
	            return;
	        }

	        String name = request.getParameter("mem_name");
	        String tel = request.getParameter("mem_tel");
	        String bir = request.getParameter("mem_bir");
	        String zip = request.getParameter("mem_zip");
	        String add1 = request.getParameter("mem_add1");
	        String add2 = request.getParameter("mem_add2");
	        String mail = request.getParameter("mem_mail");
	        String auth = request.getParameter("mem_auth");

	        // 고객 정보 저장
	        CustomerVO cusVo = new CustomerVO();
	        cusVo.setCus_id(id);
	        cusVo.setCus_pw(pw);

	        // 고객 정보 업데이트
	        int cnt = service.updateCusTeacher(cusVo);

	        // 고객 정보 업데이트 성공 시 회원 정보도 업데이트
	        if (cnt == 1) {
	            MemberVO memVo = new MemberVO();
	            memVo.setCus_id(id); 
	            memVo.setMem_name(name);
	            memVo.setMem_tel(tel);
	            memVo.setMem_bir(bir);
	            memVo.setMem_zip(zip);
	            memVo.setMem_add1(add1);
	            memVo.setMem_add2(add2);
	            memVo.setMem_mail(mail);
	            memVo.setMem_auth(auth);

	            // 프로필 사진 처리
	            Part part = request.getPart("mem_auth");

	            if (part != null) {
	                String fileName = extractFilename(part);
	                if (!"".equals(fileName)) {
	                    try {
	                        part.write(uploadPath + File.separator + fileName);
	                        memVo.setMem_auth(fileName);  // DB에 저장할 파일명을 VO객체에 저장
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            }

	            // 회원 정보 업데이트
	            service.updateMemTeacher(memVo);
	            response.sendRedirect(request.getContextPath() + "/AdminTeacherList.do");
	        } else {
	            request.setAttribute("error", "회원 정보 수정에 실패했습니다.");
	            request.getRequestDispatcher("/WEB-INF/view/adminTeacher/TeacherUpdate.jsp").forward(request, response);
	        }
	    }

	    // Part 구조 안에서 파일명을 찾는 메서드
	    private String extractFilename(Part part) {
	        String contentDisposition = part.getHeader("content-disposition");
	        for (String cdPart : contentDisposition.split(";")) {
	            if (cdPart.trim().startsWith("filename")) {
	                return cdPart.substring(cdPart.indexOf('=') + 1).trim().replace("\"", "");
	            }
	        }
	        return null;
	    }
	}


