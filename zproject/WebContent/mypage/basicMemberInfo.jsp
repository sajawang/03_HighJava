<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO memvo = (MemberVO)request.getAttribute("MemberVO");
%>
<h2>회원 정보 수정</h2>	
<h3>내 기본 정보</h3>	
<table border="1">
	<thead>
		<tr>
			<td colspan="2" style="text-align:right;">
				<input type="button" id="addBtn" value="회원정보수정">
			</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=memvo.getMem_name()%>(<%=memvo.getUser_id()%>)</td>
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
				<input type="button" id="addBtn" value="회원탈퇴">
			</td>
		</tr>
	</thead>
	<tbody>
</body>
</html>