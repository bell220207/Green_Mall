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
		return userDao.login(user);
	}

	@Override
	public int register(UserDto user) throws Exception{
		return userDao.register(user);
	}

	@Override
	public UserDto idCheck(UserDto user) {
		return userDao.idCheck(user);
	}
}
