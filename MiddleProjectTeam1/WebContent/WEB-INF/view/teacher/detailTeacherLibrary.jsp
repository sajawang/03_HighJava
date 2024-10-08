<%@page import="java.net.URLEncoder"%>
<%@page import="kr.or.ddit.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../mainScript.jsp" %>
<title>선생님 공간 - 선생님 자료실</title>
</head>
<%
	PostVO pvo = (PostVO)request.getAttribute("pvo");
%>
<script type="text/javascript">
	function goTeacherLibraryList(){
		location.href= "<%=request.getContextPath()%>/teacher/goTeacherLibraryList.do";
	}
</script>
<style type="text/css">
	.prev{
		width : 20px;
		margin: 10px 10px 16px 10px;
	}
</style>
<body>
<jsp:include page="../header.jsp" />
<article>
	<div>
		<div style="margin-top: 10px;">
			<strong style="cursor : pointer;" onclick="goTeacherLibraryList()"  ><img class="prev" alt="icon_prev.svg" src="<%=request.getContextPath()%>/images/icon_prev.svg"><span style="font-size:2.0rem">선생님 자료실 목록보기</span></strong>
		</div>
		<div style="display:flex;">
			<div style="width: 50%; background-color: #F8F8F8; padding: 0px; margin: 50px; height: 606px;">
				<div style="margin: 100px; text-align: center; height: 75%; align-content: center;">
					<img alt="<%=pvo.getFiles_name() %>" src="<%=request.getContextPath() %>/images/imageView.do?path=<%=pvo.getFiles_name() %>" >					
				</div>
			</div>
			<div style="width:50%; margin: 115px 50px 50px 115px;">
				<div style="height:20%;">
					<div style="font-weight: 900; font-size: 28px; line-height: 36px; width: 100%;"><%=pvo.getPost_title() %></div>
					<!-- <p style="padding-top: 8px; font-size: 16px; line-height: 26px; color: #7d7d7d;" >연산 응용력을 강화하여 문장제 해결력 향상</p> -->
				</div>
				<div style="height: 47%; border-top: 1px solid #dcdcdc; border-bottom: 1px solid #dcdcdc; padding-bottom: 15px;">
					<table style="width:100%; margin:10px; height:100%; font-size:1.6rem;">
						<tr style="width:100%;">
							<td style="width:20%; border: 0px;">자료설명</td>
							<td style=" border: 0px;"><%=pvo.getPost_content() %></td>
						</tr>
						<tr style="width:100%;">
							<td style=" border: 0px;">작성자</td>
							<td style=" border: 0px;"><%=pvo.getCus_id() %></td>
						</tr>
						<tr style="width:100%;">
							<td style=" border: 0px;">작성날짜</td>
							<td style=" border: 0px;"><%=pvo.getPost_date() %></td>
						</tr>
						<tr style="width:100%;">
							<td style=" border: 0px;">조회수</td>
							<td style=" border: 0px;"><%=pvo.getPost_cnt() %></td>
						</tr>
					</table>
				</div>
				<div style="height: 33%; margin-top: 35px; margin-left: 20px;" >
					<button style="color: #4d4d4d; border: 1px solid #4d4d4d; height: 46px; border-radius: 50px; background-color: #fff; padding: 0 20px; " type="button" id="btn1" onclick="location.href='<%=request.getContextPath() %>/teacher/fileDownload.do?fileName=<%=pvo.getFiles_name()%>'"><span style="font-size:16px; line-height:44px; font-weight: 700;">다운로드</span></button>
				</div>
			</div>
		</div>
	</div>
</article>

<jsp:include page="../footer.jsp" />
</body>
</html>