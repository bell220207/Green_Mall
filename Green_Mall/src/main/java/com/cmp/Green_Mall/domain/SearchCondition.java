package com.cmp.Green_Mall.domain;
import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
    private Integer page = 1; // 현재 페이지
    private Integer pageSize = 10; // 한 페이지에 들어가는 게시물 갯수
    private String keyword = "";
	private String category="";
	private String sub_cate="";	
	private String searchOption="";
	
    
    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }
    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
    
    public Integer getOffset() { return (page-1)*pageSize; }
    
    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }
    
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
    public String getSub_cate() { return sub_cate; }
	public void setSub_cate(String sub_cate) { this.sub_cate = sub_cate; }
	
	// 추가
	public String getSearchOption() { return searchOption; }
	public void setSearchOption(String searchOption) { this.searchOption = searchOption; }
	
	
	// 기본 생성자
    public SearchCondition(){};

    public SearchCondition(Integer page, Integer pageSize, 
    					   String keyword, String category,
    					   String sub_cate ) {
        this.page = page;
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.category = category;
        this.sub_cate = sub_cate;
    }
    
    public String getQueryString(){
        return getQueryString(page);
    }    

    public String getQueryString(Integer page){
        // ?page-1&pageSize=10&option=T&keyword="title"을 만들어줌
        return UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("pageSize", pageSize)
                .queryParam("keyword", keyword)
                .queryParam("category", category)
                .queryParam("sub_cate", sub_cate)
                .build().toString();
    }
    
	@Override
	public String toString() {
		return "SearchCondition [page=" + page + ", pageSize=" + pageSize + ", keyword=" + keyword + ", category="
				+ category + ", sub_cate=" + sub_cate + ", searchOption=" + searchOption + "]";
	}
    
    /*
    @Override
    public String toString() {
        return "SearchCondition{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", offset=" + getOffset() +
                ", keyword='" + keyword + '\'' +
                ", category='" + category + '\'' +
                ", sub_cate='" + sub_cate + '\'' +                
//                ", option='" + option + '\'' +
                '}';
    }
    */
    
    
}
