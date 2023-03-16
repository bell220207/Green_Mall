var pNum=1;			// 리뷰, 문의 기본 페이지
var title=""; 		// 상품명
var pType="";		// 리뷰,문의 구분
var lineUp="stars"; // 리뷰 정렬기준
var RVscore="";		// 리뷰 별점
var keyword=""; 	// 리뷰 검색 용어
var searchOption="";// 리뷰 검색 기준
var data="";

$(document).ready(function(){

	// 수정
	$(".ops").attr('onclick', 'showMenu(this)');	
	
	// 상품별 최소수량을 value 값으로 넣어서 페이지 로드
	var productMin = $("#purchaseNum").attr('min');
	$("#purchaseNum").attr('value', productMin);
	
	title = document.querySelector('.pTitle-h4').innerText;
	
	
	// 문의내역 1 페이지 자동 불러오기
	getQAlist(1, title);
	
	// 리뷰 내역 1페이지 자동 불러오기
	getRVlist(1, title, lineUp);
	
	
});

function setData(){
	data = {
				"pageNum" : pNum, 
				"proTitle" : title,
				"type" : pType, 
				"lineUp":lineUp,
				"RVscore":RVscore,
				"searchOption":searchOption,
				"keyword":keyword,
			}
}

function purchaseNum(btn){
	var btnId = `${btn.id}`;
	var purchaseNum = $("#purchaseNum").attr('value');
	purchaseNum = Number(purchaseNum);
	
	var max = $("#purchaseNum").attr('max')==""||$("#purchaseNum").attr('max')==null? 20 : $("#purchaseNum").attr('max');
	var min = $("#purchaseNum").attr('min')==""||$("#purchaseNum").attr('max')==null? 1 : $("#purchaseNum").attr('min');
	
	if(btnId == 'up'){
		if(purchaseNum==max){
			alert("구매 최대개수를 초과하였습니다");		
		}else{
			purchaseNum = purchaseNum+1;
		}
		
	}else if(btnId == 'down'){
		if(purchaseNum == min){
			alert("최소 구매 수량입니다");
		}else{
			purchaseNum = purchaseNum-1;
		}
	}
	
	$("#purchaseNum").attr('value', purchaseNum);
}


function setLineUp(clickedBtn){

	var BtnId = $(clickedBtn).attr("id");

	if(BtnId=="bestBtn"){
		lineUp="stars";
	}else if(BtnId=="dayBtn"){
		lineUp="date";
	}
	
	getRVlist(1, title, lineUp);
}

/*리뷰 내역 가져오기*/
function getRVlist(pageNum, proTitle, lineUp){					
		
		pageNum = String(pageNum);
		RVscore = String(RVscore);
		proTitle=title;
		pNum = pageNum;

		setData();
		
		var RVlistHtml="";
	    var RvImglistHtml ="";
	    var imgListId="";
		$("#rvBox-list").html("");	// 리스트 초기화 작업
		
		$.ajax({
	        type: 'POST',
	        url: 'product/RVlist',
	        headers: {"content-type":"application/json"},
	        dataType : 'json',
	        data : JSON.stringify(
	        						data
	        					  ),
	        success : function(data) {
	        	
	        	for(var i=0; i<data.length; i++){
	        		var starValue = data[i].stars;
					RVlistHtml=""; // RVlistHtml 초기화 과정 (for문 안에 있어야 한다)
	        		RvImglistHtml=""; // RvImglistHtml 초기화 과정
	        		
	        		RVlistHtml+= '<div class="rvBox-article">'
	        					+	'<div class="rvBox-article-info">'
	        					+		'<img src="img/icon/' + data[i].profileimg + '\" class="profileImg"/>'
	        					+		'<span>'+ data[i].id + '</span>'
	        					+		'<div class="starBox">'
	        					+			'<span class="star">'
	        					+				'<span>★★★★★</span>'
	        					+				'<span class="hiddenStar" id="rvStar' + data[i].rno + '">' + '★★★★★' + '</span>'
	        					
	        					/*
	        					+				'<input type="range" onclick="drawStar(this)" value="1" step="1" min="1" max="5" />'
	        					*/
	        					
	        					+			'</span>'
	        					+		'</div>'
	        					+		'<div class="proName">' + data[i].pro_title + '</div>'
	        					+	'</div>'
	        					+	'<div class="rvBox-article-imgList" id=\"rvBox-article-imgList' +data[i].rno+ '\">'
	        					+	'</div>'
	        					+	'<div class="rvBox-article-content">'
	        					+		'<div class="rvBox-article-content-title">'+ data[i].rv_title + '</div>'
	        					+		'<div class="rvBox-article-content-text">' + data[i].rv_text + '</div>'
	        					+	'</div>'
	        					+	'<div class="rvBox-article-day">' + data[i].rv_date + '</div>'
	        					+ '</div>'
	        					;
	        					
	        		// 리뷰 내역 하나씩 추가 (이미지 내역 없음)			
	        		$("#rvBox-list").append(RVlistHtml);
	        		
	        		// 별 그리기
	        		drawStar(starValue, data[i].rno);
	        		
	        		imgListId = "rvBox-article-imgList"+data[i].rno;
	        		
	        		for(var k=0; k<data[i].img_list.length; k++){
		        			RvImglistHtml += '<img src=\"img/rv_img/' 
		        								+ data[i].img_list[k] 
		        								+ '\" />'
		        								;
		        	}
		        	
		        	$("#"+imgListId).append(RvImglistHtml);
	        		
	        	} // for문
					        	
	        	// 페이징 함수 호출
	        	proPaging(pageNum, proTitle, 'RV')
	        },
	        error : function(error) {
	            console.log(error)
	        }
    	});	        
}

