package com.pppcar.spring.boot.service;

import java.util.List;
import java.util.Optional;

import com.pppcar.spring.boot.pojo.Author;

public interface AuthorServiceI {

	List<Author> findAll();
	
	void saveAuthor(Author author);
	
	Author findAuthor(Long id);
	
	void delete(Long id);

	void updateAuthor(Optional<Author> author) throws Exception;

}
