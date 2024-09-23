package kr.or.ddit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.service.AdmMaterialServiceImpl;
import kr.or.ddit.service.IAdmMaterialService;
import kr.or.ddit.vo.MaterialVO;

/**
 * Servlet implementation class AdminMateUpdate
 */
@WebServlet("/adminMateUpdate.do")
public class AdminMateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//전송데이터 얻기
		String reqData=StreamData.dataChange(request);
		
		//역직렬화 - memberVO타입으로 변환
		Gson gson = new Gson();
		
		MaterialVO mateVo = gson.fromJson(reqData, MaterialVO.class);
		
		String level = mateVo.getMaterial_level();
		
		if("normal".equals(level)) {
			level="기본";
		}
		if("hard".equals(level)) {
			level="심화";
		}
		
		mateVo.setMaterial_level(level);
		
		
		IAdmMaterialService service = AdmMaterialServiceImpl.getInstance();
		
		int cnt = service.updateMaterial(mateVo);
		
		request.setAttribute("result", cnt);
		
		request.getRequestDispatcher("/WEB-INF/view/LoginInsertUserMember/result.jsp").forward(request, response);

	}

}
