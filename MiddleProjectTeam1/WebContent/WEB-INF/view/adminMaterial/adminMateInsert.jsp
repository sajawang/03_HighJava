<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
$(function(){
	

	let i = 0;
	var rdw = 0;
	let x= 0;
	mypath='<%=request.getContextPath()%>';
	//문제삽입창. 여기서 문제 출력을 누르면 5문제를 등록할 수 있는 칸이 나와야한다.
	$('#QueBtn').on('click',function(){
				code='';
			//파일 인서트 안됨.
				code+='<form  id="mateInsert" method="post"  action='+mypath+'/adminQueInsert.do>';
					code+='<table border="1">';
					code+='<tbody>';
		for(i = 1;i<6;i++){
			rdw++;
			x++;
// 		alert(rdw);
				code+=`	<tr>
						<td>학습지번호</td>`;
				code+='		<td><input type="text" name="material_no'+i+'" id="material_no" ></td>';
					
						
				code+=`	</tr>
					<tr>
						<td>문제 내용</td>`;
				code+='		<td><input type="text" name="question_content'+i+'" id="question_content" ></td>';
				
				code+=`	</tr>`;	
					
					code+=`	<tr>
						<td>문제 정답  </td>`;
				code+='		<td><input type="text" name="question_answer'+i+'" id="question_answer" ></td>';
				code+=`	<tr>`;
					
				code+=`	<tr>
						<td>문제 풀이</td>`;
				code+='		<td><input type="text" name="question_solve'+i+'" id="question_solve" ></td>';
				code+=`	</tr>`;		
				
				code+=`	<tr>
						<td>학습지 사진</td>`;
				code+='		<td><input type="file" name="files_no'+i+'" id="files_no" ></td>';
				code+=`	</tr>`;	
		}		
				 
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

})

$('#mateSaveBtn').on('click', function() {
    var formData = new FormData();  // FormData 객체 생성

    // 폼 데이터 (텍스트 필드)
    formData.append('material_title', $('#material_title').val());
    formData.append('material_des', $('#material_des').val());
    formData.append('material_grade', $('#material_grade').val());

    // 체크박스 (체크된 값만 추가)
    var materialLevels = [];
    $('input[name="material_level"]:checked').each(function() {
        materialLevels.push($(this).val());
    });
    formData.append('material_level', materialLevels.join(','));

    // 파일 데이터 추가
    var fileInput = $('#material_file')[0].files[0];  // 파일 필드에서 파일 가져오기
    if (fileInput) {
        formData.append('material_file', fileInput);
    }

    // Ajax로 서버에 전송
    $.ajax({
        url: '<%=request.getContextPath()%>/adminMateInsert.do',
        type: 'POST',
        data: formData,
        contentType: false,  // FormData를 사용하므로 contentType 설정을 false로
        processData: false,  // 데이터를 자동으로 변환하지 않도록 설정
        success: function(res) {
        	
//             alert(res.flag);
            alert('저장되었습니다.');
<%--             window.location.href = '<%=request.getContextPath()%>/material/materialList.do'; --%>
        },
        error: function(error) {
            alert('오류 발생: ' + error.statusText);
        }
    });
});


})
</script>


</head>
<body>
<h2>학습지 정보 입력</h2>



<form id="mateInsert" method="post"  enctype="multipart/form-data" action="<%=request.getContextPath()%>/adminMateInsert.do" >
<table border="1">
<tbody>
	<tr>
		<td>학습지 제목</td>
		<td>
			<input type="text" name="material_title" id="material_title">
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="material_des" id="material_des"></td>
	</tr>
	<tr>
		<td>학년</td>
		<td><input type="text" name="material_grade" id="material_grade"></td>
	</tr>	
		<tr>
		<td>난이도</td>
		<td><input type="checkbox" name="material_level" value="normal"> 기본
		<input type="checkbox" name="material_level" value="hard"> 심화</td>
		</tr>
	<tr>
		<td>학습지 사진</td>
		<td><input type="file" name="material_file" id="material_file"></td>
	</tr>	
 
	<tr>
		<td colspan="2" style="text-align:center;">
<!-- 			<input type="submit" value="저장"> -->
			<input type="button" id = "mateSaveBtn" value="저장">
			<input type="button" id="QueBtn" value="문제출력">
			 <input type="button"  id="btnList" value="파일 저장하기.">
		</td>
	</tr>
</tbody>
</table>
</form>
<h2>문제 정보 입력</h2>

<div id = "res">

</div>

</body>
</html>