<%@page import="kr.or.ddit.vo.ViewListVO"%>
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
<%
	List<ViewListVO> mlist = null;
	mlist = (List<ViewListVO>)request.getAttribute("mlist");
	
	MaterialVO mtvo = (MaterialVO)request.getAttribute("mtvo");
%>
<script type="text/javascript">
$(function(){
	$('#subscribeSetting').on('click',function(){
		location.href="<%=request.getContextPath()%>/tenMinuteSubscribeSetting.do";		
	})
	
	$('#todayMaterial').on('click',function(){
		location.href="<%=request.getContextPath()%>/tenMinuteTodayMaterial.do";		
	})
	
	
	$('#dasiBtn').on('click',function(){
		mno = $(this).parent().parent().find('#mno').val();
		location.href= "<%=request.getContextPath()%>/material/playMaterial.do?mno="+mno+"&vgu=2&resOn=N";
	})
	$('#gyulBtn').on('click',function(){
		mno = $(this).parent().parent().find('#mno').val();
		location.href= "<%=request.getContextPath()%>/material/playMaterial.do?mno="+mno+"&vgu=2&resOn=Y";
	})
})

</script>
<body>

<div>
	<input type="button" value="구독설정" id="subscribeSetting"><br>
</div>

<div>
	<%-- <jsp:include page="/<%=request.getContextPath()%>/dummy.jsp"></jsp:include> --%>
	학습현황<jsp:include page="dummy.jsp"></jsp:include><br>
	<!-- <iframe src="/WebContent/dummy.jsp"></iframe> -->
</div>

<div>
	오늘의 10분수학<br>
	내 수강과정 : <%=mtvo.getMaterial_grade() %> <%=mtvo.getMaterial_level() %><br>
	오늘의 문제 : <%=mtvo.getMaterial_title() %>
	<input type="button" value="오늘의 문제 풀기" id="todayMaterial">
</div>


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
	int i=1;
	for(ViewListVO mvo : mlist){
%>
		<tr>
			<td><input type="hidden" id="mno" value="<%=mvo.getMaterial_no() %>"><%=i++%></td>
			<td><%=mvo.getMaterial_title()%></td>
			<td><%=mvo.getView_rank() %></td>
			<td><input type="button" id="dasiBtn" value="다시풀기"></td>
			<td><input type="button" id="gyulBtn" value="결과보기"></td>
			
		</tr>
<%
	}
%>
	</tbody>	

</table>


</body>
</html>