<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../mainScript.jsp" %>
<title>선생님 공간 - 선생님 자료실</title>
<script type="text/javascript">
mypath =  '<%= request.getContextPath()%>';
currentPage = 1;
$(function(){
	$.listPageServer3();
	
	// 다음 버튼 이벤트
	$(document).on('click', '#next', function(){
		// 나열되어 있는페이지 번호들(pageno)의 마지막 값을 가져온다.
		currentPage = parseInt($('.pageno').last().text()) + 1;
		$.listPageServer3();
	})
	// 이전 버튼 이벤트
	$(document).on('click', '#prev', function(){
		currentPage = parseInt($('.pageno').first().text()) - 1;
		$.listPageServer3();
	})
	// 페이지 번호 클릭 이벤트
	$(document).on('click', '.pageno', function(){
		currentPage = parseInt( $(this).text() );
		$.listPageServer3();
	})
	
	$(document).on('click', '.action1', function(){
		currentPage = 1;
		target = $(this);
		school = target.attr('data-school');
		grade = target.attr('data-grade');
		
		console.log("school : " + school);
		console.log("grade : " + grade);
		
		$('.action1').removeClass('on');
		$(this).addClass('on');
		$('#school').val(school);
		$('#grade').val(grade);
		$.listPageServer3();
	})
})
</script>
<style type="text/css">
	
	section #nav_bar ul li a.action, section #nav_bar ul li a.action1 {
		color: #7d7d7d;
	}
	
	section #nav_bar ul li a.on {
		color : black;
		/* text-decoration: underline; */
	}
	
	#nav_bar ul li::after {
	    content: none;
	}
	
	.pagination1{
	    display: inline-block;
	    padding-left: 0;
	    margin: 20px 0;
	    border-radius: 4px;
	}
	.pagination1>li{
		display : inline;	
	}
	.active{
		width: 100%
		margin : auto;
		min-height: 200px;
	}
	
	.pagination1>li:first-child>a {
		margin-left: 0;
	}
	
	.pagination1>.active>a, .pagination1>.active>a:focus, .pagination1>.active>a:hover {
	    z-index: 3;
	    color: black;
	    cursor: default;
	}
	
	.pagination1>li>a{
	    position: relative;
	    float: left;
	    padding: 6px 12px;
	    margin-left: -1px;
	    line-height: 1.42857143;
	    color: #337ab7;
	    text-decoration: none;
	    background-color: #fff;
	}
	
</style>
</head>
<body>
<jsp:include page="../header.jsp" />

<section>
	<nav id="nav_bar">
		<ul>
			<li><a class="action on" href="<%=request.getContextPath() %>/teacher/goTeacherLibraryList.do">선생님 자료실</a></li>
			<li style="border-left: 2px solid #dcdcdc; padding-left: 25px;"><a class="action" href="<%=request.getContextPath() %>/teacher/goSemTalkTalkList.do">쌤 톡톡(talk talk)</a></li>
		</ul>
	</nav>
	<input type="hidden" name="school" id="school" value="element">
	<input type="hidden" name="grade" id="grade" value="5">
</section>

<section>
	<nav id="nav_bar">
		<ul>
			<li>
				<a href="#" class="action1 on" data-school="element" data-grade="5" >초등5</a>	
			</li>
			<li  style="border-left: 2px solid #dcdcdc; padding-left: 25px;">
				<a href="#" class="action1" data-school="element" data-grade="6" >초등6</a>			
			</li>
			<li  style="border-left: 2px solid #dcdcdc; padding-left: 25px;">
				<a href="#" class="action1" data-school="middle" data-grade="1" >중학1</a>			
			</li>
			<li  style="border-left: 2px solid #dcdcdc; padding-left: 25px;">
				<a href="#" class="action1" data-school="middle" data-grade="2" >중학2</a>			
			</li>
			<li  style="border-left: 2px solid #dcdcdc; padding-left: 25px;">
				<a href="#" class="action1" data-school="middle" data-grade="3" >중학3</a>			
			</li>
		</ul>
	</nav>
</section>

<section>
	<div style="background-color: #F8FAFF; padding: 36px 50px;">
		<h2 style="font-weight: bold; text-align: left">선생님 자료실</h2>
		<h6>선생님을 위해 특별히 제작된 이미지 자료를 수업에 활용해 보세요!</h6>
	</div>
	<div id="result"></div>	
	<div id="pagelist" align="center"></div>
</section>

<jsp:include page="../footer.jsp" />
</body>
</html>