package com.lib.mana.validation;

import com.lib.mana.dto.BookDto;

public class BookValidation {
	
	public static String getResponseMessage(BookDto bookDto) {
		String message = "Below Fileds Can Not Be Null.";
		if (bookDto.getBookName().isEmpty()) {
			message = message.concat("\n-Book Name");
		}
		if (bookDto.getBookTypes().isEmpty()) {
			message = message.concat("\n-Book Type");
		}
		if (bookDto.getPrice()==0) {
			message = message.concat("\n-Price");
		}
		if (bookDto.getPubliserName().isEmpty()) {
			message = message.concat("\n-Publisher Name");
		}
		if (bookDto.getSellerName().isEmpty()) {
			message = message.concat("\n-Seller Name");
		}
	
		return message;
	}


}
