<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
</head>
<script type="text/javascript">
$(function(){
	
	$("#btnUpdate").on("click", function(){
		var form = document.getElementById("memberForm");
		form.method = "GET";
		form.action = "<%=request.getContextPath()%>/myPageMemberUpdateForm.do";
		form.submit();
	});
	
	$("#btnDelete").on("click", function(){
		var form = document.getElementById("memberForm");
		form.action = "<%=request.getContextPath()%>/myMemberDelete.do";
		form.submit();
	});
});
	
</script>
<body>
<%
	MemberVO memvo = (MemberVO)request.getAttribute("MemberVO");
%>
<h2>회원 정보 수정</h2>	
<form name="memberForm" id="memberForm" >	
	<input type="hidden" id="mem_id" name="mem_id" value="<%=memvo.getMem_name()%>">
<table border="1">
	<thead>
		<tr>
			<td colspan="2" style="text-align:right;">
				<h3 style="text-align: left;">내 기본 정보</h3><input type="button" id="btnUpdate" value="회원정보수정">
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=memvo.getMem_name()%>(<%=memvo.getCus_id() %>)</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td><%=memvo.getMem_bir()%></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=memvo.getMem_mail()%></td>
		</tr>
		<tr>
			<th>휴대폰</th>
			<td><%=memvo.getMem_tel()%></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right;">
				<input type="button" id="btnDelete" value="회원탈퇴">
			</td>
		</tr>
	</thead>
	</table>
</form>
</body>
</html>