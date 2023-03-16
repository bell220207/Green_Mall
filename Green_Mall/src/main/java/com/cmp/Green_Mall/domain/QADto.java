package com.cmp.Green_Mall.domain;

public class QADto {
	
	private String qa_type;
	private int qano;
	private String writer;
	private String pro_title;
	private String text;
	private String reg_date;
	
	public String getQa_type() { return qa_type; }
	public void setQa_type(String qa_type) { this.qa_type = qa_type;  }
	public int getQano() { return qano; }
	public void setQano(int qano) { this.qano = qano; }
	public String getWriter() {	return writer;}
	public void setWriter(String writer) { this.writer = writer; }
	
	public String getPro_title() {return pro_title;}
	public void setPro_title(String pro_title) {this.pro_title = pro_title;}
	
	public String getText() { return text; }
	public void setText(String text) { this.text = text; }
	public String getReg_date() { return reg_date; }
	public void setReg_date(String reg_date) { this.reg_date = reg_date; }
	
	@Override
	public String toString() {
		return "QADto [qa_type=" + qa_type + ", qano=" + qano + ", writer=" + writer + ", pro_title=" + pro_title
				+ ", text=" + text + ", reg_date=" + reg_date + "]";
	}
	
}
