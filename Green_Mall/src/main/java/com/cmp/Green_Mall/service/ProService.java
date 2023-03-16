package com.cmp.Green_Mall.service;
import java.util.List;

import com.cmp.Green_Mall.domain.ProductDto;
import com.cmp.Green_Mall.domain.QADto;
import com.cmp.Green_Mall.domain.RvDto;
import com.cmp.Green_Mall.domain.SearchCondition;

public interface ProService {

	public List<ProductDto> getList();
    public int getSearchResultCnt(SearchCondition sc);
    public List<ProductDto> getSearchResultPage(SearchCondition sc);
    public ProductDto getProductInfo(ProductDto proDto);
    public List<String> getProductImgInfo(ProductDto proDto);
    public List<String> getProductOptions(ProductDto proDto);
    public List<QADto> getQList(ProductDto proDto, SearchCondition sc);
    public int getQAlistCnt(ProductDto proDto);
    public List<RvDto> getRVlist(ProductDto proDto, SearchCondition sc, RvDto rvDto);
    public List<String> getRVimgList(RvDto rvDto);
    public int getRVlistCnt(ProductDto proDto, SearchCondition sc, RvDto rvDto);
    
}
