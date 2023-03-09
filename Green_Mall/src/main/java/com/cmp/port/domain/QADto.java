package com.cmp.port.domain;

public class QADto {
//	private String id;
//	private String title;
	
//	private String q_text;
//	private String q_date;
//	
//	private String manager_id;
//	private String r_text;
//	private String r_date;
	
	/*추가*/
	private String qa_type;
	private int qano;
	private String writer;
	private String text;
	private String reg_date;
	
//	public String getId() {	return id; }
//	public void setId(String id) { this.id = id; }
//	public String getTitle() { return title; }
//	public void setTitle(String title) { this.title = title; }
	
//	public String getQ_text() { return q_text; }
//	public void setQ_text(String q_text) { this.q_text = q_text;}
//	public String getQ_date() { return q_date; }
//	public void setQ_date(String q_date) { this.q_date = q_date; }
//	public String getManager_id() { return manager_id; }
//	public void setManager_id(String manager_id) { this.manager_id = manager_id; }
//	public String getR_text() { return r_text;}
//	public void setR_text(String r_text) { this.r_text = r_text;}
//	public String getR_date() {	return r_date; }
//	public void setR_date(String r_date) { this.r_date = r_date; }
	
	
	/*추가*/
	public String getQa_type() { return qa_type; }
	public void setQa_type(String qa_type) { this.qa_type = qa_type;  }
	public int getQano() { return qano; }
	public void setQano(int qano) { this.qano = qano; }
	public String getWriter() {	return writer;}
	public void setWriter(String writer) { this.writer = writer; }
	public String getText() { return text; }
	public void setText(String text) { this.text = text; }
	public String getReg_date() { return reg_date; }
	public void setReg_date(String reg_date) { this.reg_date = reg_date; }
	
	@Override
	public String toString() {
		return "{qa_type:"+ qa_type+ ",qano:" + qano + ",writer:" + writer + ",text:" + text + ",reg_date:"
				+ reg_date+"}";
	}
}
