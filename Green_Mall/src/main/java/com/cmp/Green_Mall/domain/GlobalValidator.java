package com.cmp.Green_Mall.domain;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GlobalValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
        System.out.println("GlobalValidator.validate() is called");		
        /* 회원가입 */
        UserDto user = (UserDto)target;
        String id = user.getId();
        String pwd = user.getPwd();
        String name = user.getName();
        String email = user.getEmail();
        String birth = user.getBirth();
        String idCheck = user.getIdCheck();
        String Rgx = "^[a-zA-Z]{1}[a-zA-Z0-9_]{4,12}$"; // 영문으로 시작하는 영문+숫자조합
        String eRgx = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
        
        // 아이디 검증
        if(id==null||id=="") {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");
        }
        else if(id.length() <  5 || id.length() > 12){
            errors.rejectValue("id", "invalidLength", new String[]{"", "5", "12"}, null);
        }
        else if(!id.matches(Rgx)){
            errors.rejectValue("id", "invalidPattern", null);
        }
        // 비번 검증
        else if(pwd==null||pwd=="") {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
        }
        else if(pwd.length() <  5 || pwd.length() > 12){
            errors.rejectValue("pwd", "invalidLength", new String[]{"", "5", "12"}, null);
        }
        else if(!pwd.matches(Rgx)) {
            errors.rejectValue("pwd", "invalidPattern", null);
        }
        // 이름 검증
        else if(name==null || name==""){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        }
        // 이메일 검증
        else if(email!=null && email!="" && !email.matches(eRgx)){
            errors.rejectValue("email", "invalidPattern", null);
        }
        else if(idCheck==null || idCheck=="") {
        	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idCheck",  "required.idCheck");
        }
	}
}
