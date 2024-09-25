<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
  
   <% 
// String sw = (String)session.getAttribute("id");
String da= (String)session.getAttribute("userGu"); // 회원의 종류 - 학생 - 선생님 값 가져오기;
String sw = null;
int eq = 0;

MemberVO memVo=(MemberVO)session.getAttribute("memVo");
if(memVo!=null){
	sw = memVo.getCus_id();
	eq = memVo.getMem_point();
}
%>
<script type="text/javascript">

function alretStudent(){
	alert("학생전용 서비스입니다.");
}
function alretTeacher(){
	alert("선생님전용 서비스입니다.");
}
</script>  
<title></title>

</head>
<body>

  
  <footer class="container-fluid text-center">
  	<div class="bottom-bar">
    	<nav class="bottom-links">

    	 <% if(sw==null){
            %>
      	<a href="<%=request.getContextPath()%>/goLogin.do">[학습지 보기]</a>
      	<a href="<%=request.getContextPath()%>/goLogin.do">[이용 문의]</a>
      	<a href="<%=request.getContextPath()%>/goLogin.do">[FAQ]</a>
      	<a href="<%=request.getContextPath()%>/goLogin.do">[마이페이지]</a>
      	
      	<%	
    	 }else if(sw!=null&&"student".equals(da)){          	%>
      	<a href="<%=request.getContextPath()%>/material/goMaterial.do?school=element&grade=3">[학습지 보기]</a>
      	<a href="#">[이용 문의]</a>
      	<a href="#">[FAQ]</a>
      	<a href="<%=request.getContextPath() %>/goTenMinMath.do">[마이페이지]</a>
        
     	<%
    	 }else if(sw!=null&&"teacher".equals(da)){%>
      	<a href="javascript:alretStudent();">[학습지 보기]</a>
      	<a href="#">[이용 문의]</a>
      	<a href="#">[FAQ]</a>
      	<a href="<%=request.getContextPath() %>/goTenMinMath.do">[마이페이지]</a>
        
        <%
     }
     %>
    	</nav>
  	</div>
  	
  	<div class="math_info">
  	<br>
  		<address>
  			" 34908 대전광역시 대전 중구 계룡로 846 3층 | 사업자등록번호 : 200-00-11222 (SELFMATH대표 홍길동)"
  			<br>
  			" SELFMATH 고객센터 1588-0000 (발신자 부담 | 인터넷 문의)"
  			<a href="mailto:selfMath@naver.com">selfMath@naver.com</a>
  			"| FAX : 042-000-0000"
  			<br>
  			" 부가통신사업신고 : 00001 | 통신판매업신고 : 2024-대전중구-8282"
  		</address>
  	</div>
</footer>
</body>
</html>