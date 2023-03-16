package com.cmp.Green_Mall.dao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmp.Green_Mall.domain.UserDto;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    SqlSession session;
	
    // . 붙이기
    String namespace = "com.cmp.port.dao.UserMapper.";
    
	@Override
	public UserDto login(UserDto user){
		return session.selectOne(namespace+"login", user);
	}

	@Override
	public int register(UserDto user) throws Exception{
		return session.insert(namespace+"register", user);
	}

	@Override
	public UserDto idCheck(UserDto user) {
		return session.selectOne(namespace+"idCheck", user);
	}
}
