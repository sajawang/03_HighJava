<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#idCheck").on("click",function(){
		let id = $("#registerSubmit").val();
		
		$.ajax({
			url : "<%=request.getContextPath()%>/IdCheck.do",			
			type : "GET", 		
			data : { "id" : id },		
			success : function(data){
				if(data=="no") alert("중복된 아이디 입니다. 다시 입력하세요.");
				else alert("아이디 사용가능합니다.");
			},
			error : function(xhr){		
				alert("응답코드 : "+xhr.status);
			},
// 			dataType : "json" 
			dataType : "text" 
		})//ajax
	})//#idCheck
	
	$("#photoChoose").on('click',function(){
		//파일선택하는 방법?
	})
	
	//$('#saveRegisterForm').on('click',function(){
		//폼에서  입력된 자료들을 어떻게 들고가지?! -> form에서는 <script>쓸 필요가 없다. 
		//폼에서 입력된 자료들이 뭔지 어떻게 알지 -> <input type="submit">
		//그걸 들고 서버로 어떻게 가지 -> 이렇게 form태그의 action과  input type의 submit이 연결된다. 
		//서버 이름은 InsertMember.do라고 하고 싶은데!!
		//action안의 주소 쓰는 방법을 모르겠어 -> action="" => action="주소/ InsertMember.do" => action="<>/ InsertMember.do"=> action="<퍼센트=request.getContextPath()퍼센트>/ InsertMember.do"
		//저 form에서 누가 넘어오지? 무적권 <input태그의 name 속성!!>
		//submit하면 넘어가나?	ㅇㅇ	
	//})
})//$(function)
</script>
<body>
<h3>회원 정보 입력 폼</h3>
<form action="<%=request.getContextPath() %>>/InsertMember.do" method="post">
<!--비밀번호니까 post방식으로 간다-->
<table border='1'>
	<tr>
		<td>회원ID</td>
		<td><input type="text" id="memid" name="memid"><input type="button" value="중복확인" id="idCheck"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" id="password" name="password"></td>
	</tr>
	<tr>
		<td>비밀번호확인</td>
		<td><input type="text" id="passwordCheck" name="passwordCheck"></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><input type="text" id="memname" name="memname"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" id="tel" name="tel"></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><input type="text" id="addr" name="addr"></td>
	</tr>
	<tr>
		<td>프로필 사진</td>
		<td><input type="button" id="photoChoose" value="파일선택" name="registerSubmit">선택된파일없음</td>
	</tr>
	<tr>
		<td colspan='2'><input type="submit" value="저장" id="saveRegisterForm"><input type="button" value="취소" id="cancel"><input type="button" value="회원목록" id="memList"></td>
	</tr>
</table>
</form>
</body>
</html>