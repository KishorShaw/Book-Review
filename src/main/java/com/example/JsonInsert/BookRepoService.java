package com.example.JsonInsert;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRepoService {

	@Autowired
	private BookRepository bookRepo;

	public List<BookDetails> getAllBooks() {

		return bookRepo.findAll();
	}

	public List<BookDetails> getBookDetailsbyTitle(String title) {

		return bookRepo.findByTitle(title);
	}

}
