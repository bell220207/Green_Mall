
if(msg=="REG_ERR") { alert("가입에 실패했습니다."); }
if(msg=='REG_OK'){   alert("가입에 성공했습니다."); };
if(msg=='READ_ERR'){ alert("삭제되거나 존재하지 않는 게시물입니다."); };
if(msg=='LIST_ERR'){ alert("문의 페이지에 접속할 수 없습니다."); };
if(msg=='DEL_OK'){ alert("삭제 성공했습니다."); };
if(msg=='DEL_ERR'){ alert("삭제에 실패했습니다."); };
if(msg=='MOD_OK'){ alert("수정에 성공했습니다."); };
if(msg=='MOD_ERR'){ alert("수정에 실패했습니다."); };
if(msg=='WRT_OK'){ alert("등록에 성공했습니다."); };
if(msg=='WRT_ERR'){ alert("등록에 실패했습니다."); };

function showList(){
	var nav = document.querySelector("#nav");
	var navStyle = getComputedStyle(nav).display;
	
	if(navStyle=='none'){
		nav.style.display = 'block'; 
	}else{
		nav.style.display = 'none'; 
	}

}


function loginFormCheck(frm) {
	
	let id = frm.id.value;
	let pwd = frm.pwd.value;
	
	if(id.length==0){
		alert("id를 입력해주세요")
		return false;
	};
	
	if(pwd.length==0){
		alert("pwd를 입력해주세요")
		return false;
	};
	
	return true;
}

function idCheck(){
	var userid = $('input[name=id]').val();
	console.log("userid: "+userid);
 	var regExp = /^[a-zA-Z]{1}[a-zA-Z0-9_]{4,12}$/; // 5~12자 이내 & 최소 한 개의 영문자와 숫자 조합
	var result = regExp.test(userid);
	console.log("result: "+result)
 	
	if(userid==""||userid==null){
		alert("아이디를 입력해주세요.");
		return;
	}
	else if(userid.length<5 || userid.length>12){
		alert("아이디는 5~12자 이내입니다");
		return;
	}
	else if(!result){
		alert("아이디는 최소 하나의 영문자와 숫자 조합이어야 합니다")
		return;
	}
	
    $.ajax({
        type: 'POST',
        url: 'registerPage/idCheck',
        headers: {"content-type":"application/json"},
        dataType : 'text',
        data : JSON.stringify({id: userid}),
        success : function(data) {
			if(data=="idCk_ok"){
				alert("사용할 수 있는 아이디 입니다");
				$('input[name=idCheck]').val("true");
			}else if(data=="idCk_Err"){
				alert("사용할 수 없는 아이디 입니다");
			}
        },
        error : function(error) {
            console.log(error)
        }
    });	        
}

function dropdown(clickedBtn){
    var dropdownClass = $(clickedBtn).next("div").attr("class");
	var dropdownBox = document.querySelector('.'+dropdownClass);	
	$(dropdownBox).toggle();
}