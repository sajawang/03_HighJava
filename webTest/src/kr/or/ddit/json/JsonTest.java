package kr.or.ddit.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/json/jsonTest.do")//이름붙이는 방법 설명
public class JsonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//응답데이터를 JSON으로 할 때 설정
		response.setCharacterEncoding("utf-8");
		//response.setContentType("text/html; charset=utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		//파라미터데이터 받기
		String choice= request.getParameter("choice"); //1.choice를 받고(String타입)
		
		Gson gson = new Gson();
		
		//처리한 결과를 JSON형태의 문자열로 변환한 후 이 문자열을 응답으로 보낸다.
		String jsonData = null;	//choice가 변환되고 저장될
		
		switch (choice) {
			case "string" :
				String str = "안녕하세요";		//뭔가를 처리한 결과라고 가정하자
				jsonData = gson.toJson(str);	//2. choice를 JSON문자열로 변환 -> jsonData로 저장하였다.
				break;
			case "array" :
				int[] intArr = {10,20,30,40,50};
				jsonData = gson.toJson(intArr);//파라미터에 넣은 값을 json으로 싹 바꿔줘요 ㅎㅎ
				break;
			case "object" :
				SampleVO sampleVo = new SampleVO(1,"홍길동");
				jsonData = gson.toJson(sampleVo);
				break;
			case  "list" :
				List<SampleVO> samList = new ArrayList<SampleVO>();
				samList.add(new SampleVO(100, "이순신"));
				samList.add(new SampleVO(200, "강감찬"));
				samList.add(new SampleVO(300, "성춘향"));
				jsonData = gson.toJson(samList);
				break;
			case "map" :
				Map<String, String> map = new HashMap<String, String>();
				map.put("name", "이몽룡");
				map.put("tel", "010-1234-7894");
				map.put("addr", "대전");
				jsonData = gson.toJson(map);
				break;
		}
		
		//JSON문자열 확인용
		System.out.println("jsonData = "+jsonData);
		
		//응답으로 보낼때 
		PrintWriter out = response.getWriter();	//PringWriter로 출력만했다
		out.write(jsonData);
		response.flushBuffer();
	}

}







































