package com.cmp.Green_Mall.service;
import com.cmp.Green_Mall.domain.UserDto;

public interface UserService {
	public UserDto login(UserDto user);
	public int register(UserDto user) throws Exception;
	public UserDto idCheck(UserDto user);
}
