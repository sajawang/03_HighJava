<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    
    //controller에서 저장한 값 꺼내기 
    //attribute의 return값은 object 형태이기 때문에 형변환 필수
    int cnt = (Integer)request.getAttribute("adminResult");
    //결과값에 대한 처리 결과를 html에서 출력하기 위한
    //cnt로 응답데이터 생성 - json형식의 문자열로
    if(cnt>0){ //성공
%>
	{
	"flag": "<%=cnt %>"
	
	}
	
<%  }else{	//실패    %>

	"flag": "실패"
	
<%    	  	
    }
    %>