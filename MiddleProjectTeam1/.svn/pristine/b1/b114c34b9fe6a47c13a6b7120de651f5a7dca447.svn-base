<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="kr.or.ddit.vo.BoardVO"%>
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
	List<PostVO> list = null;
	list = (List<PostVO>)request.getAttribute("list");
%>
<script type="text/javascript">

</script>
<body>

<h2>이용문의 </h2>	
<table border="1">
	<thead>
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
<%
	int i=1;
	for(PostVO vo : list){
%>
		<tr>
			<td><%=i++%></td>
			<td><a href="<%=request.getContextPath()%>/csDetailPost.do?post_no=<%=vo.getPost_no()%>&board_no=2"><%=vo.getPost_title()%></a></td>
			<td><%=vo.getPost_date()%></td>
			<td><%=vo.getPost_cnt()%></td>
		</tr>
<%
	}
%>
	</tbody>	

</table>


</body>
</html>