package kr.or.ddit.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileinfoVO;

/*
 	- Servlet 3.0 이상에서 파일 업로드를 하려면 서블릿에 @MultipartConfig 어노테이션을 설정해야 한다.
 	
 	- @MultipartConfig 어노테이션의 속성들...
 	1) location : 업로드한 파일이 임시적으로 저장될 경로 지정(기본값 : "")
 	2) fileSizeThreshold : 이 곳에 설정한 값보다 큰 파일이 전송되면 location에 지정한 임시 디렉토리에 저장한다. (단위 : byte, 기본값 : 0(무조건 임시 디렉토리 사용))
 	3) maxFileSize : 한 개 파일에 최대크기 지정(단위 : byte, 기본값 : -1L(무제한이란뜼)) *기본값 뜻 : 생략했을때
 	4) maxRequestSize : 서버로 전송되는 Request의 전체 데이터의 최대 크기
 					(모든 파일의 크기 + formData)(단위 : byte, 기본값 : -1L(무제한이란뜻) )
 	 
 */
@MultipartConfig(
		fileSizeThreshold = 1024*1024*10, maxFileSize=1024*1024*30,
		maxRequestSize = 1024*1024*50
		//1KB=1024byte, 
		//1MB=1024KB
		//1MB=1024*1024byte
)
@WebServlet("/fileUpload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get방식으로 호출하면 파일 입력 폼 문서가 나타나도록
		request.getRequestDispatcher("/basic/fileUpload/fileUploadForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일이 전송되어 오면 처리하기
		request.setCharacterEncoding("utf-8");
		
		//업로드된  파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		File file = new File(uploadPath);
		
		//저장될 폴더가 없으면 새로 생성한다.
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//--------------------------------------------------------------------------------------------------------
		//이제 클라이언트가 보낸 데이터를 받는겁니다.
		//파일이 아닌 일반 데이터들은 getparameter()메서드나 getParameterValues() 
		//-> 뭐 이름 간단히 보내고 이런
		String userName= request.getParameter("username"); //username은 view(클라이언트)단의 <input>의 name속성
		
		System.out.println("일반파라미터데이터"+userName);
		
		
		//--------------------------------------------------------------------------------------------------------
		//수신 받은 파일 데이터를 처리하기
		
		//Upload한 파일이 여러개일 경우 Upload한 파일 정보가 저장될 List객체 생성
		List<FileinfoVO> fileList = new ArrayList<FileinfoVO>();
		
		//Servlet 3.0이상에서 새롭게 추가된 Upload용 메서드
		// 1) request.getParts()=> 전체 Part객체를 Collection에 담아서 반환한다.
		// 2) request.getPart("이름") ==> 지정된 "이름"을 갖는 개별 part객체를 반환한다.
		//			'이름'은 <form>태그 안의 입력요소의 name속성값으로 구별한다.
		
		//전체 Part객체 개수만큼 반복처리
		for (Part part : request.getParts() ) {
			//Upload한 파일 명 구하기
			String originFileName = extractFileName(part);
			
			//찾은 파일명이 빈 문자열("")이면 이것은 파일이 아닌 일반 파라미터 데이터다
			if(!"".equals(originFileName)) {//파일인지 검사
				//1개의 파일 정보를 저장할 VO객체 생성
				FileinfoVO fileVo = new FileinfoVO();
				
				fileVo.setFile_writer(userName);	//작성자 저장
				fileVo.setOrigin_file_name(originFileName);	//실제 파일명 저장
				
				//실제 저장되는 파일 이름이 중복ㄷ괴는 것을 방지하기 위해서 UUID클래스를 이용하여 
				//저장할 파일명을 만든다.
				String saveFileName = UUID.randomUUID().toString() + "_"+originFileName; //난수 문자열을 만드는데, 중복이 거의 안된다고 한다. 
				
				fileVo.setSave_file_name(saveFileName); 		//실제 저장할 파일명 저장
				
				//전송된 파일의 크기 part.getSize()메서듣로 구할 수 있다.
				fileVo.setFile_size(part.getSize());
				
				//-----------------------------------------------
				//part.write()메서드를 이용하여 upload된 파일을 지정된 폴더에 저장한다.
				try {
					part.write(uploadPath+File.separator+saveFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//List에 1개의 파일 정보 추가
				fileList.add(fileVo);
				
			}	//if문 끝
		}//for문 끝
		
		//List에 추가된 파일 정보를 DB에 저장한다.
		IFileInfoService service = FileInfoServiceImpl.getService();
		
		//List개수만큼 반복
		for(FileinfoVO fvo : fileList) {
			service.insertFileInfo(fvo);	
		}
		
		//저장이 완료된 후에 파일 목록 보여주기
		response.sendRedirect(request.getContextPath()+"/fileList.do");
	}
	//-----------------------------------------------------------------------------------------------------------
	/*
	 * 
	 * Part구조
	 * 1) 파일이 아닌 일반 파라미터 데이터일 경우
	 *  --------------------ㅁㄴ이러ㅕ2ㅔ0398ㅕ 2089<-난수들  ==> Part르르 구분하는 구분선
	 *  content-disposition : form-data; name="username";	==> 파라미터명
	 * 	                                                   	==> 빈줄
	 *  hong												==>파라미터 값
	 * 
	 */
	
	/*
	 * 2) 파일인 경우 
	 *  --------------------ㅁㄴ이러ㅕ2ㅔ0398ㅕ 2089<-난수들  ==> Part르르 구분하는 구분선
	 * content-disposition : form-data; name="upFile1"; filename="test1.txt" ==>파일 정보
	 * content-type : text/plain		==> 파일의 종류
	 * 	                                ==> 빈줄
	 * abcd1234안녕
	 */
	
	//Part구조 안에서 파일명을 찾는 메서드
	private String extractFileName(Part part) {
		String fileName = "";
		
		String content = part.getHeader("content-disposition");
		String[] items = content.split(";"); //split은 ;기준으로 데이터를 분리해서 배열에 담아줄거다
		
		for(String item : items) {
			if (item.trim().startsWith("filename")) {//??????????????????startsWith??/?/
				fileName = item.substring(item.indexOf("=")+2, item.length()-1); //filename="test1.txt" 여기서 substing 결과 ->test1.txt
				
			}
		}
		
		return fileName;
	}
	
	
	
	
	
	

}




































