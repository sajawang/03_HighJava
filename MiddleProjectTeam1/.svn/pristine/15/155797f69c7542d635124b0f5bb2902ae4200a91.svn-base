<%@page import="kr.or.ddit.vo.ViewListVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
</head>
<%
	List<ViewListVO> list = null;
	list = (List<ViewListVO>)request.getAttribute("list");
%>
<script type="text/javascript">

</script>
<body>


<h2>풀었던 문제 목록 </h2>	
<table border="1">
	<thead>
		<tr>
			<th>NO</th>
			<th>학습지 제목</th>
			<th>점수</th>
			<th>다시풀기</th>
			<th>결과보기</th>
		</tr>
	</thead>
	<tbody>
<%
	int i=1;
	for(ViewListVO vo : list){
%>
		<tr>
			<td><%=i++%></td>
			<td><%=vo.getMaterial_title()%></td>
			<td><%=vo.getView_rank() %></td>
			<td><input type="button" id="addBtn" value="다시풀기"></td>
			<td><input type="button" id="addBtn" value="결과보기"></td>
			
		</tr>
<%
	}
%>
	</tbody>	

</table>


</body>
</html>