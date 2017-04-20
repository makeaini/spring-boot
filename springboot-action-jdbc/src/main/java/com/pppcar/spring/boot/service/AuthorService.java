package com.pppcar.spring.boot.service;

import java.util.List;

import com.pppcar.spring.boot.pojo.Author;

public interface AuthorService {
	int add(Author author);

	int update(Author author);

	int delete(Long id);

	Author findAuthor(Long id);

	List<Author> findAuthorList();
}
