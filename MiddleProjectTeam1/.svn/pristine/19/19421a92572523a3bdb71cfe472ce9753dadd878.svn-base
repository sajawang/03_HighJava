<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

<script type="text/javascript">


$(document).ready(function() {
    $('#passbtn').on('click', function() {
        let userName = $('#name').val();
        let userEmail = $('#email').val();
        
        
        $.ajax({
            url: '<%=request.getContextPath()%>/newPassword.do',
            type: 'get',
            data: {
                "userName": userName,
                "userEmail": userEmail
            },
            success: function(res) {
                alert('이메일로 임시 비밀번호가 발급되었습니다.');
            },
            error: function(err) {
                alert('Error: ' + err.status);
                console.log(err.status);
            },
            dataType: 'json'
        });
    });
});


</script>
</head>
<body>
<!-- 자바의 표현식을 body태그 안에 작성하여 조건이 달라질 때 보이는 홈페이지가 다르도록. -->

<%
//JSP문서에서의 Session은 'session' 이라는 이름으로 생성되어있음.
//로그인 관련 Session정보 가져오기
String id = (String)session.getAttribute("id");
String name = (String)session.getAttribute("name");
if(id==null){
	id="";
}
%>
<%
if(name==null){
	//로그인이 안됐을 때. 
%>
<form action="<%=request.getContextPath()%>/sessionLoginDb.do" method="post">
 id : <input type="text" id="id" placeholder="id" name="id" value="<%=id%>"> 
 pass:<input type="text" id="pass" placeholder="pass" name="pass">
<input type="submit" value="Login"> 
 name : <input type="text" id="name" placeholder="name" name="name" > 
 email : <input type="text" id="email" placeholder="email" name="email"> 

<input type="button" id="passbtn" value="임시비밀번호 발급"> 
<!-- 비밀번호 찾기를 했을 때 이메일서블릿 > forward  -->
<!-- 로그인을 모름. 비밀번호 찾기 버튼을 누름.이디와 이메일을 입력하고 전송버튼을 누름. 
[여전히 로그인 페이지] 이메일을 확인함. 이메일 인증번호 획득 비밀번호 창에 입력. 로그인 처리 끝  -->

<!-- 비밀번호 재발급 sessionLoginDb.jsp / newPassword.java / SEssionLoginDb.java -->

</form>

<%
}else{
%>

<%=id +" "%><%=name %>님 반갑습니다 <br><br>

<a href="<%=request.getContextPath()%>/sessionLogoutDb.do"> 로그아웃 </a>

<%
}
%>

</body>
</html>