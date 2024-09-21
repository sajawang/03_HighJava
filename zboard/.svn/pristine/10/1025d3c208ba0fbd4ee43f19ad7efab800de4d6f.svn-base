/<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.CustomerVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"/>
<title>선생님 상세보기</title>

<style type="text/css">
	table, tr, td { border:1px solid blue; border-collapse: collapse; }
	td { padding:5px;}
</style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>


<script>

$(function(){
	
	$("#btnUpdate").on("click", function(){
		var form = document.getElementById("TeacherList");
		form.method = "GET";
		form.action = "<%=request.getContextPath()%>/AdminTeacherUpdate.do";
		form.submit();
	});
	
	$("#btnDelete").on("click", function(){
		var form = document.getElementById("TeacherList");
		form.action = "<%=request.getContextPath()%>/AdminTeacherDelete.do";
		form.submit();
	});
	
	$("#btnList").on("click", function(){
		location.href = "<%=request.getContextPath()%>/AdminTeacherList.do";
	});
	
});




</script>
</head>
<body>

<% 	MemberVO memVo = (MemberVO) request.getAttribute("memberVo");
	CustomerVO cusVo = (CustomerVO)request.getAttribute("cusVo");
	%>

<h2>선생님 정보 상세보기</h2>
<form name="TeacherList" id="TeacherList" >
	<input type="hidden" id="cus_id" name="cus_id" value="<%=memVo.getCus_id()%>">
<table border="1">
<tbody>
	<tr>
		<td colspan="2" style="text-align:center;"><img src="<%= request.getContextPath() 
		%>/AdminTeacherImageView.do?cusID=<%= memVo.getCus_id() %>" width="200" height="140"></td>
	</tr>	

	<tr>
		<td>회원ID</td><td><%=cusVo.getCus_id()%></td>
	</tr>
	<tr>
		<td>비밀번호</td><td><%=cusVo.getCus_pw()%></td>
	</tr>
	
	<tr>
		<td>회원 분류</td><td><%=cusVo.getCus_gu()%></td>
	</tr>
		
	<tr>
		<td>회원이름</td><td><%=memVo.getMem_name()%></td>
	</tr>
	
	<tr>
		<td>전화번호</td><td><%=memVo.getMem_tel()%></td>
	</tr>
	
	<tr>
		<td>회원생일</td><td><%=memVo.getMem_bir()%></td>
	</tr>
	
	<tr>
		<td>우편번호</td><td><%=memVo.getMem_zip()%></td>
	</tr>
	
	<tr>
		<td>기본주소</td><td><%=memVo.getMem_add1()%></td>
	</tr>
	
	<tr>
		<td>상세주소</td><td><%=memVo.getMem_add2()%></td>
	</tr>
	
	<tr>
		<td>이메일</td><td><%=memVo.getMem_mail()%></td>
	</tr>
	
	<tr>
		<td>선생님 인증</td><td><%=memVo.getMem_auth()%></td>
	</tr>
	
	<tr>
	

		<td colspan="2" style="text-align:center;">
			<input id="btnUpdate" type="button" value="수정"> 
			<input id="btnDelete" type="button" value="삭제"> 
			<input type="button" id="btnList" value="회원목록"></td>
	</tr>
</tbody>
</table>
</form></body></html>