/*문의 내역 가져오기*/
function getQAlist(pageNum, proTitle){
	
	
	pageNum = String(pageNum);
	RVscore = String(RVscore);
	proTitle=title;
	pNum = pageNum;
	
	setData();
	
	var QaListHtml="";
	$("#qaBox-list").html(""); // 리스트 초기화
	
	$.ajax({
        type: 'POST',
        url: 'product/qalist',
        headers: {"content-type":"application/json"},
        dataType : 'json',
        data : JSON.stringify({"pageNum" : pageNum, proTitle : proTitle}),
        success : function(data) {
			
			for(var i=0; i<data.length; i++){
			
				QaListHtml="";
				
				if(data[i].qa_type=='Q'){
					QaListHtml += '<div class="qaBox-article">' + 
	            				'<div class="qaBox-article-ask">' + 
	            					'<em>질문</em>' +
	            					'<strong style="padding-left: 5px;">'+data[i].writer+'</strong>' +
	            					'<span>'+ data[i].reg_date+'</span>' +
	            					'<p>'+data[i].text+'</p>' +
	            				'</div>' +
	            			'</div>'
	            			;
				}
				
				if(data[i].qa_type=='A'){
					QaListHtml += '<div class="qaBox-article">' + 
	            				'<div class="qaBox-article-answer">' + 
	            					'<span class="Material-Icons">'+
										'subdirectory_arrow_right' +
									'</span>' +
	            					'<em>답변</em>' +
	            					'<strong style="padding-left: 5px;">'+data[i].writer+'</strong>' +
	            					'<span class="qaBox-article-answer-day">'+data[i].reg_date+'</span>' +
	            					'<p>'+data[i].text+'</p>' +
	            				'</div>' +
	            			'</div>'
	            			;
				}
				
				$("#qaBox-list").append(QaListHtml);
				
			} //for문 끝
			
			// 문의내역 페이징 함수 호출 (현재 페이지넘버랑 타이틀 매개변수로 넘기고)
			proPaging(pageNum, proTitle, 'QA')
					
        },
        error : function(error) {
            console.log(error)
        }
    });	        
}


