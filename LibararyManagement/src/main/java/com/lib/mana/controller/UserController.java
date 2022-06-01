package com.lib.mana.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.mana.dto.UserDto;
import com.lib.mana.response.ApiResponse;
import com.lib.mana.service.UserService;
import com.lib.mana.utils.UriMapping;

@RestController
@RequestMapping(UriMapping.BASE_URI)
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping(UriMapping.REGISTER)
	public ResponseEntity<?> userRegister(@RequestBody UserDto userDto) {

		ApiResponse response = new ApiResponse();
		try {

			UserDto userDtoRes = userService.saveUserDetails(userDto);
			response.setMessage("USER SAVED SUCCESSFULLY.");
			response.setStatusCode(200);
			response.setError(false);
			response.setData(userDtoRes);
		} catch (Exception e) {
			logger.info("Message : " + e.getMessage());
		}

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
