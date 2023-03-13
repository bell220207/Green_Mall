package com.cmp.Green_Mall.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmp.Green_Mall.domain.QADto;
import com.cmp.Green_Mall.domain.SearchCondition;
import com.cmp.Green_Mall.domain.UserDto;

@Repository
public class QaDaoImpl implements QaDao{
	
    @Autowired
    SqlSession session;

    String namespace = "com.cmp.port.dao.QaMapper.";

	@Override
	public List<QADto> getQAmyListPage(UserDto user, SearchCondition sc) {
		Map map = new HashMap();
		map.put("sc", sc);
		map.put("user", user);
		return session.selectList(namespace+"getQAmyListPage", map);
	}

	@Override
	public Integer getQAmyListCnt(UserDto user) {
		return session.selectOne(namespace+"getQAmyListCnt", user);
	}

	@Override
	public QADto readQA(QADto qaDto) {
		return session.selectOne(namespace+"readQA", qaDto);
	}

	@Override
	public int removeQA(QADto qaDto) {
		return session.delete(namespace+"removeQA", qaDto);
	}

	@Override
	public int modifyQA(QADto qaDto) {
		return session.update(namespace+"modifyQA",qaDto);
	}

	@Override
	public int insertQA(QADto qaDto) {
		return session.insert(namespace+"insertQA", qaDto);
	}

	@Override
	public Integer CmtCnt(Integer qano) {
		return session.selectOne(namespace+"CmtCnt", qano);
	}

	@Override
	public QADto getCmt(Integer qano) {
		return session.selectOne(namespace+"getCmt", qano);
	}

	@Override
	public int wrtCmt(QADto qaDto) {
		System.out.println("wrtCmt 다오");
		return session.insert(namespace+"wrtCmt", qaDto);
	}

}
