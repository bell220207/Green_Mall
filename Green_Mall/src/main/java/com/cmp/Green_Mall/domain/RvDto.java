package com.cmp.Green_Mall.domain;

import java.util.List;

public class RvDto {
	
	/*추가*/
	private String id;
	private String profileimg;
	
	private Integer rno;

	//	private Integer stars;
	private String stars;
	
	private String pro_title;
	private String rv_title;
	private String rv_text;
	private String rv_date;
	
	private List<String> img_list;

	private String lineUp;
	
	/*추가*/
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getProfileimg() {	return profileimg; }
	public void setProfileimg(String profileimg) { this.profileimg = profileimg; }
	
	/*추가2*/
	public List<String> getImg_list() {	return img_list; }
	public void setImg_list(List<String> img_list) {this.img_list = img_list; }
	
	/*추가3*/
	public String getLineUp() {	return lineUp; }
	public void setLineUp(String lineUp) {	this.lineUp = lineUp; }
	
	
	public Integer getRno() { return rno; }
	public void setRno(Integer rno) { this.rno = rno; }
	
	/*
	public Integer getStars() { return stars; }
	public void setStars(Integer stars) { this.stars = stars; }
	*/
	public String getStars() { return stars; }
	public void setStars(String stars) { this.stars = stars; }
	
	public String getPro_title() {return pro_title;}
	public void setPro_title(String pro_title) {this.pro_title = pro_title;}
	
	public String getRv_title() { return rv_title; }
	public void setRv_title(String rv_title) { this.rv_title = rv_title; }
	public String getRv_text() { return rv_text; }
	public void setRv_text(String rv_text) { this.rv_text = rv_text; }
	public String getRv_date() { return rv_date; }
	public void setRv_date(String rv_date) { this.rv_date = rv_date; }
	
	@Override
	public String toString() {
		return "RvDto [id=" + id + ", profileimg=" + profileimg + ", rno=" + rno + ", stars=" + stars + ", pro_title="
				+ pro_title + ", rv_title=" + rv_title + ", rv_text=" + rv_text + ", rv_date=" + rv_date + ", img_list="
				+ img_list + ", lineUp=" + lineUp + "]";
	}
	
}
