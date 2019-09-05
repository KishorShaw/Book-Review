package com.example.JsonInsert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class JsonInsertApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(JsonInsertApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<BookDetails>> book = new TypeReference<List<BookDetails>>() {
		};
		InputStream str = TypeReference.class.getResourceAsStream("/test.json");
		try {
			List<BookDetails> bookList = mapper.readValue(str, book);
			bookRepo.saveAll(bookList);
			System.out.println("Books list saved successfully");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
