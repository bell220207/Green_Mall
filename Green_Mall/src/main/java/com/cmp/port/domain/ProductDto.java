package com.cmp.port.domain;

import java.util.List;

public class ProductDto {
	private Integer bno;
	private String pro_title;
	private String cont_img;
	private Integer price;
	
	private List<String> proInfoList;
	private List<String> optionList;
	private String minNum;
	private String maxNum;
	
	public Integer getBno() { return bno; }
	public void setBno(Integer bno) { this.bno = bno; }
	
	public String getPro_title() {	return pro_title; }
	public void setPro_title(String pro_title) { this.pro_title = pro_title; }
	
	public String getCont_img() { return cont_img; }
	public void setCont_img(String cont_img) { this.cont_img = cont_img; }
	public Integer getPrice() {	return price; }
	public void setPrice(Integer price) { this.price = price; }
	
	public List<String> getProInfoList() { return proInfoList; }
	public void setProInfoList(List<String> proInfoList) { this.proInfoList = proInfoList; }
	public List<String> getOptionList() { return optionList;}
	public void setOptionList(List<String> optionList) { this.optionList = optionList; }
	
	public String getMinNum() { return minNum; }
	public void setMinNum(String minNum) {	this.minNum = minNum; }
	
	public String getMaxNum() {return maxNum;}
	public void setMaxNum(String maxNum) { this.maxNum = maxNum; }
	
	
	public ProductDto(){}
	
	@Override
	public String toString() {
		return "ProductDto [bno=" + bno + ", pro_title=" + pro_title + ", cont_img=" + cont_img + ", price=" + price
				+ ", proInfoList=" + proInfoList + ", optionList=" + optionList + ", minNum=" + minNum + ", maxNum="
				+ maxNum + "]";
	}
	
}
