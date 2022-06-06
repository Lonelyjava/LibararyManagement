package com.lib.mana.service;

import com.lib.mana.dto.BookDto;
import com.lib.mana.entity.BookEntity;

public interface BookService {

	
	public BookEntity saveBookDetails(BookDto bookDto);
}
