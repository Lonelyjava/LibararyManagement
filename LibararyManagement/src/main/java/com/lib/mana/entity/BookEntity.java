package com.lib.mana.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_register")
public class BookEntity extends BaseEntity {

	private String bookName;
	private int price;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seller_id")
	private SellerEntity seller;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "publisher_id")
	private PublisherEntity publisher;
	
	private String bookTypes;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	

	public SellerEntity getSeller() {
		return seller;
	}

	public void setSeller(SellerEntity seller) {
		this.seller = seller;
	}

	public PublisherEntity getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherEntity publisher) {
		this.publisher = publisher;
	}

	public String getBookTypes() {
		return bookTypes;
	}

	public void setBookTypes(String bookTypes) {
		this.bookTypes = bookTypes;
	}

}
