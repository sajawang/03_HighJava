<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>

<style>
  body {
      font-family: 'Arial', sans-serif;
      margin: 0;
      padding: 0;
      display: flex;
      flex-direction: column;
  }

  /* 헤더 스타일 */
  .header {
      background-color: tomato;
      padding: 20px;
      display: flex;
      align-items: center; /* 수직 중앙 정렬 */
      justify-content: center; /* 글씨를 중앙에 배치 */
      position: relative; /* 로그아웃 버튼을 절대 위치로 조절 */
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  }

  .header h1 {
      font-size: 36px;
      color: white;
      margin: 0;
  }

  .logout-link {
      position: absolute;
      right: 20px;
      top: 50%;
      transform: translateY(-50%);
      text-decoration: none;
      font-size: 16px;
      color: #333;
      background-color: rgb(255, 226, 20);
      padding: 5px 10px;
      border-radius: 5px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }

  .logout-link:hover {
      background-color: white;
  }

  /* 메인 레이아웃 */
  .container {
      display: flex;
      height: calc(100vh - 80px); /* 헤더를 제외한 나머지 영역을 채우기 */
  }

  /* 사이드바 스타일 */
  .sidebar {
      width: 250px;
      display: flex;
      flex-direction: column;
      align-items: center;
      padding: 20px;
      background-color: rgb(255, 226, 20);
      height: 100%;
  }

  .sidebar img {
      width: 100%;
      margin-bottom: 20px;
      border-radius: 10px;
  }

  /* 사이드바 내의 리스트 스타일 */
  .nav-list {
      list-style-type: none;
      padding: 0;
      margin: 0;
      width: 100%;
  }

  .nav-list li {
      margin-bottom: 15px;
      background-color: white;
      border-radius: 5px;
  }

  .nav-list a {
      color: black;
      text-decoration: none;
      font-size: 20px;
      display: block;
      padding: 12px 15px;
      text-align: center;
      background-color: rgb(255, 226, 20);
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      transition: background-color 0.3s, transform 0.3s;
  }

  .nav-list a:hover {
      background-color: white;
      transform: translateX(5px);
  }

  /* 메인 콘텐츠 스타일 */
  .content {
      flex: 1;
      padding: 20px;
      background-color: white;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
      border-radius: 10px;
      margin: 20px;
      overflow: hidden;
  }

  .content iframe {
      width: 100%;
      height: 100%;
      border: none;
      border-radius: 10px;
      box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  }

  /* 반응형 레이아웃 */
  @media (max-width: 768px) {
      .container {
          flex-direction: column;
      }

      .sidebar {
          width: 100%;
          height: auto;
          flex-direction: row;
          justify-content: space-around;
      }

      .content {
          margin: 10px 0;
          padding: 10px;
      }

      .content iframe {
          height: 600px;
      }
  }
</style>
</head>
<body>
    <!-- 헤더 -->
    <div class="header">
        <h1>스스로 수학 관리자 페이지</h1>
        <a href="<%=request.getContextPath()%>/AdminLogout.do" class="logout-link">로그아웃</a>
    </div>

    <!-- 메인 레이아웃 -->
    <div class="container">
        <!-- 사이드바 -->
        <div class="sidebar">
            <img src="<%=request.getContextPath()%>/images/로고.png" alt="로고">

            <ul class="nav-list">
                <li><a onclick="noticeIframe('<%=request.getContextPath() %>/AdminStudentList.do')">회원(학생)</a></li>
                <li><a onclick="noticeIframe('<%=request.getContextPath() %>/AdminTeacherauth.do')">교사인증</a></li>
                <li><a onclick="noticeIframe('<%=request.getContextPath()%>/AdminTeacherList.do')">회원(교사)</a></li>
                <li><a onclick="noticeIframe('<%=request.getContextPath()%>/adminmaterialList.do')">학습지</a></li>
                   <li><a onclick="noticeIframe('<%=request.getContextPath()%>/AdminTenMathList.do')">매일 10분 수학</a></li>
                <li><a onclick="noticeIframe('<%=request.getContextPath()%>/AdminNoticeList.do')">공지사항</a></li>
                <li><a onclick="noticeIframe('<%=request.getContextPath()%>/adminMymathBoardList.do')">수학 학습 해결소</a></li>
                <li><a onclick="noticeIframe('<%=request.getContextPath()%>/adminInquiriesList.do')">이용 문의 게시판</a></li>
                <li><a onclick="noticeIframe('<%=request.getContextPath()%>/AdminTeacherLibraryList.do')">선생님 자료실</a></li>
                <li><a onclick="noticeIframe('<%=request.getContextPath()%>/AdminTeacherTalkList.do')">샘 톡톡 (Talk Talk)</a></li>
            </ul>
        </div>

        <!-- 콘텐츠 영역 -->
        <div class="content">
            <iframe id="contentFrame" src=""></iframe>
        </div>
    </div>

   <!-- 스크립트: iframe에 페이지 뜨게 하는 것 -->
    <script>
        function noticeIframe(page) {
            document.getElementById('contentFrame').src = page;
        }
    </script> 
</body>
</html>
