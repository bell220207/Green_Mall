package com.cmp.port.controller;
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
import com.cmp.port.domain.ProductDto;
import com.cmp.port.domain.PageHandler;
import com.cmp.port.domain.QADto;
import com.cmp.port.domain.RvDto;
import com.cmp.port.domain.SearchCondition;
import com.cmp.port.service.ProService;

@Controller
public class ProductController {

	@Autowired
	ProService proService;
	
	@GetMapping("/product")
	public String productPage(SearchCondition sc, ProductDto proDto, Model m) {
		
		try{
//		System.out.println("proDto: "+proDto);
		ProductDto list = proService.getProductInfo(proDto);
		
		List<String> imgList = proService.getProductImgInfo(proDto);
		List<String> optionsList = proService.getProductOptions(proDto);
		
		list.setProInfoList(imgList);
		list.setOptionList(optionsList);
		
		m.addAttribute("list", list);
		
		}catch(Exception e) {
			System.out.println("111111111111");
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
			
//			System.out.println("==========qalist map==========");
//			System.out.println("qalist pageNum: "+pageNum);
//			System.out.println("qalist proTitle: "+proTitle);
			
			ProductDto proDto = new ProductDto();
			proDto.setPro_title(proTitle);
			
			SearchCondition sc = new SearchCondition();
			sc.setPage(pageNum);
			
			// 페이징 적용한 문의내역 리스트 가져옴
			Qlist = proService.getQList(proDto, sc);
//			System.out.println("Qlist 결과: "+Qlist);
		} catch (ParseException e) {
			System.out.println("22222222222222");
			e.printStackTrace();
		}
		return Qlist;
	}
	
	// 리뷰 내역 가져오기
	@PostMapping("product/RVlist")
    @ResponseBody
    public List<RvDto> RVlist(@RequestBody String RVinput) {
		
//		System.out.println("RVinput: "+RVinput);
		List<RvDto> result=null;
		
		try {
			Map map = parsing(RVinput);
			
			ProductDto proDto = (ProductDto) map.get("proDto");
			SearchCondition sc = (SearchCondition) map.get("sc");
			RvDto rvDto = (RvDto) map.get("rvDto");
			String type = (String) map.get("type");
			
//			System.out.println("==========RVlist map==========");
//			System.out.println(map);
//			System.out.println(proDto);
//			System.out.println(sc);
//			System.out.println(rvDto);
//			System.out.println(type);
			
			// 새 리뷰 내역
			result = proService.getRVlist(proDto, sc, rvDto);
			
			// 이미지 리스트 적용
			for(int i=0; i<result.size(); i++) {
				rvDto.setRno(result.get(i).getRno());
				List<String> RVimgList = proService.getRVimgList(rvDto);
				result.get(i).setImg_list(RVimgList);
			}
			
//			System.out.println("RVlist 결과: "+result);
		}catch (Exception e) {
			System.out.println("33333333333333333333");
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
		
//		System.out.println("==========proPaging map==========");
//		System.out.println(map);
//		System.out.println(proDto);
//		System.out.println(sc);
//		System.out.println(rvDto);
//		System.out.println(type);
				
		if(type.equals("QA")) {
			int QAlistCnt = proService.getQAlistCnt(proDto);
			pageHandler = new PageHandler(QAlistCnt, sc);
			pageHandler.setType("QA");
//			System.out.println("proPaging QAlistCnt: "+QAlistCnt);
		}
		
		if(type.equals("RV")) {
			int RVlistCnt = proService.getRVlistCnt(proDto, sc, rvDto);
			pageHandler = new PageHandler(RVlistCnt, sc);
			pageHandler.setType("RV");
//			System.out.println("proPaging RVlistCnt: "+RVlistCnt);
		}
		
//		System.out.println(pageHandler);
		
		}catch(Exception e){
			System.out.println("444444444444444444");
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
			System.out.println("5555555555555555");
			e.printStackTrace();
		}
		
		return map;
		
	}
	
	
}
