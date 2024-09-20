<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//controller에서 저장한 값 꺼내기
	String id = (String)request.getAttribute("gwgw");

	if(id==null){ //중복체크해서 null이면 사용 가능한 id
	%>	
	{"flag" : "사용가능한 아이디"}
		
	<%
	}else{//r값이 나오면 중복된 id
	%>		

	{"flag" : "사용불가한 아이디"}

	<%
	}
%>
