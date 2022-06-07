package com.lib.mana.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.mana.dto.BookDto;
import com.lib.mana.entity.BookEntity;
import com.lib.mana.entity.PublisherEntity;
import com.lib.mana.entity.SellerEntity;
import com.lib.mana.reposistory.BookReposistory;
import com.lib.mana.reposistory.PublisherReposistory;
import com.lib.mana.reposistory.SellerReposistory;
import com.lib.mana.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookReposistory bookReposistory;
	@Autowired
	PublisherReposistory publisherReposistory;
	
	@Autowired
	SellerReposistory sellerReposistory;
	
	@Override
	public BookEntity saveBookDetails(BookDto bookDto) {
		BookEntity bookEntity= new BookEntity();
		PublisherEntity publisherEntity = new PublisherEntity();
		SellerEntity sellerEntity = new SellerEntity();
		publisherEntity.setPubliserName(bookDto.getPubliserName());
		sellerEntity.setSellerName(bookDto.getSellerName());
		bookEntity.setBookName(bookDto.getBookName());
		bookEntity.setBookTypes(bookDto.getBookTypes());
		bookEntity.setPrice(bookDto.getPrice());
		publisherReposistory.save(publisherEntity);
		sellerReposistory.save(sellerEntity);
		bookEntity.setSeller(sellerEntity);
		bookEntity.setPublisher(publisherEntity);
		bookReposistory.save(bookEntity);
		
		return bookEntity;
	}

}
