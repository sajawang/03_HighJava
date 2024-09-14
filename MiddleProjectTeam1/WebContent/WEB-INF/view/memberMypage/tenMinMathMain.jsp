<%@page import="kr.or.ddit.vo.MaterialVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$('#subscribeSetting').on('click',function(){
		location.href="<%=request.getContextPath()%>/tenMinuteSubscribeSetting.do";		
	})
	
	$('#todayMaterial').on('click',function(){
		location.href="<%=request.getContextPath()%>/tenMinuteTodayMaterial.do";		
	})
})

</script>
<body>
<div><input type="button" value="구독설정" id="subscribeSetting"></div>
<div>달성률</div>
<div>오늘의 10분수학(오늘날짜)<input type="button" value="오늘의 문제" id="todayMaterial"></div>


<%
	List<MaterialVO> mlist = null;
	mlist = (List<MaterialVO>)request.getAttribute("mlist");
%>
<h2>풀었던 문제 목록 </h2>	
<table border="1">
	<thead>
		<tr>
			<th>NO</th>
			<th>학습지 제목</th>
			<th>점수</th>
			<th>다시풀기</th>
			<th>결과보기</th>
		</tr>
	</thead>
	<tbody>
<%
	for(MaterialVO mvo : mlist){
%>
		<tr>
			<td>시퀀스</td>
			<td><%=mvo.getMaterial_title()%></td>
			<td>점수</td>
			<td><input type="button" id="addBtn" value="다시풀기"></td>
			<td><input type="button" id="addBtn" value="결과보기"></td>
		</tr>
<%
	}
%>
	</tbody>	

</table>


</body>
</html>