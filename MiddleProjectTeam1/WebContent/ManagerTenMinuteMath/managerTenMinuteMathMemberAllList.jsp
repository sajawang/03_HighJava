<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");
%>
</head>
<body>
표
회원아이디		이름		10분수학 구독신청
						버튼 활성화?(표를 3개 join해야하는 -member,customer,mathsetting)
</body>
</html>