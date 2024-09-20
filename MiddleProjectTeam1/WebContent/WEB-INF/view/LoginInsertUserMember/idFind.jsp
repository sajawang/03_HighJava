<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//controller에서 저장한 값 꺼내기
	String id = String.valueOf(request.getAttribute("userId"));
	
// 	System.out.println(id);
	if(id!=null){ //중복체크해서 null이 아니면 아이디 찾기 성공.
	%>
	{"id":"<%=id%>"}
	
		
	<%
	}else{//r값이 나오면 중복된 id
	%>		

	{"flag" : "아이디 찾기 실패"}

	<%
	}
%>
