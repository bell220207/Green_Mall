package com.cmp.Green_Mall.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cmp.Green_Mall.domain.ProductDto;
import com.cmp.Green_Mall.domain.SearchCondition;
import com.cmp.Green_Mall.service.ProService;

@Controller
public class HomeController {
	@Autowired
	ProService boardService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model m, SearchCondition sc) {
		
		sc.setPage(1);
		sc.setPageSize(6);
		sc.setSearchOption("H");
		
		// 홈에 뿌려지는 최신 상품 데이터
		List<ProductDto> HomeList =	boardService.getSearchResultPage(sc);
		
		m.addAttribute("HomeList", HomeList);
		
		return "home";
	}
}
