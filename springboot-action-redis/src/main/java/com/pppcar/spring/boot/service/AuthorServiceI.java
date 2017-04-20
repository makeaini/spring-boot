package com.pppcar.spring.boot.service;

import java.util.List;

import com.pppcar.spring.boot.pojo.Author;

public interface AuthorServiceI {

	List<Author> findAll();

	Author findAuthor(Long id);
	
	Author findOne(String key);
	
	void delete(Long id);

}
