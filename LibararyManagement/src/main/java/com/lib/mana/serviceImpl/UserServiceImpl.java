package com.lib.mana.serviceImpl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.mana.controller.UserController;
import com.lib.mana.dto.UserDto;
import com.lib.mana.entity.UserEntity;
import com.lib.mana.reposistory.UserReposistory;
import com.lib.mana.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserReposistory userReposistory;

	@Override
	public UserDto saveUserDetails(UserDto userDto) {

		try {
			LocalDateTime localtime = LocalDateTime.now();
			UserEntity user = new UserEntity();
			user.setUsername(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			user.setMobile(userDto.getMobile());
			user.setEmail(userDto.getEmail());
			user.setCreatedAt(localtime);
			userReposistory.save(user);

		} catch (Exception e) {
			logger.info("Message :" + e.getMessage());
		}

		return userDto;
	}

}
