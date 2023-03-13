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
//		System.out.println("UserDaoImpl의 login 통과");
//		System.out.println("UserDaoImpl의 User: "+user.toString());	
		return session.selectOne(namespace+"login", user);
	}

	@Override
	public int register(UserDto user) throws Exception{
//		System.out.println("UserDaoImpl의 register 통과");
//		System.out.println("UserDaoImpl의 User: "+user.toString());
//		throw new Exception("test");
		return session.insert(namespace+"register", user);
	}

	@Override
	public UserDto idCheck(UserDto user) {
//		System.out.println("UserDaoImpl의 idCheck 통과");
//		System.out.println("UserDaoImpl:"+user);
		return session.selectOne(namespace+"idCheck", user);
	}
}
