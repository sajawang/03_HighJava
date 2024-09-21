<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.serializejson.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/teacherLib.js?v=<%=System.currentTimeMillis()%>"></script>
<title>Insert title here</title>
<script type="text/javascript">
mypath =  '<%= request.getContextPath()%>';
currentPage = 1;
$(function(){
	$.listPageServer();
	
	// 다음 버튼 이벤트
	$(document).on('click', '#next', function(){
		// 나열되어 있는페이지 번호들(pageno)의 마지막 값을 가져온다.
		currentPage = parseInt($('.pageno').last().text()) + 1;
		$.listPageServer();
	})
	// 이전 버튼 이벤트
	$(document).on('click', '#prev', function(){
		currentPage = parseInt($('.pageno').first().text()) - 1;
		$.listPageServer();
	})
	// 페이지 번호 클릭 이벤트
	$(document).on('click', '.pageno', function(){
		currentPage = parseInt( $(this).text() );
		$.listPageServer();
	})
	
	$(document).on('click', '.action', function(){
		currentPage = 1;
		target = $(this);
		school = target.attr('data-school');
		grade = target.attr('data-grade');
		
		console.log("school : " + school);
		console.log("grade : " + grade);
		
		$('.action').parent().removeClass('on');
		$(this).parent().addClass('on');
		$('#school').val(school);
		$('#grade').val(grade);
		$.listPageServer();
	})
})
</script>
</head>
<body>
	<ul>
		<li>
			<a href="<%=request.getContextPath() %>/teacher/goTeacherLibraryList.do">선생님 자료실</a>
		</li>
		<li>
			<a href="<%=request.getContextPath() %>/teacher/goSemTalkTalkList.do">쌤 톡톡(talk talk)</a>
		</li>
	</ul>
	<h3>선생님 자료실 | 교사용 이미지 자료</h3>
	<h6>선생님을 위해 특별히 제작된 이미지 자료를 수업에 활용해 보세요!</h6>
	<input type="hidden" name="school" id="school" value="element">
	<input type="hidden" name="grade" id="grade" value="5">
	<section>
		<ul>
			<li class="on">
				<a href="#" class="action" data-school="element" data-grade="5" >초등5</a>	
			</li>
			<li>
				<a href="#" class="action" data-school="element" data-grade="6" >초등6</a>			
			</li>
			<li>
				<a href="#" class="action" data-school="middle" data-grade="1" >중학1</a>			
			</li>
			<li>
				<a href="#" class="action" data-school="middle" data-grade="2" >중학2</a>			
			</li>
			<li>
				<a href="#" class="action" data-school="middle" data-grade="3" >중학3</a>			
			</li>
		</ul>
	</section>
	<section>
		<div id="result"></div>	
		<div id="pagelist"></div>
	</section>
</body>
</html>