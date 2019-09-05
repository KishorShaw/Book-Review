package com.example.JsonInsert;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDetails, String> {

	List<BookDetails> findByTitle(String title);

}
