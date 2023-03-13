package com.cmp.Green_Mall.controller;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
//	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model m, SearchCondition sc) {
		
		System.out.println("HomeController sc: "+sc);
		sc.setPage(1);
		sc.setPageSize(6);
		sc.setSearchOption("H");
		
		List<ProductDto> HomeList =	boardService.getSearchResultPage(sc);
		System.out.println("HomeController list: "+HomeList);
		
		m.addAttribute("HomeList", HomeList);
		
		return "home";
	}
}
