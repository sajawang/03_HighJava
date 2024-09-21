package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.service.CustomerServiceImpl;
import kr.or.ddit.service.ICustomerService;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.CustomerVO;
import kr.or.ddit.vo.MemberVO;

@MultipartConfig
@WebServlet("/myPageMemberUpdate.do")
public class MyPageMemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//session에서 아이디 받기
		// String sw = (String)session.getAttribute("id");
		HttpSession session = request.getSession();
		
		String da= (String)session.getAttribute("userGu"); // 회원의 종류 - 학생 - 선생님 값 가져오기

		String sw = null;
		int eq = 0;

		MemberVO memVo=(MemberVO)session.getAttribute("memVo");
		if(memVo!=null){
			sw = memVo.getCus_id();
			eq = memVo.getMem_point();
		}
		//----------------------------------------------------------------
		
		IMemberService service = MemberServiceImpl.getInstance();
		
		//session에서 받은 아이디 넣기
		MemberVO vo = service.getMember(sw);
		
		request.setAttribute("MemberVO", vo);
		
		request.getRequestDispatcher("/WEB-INF/view/memberMypage/basicMemberInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 회원 정보를 받는다.
		String cus_id = request.getParameter("cus_id");
		String mem_name = request.getParameter("mem_name");
		String mem_tel = request.getParameter("mem_tel");
		String mem_bir = request.getParameter("mem_bir");
		String mem_zip = request.getParameter("mem_zip");
		String mem_add1 = request.getParameter("mem_add1");
		String mem_add2 = request.getParameter("mem_add2");
		String mem_mail = request.getParameter("mem_mail");
		String mem_auth = request.getParameter("mem_auth");
		
		
		String cus_pw = request.getParameter("new_mem_pass");
		
		
		// 받아온 회원 정보를 VO에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setCus_id(cus_id);
		memVo.setMem_tel(mem_tel);
		memVo.setMem_zip(mem_zip);
		memVo.setMem_add1(mem_add1);
		memVo.setMem_add2(mem_add2);
		memVo.setMem_mail(mem_mail);
		//memVo.setMem_auth(mem_auth);
		
		
		
		
		
		//파일처리
		//----------------------------------------------------------------------
		//파일이 전송되어 오면 처리하기
		
		
		//업로드된  파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		File file = new File(uploadPath);
		
		//저장될 폴더가 없으면 새로 생성한다.
		if(!file.exists()) {
			file.mkdirs();
		}
		
		// form의 file입력요소의 name값은 Part객체의 이름역할을 한다.
		// 이 이름을 이용하여 Part객체를 구한다.
		Part part = request.getPart("mem_auth");
		if(part!=null) {
			String fileName = extractFilename(part);
			
			if(!"".equals(fileName)) {
				String newFileName = "teacher_" + cus_id + "_" + fileName; // 새 파일 이름 생성
				
				System.out.println(newFileName);
				
				try {
					part.write(uploadPath + File.separator + newFileName);
					
					memVo.setMem_auth(newFileName);
					//memVo.setMem_photo(fileName);  // DB에 저장할 파일명을 VO객체에 저장
				} catch (Exception e) {
					memVo.setMem_auth(null);  // 프로필 사진이 오류가 생기면...
				}
			}
		}
		//----------------------------------------------------------------------
		
		CustomerVO cusVo = new CustomerVO();
		cusVo.setCus_id(cus_id);
		cusVo.setCus_pw(cus_pw);
		
		IMemberService service = MemberServiceImpl.getInstance();
		ICustomerService service2 = CustomerServiceImpl.getInstance();
		
		//쿼리 서비스 전달
		service2.updateCustomer(cusVo);
		service.updateMember(memVo);
		
		//마이페이지 메인으로 가기
		request.getRequestDispatcher("/WEB-INF/view/memberMypage/mypageMain.jsp").forward(request, response);
	}

	
	// Part구조 안에서 파일명을 찾는 메서드
	private String extractFilename(Part part) {
		String fileName = "";
		
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {  
				// filename="test1.txt"
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
				System.out.println(fileName);
			}
		}
		
		return fileName;
	}
}
