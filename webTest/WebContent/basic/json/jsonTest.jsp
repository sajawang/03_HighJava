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
	//html태그를 읽어들인다
	//html태그를 분석한다
	//각각의 태그들을 트리 모양으로 구조를 만든다
	//그것을 DOM이라 부른다. html-body-.....
	//DOM의 좋은점 : 태그를 찾아가기 쉽다.
	//			   그 안에 있는 데이터 변경하기가 쉽다.
	//웹브라우저가 DOM에 있는 각각의 객체를 찾아가면서 랜더링
	// 랜더링(보여주기 위해 뭔가를 그리는 작업)
	
	//$(function(){}) -> 로딩이 되어서, 아까 DOM객체까지 만든 다음에 여기를 실행하라는 뜻
	
	//window.onload와 비슷하지만 다른점
	//window.onload는 화면에 내용이 다 보여진 다음에 실행하는것($(function(){})보다 더 늦게 실행됨)
	//화면이 약간 지직거리는 경향이 있을 수 있다. 
	
	//$(function(){ 1 2 3 }) 이런식으로.이건 하나만 써도 된다.
	$("#strBtn").on("click",function(){
					//이벤트   		//이벤트 실행했을때 실행되는 함수를 콜백함수
		
		//문자열처리
		$.ajax({
			//전송용 3개
			url : "<%=request.getContextPath()%>/json/jsonTest.do",			//요청을 보낼 주소(데이터를 받아서 처리할 문서의 주소)
			type : "POST", 		//전송방식(GET,POST) //POST방식이니까 CONTROLLER에서 doPost가 실행될것
			data : "choice=string",				//서버로 전송할 데이터를 구성
					//쿼리스트링 표기법
					//여러개이면 "choice=string&name=tom" 이런식으로 &로 연결
			
			//응답용 3개
			//servlet(controller)에서 보낸 값이 data로 온다.
			success : function(data){	//응답이 정상적으로 도달했을때 처리할 함수
									//이것도 콜백함수나 마찬가지 입니다.
					//매개변수 data에는 응답으로 온 데이터가 자동으로 저장된다.
					let htmlCode="<h3>문자열 응답 결과</h3>";
					htmlCode += data;
					
					$("#result").html(htmlCode);
			},
			error : function(xhr){		//오류응답처리
							//매개변수 3개까지 쓰기 가능
				alert("응답코드 : "+xhr.status);
			},
			dataType : "json" 			//응답으로 받을!!!!!!!!!!!!! 데이터의 Type을 지정한다.
			//json, xml, text, html....등등등등등등등등등등등등등등등등등등등등등등
			
			//총 6가지 속성
		});
	});
	//----------------------------------------------------------------------------------------------------------
	//배열처리
	$("#arrayBtn").on("click",function(){
		
		//문자열처리
		$.ajax({
			//전송용 3개
			url : "<%=request.getContextPath()%>/json/jsonTest.do",			
			type : "POST", 		
			data : "choice=array",				
			success : function(data){	
				//data = [10,20,30,40,50];
				//배열이니깐 꺼내자
				let htmlCode = "<h3>배열 응답결과</h3>";
				$.each(data,  function(i,v){
					//each의 작동방식
					htmlCode += i + "번째 자료 : " + v + "<br>";
				});
				
				$("#result").html(htmlCode);
			},
			error : function(xhr){		
			},
			dataType : "json" 			
		});
	});
	
	//----------------------------------------------------------------------------------------------------------
	//객체처리
	$("#objBtn").on("click",function(){
		
		//문자열처리
		$.ajax({
			//전송용 3개
			url : "<%=request.getContextPath()%>/json/jsonTest.do",			
			type : "POST", 		
			data : "choice=object",				
			success : function(data){	
				//data={"num":1, "name":"홍길동"}
				let htmlCode = "<h3>객체 응답결과</h3>";
				htmlCode += "번호 : "+data.num+"<br>";
				htmlCode += "이름 : "+data.name+"<br>";
				
				$("#result").html(htmlCode);
			},
			error : function(xhr){		
			},
			dataType : "json" 			
		});
	});
	//----------------------------------------------------------------------------------------------------------
	//List처리
	$("#listBtn").on("click",function(){
		
		//문자열처리
		$.ajax({
			//전송용 3개
			url : "<%=request.getContextPath()%>/json/jsonTest.do",			
			type : "POST", 		
			data : "choice=list",				
			success : function(data){	
				//data=[{"num":100, "name":이순신},{"num":200:"name":"강감찬"}]
				let htmlCode = "<h3>List 응답결과</h3>";
				$.each(data, function(i,v){
					//i, v=data[i]역할	
					htmlCode += i+"번째 자료<br>";
					htmlCode += "번호 : "+v.num+"<br>";
					htmlCode += "이름 : "+v.name+"<hr>";
				});
				/* for(let i=0; i<data.length; i++){
					htmlCode += i+"번째 자료<br>";
					htmlCode += "번호 : "+data[i].num+"<br>";
					htmlCode += "이름 : "+data[i].name+"<hr>";
				} */
				$("#result").html(htmlCode);
			},
			error : function(xhr){		
			},
			dataType : "json" 			
		});
	});
	//----------------------------------------------------------------------------------------------------------
	//Map처리
	$("#mapBtn").on("click",function(){
		
		//문자열처리
		$.ajax({
			//전송용 3개
			url : "<%=request.getContextPath()%>/json/jsonTest.do",			
			type : "POST", 		
			data : "choice=map",				
			success : function(data){	
				//data={"name":"이몽룡", "tel":"010-5656-7878", "addr":"대전"}
				//시작이 중괄호면 일반 객체
				let htmlCode = "<h3>map 응답결과</h3>";
				htmlCode += "이름 : "+data.name+"<br>";
				htmlCode += "전화 : "+data.tel+"<br>";
				htmlCode += "주소 : "+data.addr+"<br>";
				$("#result").html(htmlCode);
			},
			error : function(xhr){		
			},
			dataType : "json" 			
		});
	});
	//----------------------------------------------------------------------------------------------------------
	
});

</script>
</head>
<body>
<form>
	<input type="button" id="strBtn" value="문자열">
	<input type="button" id="arrayBtn" value="배열">
	<input type="button" id="objBtn" value="객체">
	<input type="button" id="listBtn" value="리스트">
	<input type="button" id="mapBtn" value="Map">
</form>

<div id="result"></div>

</body>
</html>