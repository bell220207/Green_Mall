package com.cmp.Green_Mall.dao;
import com.cmp.Green_Mall.domain.UserDto;

public interface UserDao {
	public UserDto login(UserDto user);
	public int register(UserDto user) throws Exception;
	public UserDto idCheck(UserDto user);
	
}
