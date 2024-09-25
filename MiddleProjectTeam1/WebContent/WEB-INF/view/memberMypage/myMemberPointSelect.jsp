<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="../mainScript.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
</script>
<style>
    .point-info {
        display: flex;
        justify-content: center;
        flex-wrap: wrap;
        margin-top: 20px;
    }

    .point-card {
        text-align: center;
        margin: 15px;
        border: 2px solid #ccc;
        border-radius: 10px;
        padding: 10px;
        box-shadow: 2px 2px 12px rgba(0, 0, 0, 0.1);
        transition: transform 0.2s;
    }

    .point-card:hover {
        transform: scale(1.05);
    }

    .point-card img {
        width: 150px;
        height: auto;
    }

    .point-card p {
        font-size: 1.2em;
        margin-top: 10px;
    }
</style>

</head>
<%
Integer mempoint = (Integer) request.getAttribute("mem_point");
String memname = (String)request.getAttribute("mem_name");
%>
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

<div style="text-align: center;">
    <h1>나의 포인트정보</h1>
	<br><br>
    <h2><p><%=memname %>님의 현재 포인트는 : <%=mempoint %></p></h2>
    <br><br>
    <div class="point-info">
       <div class="point-card">
           <img src="${pageContext.request.contextPath}/images/bronze.png" alt="브론즈">
           <p>1000 포인트 미만</p>
       </div>
       <div class="point-card">
           <img src="${pageContext.request.contextPath}/images/silver.png" alt="실버">
           <p>1000-5000 포인트</p>
       </div>
       <div class="point-card">
           <img src="${pageContext.request.contextPath}/images/gold.png" alt="골드">
           <p>5000-10000 포인트</p>
       </div>
   </div>
</div>
<br><br>
<jsp:include page="../footer.jsp" />
</body>
</html>