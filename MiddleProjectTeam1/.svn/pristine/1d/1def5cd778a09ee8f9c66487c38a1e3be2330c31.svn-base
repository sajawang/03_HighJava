<%@page import="kr.or.ddit.vo.CustomerVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>
<style type="text/css">
    table, tr, td { border:1px solid blue; }
    td { padding:5px;}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

<script type="text/javascript">
$(document).ready(function() {
    // jQuery 코드를 여기에 작성하세요
    $("#addBtn").on("click", function(){
        location.href = "<%=request.getContextPath()%>/AdminTeacherInsert.do";
    });
});
</script>
</head>
<body>
<% List<MemberVO> TeacherList = (List<MemberVO>)request.getAttribute("TeacherList"); 
	CustomerVO cusVo = (CustomerVO)request.getAttribute("cusVo");%>
	
<h2>선생님 회원 목록 보기</h2>	
<table border="1">
	<thead>
		<tr>
			<td colspan="5" style="text-align:right;">
			<input type="button" id="addBtn" value="회원추가">
			</td>
		</tr>
		<tr>
			<th>ID</th>
			<th>이 름</th>
			<th>전 화</th>
			<th>주 소</th>
		</tr>
	</thead>
	<tbody>
	<% 
if (TeacherList != null) { 
	
    for(MemberVO memvo : TeacherList){
%>
        <tr>
            <td><a href="<%=request.getContextPath()%>/AdminTeacherView.do?cus_id=<%=memvo.getCus_id()%>"> 
                <%=memvo.getCus_id() %></a></td>
            <td><%=memvo.getMem_name() %></td>
            <td><%=memvo.getMem_tel() %></td>
            <td><%=memvo.getMem_add1() %></td>
        </tr>
<%
    }
} else {
%>
    <tr>
        <td colspan="3">학생 목록이 없습니다.</td>
    </tr>
<%
}
%>
	
</tbody>
</table>
</body>
</html>