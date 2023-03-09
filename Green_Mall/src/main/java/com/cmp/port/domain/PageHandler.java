package com.cmp.port.domain;

public class PageHandler {

    private SearchCondition sc;
    private int totalCnt; // 총 게시물 갯수
    private int naviSize=10; // 페이지 네비게이션의 크기
    private int totalPage; // 전체 페이지의 갯수
    private int beginPage; // 네비게이션의 시작 페이지
    private int endPage; // 네비게이션의 마지막 페이지
    private boolean showPrev; // 이전페이지 버튼 표시 유무
    private boolean showNext; // 다음페이지 버튼 표시 유무
    private String type; // 페이징 적용되는 항목 구분용
    

    public PageHandler(){ }

    public PageHandler(int totalCnt, SearchCondition sc){
        this.totalCnt = totalCnt;
        this.sc = sc;
        doPaging(totalCnt, sc);
    }

    public void doPaging(Integer totalCnt, SearchCondition sc){
        this.totalCnt = totalCnt;
        // 나머지 있으면 올린다 (정수/정수는 나머지가 남지 않는다. 실수 형변환을 해주어야!)
        totalPage = (int)Math.ceil(totalCnt/(double)sc.getPageSize());
        // page가 10인 경우 대비해서 1뺀다
        beginPage = (sc.getPage()-1)/naviSize * naviSize + 1;
        // 둘 중에 작은 쪽
        endPage = Math.min((beginPage + naviSize) - 1, totalPage);
        showPrev = (beginPage!=1);
        showNext = (endPage != totalPage);
    }

	public SearchCondition getSc() { return sc; }
	public void setSc(SearchCondition sc) {	this.sc = sc; }
	public int getTotalCnt() { return totalCnt; }
	public void setTotalCnt(int totalCnt) {	this.totalCnt = totalCnt; }
	public int getNaviSize() {	return naviSize; }
	public void setNaviSize(int naviSize) {	this.naviSize = naviSize; }
	public int getTotalPage() {	return totalPage; }
	public void setTotalPage(int totalPage) { this.totalPage = totalPage; }
	public int getBeginPage() {	return beginPage; }
	public void setBeginPage(int beginPage) { this.beginPage = beginPage; }
	public int getEndPage() { return endPage; }
	public void setEndPage(int endPage) { this.endPage = endPage; }
	public boolean isShowPrev() { return showPrev; }
	public void setShowPrev(boolean showPrev) {	this.showPrev = showPrev; }
	public boolean isShowNext() { return showNext; }
	public void setShowNext(boolean showNext) {	this.showNext = showNext; }
	
	// 추가
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }

	@Override
	public String toString() {
		return "PageHandler [sc=" + sc + ", totalCnt=" + totalCnt + ", naviSize=" + naviSize + ", totalPage="
				+ totalPage + ", beginPage=" + beginPage + ", endPage=" + endPage + ", showPrev=" + showPrev
				+ ", showNext=" + showNext + ", type=" + type + "]";
	}

}
