/**
 * 
 */

 $.commentDeleteServer = function(comment_no, board_no, post_no){
	 $.ajax({
        url: `${mypath}/csCommentDelete.do`,
        data: { comment_no: comment_no },
        type: 'post',
        success: function(res) {
                alert("댓글이 삭제되었습니다.");
                $.commentListServer(board_no, post_no); // 댓글 리스트를 새로고침
        },
        error: function(xhr) {
            alert("오류: " + xhr.status);
        },
        dataType: 'json'
    });
};


$.commentUpdateServer = function(comment, board_no, post_no) {
    $.ajax({
        url: `${mypath}/csCommentUpdate.do`,
        type: 'post',
        data: JSON.stringify(comment),
        contentType: 'application/json; charset=UTF-8',
        success: function(res) {
                alert("댓글이 수정되었습니다.");

                $.commentListServer(board_no, post_no); // 댓글 리스트를 새로고침
        },
        error: function(xhr) {
            alert("오류: " + xhr.status);
        }
    });
};



$.commentWriteServer = function(comment,board_no,post_no) {
    $.ajax({
        url: `${mypath}/csCommentWrite.do`, // 댓글 작성 처리 URL
        type: 'POST',
        data: JSON.stringify(comment),
        contentType: 'application/json; charset=UTF-8',
        success: function(res) {
            // 댓글 작성 성공 후 처리
            alert("댓글이 작성되었습니다.");
			$.commentListServer(board_no,post_no);
        },
        error: function(xhr) {
            alert("오류: " + xhr.status);
        }
    });
};



$.commentListServer = function(board_no, post_no) {
    $.ajax({
        url: `${mypath}/csCommentList.do`,
        data: { board_no: board_no, post_no: post_no },
        type: 'get',
        success: function(res) {
            console.log(res);
            let rcode = "";

            // 댓글 리스트 res를 출력
            $.each(res, function(i, v) {
                let cont = v.comment_content;
                cont = cont.replaceAll(/\n/g, "<br>");

                rcode += `
                    <div class="comment-body">
                        <div class="p12">
                            <p class="p1">
                                댓글 번호: <span class="comment_no">${v.comment_no}</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                작성자: <span class="comment_cusId">${v.cus_id}</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                날짜: <span class="comment_date">${v.comment_date}</span>
                            </p>
                            <p class="p2">
                                ${uvo != null && uvo.cus_id === v.cus_id ? `
                                    <input idx="${v.comment_no}" type="button" value="댓글수정" name="comment_update" class="action">
                                    <input idx="${v.comment_no}" type="button" value="댓글삭제" name="comment_delete" class="action">
                                ` : ''}
                            </p>
                        </div>
                        <p class="rp3">
                            ${cont}
                        </p>
                    </div>
                `;
            });

            // 댓글 작성 폼 추가
            rcode += `
                <p class="p4">
                    <textarea rows="4" cols="60"></textarea>
                    <input idx="${post_no}" type="button" value="등록" name="comment" class="action">
                </p>
            `;

            // 출력
            $('#comments').html(rcode);
        },
        error: function(xhr) {
            alert("오류: " + xhr.status);
        },
        dataType: 'json'
    });
};







//게시글쓰기
$.boardWriteServer = function(back){
	
	console.log("mypath:", mypath);
    console.log("back:", back);

	$.ajax({
		
		url: `${mypath}/csInsertPost.do`,
		data : JSON.stringify(writeData),
		type : 'post',
		contentType : 'application/json',
		success : res=>{
			alert(res.flag);
			//리스트 페이지 혹은 메인
			location.href=`${mypath}/mainToJsp.do?target=${back}`;
			
		},
		error : xhr=>{
			alert("오류 : "+xhr.status);
		},
		dataType : 'json'
		
		
	})
	
}



$.listPageServer = function(board_no){
	
	//검색 선택값
	stype = $('#stype option:selected').val();
	//검색어
	sword = $('#sword').val();
	
	datas = {page : currentPage, stype : stype, sword : sword, board_no: board_no};
	
	$.ajax({
		url : `${mypath}/mypagecustomerService.do`,
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
			vpage = $.pageList(res.sp, res.ep, res.tp);
			
			$('#pagelist').html(vpage);
		},
		error : xhr =>{
			alert("오류 : "+xhr.status);
		},
		dataType : 'json'
		
	})//ajax
	
}

$.pageList = function(sp, ep, tp){
	
	//이전
	pager = "";
	pager += '<ul class="pagination">';
	if(sp > 1){
		pager += `<li class="page-item"><a id="prev" class="page-link" href="#">Previous</a></li>`;
	}
	//페이지번호
	for(i=sp; i<=ep; i++){
		if(currentPage == i){
			pager +=  `<li class="page-item active"><a class="page-link pageno" href="#">${i}</a></li>`;
		}
		else{
			pager +=  `<li class="page-item"><a class="page-link pageno" href="#">${i}</a></li>`;
		}
	}	
	//다음
	if(ep < tp){
		pager += `<li class="page-item"><a id="next" class="page-link" href="#">Next</a></li>`;
	}
	pager += "</ul>";
	
	return pager;
}
