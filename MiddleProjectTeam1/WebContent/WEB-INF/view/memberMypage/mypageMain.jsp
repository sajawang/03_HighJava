<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="../mainScript.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>




<!--스타일추가 첫번째 테스트 전 원본 0923 4:15분-->
<style>
        #content {
            width: 100%;
            height: 600px; /* 원하는 높이로 설정 */
            border: none;
        }
</style>
    


    
</head>
<body>
<jsp:include page="../header.jsp" />
<%-- <jsp:include page="/WEB-INF/view/header.jsp"></jsp:include> --%>
<h2>마이페이지 </h2>



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



<!-- 마이페이지 메인에서  10분 수학 띄우기-->
<!-- <div class="search-container">
   	<select class="for-select" id="stype">
   		<option value="">전체</option>
   		<option value="cus_id">작성자</option>
   		<option value="post_title">제목</option>
   		<option value="post_content">내용</option>
   	</select>
   	<input type="text" id="sword" placeholder="검색어를 입력해주세요">
   	<input type="button" id="searchbtn" value="검색"> 
</div>-->



<jsp:include page="../footer.jsp" />
</body>
</html>                                                                                                       