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
	MemberVO memVo = (MemberVO)request.getAttribute("memberVo");
%>
<h2>회원 정보 수정 </h2>
<form action="<%=request.getContextPath()%>/member/memberUpdate.do" 
		method="post" enctype="multipart/form-data">
<table border="1">
<tbody>
	<tr>
		<td>아이디</td>
		<td><%=memVo.getCus_id()%></td>
	</tr>
	<tr>
		<td>새 비밀번호</td>
		<td><input type="password" name="mem_pass" value=""></td>
	</tr>
	<tr>
		<td>새 비밀번호 확인</td>
		<td><input type="password" name="mem_pass_check" value=""></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="mem_name" value="<%=memVo.getMem_name()%>"></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><input type="text" name="mem_name" value="<%=memVo.getMem_bir()%>"></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type="text" name="mem_addr" value="주소처리 해야함(회원가입 석님 참고)"></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="mem_addr" value="<%=memVo.getMem_mail()%>"></td>
	</tr>
	<tr>
		<td>휴대폰</td>
		<td><input type="text" name="mem_tel" value="<%=memVo.getMem_tel()%>"></td>
	</tr>
	<tr>
		<td>교사 인증 정보</td>
		<td><input type="text" name="mem_tel" value="교사인증버튼 생성-> 사진 올리고->...과정 필요"></td>
	</tr>
</tbody>
</table>
</form>
</body>
</html>	
