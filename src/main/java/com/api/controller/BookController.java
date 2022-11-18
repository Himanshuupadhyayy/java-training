package com.api.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.dao.BookRepository;
import com.api.model.Book;


@RestController
public class BookController {

	@Autowired
	private BookRepository repository;
	
	@PostMapping("/book")
	public Book saveBook(@Valid @RequestBody Book book) {
		this.repository.save(book);
		return book;
	}
}