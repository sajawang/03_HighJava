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
		let id = $("#memid").val();
		
		$.ajax({
			url : "<%=request.getContextPath()%>/IdCheck.do",			
			type : "GET", 		
			data : { "id" : id },		
			success : function(data){
				if(data!=null) alert("중복된 아이디 입니다. 다시 입력하세요.");
				else alert("아이디 사용가능합니다.");
				/* let htmlCode="<h3>Lprod자료 목록</h3>";
				htmlCode += "<table border='1'>";
				htmlCode += "<tr><td>아이디</td><td>gu</td><td>nm</td></tr>"
				$.each(data, function(i,v){
					htmlCode += "<tr><td>"+v.lprod_id+"</td>";
					htmlCode += "<td>"+v.lprod_gu+"</td>";
					htmlCode += "<td>"+v.lprod_nm+"</td><tr>";
				});
				htmlCode += "</table>";
			
				$("#result").html(htmlCode); */
			},
			error : function(xhr){		
				alert("응답코드 : "+xhr.status);
			},
			dataType : "json" 
		})//ajax
	})//function
})//$(function)
</script>
<body>
<h3>회원 정보 입력 폼</h3>
<form>
<table border='1'>
	<tr>
		<td>회원ID</td>
		<td><input type="text" id="memid" name="memid"><input type="button" value="중복확인" id="idCheck"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" id="password"></td>
	</tr>
	<tr>
		<td>비밀번호확인</td>
		<td><input type="text" id="passwordCheck"></td>
	</tr>
	<tr>
		<td>회원이름</td>
		<td><input type="text" id="name"></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type="text" id="tel"></td>
	</tr>
	<tr>
		<td>회원주소</td>
		<td><input type="text" id="addr"></td>
	</tr>
	<tr>
		<td>프로필 사진</td>
		<td><input type="button" id="photo" value="파일선택">선택된파일없음</td>
	</tr>
	<tr>
		<td colspan='2'><input type="button" value="저장" id="save"><input type="button" value="취소" id="cancel"><input type="button" value="회원목록" id="memList"></td>
	</tr>
</table>
</form>
</body>
</html>