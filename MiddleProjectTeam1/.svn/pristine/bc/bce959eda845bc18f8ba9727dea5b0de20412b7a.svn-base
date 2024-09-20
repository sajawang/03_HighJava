<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<!-- <link rel="stylesheet" href="../css/public.css"> -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<!-- <script src="../js/jquery-3.7.1.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-serializeJSON/2.5.0/jquery.serializejson.min.js"></script> -->

<!-- <script src="../../js/jquery.serializejson.min.js"></script> -->
<script src="${pageContext.request.contextPath}/js/jquery.serializejson.min.js"></script>

<!-- <script src="../WebContent/js/jquery.serializejson.min.js"></script> -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<style type="text/css">

.ziptr:hover{
/* 주소에 마우스 올리면 색 변하도록 */
background: crimson;
}


</style>
<script type="text/javascript">


$(()=>{		
	
	    $('.mb-3 i').on('click',function(){
	        $('input').toggleClass('active');
	        if($('input').hasClass('active')){
	            $(this).attr('class',"fa fa-eye-slash fa-lg")
	            .prev('input').attr('type',"text");
	        }else{
	            $(this).attr('class',"fa fa-eye fa-lg")
	            .prev('input').attr('type','password');
	        }
	    });
	
	//id인 부분에 keyup 키를 눌렀다가 땔 때마다 이벤트 발생
		$('#id').on('keyup',function(){
		//id의 값을 가져오고
		idv=$('#id').val();
			
		//최대 12자리
		//첫글자는 소문자a~z까지 두 번째 부터는 a~z / A~Z / 0~9의 값이 
		//최소 3글자에서 11글자 까지.
		idreg=/^[a-zA-Z][a-zA-Z0-9]{3,11}$/
		
		//정규식 패턴에 대한 idreg에 .test(idv) = idv값을 대입하여 판단한다. 리턴은 true / false
		if(!(idreg.test(idv))){
			//입력하고 있는 id칸 부분이 잘못되면 붉은 테두리
			$(this).css('border','2px solid red');
			//비정상인 상태면 [중복검사] 버튼이 비활성화 된다.
			$('#idcheck').prop('disabled',true);
		}else{
			//위와 반대. idv의 값이 정규식 패턴과 동일 하면
			//초록 테두리와 버튼을 조작 가능하게 바꾼다.
			$(this).css('border','2px solid green');
			$('#idcheck').prop('disabled',false);
		}
		
		})//아이디 정규식
		
		//비밀번호 정규식
		$('#pwd').on('keyup',function(){
		//id의 값을 가져오고
		ipass=$('#pwd').val();

		//최소 8글자 이상이면서, 알파벳과 숫자 및 특수문자(@$!%*#?&)가 하나 이상 포함
		passReg=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/
		
		//정규식 패턴에 대한 idreg에 .test(idv) = idv값을 대입하여 판단한다. 리턴은 true / false
		if(!(passReg.test(ipass))){
			//입력하고 있는 id칸 부분이 잘못되면 붉은 테두리
			$(this).css('border','2px solid red');
			//비정상인 상태면 [중복검사] 버튼이 비활성화 된다.
		}else{
			//위와 반대. idv의 값이 정규식 패턴과 동일 하면
			//초록 테두리와 버튼을 조작 가능하게 바꾼다.
			$(this).css('border','2px solid green');
		}
		
		})//비밀번호 정규식 끝
		
		//이메일 정규식
		$('#mail').on('keyup',function(){
		//이메일 값을 가져오고
		imail=$('#mail').val();
		
		//골뱅이 포함하며 특수문자 . 가능
		mailReg=/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i
		
		if(!(mailReg.test(imail))){
			$(this).css('border','2px solid red');
		}else{
			$(this).css('border','2px solid green');
		}
		
		})//이메일 정규식 끝
		
		//비밀번호 표시 체크 눈동자
		$("#alert-success").hide();
        $("#alert-danger").hide();
        
        $("input").keyup(function(){
            var pwd1=$("#pwd").val();
            var pwd2=$("#pwdCh").val();
            if(pwd1 != "" || pwd2 != ""){
                if(pwd1 == pwd2){
                    $("#alert-success").show();
                    $("#alert-danger").hide();
                    $("#submit").removeAttr("disabled");
                }else{
                    $("#alert-success").hide();
                    $("#alert-danger").show();
                    $("#submit").attr("disabled", "disabled");
                }    
            }
        })
    
        
	$('#idcheck').on('click',function(){
		//입력한 아이디 값 가져오기
		idv=$('#id').val().trim();
		console.log(idv);
		
		if(idv.length<1){
			alert("입력된 ID가 없습니다. ID를 입력하세요.");
			return; // 입력창 띄우고 아래는 진행되면 안되니 return
		}
		
		$.ajax({		//java파일의 @WebServlet 부분을 쓰기
			//IdCheckController.do에 정보를 넘긴다.
			url:'/MiddleProjectTeam1/IdCheckController.do',
			type:'get', 	//get방식으로
			// id 가 controller에서의 전송데이터 받기의 key값과 동일해야함
			data:{id : idv}, // get방식은 data:"id="idv 도 가능
			
			//위의 전달한 값에 대한 처리가 성공 했을 시 success 구문 실행.
			success : function(rw){
				if(rw.flag=="사용가능한 아이디"){
					alert(rw.flag);		
					$('#idspan').html(rw.flag).css('color','aqua');
				}else{
					alert(rw.flag);		
					$('#idspan').html(rw.flag).css('color','red');
				}
				
			},
			//전송 데이터에 대한 처리가 비정상적 이유로 처리가 안 됐을 시 error구문 실행.
			error : function(xhr){
				alert("오류"+xhr.status)	
			},
			dataType:'json'
			
		})
		
	})//id 입력 체크 및 중복체크 끝
	
	//가입 전송버튼 클릭
	$('#send').on('click',function(){
		//입력한 모든 값 가져오기
// 		fdata1=$('#ff').serialize();
// 		console.log(fdata1);

// 		fdata2=$('#ff').serializeArray();		
// 		console.log(fdata2);
		
		fdata3=$('#ff').serializeJSON();
		console.log(fdata3);
		
		$.ajax({
			url:'/MiddleProjectTeam1/insertMember.do',
			data:JSON.stringify(fdata3),//script객체를 json형식의 문자열로 직렬화
			type:"post",
			contentType:'application/json',
			success:function(res){
// 			$('#joinspan').html(res.flag).css('color','aqua');
				alert(res.flag+" 로그인 화면으로 되돌아갑니다.");
			
				location.href='index.jsp';
			
			},
			error : function(xhr){
				alert("오류 : " + xhr.status);
			},
			dataType:'json' //res json 형식의 문자열 -script 객체로 역직렬화
		})
	})
	
})
</script>
<style type="text/css">
</style>
</head>
<body>

	<div class="box">
		<h3>1.</h3>
		<br> <input type="button" value="확인" onclick="proc1()"> <br>
		<div class="container mt-3">
			<h2>회원가입 form</h2>
			<form id="ff">
				<div class="mb-3 mt-3">
					<label for="id">아이디:</label> 
					<span id = "idspan"></span>
				<input class="btn btn-success btn-sm" type="button" value="중복검사" id="idcheck">
				
					<input type="text"class="form-control" id="id" placeholder="첫글자는 영어, 길이는 3~12글자까지 가능합니다."name="cus_id"><!-- name은 VO/db 명이랑 같아야함 -->
				</div>
				
				<div class="mb-3 mt-3">
					<label for="name">이름:</label> 
					<input type="text"class="form-control" id="name" placeholder="Enter name"name="mem_name"><!-- name은 VO/db 명이랑 같아야함 -->
				</div>
				<div class="mb-3 mt-3">
					<label for="hp">전화번호:</label> 
					<input type="text"class="form-control" id="hp" placeholder="Enter hp"name="mem_tel"><!-- name은 VO/db 명이랑 같아야함 -->
				</div>
				<div class="mb-3 mt-3">
					<label for="bir">생일:</label> 
					<input type="date"class="form-control" id="bir" placeholder="Enter bir"name="mem_bir"><!-- name은 VO/db 명이랑 같아야함 -->
				</div>
				<div class="mb-3 mt-3">
					<label for="mail">이메일:</label> 
					<input type="email"class="form-control" id="mail" placeholder="Enter mail" name="mem_mail">
				</div>
				<div class="mb-3">
					<label for="pwd">비밀번호: </label>
					 <input type="password"class="form-control" id="pwd" placeholder="최소 8글자. 알파벳과 숫자 및 특수문자(@$!%*#?&)가 하나 이상 포함되어야 합니다."name="cus_pw">
				    <i class="fas fa-eye icon"></i>   
				</div>
				
				<div class="mb-3">
					<label for="pwdCh">비밀번호 확인:</label>
					 <input type="password"class="form-control" id="pwdCh" placeholder="비밀번호를 다시 입력해주세요."name="mem_passCheck">
				</div>
				
				<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
				<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>

				<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				<input type="button" class="btn btn-success btn-sm" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				<input type="text" class="form-control" name="mem_zip" id="sample6_postcode" placeholder="우편번호">
				<input type="text"class="form-control"  name="mem_add1" id="sample6_address" placeholder="주소"><br>
				<input type="text"class="form-control"  name="mem_add2" id="sample6_detailAddress" placeholder="상세주소">
				
				<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
				<script>
				    function sample6_execDaumPostcode() {
				        new daum.Postcode({
				            oncomplete: function(data) {
				                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				
				                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
				                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				                var addr = ''; // 주소 변수
				                var extraAddr = ''; // 참고항목 변수
				
				                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
				                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				                    addr = data.roadAddress;
				                } else { // 사용자가 지번 주소를 선택했을 경우(J)
				                    addr = data.jibunAddress;
				                }
				
				                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
				                if(data.userSelectedType === 'R'){
				                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
				                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
				                        extraAddr += data.bname;
				                    }
				                    // 건물명이 있고, 공동주택일 경우 추가한다.
				                    if(data.buildingName !== '' && data.apartment === 'Y'){
				                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				                    }
				                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				                  
				                
				                }
				
				                // 우편번호와 주소 정보를 해당 필드에 넣는다.
				                document.getElementById('sample6_postcode').value = data.zonecode;
				                document.getElementById("sample6_address").value = addr;
				                // 커서를 상세주소 필드로 이동한다.
				                document.getElementById("sample6_detailAddress").focus();
				            }
				        }).open();
				    }
				</script>

				<!-- 혹시ㅣ몰라 남겨둠 -->
