package com.example.JsonInsert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookRepoService bookRepo;

	@GetMapping(value = "/get", produces = "application/json")

	public String getDetails() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();

		String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookRepo.getAllBooks());
		if (result.contentEquals("[ ]"))
			return ("[{\"Data\" : \"No Details Found\"}]");
		return result;

	}

	@GetMapping(value = "/getBook", produces = "application/json")
	public String getDetailsByTitle(@RequestParam String title) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();

		String result = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(bookRepo.getBookDetailsbyTitle(title));

		if (result.contentEquals("[ ]"))
			return ("[{\"Data\" : \"No Details Found\"}]");
		return result;

	}

}
