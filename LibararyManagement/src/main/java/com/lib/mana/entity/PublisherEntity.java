package com.lib.mana.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="publisher")
public class PublisherEntity extends BaseEntity {
	
	private String publiserName;
	
	@OneToOne(mappedBy = "publisher")
	private BookEntity book;
	
	

	public BookEntity getBook() {
		return book;
	}

	public void setBook(BookEntity book) {
		this.book = book;
	}

	public String getPubliserName() {
		return publiserName;
	}

	public void setPubliserName(String publiserName) {
		this.publiserName = publiserName;
	}
	
	

}
