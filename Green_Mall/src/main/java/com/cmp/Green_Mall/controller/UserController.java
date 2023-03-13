package com.cmp.Green_Mall.controller;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cmp.Green_Mall.domain.GlobalValidator;
import com.cmp.Green_Mall.domain.UserDto;
import com.cmp.Green_Mall.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
    // 로그인 페이지
	@RequestMapping("/loginPage")
	public void loginPage() {
//		System.out.println("loginPage 통과");
	}

	// 로그인 기능
    @PostMapping("/login/login")
	public String login(UserDto user, boolean rememberId, 
						RedirectAttributes rattr,
						String toURL,
			            HttpServletResponse response, HttpServletRequest request) {
		
    	String id = user.getId();
		String pwd = user.getPwd();
        
    	// 서비스 호출
    	UserDto result = userService.login(user);
    	System.out.println(result);
    	
		toURL = (toURL==null || toURL.equals("") ? "/" : toURL);
    	System.out.println("toURL: "+toURL);
    	if(result==null) { // 로그인 실패
    		String msg ="";
            try {
//            	msg = URLEncoder.encode("아이디 혹은 패스워드가 일치하지 않습니다", "utf-8");
            	msg="loginFail";
            	rattr.addFlashAttribute("msg", msg);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		return "redirect:/loginPage?toURL="+toURL;
    	}else { //  로그인 성공
    		HttpSession session = request.getSession();
    		session.setAttribute("SessionId", id);
    		
            // 아이디 저장 기능
            if(rememberId) {
            	try { // 쿠키를 생성해서 응답에 저장
	                Cookie cookie = new Cookie("id", id);
	                //쿠키의 path를 설정해주지 않으면 현재 경로에서만 only valid하도록 처리되기 때문에 리다이렉트 되면서 유효하지 않기에 사라져 버리는 것이다.
	                cookie.setPath("/");
	                response.addCookie(cookie);
            	}catch(Exception e){
            		System.out.println(e);
            	}
            }else {
                Cookie cookie = new Cookie("id", id);
                cookie.setMaxAge(0); // 쿠키 삭제
                cookie.setPath("/");
                response.addCookie(cookie);
            }
    		return "redirect:"+toURL;	
    	}
	}
    
    // 로그아웃
    @GetMapping("/login/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    
    // 회원가입 페이지
	@GetMapping("/registerPage")
	public void registerPage() {
	}
	
	// 회원가입 기능
    @PostMapping("/registerPage")
	public String register(@Valid UserDto user, BindingResult result, 
							Model m, RedirectAttributes rattr){
    	
		try {
			
			if(result.hasErrors()) {
	        	throw new Exception();
			}
			
			System.out.println("user: "+user);
			
			int rg_result = userService.register(user);
	    	if(rg_result==1) { // 가입 성공
				rattr.addFlashAttribute("msg", "REG_OK");
	    		return "redirect:/";				
//				m.addAttribute("msg", "REG_OK");
//	    		return "home";
	    	}else { // 가입 실패
	        	throw new Exception();
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("user", user);
			m.addAttribute("msg", "REG_ERR");
			return "registerPage";
		}
    }
    
    @PostMapping("registerPage/idCheck")
    @ResponseBody
	public String idCheck(@RequestBody UserDto user, BindingResult result) {
    	
    	String msg ="";
    	String id = user.getId();
    	UserDto id_result = userService.idCheck(user);
    	
    	if(id_result!=null) {
    		msg="idCk_Err";    		
    	}else {
    		msg="idCk_ok";
    	}    	
    	return msg;
    }
}
