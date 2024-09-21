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
	$("#cancel").on("click", function(){
		location.href="<%=request.getContextPath()%>/index.jsp";
		//메인페이지로 
	});
});
</script>
</head>
<body>
<h2>매일10분 수학 구독 설정</h2>
<form name="tenMinForm" id="tenMinForm" action="<%=request.getContextPath()%>/firstTenMinuteSubscribeSetting.do">	
<table border="1">
	<thead>
		<tr>
			<th>목표시간</th>
			<td>
				<input type = "radio" value="10분" name="setGoalTime">10분 
				<input type = "radio" value="20분" name="setGoalTime">20분 
				<input type = "radio" value="30분" name="setGoalTime">30분 
			</td>
		</tr>
		<tr>
			<th>학년선택</th>
			<td>
				<input type = "radio" value="초등 3학년 " name="setGrade">초등 3학년 
				<input type = "radio" value="초등 4학년 " name="setGrade">초등 4학년 
				<input type = "radio" value="초등 5학년 " name="setGrade">초등 5학년 
				<input type = "radio" value="초등 6학년 " name="setGrade">초등 6학년 
			</td>
		</tr>
		<tr>
			<th>학기선택</th>
			<td>
				<input type = "radio" value="1학기" name="setSemester">1학기
				<input type = "radio" value="2학기" name="setSemester">2학기
			</td>
		</tr>
		<tr>
			<th>난이도</th>
			<td>
				<input type = "radio" value="기본" name="setLevel">기본 
				<input type = "radio" value="심화" name="setLevel">심화 
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right;">
				개인정보 수집 동의<input type="checkbox" id="개인정보 수집 동의" value="개인정보 수집 동의" name="personalInfoConsent">
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:right;">
				<input type="button" id="cancel" value="취소">
				<input type="submit" id="submit" value="저장">
			</td>
		</tr>
	</thead>
</table>
</form>
</body>
</html>