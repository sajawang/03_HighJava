<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>스스로 로그인</title>

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<!-- <script src="../js/jquery-3.7.1.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-serializeJSON/2.5.0/jquery.serializejson.min.js"></script> -->

<!-- <script src="../../js/jquery.serializejson.min.js"></script> -->
<script src="${pageContext.request.contextPath}/js/jquery.serializejson.min.js"></script>
<script type="text/javascript">

$(function(){
	  function openIdPopup(){
	        window.open("idInput.jsp", "new", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=700, height=700, left=0, top=0" );
	    }
	  function openPassPopup(){
	        window.open("passInput.jsp", "new", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=700, height=700, left=0, top=0" );
	    }

	$('#idFind').on('click',function(){
		openIdPopup();
	})
	$('#newPass').on('click',function(){
		openPassPopup();
	})

// function openPopup() {
//   // 팝업을 띄울 페이지 URL
//   var popupURL = "https://aortm2.tistory.com/";
//   // 팝업 창의 속성
//   var popupProperties = "width=600,height=400,scrollbars=yes";
//   // 팝업 열기
//   window.open(popupURL, "Popup", popupProperties);
// }

	$('#newCustomer').on('click',function(){
		
		location.href='<%=request.getContextPath()%>/goInsertMember.do';	
	})
	
})

</script>

<style>

* {
  box-sizing: border-box;azimuth;
  font font-family :'Hakgyoansim Dunggeunmiso OTF B',sans-serif;
  }
  

 h1 {
  text-align: center;
}


body{
   
   margin :0;
   background-color: tomato;
   padding : 500px;
    }
    
.login-form{
   width :400px;
   border:0;
   border-radius :5px;
   background-color : white;
   padding : 20px;
   margin: 0 auto;
   height : 450px;
}
.logo{
width: 150px;

}
.text-field{
   font-size : 14px;
   margin :10px;
   border :none;
   border-radius: 5px;
   padding :1px;

}
.submit-btn{
color : white;
font-size: 14px;
background-color : tomato;
margin-bottom :40px;
padding: 10px;
border : none;
border-radius: 5px;
}

</style>
</head>
   
<body>
<%
    String loginId = (String)session.getAttribute("loginId");
   if(loginId==null){
      
%>  

<form  class="login-form" action="<%=request.getContextPath() %>/sessionLoginDb.do"  method="post">
<table border-collapse= 'collapse'   width='100%'>
<div class="container">

  <h1>LOGIN</h1>
  <tr>
<td><img src="${pageContext.request.contextPath}/images/로고.png" class="logo" style= "text-align: center"></td>

</tr>
</div> 
<tr>
   <td>ID: </td>
<td><input type = "text" class="text-field" placeholder="ID 입력하세요" name = "cus_id" ></td>
</tr>
<tr>
<br>
   <td>PASS:</td>
<td><input type = "password" class="text-field" placeholder="PASSWORD를 입력하세요" name = "cus_pw" id ="userpass"></td>
</tr>
 <tr>    
<td colspan="2" style="text-align: center">
<br>
<input type="submit" class= "submit-btn" name="Login" id="Login"  value="Login">
<br>
<input type="button" class= "submit-btn" name="idFind" id="idFind"  value="아이디찾기">
<input type="button" class= "submit-btn" name="newPass" id="newPass"  value="비밀번호찾기">
<input type="button" class= "submit-btn" name="newCustomer" id="newCustomer"  value="회원가입">

</td>
</tr>

</table>
</form>
<%
} else{// 로그인 성공했을 때
%>
<%-- <%=loginId %>님 반갑습니다.<br><br> --%>
<a href= "<%=request.getContextPath() %>/AdminLogin.do">로그아웃</a>
<%      
   }
%>
</body>



</html>