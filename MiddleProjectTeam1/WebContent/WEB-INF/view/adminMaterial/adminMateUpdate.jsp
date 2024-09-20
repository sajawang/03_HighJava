<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.QuestionVO"%>
<%@page import="kr.or.ddit.vo.MaterialVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, tr, td { border:1px solid blue; border-collapse: collapse; }
	td { padding:5px;}
</style>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>

<script >
<%
// QuestionVO qVo = null;
	MaterialVO mateVo = (MaterialVO) request.getAttribute("mateVo");
	List<QuestionVO> qList = (List<QuestionVO>)request.getAttribute("qVoList");
	
	int queNo = 0;
	int mateNo = 0;
	String queCon = "";
	String queAns = "";
	String queSol = "";
	Integer filesNo = 0;
	
	Integer fileN=null;
	fileN=mateVo.getFiles_no();
	
	%>

$(function(){
	let i = 0;
	var rdw = 0;
	let x= 0;
	mypath='<%=request.getContextPath()%>';
	$("#btnList").on("click", function(){
//버튼을 클릭하면 문제 목록이 출력되도록
	
code='';
	
	//파일 인서트 안됨.
			code+='<form id="mateInsert" method="post" action='+mypath+'/adminQueUpdate.do>';
				code+='<table border="1">';
				code+='<tbody>';
	
		rdw++;
		x++;
//		alert(rdw);
	<%
	for(QuestionVO qvo : qList){
		 queNo = qvo.getQuestion_no();
		 mateNo = qvo.getMaterial_no();
		 queCon = qvo.getQuestion_content();
		 queAns = qvo.getQuestion_answer();
		 queSol = qvo.getQuestion_solve();
		 filesNo = qvo.getFiles_no();
	%>
			code+=`	<tr>`;
			code+='<input type="hidden" name="question_no" value="<%=queNo%>">';
					
			code+=`	<tr>
					<td>학습지번호</td>`;
			code+='		<td><input type="text" name="material_no'+i+'" id="material_no" value=<%=mateNo%>   ></td>';
				
					
			code+=`	</tr>
				<tr>
					<td>문제 내용</td>`;
			code+='		<td><input type="text" name="question_content'+i+'" id="question_content" value=<%=queCon%>   ></td>';
			
			code+=`	</tr>`;	
				
				code+=`	<tr>
					<td>문제 정답  </td>`;
			code+='		<td><input type="text" name="question_answer'+i+'" id="question_answer" value=<%=queAns%>   ></td>';
			code+=`	</tr>`;
				
			code+=`	<tr>
					<td>문제 풀이</td>`;
			code+='		<td><input type="text" name="question_solve'+i+'" id="question_solve" value=<%=queSol%>   ></td>';
			code+=`	</tr>`;		
			
			code+=`	<tr>
					<td>학습지 사진</td>`;
			code+='		<td><input type="file" name="files_no'+i+'" id="files_no" value=<%=filesNo%>   ></td>';
			code+=`	</tr>`;	
			
	<%
	}
	%>
		
			 
			code+=`	<tr>
					<td colspan="2" style="text-align:center;">
						<input type="submit" value="저장">
						<input type="button" id="Btn" value="그냥버튼">
						<input type="button"  id="btnList" value="학습지 등록 취소 목록으로 돌아가기">
					</td>
				</tr>`;
		code+=`</tbody>
				</table>`
			code+=`</form>`
			$('#res').html(code);	


	});
});
</script>
</head>
<body>

<h2>문제집 정보 설정</h2>
<form action="<%=request.getContextPath()%>/materialUpdate.do" 
		method="post" enctype="multipart/form-data">
	<input type="hidden" name="material_no" value="<%=mateVo.getMaterial_no()%>">
	<input type="hidden" name="files_no" value="<%=fileN == null ? "" : fileN%>">
	
<table border="1">
<tbody>
	
	<tr>
		<td colspan="2" style="text-align:center;">
		<img src="<%=request.getContextPath() %>/images/adminMateQueImageView.do?mno=<%=mateVo.getMaterial_no() %>" width="200" height="140"></td>
	</tr>
	<tr>
		<td>학습지 제목</td>
		<td><input type="text" name="material_title" value="<%=mateVo.getMaterial_title()%>"></td>
	</tr>
	<tr>
		<td>학습지 설명</td>
		<td><input type="text" name="material_des" value="<%=mateVo.getMaterial_des()%>"></td>
	</tr>
	<tr>
		<td>학습지 학년</td>
		<td><input type="text" name="material_grade" value="<%=mateVo.getMaterial_grade()%>"></td>
	</tr>
	<tr>
		<td>난이도 등급</td>
		<td><input type="text" name="material_level" value="<%=mateVo.getMaterial_level()%>"></td>
	</tr>
	
	<tr>
		<td>첨부파일</td>
		<td><input type="file" name="material_file" value="<%=mateVo.getFiles_no()%>"></td>
	</tr>	
	
	<tr>
		<td colspan="2" style="text-align:center;">
			<input type="submit" value="업데이트">
			<input type="button" id="btnList" value="문제목록 확인하기."></td>
			<input type="reset" value="취소"> 
	</tr>
</tbody>
</table>
</form>
<div id = res>

</div>

</body>
</html>