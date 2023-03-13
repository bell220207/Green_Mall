package com.cmp.Green_Mall.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmp.Green_Mall.domain.PageHandler;
import com.cmp.Green_Mall.domain.ProductDto;
import com.cmp.Green_Mall.domain.SearchCondition;
import com.cmp.Green_Mall.service.ProService;

@Controller
public class ProductsListController {
	
	@Autowired
	ProService proService;
	
	private boolean loginCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		boolean result = session.getAttribute("SessionId")==null? false : true ;
		return result;
	}
	
    // 상품 페이지
	@GetMapping("/productsList")
	public String products(HttpServletRequest request, Model m,
						   SearchCondition sc) {
		System.out.println("productsList 통과");
		sc.setPageSize(9);
		System.out.println("sc: "+sc);
		
//		Integer page = sc.getPage();
//		Integer pageSize = sc.getPageSize();
//		System.out.println("page: "+page);
//		System.out.println("pageSize: "+pageSize);
//		System.out.println("keyword: "+sc.getKeyword());
		
		if(!loginCheck(request)) { // false
			System.out.println("toUrl: "+request.getRequestURL());
			return "redirect:/loginPage?toURL="+request.getRequestURL();
		}
		
		try{
			
			/*
			List<BoardDto> list = proService.getList();
			System.out.println(list);
			m.addAttribute("list", list);
			*/
			
			/*페이징*/
			int totalCnt = proService.getSearchResultCnt(sc);
			System.out.println("productsList totalCnt: "+totalCnt);
			PageHandler pageHandler = new PageHandler(totalCnt, sc);
			System.out.println("productsList pageHandler: "+pageHandler);
			m.addAttribute("ph", pageHandler);

			/*페이지 데이터 뿌리기*/
			List<ProductDto> list =	proService.getSearchResultPage(sc);
//			System.out.println("==============결과===============");
			System.out.println("productsList 페이지 결과: "+list);
//			System.out.println("================================");
			
			m.addAttribute("list", list);
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		
		return "productsList";
	}
	
}
