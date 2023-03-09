package com.cmp.port.dao;
import java.util.List;
import com.cmp.port.domain.ProductDto;
import com.cmp.port.domain.QADto;
import com.cmp.port.domain.RvDto;
import com.cmp.port.domain.SearchCondition;

public interface ProDao {

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
