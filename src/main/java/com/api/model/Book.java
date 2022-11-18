package com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
public class Book {


	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@GenericGenerator(name="book_seq",
	strategy = "com.api.model.StringPrefixSequenceGenerator",
	parameters = {
			@Parameter(name=StringPrefixSequenceGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name=StringPrefixSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "Book_"),
			@Parameter(name=StringPrefixSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%1d")
	})
	@Id
	@Column(name = "bid")	
	private String bid;
 
    @Column(name = "title")
    private String title;

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}