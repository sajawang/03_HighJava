<%@page import="kr.or.ddit.vo.CustomerVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, tr, td { border:1px solid blue; border-collapse: collapse; }
	td { padding:5px;}
</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

<script >

$(function(){
	
	$("#btnList").on("click", function(){
		location.href = "<%=request.getContextPath()%>/AdminStudentList.do";
	});
	
});
</script>
</head>
<body>
<%
	MemberVO memVo = (MemberVO) request.getAttribute("memberVo");
	CustomerVO cusVo = (CustomerVO)request.getAttribute("cusVo");
%>
<h2>학생 정보 수정</h2>
<form action="<%=request.getContextPath()%>/AdminStudentUpdate.do" method="post">
	<input type="hidden" name="cus_id" value="<%= (cusVo != null) ? cusVo.getCus_id() : "" %>"> 
	
<table border="1">
<tbody>
	
	<tr>
    <td>회원ID</td>
    <td><%=cusVo.getCus_id()%></td>
	</tr>
	
	
	<tr>
    <td>비밀번호</td>
    <td><input type="text" name="cus_pass" value="<%= (cusVo != null) ? cusVo.getCus_pw() : "" %>"></td>
	</tr>
	
	<tr>
    <td>회원이름</td>
<td><input type="text" name="mem_name" value="<%= (memVo != null ? memVo.getMem_name() : "") %>"></td>	</tr>
	
	<tr>
		<td>전화번호</td>
<td><input type="text" name="mem_tel" value="<%=(memVo != null ? memVo.getMem_tel() : "") %>"></td>	</tr>
	
	<tr>
		<td>회원생일</td>
		<td><input type="text" name="mem_bir" value="<%=(memVo !=null) ? memVo.getMem_bir() : ""%>"></td>
	</tr>	
		
	<tr>
		<td>우편번호</td>
		<td><input type="text" name="mem_zip" value="<%=(memVo != null) ?memVo.getMem_zip() : ""%>"></td>
	</tr>
	
	<tr>
		<td>기본주소</td>
		<td><input type="text" name="mem_add1" value="<%=(memVo!=null) ? memVo.getMem_add1() :""%>"></td>
	</tr>

	<tr>
		<td>상세주소</td>
		<td><input type="text" name="mem_add2" value="<%=(memVo!=null) ? memVo.getMem_add2() :""%>"></td>
	</tr>
	
	<tr>
		<td>메일</td>
		<td><input type="text" name="mem_mail" value="<%=(memVo!=null) ?memVo.getMem_mail() :""%>"></td>
	</tr>
		
		
		
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" value="저장"> <input type="reset" value="취소"> 
			<input type="button" id="btnList" value="회원목록"></td>
	</tr>
</tbody>
</table>
</form>
</body>
</html>