package com.cmp.Green_Mall.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmp.Green_Mall.dao.UserDao;
import com.cmp.Green_Mall.domain.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public UserDto login(UserDto user) {
//		System.out.println("UserServiceImpl의 login 통과");
//		System.out.println(user.toString());		
//		User result = userDao.login(user);
//		System.out.println("Dao 호출 결과: "+result);
		return userDao.login(user);
	}

	@Override
	public int register(UserDto user) throws Exception{
//		System.out.println("UserServiceImpl의 register 통과");
		return userDao.register(user);
	}

	@Override
	public UserDto idCheck(UserDto user) {
//		System.out.println("UserServiceImpl의 idCheck 통과");
//		System.out.println("UserServiceImpl:"+id);
		return userDao.idCheck(user);
	}
}
