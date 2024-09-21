<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.MaterialVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    // jQuery 코드를 여기에 작성하세요
    $("#mateInsert").on("click", function(){
        location.href = "<%=request.getContextPath()%>/goMateInsert.do";
    });
});
</script>
<title>Insert title here</title>
</head>
<%
	List<MaterialVO> materList = (List<MaterialVO>)request.getAttribute("materList");
	int cnt = 0;
%>
<body>
	<h3>Material List</h3>
	<table border=1>
		<tr>
			<th>번호11</th>
			<th>제목33</th>
			<th>내용</th>
			<th>학년</th>
			<th>난이도</th>
		</tr>
		<% 
			if(materList == null || materList.size() == 0){
		%>
		
		<tr>
			<td colspan="5"> 내용이 없습니다.</td>
		</tr>
		
		<%
			} else {
				for(MaterialVO vo : materList) {
					cnt++;
		%>
		
		<tr>
			
			<td><input type="hidden" value="<%=vo.getMaterial_no() %>"><%=cnt %></td>
			<td><a href="<%=request.getContextPath()%>/material/detailMaterial.do?mno=<%=vo.getMaterial_no() %>"><%=vo.getMaterial_title() %></a></td>
			<td><%=vo.getMaterial_des() %></td>
			<td><%=vo.getMaterial_grade() %></td>
			<td><%=vo.getMaterial_level() %></td>
		</tr>
		
		<%	
				}
			}
		%>
	</table>
	<input type="button" value="학습지등록" id="mateInsert">
	
</body>
</html>