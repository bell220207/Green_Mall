package com.cmp.port.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmp.port.dao.ProDao;
import com.cmp.port.domain.ProductDto;
import com.cmp.port.domain.QADto;
import com.cmp.port.domain.RvDto;
import com.cmp.port.domain.SearchCondition;

@Service
public class ProServiceImpl implements ProService{
	
	@Autowired
	ProDao boardDao;
	
	@Override
	public List<ProductDto> getList() {
		return boardDao.getList();
	}

	@Override
	public int getSearchResultCnt(SearchCondition sc) {
		return boardDao.getSearchResultCnt(sc);
	}

	@Override
	public List<ProductDto> getSearchResultPage(SearchCondition sc) {
		return boardDao.getSearchResultPage(sc);
	}
	
	@Override
	public ProductDto getProductInfo(ProductDto proDto) {
		return boardDao.getProductInfo(proDto);
	}
	
	@Override
	public List<String> getProductImgInfo(ProductDto proDto) {
		return boardDao.getProductImgInfo(proDto);
	}
	
	@Override
	public List<String> getProductOptions(ProductDto proDto) {
		return boardDao.getProductOptions(proDto);
	}
	
	
	@Override
	public List<QADto> getQList(ProductDto proDto, SearchCondition sc) {
		return boardDao.getQList(proDto, sc);
	}

	@Override
	public int getQAlistCnt(ProductDto proDto) {
		return boardDao.getQAlistCnt(proDto);
	}

	@Override
	public List<RvDto> getRVlist(ProductDto proDto, SearchCondition sc, RvDto rvDto) {
		return boardDao.getRVlist(proDto, sc, rvDto);
	}
	
	@Override
	public List<String> getRVimgList(RvDto rvDto) {
		return boardDao.getRVimgList(rvDto);
	}

	@Override
	public int getRVlistCnt(ProductDto proDto, SearchCondition sc, RvDto rvDto) {
		return boardDao.getRVlistCnt(proDto, sc, rvDto);
	}
	
}
