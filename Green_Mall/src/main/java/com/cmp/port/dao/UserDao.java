package com.cmp.port.dao;
import com.cmp.port.domain.UserDto;

public interface UserDao {
	public UserDto login(UserDto user);
	public int register(UserDto user) throws Exception;
	public UserDto idCheck(UserDto user);
	
}
