package com.cmp.Green_Mall.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmp.Green_Mall.domain.PageHandler;
import com.cmp.Green_Mall.domain.ProductDto;
import com.cmp.Green_Mall.domain.QADto;
import com.cmp.Green_Mall.domain.RvDto;
import com.cmp.Green_Mall.domain.SearchCondition;
import com.cmp.Green_Mall.service.ProService;

@Controller
public class ProductController {

	@Autowired
	ProService proService;
	
	@GetMapping("/product")
	public String productPage(SearchCondition sc, ProductDto proDto, Model m) {
		
		try{
			ProductDto list = proService.getProductInfo(proDto);
			List<String> imgList = proService.getProductImgInfo(proDto);
			List<String> optionsList = proService.getProductOptions(proDto);
			
			list.setProInfoList(imgList);
			list.setOptionList(optionsList);
			
			m.addAttribute("list", list);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "product";
	}
	
	@PostMapping("product/qalist")
    @ResponseBody
    public List<QADto> qalist(@RequestBody String input) {

		JSONParser jsonParse = new JSONParser();
		List<QADto> Qlist = null;
		
		try {
			JSONObject jsonInput = (JSONObject)jsonParse.parse(input);
			Integer pageNum = Integer.parseInt((String) jsonInput.get("pageNum"));
			String proTitle = (String)jsonInput.get("proTitle");
			
			ProductDto proDto = new ProductDto();
			proDto.setPro_title(proTitle);
			
			SearchCondition sc = new SearchCondition();
			sc.setPage(pageNum);
			
			Qlist = proService.getQList(proDto, sc);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Qlist;
	}
	
	// 리뷰 내역 가져오기
	@PostMapping("product/RVlist")
    @ResponseBody
    public List<RvDto> RVlist(@RequestBody String RVinput) {
		
		List<RvDto> result=null;
		
		try {
			Map map = parsing(RVinput);
			
			ProductDto proDto = (ProductDto) map.get("proDto");
			SearchCondition sc = (SearchCondition) map.get("sc");
			RvDto rvDto = (RvDto) map.get("rvDto");
			String type = (String) map.get("type");
			
			// 새 리뷰 내역
			result = proService.getRVlist(proDto, sc, rvDto);
			
			// 이미지 리스트 적용
			for(int i=0; i<result.size(); i++) {
				rvDto.setRno(result.get(i).getRno());
				List<String> RVimgList = proService.getRVimgList(rvDto);
				result.get(i).setImg_list(RVimgList);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return result;
	}
	
	
	// 상품 페이지 페이징 요청
	@PostMapping("product/proPaging")
    @ResponseBody
    public PageHandler proPaging(@RequestBody String input) {
		
		PageHandler pageHandler=new PageHandler();
		
		try {
			Map map = parsing(input);
			
			ProductDto proDto = (ProductDto) map.get("proDto");
			SearchCondition sc = (SearchCondition) map.get("sc");
			RvDto rvDto = (RvDto) map.get("rvDto");
			String type = (String) map.get("type");
					
			if(type.equals("QA")) {
				int QAlistCnt = proService.getQAlistCnt(proDto);
				pageHandler = new PageHandler(QAlistCnt, sc);
				pageHandler.setType("QA");
			}
			
			if(type.equals("RV")) {
				int RVlistCnt = proService.getRVlistCnt(proDto, sc, rvDto);
				pageHandler = new PageHandler(RVlistCnt, sc);
				pageHandler.setType("RV");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return pageHandler;
	}
	
	
	// 파싱 메서드
	public Map parsing(String input) {
		JSONParser jsonParse = new JSONParser();
		JSONObject jsonInput;
		Map map = new HashMap();
		
		try {
			jsonInput = (JSONObject)jsonParse.parse(input);
			Integer pageNum = Integer.parseInt((String) jsonInput.get("pageNum"));
			String proTitle = (String)jsonInput.get("proTitle");
			String type = (String)jsonInput.get("type");

			String lineUp = (String) jsonInput.get("lineUp");
			String RVscore = (String)jsonInput.get("RVscore");
			
			String searchOption = (String)jsonInput.get("searchOption");
			String keyword = (String) jsonInput.get("keyword");
			
			ProductDto proDto = new ProductDto();
			proDto.setPro_title(proTitle);
			
			SearchCondition sc = new SearchCondition();
			sc.setPage(pageNum);
			sc.setKeyword(keyword);
			sc.setSearchOption(searchOption);
			
			RvDto rvDto = new RvDto();
			rvDto.setStars(RVscore);
			rvDto.setLineUp(lineUp);
			
			map.put("proDto", proDto);
			map.put("sc", sc);
			map.put("rvDto", rvDto);
			map.put("type", type);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return map;
		
	}
	
	
}
