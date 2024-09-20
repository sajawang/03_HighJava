<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>

  <style>
  html, body {
 height: 100%;
  margin: 0;
  padding: 0;
}

  body {
    color: black;
	}
	.header-text {
    color: black !important;
}
	.header-text {
    color: black;
}
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
   .navbar-inverse .navbar-nav > li > a {
    background-color: transparent !important; /* 배경을 투명으로 */
   	color: black; /* 텍스트는 검정 */
}
    
    .navbar-inverse {
    background-color: white; /* 배경을 흰색으로 */
    border-color: white; /* 테두리 색도 흰색으로 */
}
    
   .navbar-inverse .navbar-nav > li > a, 
	.navbar-inverse .navbar-brand
	.navbar-inverse .navbar-nav > li > a:hover {
    color: black; /* 텍스트 색상을 검정으로 */
} 
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: tomato;
      height: 150%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: white;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
     .sidenav a {
        color:white;
        text-decoration:none;
      }
    
    
.navbar-nav > li.active > a {
    color: black !important;
    font-size: 40px;
}
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#" ></a>
      <img src="<%=request.getContextPath()%>/images/로고.png">
    </div>
	<div class="collapse navbar-collapse" id="myNavbar"> 
      <ul class="nav navbar-nav">
       <li class="active special-text" style="color:black"><a href="#">관리자 페이지</a></li>
        <tr>
        <td></td>
        </tr>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon logout"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">   
  <div class="row content">
    <div class="col-sm-2 sidenav" style="color: white;">
            <!-- 학생페이지 -->
      <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown">회원(학생) <span class="caret"></span></a>
          <ul class="dropdown-menu">
                   
           <li><a href="<%=request.getContextPath() %>/StudentList.do">학생 조회</a></li>
            <li><a href="#">새로운 학생 등록</a></li>
            <li><a href="#">학생 정보 변경</a></li>
            <li><a href="#">학생 탈퇴</a></li>
          </ul>
        </li>
      	<br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">회원(교사) <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">교사 조회</a></li>
            <li><a href="#">새로운 교사 등록</a></li>
            <li><a href="#">교사 인증 승인</a></li>
            <li><a href="#">교사 정보변경</a></li>
            <li><a href="#">교사 탈퇴</a></li>
          </ul>
        </li>
        
        <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">학습지 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">학습지 조회</a></li>
            <li><a href="#">새로운 학습지 등록</a></li>
            <li><a href="#">학습지 수정</a></li>
            <li><a href="#">학습지 삭제</a></li>
          </ul>
        </li>
        
         <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">매일10분수학<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">매일 10분 수학 신청 조회</a></li>
            <li><a href="#">매일 10분 수학 등록</a></li>
            <li><a href="#">매일 10분 수학 수정</a></li>
            <li><a href="#">매일 10분 수학 삭제</a></li>
          </ul>
        </li>
        
        <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">공지사항&자주 묻는 질문<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">공지사항 조회</a></li>
            <li><a href="#">공지사항 등록</a></li>
            <li><a href="#">공지사항 수정</a></li>
            <li><a href="#">공지사항 삭제</a></li>
          </ul>
        </li>
        
        <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">수학 학습 해결소<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">수학 학습 해결소 게시글 조회</a></li>
            <li><a href="#">수학 학습 해결소 게시글 삭제</a></li>
          </ul>
        </li>
        
             <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">수학 학습 해결소 댓글<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">수학 학습 해결소 댓글 조회</a></li>
            <li><a href="#">수학 학습 해결소 댓글 수정</a></li>
            <li><a href="#">수학 학습 해결소 댓글 삭제</a></li>
          </ul>
        </li>
        
     	     <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">이용문의<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">이용 문의 게시글 조회</a></li>
            <li><a href="#">이용 문의 게시글 삭제</a></li>
          </ul>
        </li>   
        
          <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">이용문의 댓글<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">이용 문의 댓글 조회</a></li>
            <li><a href="#">이용 문의 댓글 수정</a></li>
            <li><a href="#">이용 문의 댓글 삭제</a></li>
          </ul>
        </li>   
     
         <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">선생님 자료실<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">선생님 자료실 조회</a></li>
            <li><a href="#">선생님 자료실 등록</a></li>
            <li><a href="#">선생님 자료실 수정</a></li>
            <li><a href="#">선생님 자료실 삭제</a></li>
          </ul>
        </li>  
        
            <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">쌤 톡톡(talk talk)<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">쌤 톡톡 조회</a></li>
            <li><a href="#">쌤 톡톡 등록</a></li>
            <li><a href="#">쌤 톡톡 수정</a></li>
            <li><a href="#">쌤 톡톡 삭제</a></li>
          </ul>
        </li>    
     
     <br>
 		 <li class="dropdown">	     
         <a class="dropdown-toggle" data-toggle="dropdown" href="#">매일 10분 수학<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">매일 10분 수학 신청 조회</a></li>
            <li><a href="#">매일 10분 수학 신청 등록</a></li>
            <li><a href="#">매일 10분 수학 신청 수정</a></li>
            <li><a href="#">매일 10분 수학 신청 삭제</a></li>
          </ul>
        </li>    
     
     
     
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Welcome</h1>
      <p>안녕하세요 관리자 페이지 입니다</p><hr>
     <iframe src="admin/StudentList.jsp" name="student.main" style="width: 100%; height: 100vh; border: none;"></iframe>
    </div>
    <!-- <div class="col-sm-2 sidenav">
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div> -->
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
</head>
<body>

</body>
</html>