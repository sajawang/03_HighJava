<%@page import="kr.or.ddit.vo.CustomerVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 수정</title>
<style type="text/css">
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 20px;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
        font-size: 24px;
    }

    .container {
        width: 60%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 10px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
        table-layout: fixed;
    }

    th, td {
        border: 1px solid #ddd;
        padding: 15px;
        text-align: left;
    }

    th {
        background-color: #f4f4f4;
        font-weight: bold;
        width: 30%;
    }

    td input[type="text"] {
        width: 100%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .button-container {
        text-align: center;
        margin-top: 20px;
    }

    input[type="submit"], input[type="reset"], input[type="button"] {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        margin-right: 10px;
        transition: background-color 0.3s;
    }

    input[type="submit"]:hover, input[type="reset"]:hover, input[type="button"]:hover {
        background-color: #0056b3;
    }

    input[type="button"] {
        background-color: #28a745;
    }

    input[type="button"]:hover {
        background-color: #218838;
    }

    td[colspan="2"] {
        text-align: center;
    }

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