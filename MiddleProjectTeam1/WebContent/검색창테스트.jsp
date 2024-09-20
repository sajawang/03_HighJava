<%@page import="kr.or.ddit.vo.PostVO"%>
<%@page import="kr.or.ddit.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
   <script src="js/jquery-3.7.1.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="main/css/customerService.css"> 
  <link rel="stylesheet" href="main/css/main.css">
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">

<script>
currentPage = 1;
mypath =  '<%= request.getContextPath()%>';
</script>

<title>고객센터_공지사항</title>
</head>

<body>
<jsp:include page="/WEB-INF/view/header.jsp" />

<section>
    <h2>고객센터</h2>
    <nav id="nav_bar">
        <ul>
            <li><a href="<%=request.getContextPath() %>/customerService.do">공지사항</a></li>
            <li><a href="<%=request.getContextPath() %>/customerService.do?target=/WEB-INF/view/customerService/FAQ.jsp">FAQ</a></li>
            <li><a href="<%=request.getContextPath() %>/customerService.do?target=/WEB-INF/view/customerService/inquiry.jsp">1:1 문의</a></li>
            <li><a href="<%=request.getContextPath() %>/customerService.do?target=/WEB-INF/view/customerService/mathSolution.jsp">수학학습해결소</a></li>
        </ul>
    </nav>
    
    <!-- 검색창 -->
    <div class="search-container">
    	<select class="for-select" id="stype">
    		<option value="">전체</option>
    		<option value="cus_id">작성자</option>
    		<option value="post_title">제목</option>
    		<option value="post_content">내용</option>
    	</select>
    	<input type="text" id="sword" placeholder="검색어를 입력해주세요">
    	<input type="button" id="searchbtn" value="Q">
	</div>
</section>

<!-- 리스트 3개씩을 출력 -->
   <div id="result"></div>
   
   <br>
   <br>
   
   <!-- 페이지정보를 출력  -->
   <div id="pagelist"></div>


<jsp:include page="/WEB-INF/view/footer.jsp" />

</body>
</html>