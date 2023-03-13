
console.log("ContextPath: "+ContextPath);
console.log("sc: "+sc);
console.log("mode: "+mode);

// 폼 체크 함수 선언
let QAformCheck = function() {
    let form = document.getElementById("QAform");
    if(form.text.value=="") {
        alert("내용을 입력해 주세요.");
        form.text.focus();
        return false;
    }
    return true;
}

function showList(qano){
	console.log("showList 호출");
    console.log("showList qano: "+qano);
    
	$.ajax({
        type:'GET',
        url: '/QAmyDetailPage/readCmt?qano='+qano,
        success: function(result){
        	alert("성공");
        	
        	if(result==""){
        		console.log("결과없음")
        	}else{
        		CmtHtml(result);
        	}
        },
        error: function(){ 
        	alert("error");
        } 
    });    
}

function CmtHtml(cmt){
	console.log("CmtHtml 호출");
	console.log(cmt); // 잘 받아옴
	
	CmtHtml="";
	CmtHtml +=	'<ul class="cmt_ul">'
			  +		'<li class="comment-item">'
			  +			'<img src="/img/icon/blank-profile.png" class="comment-img">'
			  +			'<div class="comment-area">'
			  +				'<div class="commenter" id="">' + cmt.writer + '</div>'
			  +				'<div class="comment-content">'+cmt.text+'</div>'
			  +				'<div class="comment-bottom">'
			  +					'<span class="up_date">'+cmt.reg_date+'</span>'
			  +					'<a href="#" class="cmt-btn-modify">수정</a>'
			  +					'<a href="#" class="cmt-btn-delete">삭제</a>'
			  +				'</div>'
			  +			'</div>'
			  +		'</li>'	
			  + '</ul>'	;
			  
	$("#commentList").append(CmtHtml);
}

function wrtCmt(cmtText){
	console.log("wrtCmt 호출");
	console.log("cmtText: "+cmtText);

	var qano = $("input[name=qano]").val();
	var pro_title = $("input[name=pro_title]").val();
	var writer = $("input[name=writer]").val();
	
	console.log(qano);
	console.log(pro_title);
	
	$.ajax({
	        type: 'POST',
	        url: '/QAmyDetailPage/wrtCmt',
	        headers: {"content-type":"application/json"},
	        dataType : 'text',
	        data : JSON.stringify({
	        						"qano":qano,
	        						"writer":writer,
	        						"pro_title":pro_title,
	        						"text":cmtText
	        					  }),
	        success : function(data) {
	        	alert("댓글 작성 성공");
	        	console.log(data);
	        	
	        	// 댓글 조회 함수 호출하기
	        	showList(qano);
	        	$("textarea[name=comment]").val("");
	        	
	        },
	        error : function(error) {
	            alert("연결 실패");
	        }
    	});	     
	
}

$(document).ready(function(){
	let form = $('#QAform');
	
	$('#listBtn').on("click", function(){
		location.href= ContextPath+"/QAmyListPage"+sc;
    });
    
    $("#writeBtn").on("click", function(){
    	console.log("쓰기");
		form.attr("action", ContextPath+"/QAmyDetailPage/write");
        form.attr("method", "post");
		
        if(QAformCheck()){
            form.submit()
        };
	});
	
	$('#modifyBtn').on("click", function(){
		
		console.log("수정");
		let isReadOnly = $("textarea[name=text]").attr('readonly');
        
		$('#removeBtn').css('display', 'none');
		
		if(isReadOnly=='readonly'){
			 $(".writing-header").html("게시판 수정");
			 $("textarea").attr('readonly', false);
			 $("#modifyBtn").html("등록");
			 return;
        }
        
        form.attr("action", ContextPath+"/QAmyDetailPage/modify"+sc);
        form.attr("method", "post");
        
        if(QAformCheck()){
        	form.submit();
        }
	});
    
	$('#removeBtn').on("click", function(){
		if(!confirm("정말로 삭제하시겠습니까?")) return;
		
		// 답변이 있는 경우 
		var content = $("#commentList").text();
		console.log(content);
		
		if(!content){
			alert("답변 없음");
			form.attr("action", ContextPath+"/QAmyDetailPage/remove"+sc);
        	form.attr("method", "post");
        	form.submit();
		}else{
			alert("답변이 달린 문의는 삭제할 수 없습니다");
			return;
		}
      
	});
	
		
    // ============ 댓글 ===============
    
    if(mode=="read"){
		console.log("읽기모드");
        var qano = $("input[name=qano]").val();
		showList(qano);
    }
     
    if(mode=="new"){
       console.log("쓰기모드");
       $("#comment-writebox").css("display", "none");
    }
    
    $("#btn-write-comment").click(function(){
		console.log("댓글 등록 클릭");
		let comment = $("textarea[name=comment]").val();
		console.log("comment: "+comment);
		if(comment.trim()==''){
            alert("댓글을 입력해주세요");
            $("textarea[name=comment]").focus();
            return;
        }      
        wrtCmt(comment);
    });
});

