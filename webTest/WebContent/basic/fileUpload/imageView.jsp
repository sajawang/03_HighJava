<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>이미지 처리하기</h2>

<!--현재 폴더 Webcontent-->
<img src="<%=request.getContextPath()%>/images/shutterstock_2205178589-1-1.png">


<!-- 이렇게 못쓴다 (이유 : 서버가 작동하는 경로와, 내가 저장한 접근경로가 다르다)
			   (결론 : 이클립스 폴더 안의 값만 사용 가능)
			   (하고 싶은 것 : 내 폴더에 있는 파일 내용을 img태그가 읽어갈 수 있게 하고 싶다.)  
<img src="d:/d_other/images/shutterstock_2205178589-1-1.png">

-->

<!--해결방법 : 이미지에 servlet명령을 쓰자-->
<img src="<%=request.getContextPath()%>/images/imageView.do?fileno=6">


</body>
</html>