package com.lib.mana.service;

import java.util.Optional;

import com.lib.mana.dto.UserDto;
import com.lib.mana.entity.UserEntity;

public interface UserService {

	public UserDto saveUserDetails(UserDto userDto);

//	public UserDto saveUser(UserDto userDto);

	public UserDto forgetPassword(UserDto userDto);

	public Optional<UserEntity> validateMobileNo(String mobile);

}
