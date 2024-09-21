package kr.or.ddit.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.google.gson.Gson;
import com.sun.javafx.css.CssError;

import kr.or.ddit.service.MypageCSPostServiceImpl;
import kr.or.ddit.service.IMypageCSPostService;
import kr.or.ddit.vo.FileVO;
import kr.or.ddit.vo.PostVO;

/**
 *  고객센터에서 글쓰기 서블릿
 */
@MultipartConfig
@WebServlet("/mypagecsInsertPost.do")
public class MypageCsInsertPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// PostVO 객체 생성
	    PostVO pvo = new PostVO();
	    String saveFileName = null;
	    // map객체 생성 포스트의 파일번호 업데이트용 
	    Map<String, Object> map = new HashMap<>();
	    
	    // 폼 필드 값 가져오기
	    String cus_id = request.getParameter("cus_id");
	    String post_title = request.getParameter("post_title");
	    String post_content = request.getParameter("post_content");
	    String post_gu = request.getParameter("post_gu");
	    String file_name = request.getParameter("post_files");
	    
	    // 가져온 값 설정
	    pvo.setCus_id(cus_id);
	    pvo.setPost_title(post_title);
	    pvo.setPost_content(post_content);
	    pvo.setPost_gu(post_gu);
		pvo.setFiles_name(file_name);
		
		int board_no = 0;
		String back = request.getParameter("back");
		
		IMypageCSPostService service = MypageCSPostServiceImpl.getInstance();
		
		switch (post_gu) {
		case "이용문의":
			board_no = 3;
			back = "/WEB-INF/view/customerService/inquiry.jsp";
			break;
		case "나의수학해결소":
			board_no = 2;
			back = "/WEB-INF/view/customerService/mathSolution.jsp";
			break;
		}
		pvo.setBoard_no(board_no);
		
		//파일 업로드 처리
		// 업로드된 파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		File file = new File(uploadPath);
		
		// 저장될 폴더가 없으면 새로 생성한다.
		if(!file.exists()) {
			file.mkdirs();
		}
		// ------------------------------------------------------------------------------------------------------------
		// 수신받은 파일 데이터를 처리하기
		
		// Upload한 파일이 여러개 일 경우 Upload한 파일 정보가 저장될 List객체 생성
		List<FileVO> fileList = new ArrayList<FileVO>();
		
		// - Servlet 3.0이상에서 새롭게 추가된 Upload용 메서드
		// 1) request.getParts() ==> 전체 Part객체를 Collection에 담아서 반환한다.
		// 2) request.getPart("이름") ==> 지정된 "이름"을 갖는 개별 part객체를 반환한다.
		//						"이름"은 <form>태그 안의 입력요소의 name속성값으로 구별한다.
		
		// 전체 Part객체 개수만큼 반복 처리
		for(Part part : request.getParts()) {

			// Upload한 파일명 구하기
			String originFileName = extractFileName(part);
			
			// 찾은 파일명이 빈문자열("")이면 이것은 파일이 아닌 일반 파라미터 데이터라는 의미이다.
			if(!"".equals(originFileName)) {	// 파일인지 검사
				// 1개의 파일 정보를 저장할 VO객체 생성
				FileVO fileVo = new FileVO();
				
				// 실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 UUID클래스를 이용하여
				// 저장할 파일명을 만든다.
				saveFileName = UUID.randomUUID().toString()+"_"+originFileName;
				
				fileVo.setFiles_name(saveFileName); // 실제 저장할 파일명 저장
				
				// 전송된 파일의 크기의 part.getSize()메서드로 구할 수 있다.
				fileVo.setFiles_size(String.valueOf(part.getSize())); // 파일 크기 저장
				
				// ------------------------------------------------------------------------------------------------------------
				// part.write()메서드를 이용하여 upload된 파일을 지정된 폴더에 저장한다.
				try {
					part.write(uploadPath+ File.separator+saveFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				// List에 1개의 파일 정보 추가
				fileList.add(fileVo);
				
			} //  if문 끝
			
		}// for문 끝...
		
		// List에 추가된 파일 정보를 DB에 저장한다.
		
		// List 개수만큼 반복
		for(FileVO fvo : fileList) {
			int res = service.insertFiles(fvo);
			System.out.println(res);
		}
		FileVO fvo = service.fileinfo(saveFileName);
		pvo.setFiles_no(fvo.getFiles_no());
			
		int cnt = service.insertCsPost(pvo);
		
		request.setAttribute("result", cnt);
		
		//view
		request.getRequestDispatcher(back).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		doGet(request, response);
	}

	// Part구조 안에서 파일명을 찾는 메서드
		private String extractFileName(Part part) {
			String fileName = "";
			
			String content = part.getHeader("content-disposition");
			String[] items = content.split(";");
			
			for(String item : items) {
				if(item.trim().startsWith("filename")) {
					fileName = item.substring(item.indexOf("=")+2,item.length()-1 );
				}
			}
			
			return fileName;
		}
}
