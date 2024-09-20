<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<title>Insert title here</title>

<style>
/* 전체 레이아웃 */
body {
    font-family: 'Noto Sans', sans-serif;
    background-color: #f9fafc;
    margin: 0;
    padding: 0;
}

.container {
    width: calc(100% - 300px); /* 왼쪽 메뉴를 제외한 화면의 나머지를 차지하도록 설정 */
    max-width: 900px;
    margin: 0 auto; /* 중앙 정렬 */
    background-color: #fff;
    padding: 30px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
}

/* 왼쪽 사이드바에 대한 스타일 */
.sidebar {
    width: 300px; /* 사이드바 크기를 고정 */
    position: fixed; /* 사이드바를 고정 */
    left: 0;
    top: 0;
    bottom: 0;
    background-color: #ffeb3b;
    padding: 20px;
}

/* 제목 스타일 */
h1 {
    text-align: center;
    color: #333;
    margin-bottom: 30px;
    font-size: 2.5rem;
    font-weight: 700;
    letter-spacing: -0.5px;
}

/* 입력 폼 스타일 */
form {
    width: 100%;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    font-weight: 600;
    margin-bottom: 5px;
}

input[type="text"],
input[type="password"],
input[type="date"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1rem;
}

button {
    padding: 12px 24px;
    background-color: #3498db;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 1rem;
    cursor: pointer;
    transition: background-color 0.3s;
    display: inline-block;
    margin-top: 10px;
}

button:hover {
    background-color: #2980b9;
}

button:active {
    background-color: #1c6693;
}

/* 반응형 처리 */
@media (max-width: 768px) {
    .container {
        padding: 20px;
    }
}

</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

<script type="text/javascript">




$(function(){
	$("#btnList").on("click", function(){
		location.href="<%=request.getContextPath()%>/AdminStudentList.do";
	});
	
	$("#idCheck").on("click", function(){
		var cusId = $("#cus_id").val();
		if(cusId==""){
			alert("ID를 입력하세요");
			return;
		}
		
		$.ajax({
	    	 url : '<%=request.getContextPath()%>/AdminCusIdCheck.do',
	    	 data : { "cus_id" : cusId },
	    	 dataType : 'json',
	    	 success : function(result){
	    		 if(result=="OK"){
	    			 $("#idChkResult").html("사용가능");
	    		 }else{
	    			 $("#idChkResult").html("ID 중복 - 사용불가");
	    		 }
	    	 },
	    	 error : function(xhr){
	    		 alert("status :" + xhr.status);
	    	 }
	     })
	});
	
	$("#Studentinsert").on("submit", function(){
		var idchk = $("#idChkResult").html();
		
		if(idchk!="사용가능"){
			alert("ID 중복되거나 중복체크를 하지 않았습니다.");
			return false;  // 전송 중단.
		}
		
		if($("#cus_pass").val()=="" || $("#cus_pass").val()!= $("#cus_pass2").val()){
			alert("비밀번호와 비밀번호 확인이 다릅니다. 다시 확인하세요.");
			return false;   // 서버로 전송을 하지 않는다.
		}
		
		
		return true;
	});
});

</script>
</head>


<body>
<div class="container">
    <h1>학생 정보 입력</h1>
<form id="Studentinsert" method="post" 
	action="<%=request.getContextPath()%>/AdminStudentInsert.do" >
	<div class="form-group">
            <label for="cus_id">회원ID</label>
			<input type="text" name="cus_id" id="cus_id">
			<input id="idCheck" type="button" value="중복확인"><br>
			<span id="idChkResult"></span>
		   </div>
	
		 <div class="form-group">
            <label for="cus_pass">비밀번호</label>
			<input type="text" name="cus_pass" id="cus_pass">
		</div>
	
	  <div class="form-group">
	   <label for="cus_pass2">비밀번호 확인</label>
		<input type="text" name="cus_pass2" id="cus_pass2">
	</div>
	
		 <div class="form-group">
            <label for="mem_name">회원 이름</label>
		<input type="text" name="mem_name">
	</div>
	
		  <div class="form-group">
            <label for="mem_tel">전화번호</label>
		<input type="text" name="mem_tel">
	</div>

	  <div class="form-group">
            <label for="mem_bir">생일</label>
		 <input type="date" name="mem_bir">
		 </div>
	
	
	 <div class="form-group">
            <label for="mem_zip">우편번호</label>
		<input type="text" name="mem_zip">
	</div>
	
	  <div class="form-group">
            <label for="mem_add1">주소</label>
		<input type="text" name="mem_add1">
		</div>

	  <div class="form-group">
            <label for="mem_add2">상세주소</label>
		<input type="text" name="mem_add2">
	</div>
	
	 <div class="form-group">
            <label for="email">이메일</label>
		<input type="text" name="mem_mail">
	</div>
	
	
		 <button type="submit">회원 등록</button>
		  <button type="button" id="btnList">취소</button>
		<!-- 	<input type="submit" value="저장"> <input type="button"  id="btnList" value="회원 등록 취소 목록으로 돌아가기"> -->
		

</form>
</div>
</body>
</html>