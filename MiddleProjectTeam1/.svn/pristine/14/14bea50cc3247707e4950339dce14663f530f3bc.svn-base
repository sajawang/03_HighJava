<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#goBackToMainPage").on("click", function(){
		location.href="<%=request.getContextPath()%>/index.jsp";
		//메인페이지로 
	});
});
</script>
</head>
<%
Integer mempoint = (Integer) request.getAttribute("mem_point");
String memname = (String)request.getAttribute("mem_name");
%>
<body>

<h1>나의 포인트정보</h1>

<%=memname %>님의 현재 포인트는 : <%=mempoint %><br>
<img src="<%=request.getContextPath() %>/mypageImages/브론즈.png" width="200" height="140">1000 포인트 미만<br>
<img src="<%=request.getContextPath() %>/mypageImages/실버.png" width="200" height="140">1000-5000 포인트<br>
<img src="<%=request.getContextPath() %>/mypageImages/골드.png" width="200" height="140">5000-10000 포인트<br>

<input type="button" id="goBackToMainPage" value="메인페이지로 돌아가기">

</body>
</html>