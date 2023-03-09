$(document).ready(function(){

	st_Menu();
	
});




function st_Menu(){
	
	var target=".";
	
	if(ct=="" && sub_ct==""){ target+="all"; }
	
	if(ct=="top"){
		if(sub_ct==""){	target+="top"; }
		if(sub_ct=="half"){	target+="top-half"; }
		if(sub_ct=="long"){	target+="top-long"; }
		if(sub_ct=="shirt"){target+="top-shirt"; }
		if(sub_ct=="hoodie"){target+="top-hoodie"; }
		if(sub_ct=="outer"){target+="top-outer"; }
	}
	
	if(ct=="bottom"){
		if(sub_ct==""){	target+="bottom"; }
		if(sub_ct=="half"){	target+="bottom-half"; }
		if(sub_ct=="long"){	target+="bottom-long"; }
		if(sub_ct=="skirt"){target+="bottom-skirt"; }
		if(sub_ct=="onepiece"){target+="bottom-onepiece"; }
	}
	
	if(ct=="accessary"){
		if(sub_ct==""){	target+="accessary"; }
		if(sub_ct=="bag"){	target+="acce-bag"; }
		if(sub_ct=="shoes"){target+="acce-shoes"; }
		if(sub_ct=="hair"){target+="acce-hair"; }
		if(sub_ct=="acc"){target+="acce-acc"; }
		if(sub_ct=="ect"){target+="acce-ect"; }
	}
	
	$(target).css("background-color", "rgba(0, 0, 0, 0.1)");
}
