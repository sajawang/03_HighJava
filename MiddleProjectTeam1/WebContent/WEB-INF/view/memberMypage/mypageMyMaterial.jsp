<%@page import="kr.or.ddit.vo.ViewListVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="../mainScript.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
</head>
<%
	List<ViewListVO> list = null;
	list = (List<ViewListVO>)request.getAttribute("list");
%>
<script type="text/javascript">
$(function(){
	$('.dasiBtn').on('click',function(){
		mno = $(this).parent().parent().find('#mno').val();
		location.href= "<%=request.getContextPath()%>/material/playMaterial.do?mno="+mno+"&vgu=1&resOn=N";
	})
	$('.gyulBtn').on('click',function(){
		mno = $(this).parent().parent().find('#mno').val();
		location.href= "<%=request.getContextPath()%>/material/playMaterial.do?mno="+mno+"&vgu=1&resOn=Y";
	})
	$('#gobacktomypagemain').on('click',function(){
		location.href= "<%=request.getContextPath()%>/goMypage.do";
	})
})	
</script>
<body>
<jsp:include page="../header.jsp" />

<br>
<nav id="nav_bar">
        <ul>
            <li><a href="<%=request.getContextPath()%>/myPageMaterial.do">내가 푼 학습지</a></li>
            <li><a href="<%=request.getContextPath()%>/tenMinuteViewMaterialist.do">매일10분수학</a></li>
            <li><a href="<%=request.getContextPath()%>/myPageBoardThree.do">이용문의내역</a></li>
            <li><a href="<%=request.getContextPath()%>/myPageBoardTwo.do">수학학습해결소내역</a></li>
            <li><a href="<%=request.getContextPath()%>/myMemberPointSelect.do">나의 포인트조회</a></li>
            <li><a href="<%=request.getContextPath()%>/myPageMemberUpdate.do">회원정보수정</a></li>
        </ul>
</nav>
<br>

<div style="display: flex; flex-direction: column; align-items: center;">
    <h2>풀었던 문제 목록 </h2>    
    <br><br>
    <table border="1" style="margin: 0 auto;">
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
        for(ViewListVO vo : list){
    %>
            <tr>
                <td><input type="hidden" id="mno" value="<%=vo.getMaterial_no() %>"><%=i++%></td>
                <td><%=vo.getMaterial_title()%></td>
                <td><%=vo.getView_rank() %></td>
                <td><input type="button" class="dasiBtn" value="다시풀기"></td>
                <td><input type="button" class="gyulBtn" value="결과보기"></td>
            </tr>
    <%
        }
    %>
        </tbody>    
    </table>
</div>
<br><br>
<jsp:include page="../footer.jsp" />
</body>
</html>