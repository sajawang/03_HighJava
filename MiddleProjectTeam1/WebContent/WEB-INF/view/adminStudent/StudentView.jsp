<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.CustomerVO"%>
<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head><meta charset="UTF-8"/>
<title>Insert title here</title>

  <style type="text/css">
     /* 기본 스타일 설정 */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: flex-start;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
            font-size: 24px;
        }

        /* 전체 폼을 감싸는 컨테이너 */
        .container {
            width: 80%;
            max-width: 800px;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin: 20px auto;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            table-layout: fixed;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #f4f4f4;
            font-weight: bold;
            text-align: right;
            width: 30%;
        }

        td {
            background-color: #fff;
            text-align: left;
            word-wrap: break-word;
        }

        .button-container {
            margin-top: 20px;
        }

        input[type="button"] {
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

        input[type="button"]:hover {
            background-color: #0056b3;
        }

        input[type="button"]:last-child {
            margin-right: 0;
        }

    </style>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>


<script>

$(function(){
	
	$("#btnUpdate").on("click", function(){
		var form = document.getElementById("StudentList");
		form.method = "GET";
		form.action = "<%=request.getContextPath()%>/AdminStudentUpdate.do";
		form.submit();
	});
	
	$("#btnDelete").on("click", function(){
		var form = document.getElementById("StudentList");
		form.action = "<%=request.getContextPath()%>/AdminStudentDelete.do";
		form.submit();
	});
	
	$("#btnList").on("click", function(){
		location.href = "<%=request.getContextPath()%>/AdminStudentList.do";
	});
	
});




</script>
</head>
<body>

<% 	MemberVO memVo = (MemberVO) request.getAttribute("memberVo");
	CustomerVO cusVo = (CustomerVO)request.getAttribute("cusVo");
	%>


<form name="StudentList" id="StudentList" >
	<input type="hidden" id="cus_id" name="cus_id" value="<%=memVo.getCus_id()%>">
<table border="1">
<tbody>

	<tr>
    <td colspan="2" style="text-align:center; font-weight:bold; font-size:18px;">학생 정보 상세보기</td>
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
	

		<td colspan="2" style="text-align:center;">
			<input id="btnUpdate" type="button" value="수정"> 
			<input id="btnDelete" type="button" value="삭제"> 
			<input type="button" id="btnList" value="회원목록"></td>
	</tr>
</tbody>
</table>
</form></body></html>