package com.cmp.Green_Mall.service;
import java.util.List;

import com.cmp.Green_Mall.domain.QADto;
import com.cmp.Green_Mall.domain.SearchCondition;
import com.cmp.Green_Mall.domain.UserDto;

public interface QaService {
	
	public List<QADto> getQAmyListPage(UserDto user, SearchCondition sc);
	public Integer getQAmyListCnt(UserDto user);	
	public QADto readQA(QADto qaDto);
	public int removeQA(QADto qaDto);
	public int modifyQA(QADto qaDto);
	public int insertQA(QADto qaDto);
	
	public Integer CmtCnt(Integer qano);
	public QADto getCmt(Integer qano);
	public int wrtCmt(QADto qaDto);
}
