<%@page import="kr.or.ddit.vo.MyMemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
//서블릿에서 보내온 자료받기
List<MyMemberVO> list =(List<MyMemberVO>)request.getAttribute("list");
%>
</head>

<body>
<h3>전체 회원 목록</h3>
<table border="1">
	<tr><td colspan="5"><input type="button" value="회원추가" onclick="location.href='<%= request.getContextPath()%>/basic/insertForm.jsp' "></td></tr>
	<tr><th>아이디</th><th>비밀번호</th><th>이름</th><th>전화</th><th>주소</th></tr>
	<% 
	for(MyMemberVO memberVo : list){
	%>	
		<tr>
		<td><%=memberVo.getMem_id()%></td>
		<td><%=memberVo.getMem_pass()%></td>
		<td><%=memberVo.getMem_name()%></td>
		<td><%=memberVo.getMem_tel()%></td>
		<td><%=memberVo.getMem_addr()%></td>
	</tr>
	<% 
	}
	%>
</table>
</body>
</html>