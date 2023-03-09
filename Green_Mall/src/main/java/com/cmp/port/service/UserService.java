package com.cmp.port.service;
import com.cmp.port.domain.UserDto;

public interface UserService {
	public UserDto login(UserDto user);
	public int register(UserDto user) throws Exception;
	public UserDto idCheck(UserDto user);
}
