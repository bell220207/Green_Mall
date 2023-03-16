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
		sc.setPageSize(9);

		if(!loginCheck(request)) { // false
			return "redirect:/loginPage?toURL="+request.getRequestURL();
		}
		
		try{
			
			/*페이징*/
			int totalCnt = proService.getSearchResultCnt(sc);
			PageHandler pageHandler = new PageHandler(totalCnt, sc);
			m.addAttribute("ph", pageHandler);

			/*페이지 데이터 뿌리기*/
			List<ProductDto> list =	proService.getSearchResultPage(sc);
			
			m.addAttribute("list", list);
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		
		return "productsList";
	}
	
}
