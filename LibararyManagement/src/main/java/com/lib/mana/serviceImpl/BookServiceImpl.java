package com.lib.mana.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.mana.dto.BookDto;
import com.lib.mana.entity.BookEntity;
import com.lib.mana.reposistory.BookReposistory;
import com.lib.mana.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookReposistory bookReposistory;
	@Override
	public BookEntity saveBookDetails(BookDto bookDto) {
		BookEntity bookEntity= new BookEntity();
		bookEntity.setBookName(bookDto.getBookName());
		bookEntity.setBookTypes(bookDto.getBookTypes());
		bookEntity.setPubliserName(bookDto.getPubliserName());
		bookEntity.setSellerName(bookDto.getSellerName());
		bookEntity.setPrice(bookDto.getPrice());
		// TODO Auto-generated method stub
		bookReposistory.save(bookEntity);
		return bookEntity;
	}

}
