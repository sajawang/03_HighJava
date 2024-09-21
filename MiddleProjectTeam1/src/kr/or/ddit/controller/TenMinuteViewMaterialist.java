package kr.or.ddit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.service.IMaterialService;
import kr.or.ddit.service.IMathSettingService;
import kr.or.ddit.service.MaterialServiceImpl;
import kr.or.ddit.service.MathSettingServiceImpl;
import kr.or.ddit.vo.MaterialVO;
import kr.or.ddit.vo.MathSettingVO;
import kr.or.ddit.vo.MemberVO;
import kr.or.ddit.vo.ViewListVO;

@WebServlet("/tenMinuteViewMaterialist.do")
public class TenMinuteViewMaterialist extends HttpServlet {
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
		
		
		//세션에 있는 아이디가 mathsetting테이블에 없으면
		//mathsetting insert jsp로 가기
		IMathSettingService service2 = MathSettingServiceImpl.getInstance();
		MathSettingVO vo =  service2.getMathSetting(sw);
		
		String mathsetting_minute=vo.getMathsetting_minute();
		request.setAttribute("mathsetting_minute", mathsetting_minute);
		
		if(vo==null) {
			request.getRequestDispatcher("/WEB-INF/view/memberMypage/firstTenMinMath.jsp").forward(request, response);
		} else {
			
			//10분수학 설정가져오기, 아이디에 따른
			MathSettingServiceImpl service3 = MathSettingServiceImpl.getInstance();
			MathSettingVO mvo = service3.getMathSetting(sw);
			
			String mgrade =  mvo.getMathsetting_grade(); //초등 3학년 1학기
			String material_level = mvo.getMathsetting_level(); //심화, 기본
			
			//--------------------------------------------------------------
			//--------------------------------------------------------------
			
			//문자열 분리 작업
			String[] parts = mgrade.split(" ");  // 공백으로 문자열 분리

			String m1 = parts[0];  // "초등"
			String m2 = parts[1].substring(0, 1);  // "3" (학년 숫자 추출)
			String m3 = parts[2].substring(0, 1);  // "1" (학기 숫자 추출)

			System.out.println("m1: " + m1);  // "초등"
			System.out.println("m2: " + m2);  // "3"
			System.out.println("m3: " + m3);  // "1"
			
			//초등 3-1 형식으로 만드는 작업
			String material_grade = m1 + " " + m2 + "-" + m3;

			System.out.println("material_grade: " + material_grade);  // "초등 3-1"
			
			//map 만들기 cus_id,material_grade 초등 6-2 ,materiala_level 심화,기본
			// 파라미터값 담을 맵
			Map<String, Object> map = new HashMap<>();
			
			//jsp에서 날아온 파라미터값 꺼내서 맵에 담기
			map.put("cus_id", sw);
			map.put("material_grade", material_grade);
			map.put("material_level", material_level);
			
			//material의 쿼리 가져오는데, material의 vo에 cus_id를 추가한
			MaterialServiceImpl service4 = MaterialServiceImpl.getInstance();
			MaterialVO mtvo = service4.todayTenMinMaterial(map);
			
			//----------------------------------------------------------------------------
			//----------------------------------------------------------------------------
			
			IMaterialService service = MaterialServiceImpl.getInstance();
			List<ViewListVO> mlist = service.getViewMaterial(sw);
			
			//----------------------------------------------------------------------------
			//----------------------------------------------------------------------------

			request.setAttribute("mtvo", mtvo);
			request.setAttribute("mlist", mlist);
			request.getRequestDispatcher("/WEB-INF/view/memberMypage/tenMinMathMain.jsp").forward(request, response);
		}
		
	}
}
