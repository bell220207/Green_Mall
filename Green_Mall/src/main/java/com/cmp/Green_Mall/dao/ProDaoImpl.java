package com.cmp.Green_Mall.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmp.Green_Mall.domain.ProductDto;
import com.cmp.Green_Mall.domain.QADto;
import com.cmp.Green_Mall.domain.RvDto;
import com.cmp.Green_Mall.domain.SearchCondition;

@Repository
public class ProDaoImpl implements ProDao{

    @Autowired
    SqlSession session;

    String namespace = "com.cmp.port.dao.ProMapper.";
	
	@Override
	public List<ProductDto> getList() {
		return session.selectList(namespace+"getList");
	}

	@Override
	public int getSearchResultCnt(SearchCondition sc) {
		return session.selectOne(namespace+"searchResultCnt", sc);
	}

	@Override
	public List<ProductDto> getSearchResultPage(SearchCondition sc) {
		return session.selectList(namespace+"getSearchResultPage", sc);
	}

	@Override
	public ProductDto getProductInfo(ProductDto proDto) {
		return session.selectOne(namespace+"getProductInfo", proDto);
	}
	
	@Override
	public List<String> getProductImgInfo(ProductDto proDto) {
		return session.selectList(namespace+"getProductImgInfo", proDto);
	}

	@Override
	public List<String> getProductOptions(ProductDto proDto) {
		return session.selectList(namespace+"getOptionsList", proDto);
	}
	
	@Override
	public List<QADto> getQList(ProductDto proDto, SearchCondition sc) {
		Map map = new HashMap();
		map.put("proDto", proDto);
		map.put("sc", sc);
		return session.selectList(namespace+"getQList", map);
	}

	@Override
	public int getQAlistCnt(ProductDto proDto) {
		return session.selectOne(namespace+"QAlistCnt", proDto);
	}

	@Override
	public List<RvDto> getRVlist(ProductDto proDto, SearchCondition sc, RvDto rvDto) {
		Map map = new HashMap();
		map.put("proDto", proDto);
		map.put("sc", sc);
		map.put("rvDto", rvDto);
		
		return session.selectList(namespace+"getRVlist", map);
	}
	
	@Override
	public List<String> getRVimgList(RvDto rvDto) {
		return session.selectList(namespace+"getRVimgList", rvDto);
	}

	@Override
	public int getRVlistCnt(ProductDto proDto, SearchCondition sc, RvDto rvDto) {
		Map map = new HashMap();
		map.put("proDto", proDto);
		map.put("sc", sc);
		map.put("rvDto", rvDto);
		return session.selectOne(namespace+"RVlistCnt", map);
	}
	
}
