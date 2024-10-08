<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../mainScript.jsp" %>

<%
String da= (String)session.getAttribute("userGu"); // 회원의 종류 - 학생 - 선생님 값 가져오기

String sw = null;
int eq = 0;

MemberVO memVo=(MemberVO)session.getAttribute("memVo");
if(memVo!=null){
	sw = memVo.getCus_id();
	eq = memVo.getMem_point();
}

String back =(String)request.getAttribute("back");
	String board_no =(String)request.getAttribute("board_no");
%>

<script>
mypath =  '<%= request.getContextPath()%>';
back = '<%= back%>';
board_no = '<%=board_no%>';
/*
$(function(){
	
	$('#send').on('click', function(){
		writeData = $('#csPostForm').serializeJSON();
		
		$.boardWriteServer(back);
		
		 $('#csPostForm').find('input, textarea, select').each(function() {
		        $(this).val('');
		        
		  });
	
	});
	
});
*/

/*
$(function(){
	$('#send').on('click', function(){
		// FormData 객체 생성
		let formData = new FormData($('#csPostForm')[0]);
		
		let url = "http://localhost/MiddleProjectTeam1/csInsertPost.do";
		
		$.ajax({
			url: url,
			data: formData,
			type: 'post',
			contentType: false,  // 파일 전송을 위해 contentType을 false로 설정
			processData: false,  // 데이터 자동 변환 방지
			success: function(res) {
				alert(res.flag);
				
				// 폼 초기화
				$('#csPostForm').find('input, textarea, select').each(function() {
					$(this).val('');
				});
				location.href = `${mypath}/mainToJsp.do?target=${back}`;
			},
			error: function(xhr) {
				alert("오류 : " + xhr.status);
			},
			dataType: 'json'
		});

		
	});
});
*/	

</script>

<title>게시글쓰기</title>
<style>

        /* 게시판 테이블 스타일 */
        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
            text-align: left;
        }

        table th, table td {
            border: 1px solid #ccc;
            padding: 10px;
        }

        table th {
            background-color: #f9f9f9;
        }

</style>
</head>
<body>
<jsp:include page="../header.jsp" />

<form id="csPostForm" method="post" enctype="multipart/form-data"
	action="<%=request.getContextPath()%>/csInsertPost.do">
	<h3 align="center">게시글 작성</h3>
<table border="1">
<tbody>
	<tr>
		<td>회원ID</td>
		 <td><%=sw %></td>
		<td><input type="hidden" name="cus_id" id="cus_id" value="<%=sw %>"></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" name="post_title" id="post_title" placeholder="제목을 입력하세요"></td>
	</tr>
	<tr>
		<td>분류</td>
		<td>
    <select class="post_gu" id="post_gu" name="post_gu">
        <option value="이용문의" <% if ("3".equals(board_no)) { %>selected<% } %>>이용문의</option>
        <%
            String userGu = (String) session.getAttribute("userGu");
            if ("student".equals(userGu)) {
        %>
            <option value="나의수학해결소" <% if ("2".equals(board_no)) { %>selected<% } %>>나의수학해결소</option>
        <%
            }
            if ("teacher".equals(userGu)) {
        %>
            <option value="쌤톡톡" <% if ("5".equals(board_no)) { %>selected<% } %>>쌤톡톡</option>
        <%
            }
        %>
    </select>
</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea rows="10" cols="100" name="post_content" id="post_content" placeholder="내용을 입력하세요"></textarea></td>
	</tr>
	
    <%
    	if (!"5".equals(board_no)) {
    %>	
	<tr>
		<td>첨부파일</td>
		<td><input type="file" name="post_files" id="post_files"></td>
	</tr>
	<%
    	}
    %>	
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" value="저장" id="send"> <input type="reset" value="초기화">
			<input type="button" id="backbtn" value="돌아가기" onclick="location.href=<%=request.getContextPath()%>/customerService.do"></td>
	</tr>
</tbody>
</table>
</form>

<jsp:include page="../footer.jsp" />
</body>
</html>