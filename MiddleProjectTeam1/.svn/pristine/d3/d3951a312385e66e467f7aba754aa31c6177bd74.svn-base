package kr.or.ddit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
 * Servlet implementation class AdminMateQueImageView
 */
@WebServlet("/adminMateQueImageView2.do")
public class AdminMateQueImageView2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//상세보기 할 문제번호
    	String mno = request.getParameter("qno");
    	int mmm = Integer.parseInt(mno);
    	
    	System.out.println(mno+"mno");
    	System.out.println(mmm+"mmm");
    	
    	//ㅈㅁ 여기서 다섯개가 들어오잖아. 시발; 문제번호가 5개가 들어온다.
    	// mmm 하나를 받는다 - > mateVo는 5개의 문제가 담긴 학습지 객체. 그럼 여기서 사진 하나를 뽑으면? 5개가 동시출력
    	//그 다음 mmm을 받으면 위의 결과를 반복한다. 그러면 총 25개의 사진을 불러오고 아주 개지랄이 난다. 그러면 어떻게 해야할까
    	//1. 해당 문제에 대한 file을 가져와서 출력한다. 이게 정답인거같은데
    	// 2. 결국 mmm값 하나만 받아서 이에 해당하는 학습지 만 가져오게 만든다.
    	
    	//question의 qno 값을 받는다. 이에 해당하는 사진 출력 작업을 실행한다.
    	// 그러고? 다음 qno 값이 들어오면? 이를 반복한다.mmm값은 자동으로 들어오고 자동으로 실행될테니까 그러면 된거아닌가?
    	
    	
    	IAdmMaterialService admService = AdmMaterialServiceImpl.getInstance();
    	IMaterialService service = MaterialServiceImpl.getInstance();
    	
    	//상세보기한 학습지의 모든 정보를 가져오고
//    	MaterialVO mateVo = service.selectDetailMaterial(mmm);
    	
    	
    	//문제 번호에 해당하는 문제 하나만 가져온다.
    	QuestionVO qVo = admService.selectDetailQuestion(mmm);
    	
    	
    	
    	String filePath = "D:/D_Other/upload";
    	File file =  null;
//    	List<QuestionVO> qvoList = admService.getMateQuestionList(mmm);
    	
//    	for(QuestionVO QQ : qvoList) {
    		int queFileNo = 0;
    		file=null;
    		String queFileName = null;
    		
    		//그 문제의 파일번호를 가져온다.
    		queFileNo = qVo.getFiles_no();
    		
    		//그 문제의 파일번호로 그 문제의 파일 이름을 얻는다.
    		queFileName = admService.adminSelectMateQueName(queFileNo);
    		
    		System.out.println(queFileName +"fileName");
    	
    	//문제지의 정보중 파일 번호를 이용해 파일 이름을 구한다.
    	
    		//파일주소랑 이름 지정하고
    		file = new File(filePath,queFileName);
    	
    	
    	//이미지가 저장된 폴더 설정
    	
    	BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		if(file.exists()) {	// 이미지 파일이 있을 때...
			try {
				// 출력용 스트림
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림
				bin = new BufferedInputStream(new FileInputStream(file));
				
				byte[] temp = new byte[1024];
				int len = 0;
				
				while( (len = bin.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				bout.flush();
				
				
			} catch (Exception e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bin!=null) try { bin.close(); }catch(IOException e) {}
				if(bout!=null) try { bout.close(); }catch(IOException e) {}
			}
		}
    	}
//    	request.getRequestDispatcher("/adminTeacher/Teacherinsert.jsp").forward(request, response);
		
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}

	

	



