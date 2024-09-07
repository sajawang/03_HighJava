<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//JSP문서에서의 Session은 'session'이라는 이름으로 이미 저장되어 있다.

//로그인 관련 Session정보 가져오기
MemberVO loginMember = (MemberVO)session.getAttribute("loginMemVo");

%>

<%
if(loginMember==null){//로그인 안되었을때...
	
%>
<body>

<div class="login-container">
	<form action="<%=request.getContextPath()%>/sessionLoginDb.do" method="get">
		<label for="id">ID : </label>
		<input type="text" id="userid" name="userid" placeholder="ID 입력하세요.">
		<br>
		
		<label for="password">PASS : </label>
		<input type="password" id="userpass" name="userpass" placeholder="PassWord 입력하세요.">
		<br>
		
		<button type="submit">Login</button>
	</form>
<%
}else{//로그인 성공했을때
%>	

<%=loginMember.getMem_name() %>님 반갑습니다.<br><br>

<a href="<%=request.getContextPath() %>/sessionLogoutDb.do"> 로그아웃</a>

<%
}
%>
</div>

	
</body>
</html>
</body>
</html>