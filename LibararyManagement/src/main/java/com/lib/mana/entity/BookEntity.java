package com.lib.mana.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book_register")
public class BookEntity extends BaseEntity {

	private String bookName;
	private int price;
	private String publiserName;
	private String sellerName;
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

	public String getPubliserName() {
		return publiserName;
	}

	public void setPubliserName(String publiserName) {
		this.publiserName = publiserName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getBookTypes() {
		return bookTypes;
	}

	public void setBookTypes(String bookTypes) {
		this.bookTypes = bookTypes;
	}

}
