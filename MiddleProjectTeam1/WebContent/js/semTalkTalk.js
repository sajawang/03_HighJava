$.listPageServer4 = function(board_no){
	
	
	stype = $('#stype option:selected').val();
	sword = $('#sword').val();
	
	datas = {page : currentPage, stype : stype, sword : sword, board_no: board_no};
	
	$.ajax({
		url : `${mypath}/customerService.do`,
		type : 'post',
		data : JSON.stringify(datas),
		contentType : 'application/json',
		success : res =>{
			console.log(res);
			code = '<table border="1" style="width: 100%; margin-top: 20px; text-align: left;">';
		    code += '<thead><tr>';
		    code += '<th style="width: 10%;">게시물번호</th>'; // 게시물번호 열 크기 조정
		    code += '<th style="width: 10%;">구분</th>'; // 구분 열 크기 조정
		    code += '<th style="width: 60%;">제목</th>'; // 제목 열 크기 넓게 조정
		    code += '<th style="width: 20%;">작성자</th>'; // 작성자 열 크기
		    code += '</tr></thead><tbody>';
			$.each(res.datas, function(i,v){
				
				//내용가져온다 - 엔터로 저장되어 있는 것을 <br>로 바꾸기 위해서
				cont = v.post_content;
				cont = cont.replaceAll(/\n/g, "<br>");
				
				code+= `
					 <tr>
						<td>${v.post_no}</td>
						<td>${v.post_gu}</td>
						<td>
						<a href="${mypath}/csDetailPost.do?post_no=${v.post_no}&board_no=${v.board_no}">
                            ${v.post_title}
                        </a>
						</td>
						<td>${v.cus_id}</td>
					 </tr>
				` ;
//			         if(uvo !=null&& uvo.mem_name == v.cus_id){
//						code+=`  <div>    
//			               <input idx="${v.num}" type="button"  value="수정" name="modify"  class="action">
//			               <input idx="${v.num}" type="button"  value="삭제" name="delete"  class="action">
//			           </div> `   
//						}
			
			});//$each
						code +=`
						</tbody>
						</table>
			            
			             ` ;
			
			//리스트 출력
			$('#result').html(code);
			
			//page정보 출력 - 함수 호출
			vpage = $.pageList4(res.sp, res.ep, res.tp);
			
			$('#pagelist').html(vpage);
		},
		error : xhr =>{
			alert("오류 : "+xhr.status);
		},
		dataType : 'json'
		
	})//ajax
	
}

$.pageList4 = function(sp, ep, tp){
	
	//이전
	pager = "";
	pager += '<ul class="pagination1">';
	if(sp > 1){
		pager += `<li class=""><a id="prev" class="" href="#">Previous</a></li>`;
	}
	//페이지번호
	for(i=sp; i<=ep; i++){
		if(currentPage == i){
			pager +=  `<li class="active"><a class="pageno" href="#">${i}</a></li>`;
		}
		else{
			pager +=  `<li class=""><a class="pageno" href="#">${i}</a></li>`;
		}
	}	
	//다음
	if(ep < tp){
		pager += `<li class=""><a id="next" class="" href="#">Next</a></li>`;
	}
	pager += "</ul>";
	
	return pager;
}