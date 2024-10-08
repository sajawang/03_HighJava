// 게시글 리스트 요청 - 응답 -  출력
$.listPageServer3 = function(){
	
	school = $('#school').val().trim();
	grade  = $('#grade').val().trim();
	
	$('#school').val(school);
	$('#grade').val(grade);

	if(school=='element'){
		school = '초등';
	} else if (school=='middle'){
		school = '중등';
	}
	
	datas = {page : currentPage, school : school, grade : grade};
	
	$.ajax({
		url : `${mypath}/teacher/goTeacherLibraryList.do`,
		type : 'post',
		data : JSON.stringify(datas),
		contentType : 'application/json',
		success : res => {
			console.log(res.datas);
			code =  '<ul style="width: 100%; display: flex; flex-wrap: wrap; justify-content: flex-start; margin: 3.2rem 0 0 0;">';
			$.each(res.datas, function(i, v){
				code += `<li style="list-style: none; margin: 10px; flex : 1;" onclick="location.href='${mypath}/teacher/detailTeacherLibrary.do?pno=${v.post_no}'">`;
				code += '<div>'
				code += '<div class="thumnail" style="height: 406px;">'
				code += `<img alt="" src="${mypath}/images/imageView.do?path=${v.files_name}">`
				code += '</div>'
				code += '<div style="margin-top: 15px;">'
				code += `<p><strong>${v.post_title}</strong><span>&nbsp;&nbsp;|&nbsp;&nbsp;${v.post_gu}</span></p>`
				code += '</div>'
				code += '</div>'
				code += '</li>'
			});
			code+='</ul>'
			// 리스트 출력
			$('#result').html(code);
			
			// page정보를 출력 - 함수 호출
			console.log("res.sp : "+res.sp)
			console.log("res.ep : "+res.ep)
			console.log("res.tp : "+res.tp)
			vpage = $.pageList3(res.sp, res.ep, res.tp);
			
			$('#pagelist').html(vpage);
		},
		error : xhr => {
			alert("오류 : " + xhr.status);
		},
		dataType : 'json'
		
	});
} // $.listPageServer

$.pageList3 = function(sp, ep, tp){
		// 이전
		pager = "";
		pager += `<ul class="pagination1">`;
		if(sp > 1){
			pager +=`<li class=""><a id="prev" class="" href="#">Previous</a></li>`;
		}   
		
		//currentPage = 7(마지막 페이지) 마지막 페이지의 모든 데이터 삭제할 경우
		//currentPage의 값이 새로 구한 totalPage로 변경되어야 한다.
		if(currentPage > tp) currentPage = tp;
		
		// 페이지 번호
		for(i=sp; i<=ep; i++){
			// board.jsp currenPage : 전역변수
			if(currentPage == i){
				  pager += '<li class="active"><a class="pageno" href="#">'+i+'</a></li>';
			} else {
				  pager += '<li class=""><a class=" pageno" href="#">'+i+'</a></li>';
			}
		}
		
		// 다음
		if(ep < tp){
			  pager += `<li class=""><a id="next" class="" href="#">Next</a></li>`
		}
		pager +="</ul>";
		
		// 반환
		return pager;
}