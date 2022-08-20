package com.lib.mana.login.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.mana.dto.LoginDto;
import com.lib.mana.dto.UserDto;
import com.lib.mana.entity.UserEntity;
import com.lib.mana.response.ApiResponse;
import com.lib.mana.service.UserService;
import com.lib.mana.utils.UriMapping;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(UriMapping.API_AUTH)
public class UserRegistrationController {

	@Autowired
	UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping(UriMapping.REGISTER)
	public ResponseEntity<?> userRegistration(@RequestBody UserDto userDto) {
		ApiResponse response = new ApiResponse();
		try {
			

			if (String.valueOf(userDto.getMobile()).length() <= 10 && String.valueOf(userDto.getMobile()).length() >= 10
					&& userDto.getPassword().equals(userDto.getConf_password())) {

				Optional<UserEntity> mobileNoValidate = userService.validateMobileNo(userDto.getMobile());

				if (!mobileNoValidate.isPresent()) {
					if (!userDto.getName().isEmpty() && !userDto.getMobile().isEmpty() && !userDto.getEmail().isEmpty()
							&& !userDto.getPassword().isEmpty() && !userDto.getConf_password().isEmpty()) {

						UserDto userDtoRes = userService.saveUserDetails(userDto);
						response.setMessage("USER SAVED SUCCESSFULLY.");
						response.setStatusCode(200);
						response.setError(false);
						response.setData(userDtoRes);

					} else {
						return new ResponseEntity<>("All details are Can not be Null .", HttpStatus.ACCEPTED);
					}
				} else {
					return new ResponseEntity<>("Mobile number already exist , .", HttpStatus.ACCEPTED);
				}
			} else {
				return new ResponseEntity<>(
						"Mobile no can not be more than 10 digits or less than 10 digits------ OR. ------  both password are not macthed..",
						HttpStatus.ACCEPTED);
			}

		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
		}

		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	@PostMapping(UriMapping.FORGET_PASSWORD)
	public ResponseEntity<String> forgetPassword(@RequestBody UserDto userDto) {
		try {

			if (String.valueOf(userDto.getMobile()).length() <= 10 && String.valueOf(userDto.getMobile()).length() >= 10
					&& userDto.getPassword().equals(userDto.getConf_password())) {
				if (!userDto.getMobile().isEmpty() && !userDto.getPassword().isEmpty()
						&& !userDto.getConf_password().isEmpty()) {

					Optional<UserEntity> mobileNoValidate = userService.validateMobileNo(userDto.getMobile());

					if (mobileNoValidate.isPresent()) {
						userService.forgetPassword(userDto);
					} else {
						return new ResponseEntity<>("Not a valid mobile number . please enter valid mobile number .",
								HttpStatus.ACCEPTED);
					}

				} else {
					return new ResponseEntity<>("All details are Can not be Null .", HttpStatus.ACCEPTED);
				}
			} else {
				return new ResponseEntity<>(
						"Mobile no can not be more than 10 digit ------ OR. ------  both password are not macthed..",
						HttpStatus.ACCEPTED);
			}

		} catch (Exception e) {
			System.out.println("Exception :" + e.getMessage());
		}

		return new ResponseEntity<>("password update successfully...", HttpStatus.ACCEPTED);
	}

	@PostMapping(UriMapping.SIGN_IN)
	public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

		System.out.println("authentication-- " + authentication);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	}

}
