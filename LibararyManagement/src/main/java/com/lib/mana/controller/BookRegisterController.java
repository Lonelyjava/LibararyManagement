package com.lib.mana.controller;

/*Author : Kundan Kumar
 * 
 * 
 * 
 * 
 * 
 * 
 * */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.mana.dto.BookDto;
import com.lib.mana.entity.BookEntity;
import com.lib.mana.response.ApiResponse;
import com.lib.mana.service.BookService;
import com.lib.mana.utils.UriMapping;
import com.lib.mana.validation.BookValidation;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(UriMapping.BASE_URI)
@Api(value = "/libmgnt", tags = "Library Management")
public class BookRegisterController {

	Logger logger = LoggerFactory.getLogger(BookRegisterController.class);

	@Autowired
	BookService bookService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping(UriMapping.BOOK_REGISTER)
	public ResponseEntity<?> bookRegister(@RequestBody BookDto bookDto) {
		ApiResponse response = new ApiResponse();
		if (!bookDto.getBookName().isEmpty() && !bookDto.getBookTypes().isEmpty() && bookDto.getPrice() != 0
				&& !bookDto.getPubliserName().isEmpty() && !bookDto.getSellerName().isEmpty()) {
			try {
				BookEntity userDtoRes = bookService.saveBookDetails(bookDto);
				response.setMessage("REGISTER SUCCESSFULLY.");
				response.setStatusCode(200);
				response.setError(false);
				response.setData(userDtoRes);

			} catch (Exception e) {
				logger.info("Message : " + e.getMessage());
			}
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			String messages = BookValidation.getResponseMessage(bookDto);
			return new ResponseEntity<>(messages, HttpStatus.OK);
		}
	}

	@GetMapping(UriMapping.FIND_ALL)
	public ResponseEntity<?> getAllbook(@RequestBody BookDto bookDto) {

		ApiResponse response = new ApiResponse();
		try {

			BookEntity userDtoRes = bookService.saveBookDetails(bookDto);
			response.setMessage("USER SAVED SUCCESSFULLY.");
			response.setStatusCode(200);
			response.setError(false);
			response.setData(userDtoRes);
		} catch (Exception e) {
			logger.info("Message : " + e.getMessage());
		}

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@PutMapping(UriMapping.UPDATE_BOOK)
	public ResponseEntity<?> updateBook(@RequestBody BookDto bookDto) {

		ApiResponse response = new ApiResponse();
		try {

			BookEntity userDtoRes = bookService.saveBookDetails(bookDto);
			response.setMessage("USER SAVED SUCCESSFULLY.");
			response.setStatusCode(200);
			response.setError(false);
			response.setData(userDtoRes);
		} catch (Exception e) {
			logger.info("Message : " + e.getMessage());
		}

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(UriMapping.DELETE_BOOK)
	public ResponseEntity<?> deleteBook(@RequestBody BookDto bookDto) {

		ApiResponse response = new ApiResponse();
		try {

			BookEntity userDtoRes = bookService.saveBookDetails(bookDto);
			response.setMessage("USER SAVED SUCCESSFULLY.");
			response.setStatusCode(200);
			response.setError(false);
			response.setData(userDtoRes);
		} catch (Exception e) {
			logger.info("Message : " + e.getMessage());
		}

		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@GetMapping(UriMapping.SEARCH_BOOK)
	public ResponseEntity<?> searchBook(@RequestBody BookDto bookDto) {

		ApiResponse response = new ApiResponse();
		try {

			BookEntity userDtoRes = bookService.saveBookDetails(bookDto);
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
