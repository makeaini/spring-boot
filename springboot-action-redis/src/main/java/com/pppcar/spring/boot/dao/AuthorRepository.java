package com.pppcar.spring.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pppcar.spring.boot.pojo.Author;
@Repository
public interface AuthorRepository extends CrudRepository<Author,Long> {
	List<Author> findAll();
    @Query("from Author where id = :id")
    Author findAuthor(@Param("id") Long id);
}
