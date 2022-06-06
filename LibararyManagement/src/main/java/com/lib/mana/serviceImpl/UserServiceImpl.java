package com.lib.mana.serviceImpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lib.mana.dto.UserDto;
import com.lib.mana.entity.UserEntity;
import com.lib.mana.reposistory.RoleRepository;
import com.lib.mana.reposistory.UserReposistory;
import com.lib.mana.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserReposistory userRepo;
	
	@Autowired
	RoleRepository roleRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto saveUserDetails(UserDto userDto) {

		try {
			UserEntity user = new UserEntity();
			user.setUsername(userDto.getUsername());
			user.setMobile(userDto.getMobile());
			user.setEmail(userDto.getEmail());
			user.setName(userDto.getName());
			user.setPassword(passwordEncoder.encode(userDto.getPassword()));
			user.setConfPassword(passwordEncoder.encode(userDto.getConf_password()));
			userRepo.save(user);
			userDto.setId(user.getId());
			userDto.setPassword("**********");
			userDto.setConf_password("**********");

		} catch (Exception e) {
			logger.info("Message :" + e.getMessage());
		}

		return userDto;
	}

	@Override
	public UserDto forgetPassword(UserDto userDto) {

		String password = passwordEncoder.encode(userDto.getPassword());
		String confpassword = passwordEncoder.encode(userDto.getConf_password());
		userRepo.updatePassword(userDto.getMobile(), password, confpassword);

		return userDto;
	}

	@Override
	public Optional<UserEntity> validateMobileNo(String mobile) {
		// TODO Auto-generated method stub
		return userRepo.findByMobile(mobile);
	}

}
