package com.cmp.Green_Mall.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cmp.Green_Mall.dao.QaDao;
import com.cmp.Green_Mall.domain.QADto;
import com.cmp.Green_Mall.domain.SearchCondition;
import com.cmp.Green_Mall.domain.UserDto;

@Service
public class QaServiceImpl implements QaService{

	@Autowired
	QaDao qaDao;
	
	@Override
	public List<QADto> getQAmyListPage(UserDto user, SearchCondition sc) {
		return qaDao.getQAmyListPage(user, sc);
	}

	@Override
	public Integer getQAmyListCnt(UserDto user) {
		return qaDao.getQAmyListCnt(user);
	}

	@Override
	public QADto readQA(QADto qaDto) {
		return qaDao.readQA(qaDto);
	}

	@Override
	public int removeQA(QADto qaDto) {
		return qaDao.removeQA(qaDto);
	}

	@Override
	public int modifyQA(QADto qaDto) {
		return qaDao.modifyQA(qaDto);
	}

	@Override
	public int insertQA(QADto qaDto) {
		return qaDao.insertQA(qaDto);
	}

	@Override
	public Integer CmtCnt(Integer qano) {
		return qaDao.CmtCnt(qano);
	}

	@Override
	public QADto getCmt(Integer qano) {
		return qaDao.getCmt(qano);
	}

	@Override
	public int wrtCmt(QADto qaDto) {
		return qaDao.wrtCmt(qaDto);
	}
	
	

}
