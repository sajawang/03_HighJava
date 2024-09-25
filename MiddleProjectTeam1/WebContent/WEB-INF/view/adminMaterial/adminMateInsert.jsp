<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.vo.MaterialVO"%>
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
	   
	 var gg = 0;  
	   let i = 0;
	   var rdw = 0;
	   let x= 0;
	   mypath='<%=request.getContextPath()%>';
	   //문제삽입창. 여기서 문제 출력을 누르면 5문제를 등록할 수 있는 칸이 나와야한다.
	   $('#QueBtn').on('click',function(){
	            code='';
	         //파일 인서트 안됨.
	            code+='<form enctype="multipart/form-data" id="mateInsert" method="post"  action='+mypath+'/adminQueInsert.do>';
	               code+='<table border="1">';
	               code+='<tbody>';
	      for(i = 1;i<6;i++){
	         rdw++;
	         x++;
//	       alert(rdw);
	            code+='      <input type="hidden" name="material_no'+gg+'" id="material_no" >';
	                  
	            code+='   </tr><tr> <td>문제 내용 '+i+'</td>';
	            code+='      <td><input type="text" name="question_content'+i+'" id="question_content'+i+'" ></td>';
	            
	            code+=`   </tr>`;   
	               
	               code+='   <tr> <td>문제 정답  '+i+' </td>';
	            code+='      <td><input type="text" name="question_answer'+i+'" id="question_answer'+i+'" ></td>';
	            code+=`   <tr>`; 
	               
	            code+='   <tr> <td>문제 풀이 '+i+'</td>';
	            code+='      <td><input type="text" name="question_solve'+i+'" id="question_solve'+i+'" ></td>';
	            code+=`   </tr>`;      
	            
	            code+='   <tr> <td>문제 사진  '+i+'</td>';
	            code+='      <td><input type="file" name="files_no'+i+'" id="files_no'+i+'" ></td>';
	            code+=`   </tr>`;   
	      }      
	             
	            code+=`   <tr>
	                  <td colspan="2" style="text-align:center;">
	                  	 <input type="button" id="insertQuestion" value="문제 입력하기">
	                     <input type="button" id="queSaveBtn" value="문제 저장하기">
	                     <input type="button"  id="btnList" value="학습지 등록 취소 목록으로 돌아가기">
	                  </td>
	               </tr>`;
	         code+=`</tbody>
	               </table>`
	            code+=`</form>`
// 	            alert(gg);
	            $('#res').html(code);   

	})
	 
	   
	   $(document).on("click", "#btnList", function() {
        location.href = '<%=request.getContextPath()%>/adminmaterialList.do'; // 목록으로 돌아가기 URL
		});
	   
	   
	   $(document).on("click", "#queSaveBtn", function() {
		    var formData2 = new FormData(); 
			   
			    for (i = 1; i < 6; i++) {
			        // 문제 내용
			        formData2.append('question_content'+i, $('#question_content'+ i).val());
			        // 문제 정답
			        formData2.append('question_answer'+i, $('#question_answer'+ i).val());
			        // 문제 풀이
			        formData2.append('question_solve'+i, $('#question_solve'+ i).val());
			        // 문제 사진 파일
			        var fileInput = $('#files_no'+i)[0].files[0];
			        if (fileInput) {
			            formData2.append('files_no'+i, fileInput);
			        }
			    }

			    // AJAX 요청
			    $.ajax({
			        url: '<%=request.getContextPath()%>/adminQueInsert.do',
			        type: 'POST',
			        data: formData2,
			        contentType: false,
			        processData: false,
			        success: function(res) {
			            alert("문제가 성공적으로 등록되었습니다.");
			            location.href='adminmaterialList.do';
			        },
			        error: function(error) {
			            alert('오류 발생: ' + error.status);
			        },
			        dataType: 'json'
			    });
			});
	   
	   
	$('#mateSaveBtn').on('click', function() {
		var formData = new FormData();
		formData.append('material_title', $('#material_title').val());
		formData.append('material_des', $('#material_des').val());
		formData.append('material_grade', $('#material_grade').val());

		var materialLevels = [];
		$('input[name="material_level"]:checked').each(function() {
			materialLevels.push($(this).val());
		});
		formData.append('material_level', materialLevels.join(','));

		var fileInput = $('#material_file')[0].files[0];
		if (fileInput) {
			formData.append('material_file', fileInput);
		}

		let va = <%=(Integer)request.getAttribute("result1")%>;
		
		
		$.ajax({
			url: '<%=request.getContextPath()%>/adminMateInsert.do',
			type: 'POST',
			data: formData,
			contentType: false,
			processData: false,
			success: function(res) {
// 				alert(res.flag);
// 				alert(res);
				alert("학습지 등록이 완료되었습니다.");
// 				console.log(res.flag);
// 				console.log(res);
				
				gg=res.flag;
			
// 				console.log(gg);
// 				alert("gg값 "+gg);
			},
			error: function(error) {
				alert('오류 발생: ' + error.status);
			},
			dataType:'json'
		});
	});
	   
	// 학습지 자동입력
	$('#insertMater').on('click', function() {
		$('#material_title').val("[실력] 1.덧셈과 뺄셈(3-1) 문제지");
		$('#material_des').val("덧셈과 뺄셈");
		$('#material_grade').val("초등 3-1");
		$('#hard').prop('checked',true);
	})
	// 문제 자동입력
	$(document).on('click','#insertQuestion', function() {
		
		$('input[name=question_content1]').val("두 수의 합을 구하세요.");
		$('input[name=question_content2]').val("화살표 방향에 따라 덧셈을 하려고 합니다. ㉡에 알맞은 수를 구하세요.");
		$('input[name=question_content3]').val("계산 결과가 더 큰 쪽을 선택하세요.");
		$('input[name=question_content4]').val("다음 수보다 359 더 큰 수를 구해 보세요.");
		$('input[name=question_content5]').val("호영이와 삼촌의 키의 차는 몇 cm인지 구해 보세요.");
		
		$('input[name=question_answer1]').val("768");
		$('input[name=question_answer2]').val("1430");
		$('input[name=question_answer3]').val("2");
		$('input[name=question_answer4]').val("838");
		$('input[name=question_answer5]').val("36");
		
		$('input[name=question_solve1]').val("473 + 295 = 768");
		$('input[name=question_solve2]').val("㉠ 347 + 297 = 644 ㉡ 644 + 786 = 1430");
		$('input[name=question_solve3]').val("① 698 - 342 = 356 ② 724 - 358 = 366");
		$('input[name=question_solve4]').val("100이 4개, 10이 7개, 1이 9개인 수는 479입니다. → 479 + 359 = 838");
		$('input[name=question_solve5]').val("181 - 145 = 36(cm)");
	})
	   
});

