<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <% 
String da= (String)session.getAttribute("userGu"); // 회원의 종류 - 학생 - 선생님 값 가져오기
System.out.println(da);
String sw = null;
int eq = 0;

MemberVO memVo=(MemberVO)session.getAttribute("memVo");
if(memVo!=null){
	sw = memVo.getCus_id();
	eq = memVo.getMem_point();
}
%>
<title></title>

<script type="text/javascript">

function alretStudent(){
	alert("학생전용 서비스입니다.");
}
function alretTeacher(){
	alert("선생님전용 서비스입니다.");
}

function openPopup() {
    window.open(
        '<%=request.getContextPath() %>/mainToJsp.do?target=/WEB-INF/view/chat/webSocketMutiChatting.jsp', 
        'popupWindow', 
        'width=600, height=400, scrollbars=yes, resizable=yes'
    );
}


</script>

</head>
<body>
<header id="header">
        <div class="top-bar">
            <nav class="top-links">
            <% if(sw==null){
            %>
                <a href="<%=request.getContextPath()%>/goLogin.do">고객센터</a>
                <a href="<%=request.getContextPath()%>/goLogin.do">선생님공간</a>
                <a href="<%=request.getContextPath()%>/goLogin.do">매일 10분 수학</a>
                <a href="<%=request.getContextPath()%>/goLogin.do">공지사항</a>            
            <%	
            }else if(sw!=null&&"student".equals(da)){          	%>
                <a href="<%=request.getContextPath() %>/mainToJsp.do?target=/WEB-INF/view/customerService/customerService.jsp" >고객센터</a>
                <a href="javascript:alretTeacher();">선생님공간</a>
                <a href="<%=request.getContextPath()%>/goTenMinMath.do">매일 10분 수학</a>
                <a href="<%=request.getContextPath() %>/mainToJsp.do?target=/WEB-INF/view/customerService/customerService.jsp">공지사항</a>
            	<%
            }else if(sw!=null&&"teacher".equals(da)){			%>
                <a href="<%=request.getContextPath() %>/mainToJsp.do?target=/WEB-INF/view/customerService/customerService.jsp" >고객센터</a>
                <a href="<%=request.getContextPath()%>/teacher/goTeacherLibraryList.do">선생님공간</a>
                <a href="javascript:alretStudent();">매일 10분 수학</a>
                <a href="<%=request.getContextPath() %>/mainToJsp.do?target=/WEB-INF/view/customerService/customerService.jsp">공지사항</a>
            	<%
            }
           %>
            </nav>
        <div class="user-options">
        <!-- 서블릿으로 view폴더 안의 jsp파일에 접근할 수 있도록 하이퍼링크에 서블릿 주소를 작성하고 서블릿에서 원하는 jsp파일로 바로 리다이렉트로 전송 -->
            <% if(sw==null){
            %>
                <a href="<%=request.getContextPath() %>/goInsertMember.do">회원가입</a>
            <%	
            }else{
            	%>
            	<a href="#" onclick="openPopup(); return false;">실시간토의실</a>
                <a href="<%=request.getContextPath() %>/goTenMinMath.do">마이페이지</a>
                <a href="<%=request.getContextPath() %>/goInsertMember.do">회원가입</a>                
            	<%
            } 
            %>
                
            </div>
        </div>
  </header>      
  
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="<%=request.getContextPath() %>/mainToJsp.do?target=/index.jsp"><img src="<%=request.getContextPath() %>/images/로고.png" alt="로고" id="logo" ></a></li>
        <li id="active"><a href="<%=request.getContextPath() %>/mainToJsp.do?target=/index.jsp">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">초등수학 <span class="caret"></span></a>
          <ul class="dropdown-menu">
          <% if(sw==null){
          %>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">초등학교 3학년</a></li>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">초등학교 4학년</a></li>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">초등학교 5학년</a></li>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">초등학교 6학년</a></li>

            <%	
            }else if(sw!=null&&"student".equals(da)){
            	%>
            <li><a href="<%=request.getContextPath() %>/material/goMaterial.do?school=element&grade=3">초등학교 3학년</a></li>
            <li><a href="<%=request.getContextPath() %>/material/goMaterial.do?school=element&grade=4">초등학교 4학년</a></li>
            <li><a href="<%=request.getContextPath() %>/material/goMaterial.do?school=element&grade=5">초등학교 5학년</a></li>
            <li><a href="<%=request.getContextPath() %>/material/goMaterial.do?school=element&grade=6">초등학교 6학년</a></li>

            	<%
            } else if(sw!=null&&"teacher".equals(da)){
            %>
            <li><a href="javascript:alretStudent();">초등학교 3학년</a></li>
            <li><a href="javascript:alretStudent();">초등학교 4학년</a></li>
            <li><a href="javascript:alretStudent();">초등학교 5학년</a></li>
            <li><a href="javascript:alretStudent();">초등학교 6학년</a></li>
            <%
		    }
    		%>
            <!-- Add more items as needed -->
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">중등수학 <span class="caret"></span></a>
          <ul class="dropdown-menu">
                    <% if(sw==null){
          %>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">중학교 1학년</a></li>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">중학교 2학년</a></li>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">중학교 3학년</a></li>

            <%	
            }else if(sw!=null&&"student".equals(da)){
            	%>
            <li><a href="<%=request.getContextPath() %>/material/goMaterial.do?school=middle&grade=1">중학교 1학년</a></li>
            <li><a href="<%=request.getContextPath() %>/material/goMaterial.do?school=middle&grade=2">중학교 2학년</a></li>
            <li><a href="<%=request.getContextPath() %>/material/goMaterial.do?school=middle&grade=3">중학교 3학년</a></li>

            	<%
            } else if(sw!=null&&"teacher".equals(da)){
            %>
            <li><a href="javascript:alretStudent();">중학교 1학년</a></li>
            <li><a href="javascript:alretStudent();">중학교 2학년</a></li>
            <li><a href="javascript:alretStudent();">중학교 3학년</a></li>
            <%
		    }
    		%>
          
            <!-- Add more items as needed -->
          </ul>
        </li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">고등수학 <span class="caret"></span></a>
          <ul class="dropdown-menu">
                    <% if(sw==null){
          %>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">고등학교 수학</a></li>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">수학 I</a></li>
            <li><a href="<%=request.getContextPath()%>/goLogin.do">수학 II</a></li>

            <%	
            }else if(sw!=null&&"student".equals(da)){
            	%>
            <li><a href="#">고등학교 수학</a></li>
            <li><a href="#">수학 I</a></li>
            <li><a href="#">수학 II</a></li>
            <%
            } else if(sw!=null&&"teacher".equals(da)){
            %>
            <li><a href="javascript:alretStudent();">고등학교 수학</a></li>
            <li><a href="javascript:alretStudent();">수학 I</a></li>
            <li><a href="javascript:alretStudent();">수학 II</a></li>
             <%
		    }
    		%>
          
            <!-- Add more items as needed -->
          </ul>
        </li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
      <br>
   		<%
   		if(memVo==null){
   		%>	
        <li><a href="<%=request.getContextPath()%>/goLogin.do"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      	<%
   		}else{
   		//memVo에 정보가 담기고 Gu값이 teacher라면 황금칭호를 출력한다.
   		if(da.equals("teacher")){
		%>
   		<li> <img height="50" width="50" alt="king.png" src="${pageContext.request.contextPath}/images/king.png">&emsp;&emsp; </li>

		<%   			
   		}else{
   			%>
   			<%
   		if(eq<1000){
        %>
   		<li> <img height="50" width="50" alt="bronze.png" src="${pageContext.request.contextPath}/images/bronze.png">&emsp;&emsp; </li>

   		<%
   		}else if(eq>1000&&eq<4999){
   		%>
   		<li> <img height="50" width="50" alt="silver.png" src="${pageContext.request.contextPath}/images/silver.png">&emsp;&emsp; </li>   		

   		<%	
   		}else if(eq>5000&&eq<9999){
   	   	%>
   	   	<li> <img height="50" width="50" alt="gold.png" src="${pageContext.request.contextPath}/images/gold.png">&emsp;&emsp; </li>   		

   	   	<%	
   	   	}else if(eq>9999){
   	   	%>
   	   	<li> <img height="50" width="50" alt="diamond.png" src="${pageContext.request.contextPath}/images/diamond.png">&emsp;&emsp; </li>   		

   	   	<%	
   	   	}
   	   	%>
   		<%
   		}
   		%>
   		<li><span> <%=sw%>님 반갑습니다. </span> </li>
   		
        <li> <a href="<%=request.getContextPath()%>/goLogout.do"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
   		<%
   		}
   		%>
      </ul>
    
    </div>
  </div>
</nav>

 
</body>
</html>