<%@page import="kr.or.ddit.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%
	//컨트롤러(서블릿)가 보낸 데이터를 받는다.
	List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("lprodList");
%>
<body>

<!--이제 출력만 하면 돼여-->
<h3> Lprod 자료 목록(동기방식)</h3>
<table border="1">
<tr><td>id</td><td>gu</td><td>nm</td></tr>

<%
for(LprodVO lvo : lprodList){
%>
<!--리스트를 출력할떄는 for문 도는게 좋으니까, 스크립트릿을 써준다-->
	<tr><td><%=lvo.getLprod_id() %></td>
	<td><%=lvo.getLprod_gu() %></td>
	<td><%=lvo.getLprod_nm() %></td>
<% 	
}
%>

</table>
</body>
</html>