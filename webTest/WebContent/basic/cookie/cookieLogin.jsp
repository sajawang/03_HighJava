<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .login-container {
            width: 300px;
            margin: 0 auto;
            border: 1px solid #ccc;
            padding: 20px;
        }
 .login-container button {
			margin-left:100px;
      }
  
</style>
<%
	//쿠기 값을 확인하여 로그인 정보를 가져온다.
	Cookie[] cookieArr = request.getCookies();
	String loginId = "";	//쿠키에 저장된 ID값이 저장될 변수
	String chk="";		//checkbox의 체크 여부를 처리할 변수
	
	if(cookieArr != null){
		for(Cookie cookie : cookieArr){
			if("LOGIN_ID".equals(cookie.getName())){ 	//쿠키이름이 있으면
				loginId = cookie.getValue();	//쿠키값(로그인 할때 사용한 ID) 구하기
				chk = "checked";
			}
		}
	}

%>
</head>
<body>

<div class="login-container">
	<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="get">
		<label for="id">ID : </label>
		<input type="text" id="userid" name="userid" placeholder="ID 입력하세요." value=<%=loginId %>>
		<br>
		
		<label for="password">PASS : </label>
		<input type="password" id="userpass" name="userpass" placeholder="PassWord 입력하세요.">
		<br>
		
		<input type="checkbox" id="idChk" name="remember" value="<%=chk%>">
		<label for="remember">id 기억하기</label>
		<br><br>
		
		<button type="submit">Login</button>
	</form>
</div>

	
</body>
</html>