</script>

<!-- CSS Styling -->
<style>

    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f9;
        padding: 20px;
        color: #333;
        position: relative; /* 부모 요소를 relative로 설정 */
    }

    h2 {
        text-align: center;
        color: #444;
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px 0;
        background-color: #fff;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    th, td {
        border: 1px solid #ddd;
        padding: 12px 15px;
        text-align: left;
    }

    th {
        background-color: #FFEB3B;
        color: #333;
        font-weight: bold;
    }

    td input[type="text"], td input[type="file"] {
        width: 90%;
        padding: 12px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
       	font-size: 16px; 
    }

    td input[type="checkbox"] {
        margin-right: 10px;
    }

    .center {
        text-align: center;
    }

    input[type="button"], input[type="submit"] {
        display: inline-block;
        padding: 10px 20px;
        font-size: 16px;
        margin: 10px 5px;
        color: #fff;
        background-color: #007BFF;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        text-align: center;
    }

    input[type="button"]:hover, input[type="submit"]:hover {
        background-color: #0056b3;
    }

    input[type="file"] {
        background-color: #f1f1f1;
    }

    #res {
        margin-top: 20px;
    }

    /* 버튼을 오른쪽 상단으로 이동시키는 스타일 */
    .buttons-container {
        position: absolute;
        top: 20px;
        right: 20px;
    }

    /* 숨김 처리 */
    #problemTitle {
        display: none;
    }
</style>
</head>
<body>

<h2>학습지 정보 입력</h2>

<form id="mateInsert" method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/adminMateInsert.do">
<table>
<tbody>
	<tr>
    <td style="background-color: rgb(255, 226, 20); ">학습지 제목</td>
    <td><input type="text" name="material_title" id="material_title"></td>
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
		<td>
			<input type="radio" name="material_level" id="normal" value="normal" > 기본
			<input type="radio" name="material_level" id="hard" value="hard"> 심화
			
		</td>
	</tr>
	<tr>
		<td>학습지 사진</td>
		<td><input type="file" name="material_file" id="material_file"></td>
	</tr>
</tbody>
</table>
</form>

<!-- 버튼을 오른쪽 상단으로 이동 -->
<div class="buttons-container">
	<input type="button" id="insertMater" value="학습지 입력하기">
    <input type="button" id="mateSaveBtn" value="학습지 저장하기">
    <input type="button" id="QueBtn" value="문제 입력 하기">
</div>

<!-- 문제 정보 입력 제목 -->
<h2 id="problemTitle">문제 정보 입력</h2>
<div id="res"></div>

</body>
</html>