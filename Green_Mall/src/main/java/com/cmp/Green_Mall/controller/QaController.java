package com.cmp.Green_Mall.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cmp.Green_Mall.domain.PageHandler;
import com.cmp.Green_Mall.domain.ProductDto;
import com.cmp.Green_Mall.domain.QADto;
import com.cmp.Green_Mall.domain.RvDto;
import com.cmp.Green_Mall.domain.SearchCondition;
import com.cmp.Green_Mall.domain.UserDto;
import com.cmp.Green_Mall.service.QaService;

@Controller
public class QaController {

	@Autowired
	QaService qaService;
	
	@GetMapping("/QAmyListPage")
	public String getQAmyListPage(SearchCondition sc, Model m, RedirectAttributes rattr,  HttpSession session) {
		
		try {
			
			String id = (String)session.getAttribute("SessionId");
			System.out.println("QAmyListPage id: "+id);
			
			// 임시
			UserDto user = new UserDto();
			user.setId(id);
			
			System.out.println(user.toString());
			System.out.println("QAMylistPage sc: "+sc);
			
			List<QADto> QAmyList = qaService.getQAmyListPage(user, sc);
			Integer QAmyListCnt = qaService.getQAmyListCnt(user);
			
			System.out.println("QAmyList: "+QAmyList);
			System.out.println("QAmyListCnt: "+QAmyListCnt);
			
			PageHandler pageHandler = new PageHandler(QAmyListCnt, sc);
			System.out.println("QAMylistPage pageHandler: "+pageHandler);
			
			m.addAttribute("QAmyList", QAmyList);
			m.addAttribute("ph", pageHandler);
			
		}catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "LIST_ERR");
			return "redirect:/";
		}
		
		return "QAmyListPage";
	}
	
    @GetMapping("/QAmyDetailPage/write")
    public String writePage(Model m, QADto qaDto){
        System.out.println("get write QADto: "+qaDto);
    	m.addAttribute("mode", "new"); // 쓰기에 사용하는 값
        
        return "QAmyDetailPage";
    }
	
	
    @PostMapping("/QAmyDetailPage/write")
    public String write(Model m, QADto qaDto, HttpSession session, RedirectAttributes rattr){
    	
    	System.out.println("post write");
    	System.out.println("들어온 qaDto: "+qaDto);
    	
    	try{
	    	String id = (String)session.getAttribute("SessionId");
	    	qaDto.setWriter(id);
	    	System.out.println("post write QADto: "+qaDto);
	    	
	    	Integer result = qaService.insertQA(qaDto);
//	    	Integer result = 0;
	    	if(result!=1){
                throw new Exception("board write error");
            }
	    	
	    	System.out.println("result: "+result);
    		rattr.addFlashAttribute("msg", "WRT_OK");
	    	
	    	return "redirect:/QAmyListPage";
	    	
    	}catch (Exception e) {
    		
    		e.printStackTrace();
    		rattr.addAttribute("pro_title", qaDto.getPro_title());
    		rattr.addAttribute("text", qaDto.getText());
    		rattr.addFlashAttribute("msg", "WRT_ERR");
    		 
    		return "redirect:/QAmyDetailPage/write";
		}
    }
	
	@GetMapping("/QAmyDetailPage/read")
	public String getQAmyDetailPage(QADto qaDto, SearchCondition sc, Model m, RedirectAttributes rattr, HttpSession session) {
		
		try {
			
			String id = (String)session.getAttribute("SessionId");
			System.out.println("getQAmyDetailPage id: "+id);
			qaDto.setWriter(id);
			
			System.out.println("read qaDto: "+qaDto);
			System.out.println("read sc: "+sc);
			
			QADto QADto = qaService.readQA(qaDto);
			System.out.println("QADto: "+QADto);
			
			m.addAttribute("QADto", QADto);
			m.addAttribute("mode", "read");
			
			return "QAmyDetailPage";
			
		}catch(Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "READ_ERR");
			return "redirect:/QAmyListPage"+sc.getQueryString();
		}
	}
	
	@PostMapping("/QAmyDetailPage/remove")
	public String removeQAmyDetailPage(QADto qaDto, SearchCondition sc, Model m, RedirectAttributes rattr) {
		try{
			System.out.println("remove removeQAmyDetailPage 통과");
			System.out.println("remove qaDto: "+qaDto);
			System.out.println("remove sc: "+sc);
			
			Integer del_result = qaService.removeQA(qaDto);
			
			// 에러용
//			Integer del_result = 0;
			System.out.println("del_result: "+del_result);
			
			rattr.addFlashAttribute("msg", "DEL_OK");
			
			if(del_result!=1){
                throw new Exception("board remove error");
            }
			
			return "redirect:/QAmyListPage"+sc.getQueryString();
			
		}catch (Exception e) {
			e.printStackTrace();
			rattr.addFlashAttribute("msg", "DEL_ERR");
			return "redirect:/QAmyDetailPage/read"+sc.getQueryString()+"&qano="+qaDto.getQano()+"&writer="+qaDto.getWriter();
		}
	}
	
	@PostMapping("/QAmyDetailPage/modify")
	public String modQAmyDetailPage(QADto qaDto, SearchCondition sc, Model m, RedirectAttributes rattr) {
		try {
			System.out.println("modify: 수정");
			System.out.println("modify qaDto: "+qaDto);
			System.out.println("modify sc: "+sc);
			
			Integer result= qaService.modifyQA(qaDto);
		//	Integer result=0;
			
			System.out.println("modify: "+result);
			if(result!=1){
                throw new Exception("Modify failed");
            }
			rattr.addFlashAttribute("msg", "MOD_OK");
			return "redirect:/QAmyListPage"+sc.getQueryString();
			
		}catch(Exception e) {
			e.printStackTrace();
			m.addAttribute("QADto", qaDto);
			m.addAttribute("msg", "MOD_ERR");
			
			return "QAmyDetailPage";
		}
		
	}
	
	@GetMapping("/QAmyDetailPage/readCmt")
	@ResponseBody
	public QADto readCmt(Integer qano) {
		
		System.out.println("readCmt qano: "+qano);
		QADto Cmt = null;
		Integer result = qaService.CmtCnt(qano);
		if(result!=0) {
			Cmt = qaService.getCmt(qano);
			System.out.println("Cmt: "+Cmt);
		}
		return Cmt;
	}
	
	@PostMapping("/QAmyDetailPage/wrtCmt")
    @ResponseBody
    public String wrtCmt(@RequestBody String input) {
		
		System.out.println("input: "+input);
		
		JSONParser jsonParse = new JSONParser();
		JSONObject jsonInput;
		QADto qaDto = new QADto();
		String msg = "";
		
		try {
			jsonInput = (JSONObject)jsonParse.parse(input);
			Integer qano = Integer.parseInt((String) jsonInput.get("qano"));
			String writer = (String)jsonInput.get("writer");
			String pro_title = (String)jsonInput.get("pro_title");
			String text = (String)jsonInput.get("text");
			
			System.out.println("wrtCmt qano: "+qano);
			System.out.println("wrtCmt pro_title: "+pro_title);
			System.out.println("wrtCmt text: "+text);
			qaDto.setQano(qano);
			qaDto.setWriter(writer);
			qaDto.setPro_title(pro_title);
			qaDto.setText(text);
		
			Integer result = qaService.wrtCmt(qaDto);
			System.out.println("result: "+result);
			
			if(result!=1){
                throw new Exception("wrtCmt failed");
            }
			
			msg ="wrtCmt success";
			
			
		}catch (Exception e) {
			e.printStackTrace();
			msg ="wrtCmt failed";
		}
		
		return msg;
	}
	
	
	
	
}