function proPaging(pageNum, proTitle, type){
	
	pType=type;

	setData();
	
	$.ajax({
        type: 'POST',
        url: 'product/proPaging',
        headers: {"content-type":"application/json"},
        dataType : 'json',
        data : JSON.stringify(
        						data
        					 ),
        success : function(data) {
        
			var clickedPage="";
			var element="";
			var pagingHtml="";
			var totalCnt = data.totalCnt;
			var totalPage = data.totalPage;
			var naviSize = data.naviSize;			
			var beginPage = data.beginPage;
			var endPage = data.endPage;
			var showPrev = data.showPrev;
			var showNext = data.showNext;
			var type = data.type;
			
			if(type=='RV'){
				
				if(totalCnt==0){
					pagingHtml += '<span class="noPage">등록된 리뷰가 없습니다</span>';
				}else if(totalCnt!=0 && totalCnt!=null){
					
					if(showPrev){
						pagingHtml += '<span class="page" onclick="getRVlist(' 
										+ (beginPage-1) + ', \'' 
										+ proTitle + '\', \'' 
										+ lineUp
										+ '\' )">&lt;</span>';				
					}
					for(var i=beginPage; i<=endPage;i++){
						pagingHtml += '<span class="page" id=\"rv' + i + '\" onclick="getRVlist(' 
										+ i + ', \'' 
										+ proTitle + '\', \'' 
										+ lineUp
										+ '\' )">'
										+ i 
										+ '</span>';
					}
					if(showNext){
						pagingHtml += '<span class="page" onclick="getRVlist(' 
										+ (endPage+1) + ', \'' 
										+ proTitle + '\', \'' 
										+ lineUp
										+ '\' )">&gt;</span>';
										
					}
					clickedPage = "rv"+pageNum;
				}
				
				// rv에 추가
				$("#RVpaging").html(pagingHtml);
			}
			
			if(type=='QA'){
				if(totalCnt==0){
					pagingHtml += '<span class="noPage">등록된 문의가 없습니다</span>';
				}else if(totalCnt!=0 && totalCnt!=null){
					if(showPrev){
						pagingHtml += '<span class="page" onclick="getQAlist(' 
										+ (beginPage-1) + ', \'' 
										+ proTitle + '\')">&lt;</span>';				
					}
					for(var i=beginPage; i<=endPage;i++){
						pagingHtml += '<span class="page" id="qa' + i + '\" onclick="getQAlist(' 
										+ i + ', \'' 
										+ proTitle + '\')">'
										+ i 
										+ '</span>';
					}
					if(showNext){
						pagingHtml += '<span class="page" onclick="getQAlist(' 
										+ (endPage+1) + ', \'' 
										+ proTitle + '\')">&gt;</span>';
					}
					clickedPage = "qa"+pageNum;
					
				}
				// qa에 추가
				$("#QApaging").html(pagingHtml);
			}
			
			if(clickedPage!=null && clickedPage!=""){
				document.getElementById(clickedPage).style.fontWeight="bold";
				document.getElementById(clickedPage).style.color="#70d570";
			}
			
        },
        error : function(error) {
            console.log(error)
        }
    });	 
}


function showMenu(value){
	// 클릭한 값(히든 value값)
	var selectedValue = $(value).children("input").attr("value");

	// 클릭한 텍스트
	var selectedText = $(value).children("span").text();

	var resultList = $(value).parent().prev().children();
	resultList[0].innerText = selectedText;
	
	// 박스 사라지게 하기	
	$(value).parent().toggle();
	
	var MenuBtn = $(value).parent().prev().attr("id");
	
	if(MenuBtn=='starsBtn'){
		RVscore = selectedValue;
		getRVlist(1, title, lineUp);
		
	}else if(MenuBtn=='searchBtn'){
		searchOption = selectedValue;
	}
};


function getKeyword(){
	keyword = document.getElementById('searchText').value;
	getRVlist(1, title, lineUp);
}

function seeMore(){
	var btState = document.querySelector('#pDetail-Button');
	
	if(btState.innerText=='더보기'){
		btState.innerText = '접기';
		$("div.pDetail-ImageList").css('height', 'unset');
	
	}else if(btState.innerText=='접기'){
		btState.innerText = '더보기';
		$("div.pDetail-ImageList").css('height', '400px');
	}
}

/*
function drawStar(target){
	alert("와웅");
    document.querySelector(`.star .hiddenStar`).style.width = `${target.value * 20}%`;
    var lol = document.querySelector(`.star .hiddenStar`).style.width;
    console.log(lol);
}
*/

function drawStar(starValue, idNum){
	$(`#rvStar`+idNum).attr('style', 'width:'+ (starValue * 20) +'%');
}