<!-- 				<div class="mb-3 mt-3"> -->
<!-- 					<label for="zip">우편번호:</label>  -->
<!-- 					<input data-bs-toggle="modal" data-bs-target="#myModal" class="btn btn-success btn-sm" type="button" value="郵便番呼" id="dongbtn"> -->
<!-- 					<input type="text"class="form-control" id="zip" placeholder="Enter zip"name="mem_zip">name은 VO/db 명이랑 같아야함 -->
<!-- 				</div> -->
<!-- 				<div class="mb-3 mt-3"> -->
<!-- 					<label for="add">주소:</label>  -->
<!-- 					<input type="text"class="form-control" id="add1" placeholder="Enter add1"name="mem_add1">name은 VO/db 명이랑 같아야함 -->
<!-- 				</div> -->
<!-- 				<div class="mb-3 mt-3"> -->
<!-- 					<label for="add2">상세주소:</label>  -->
<!-- 					<input type="text"class="form-control" id="add2" placeholder="Enter add2"name="mem_add2">name은 VO/db 명이랑 같아야함 -->
<!-- 				</div> -->
				
				<button type="button" id='send' class="btn btn-primary btn-sm">Submit</button>
				<span id="joinspan"></span>
			</form>
		</div>

	</div>
<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">우편번호 찾기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        동 이름 입력
        <input type="text" id="dong">
        <input type="button" value="확인" id="zipbtn">
        <br><br>
        <div id="result1"></div>
        
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
</body>
</html>