package com.pppcar.spring.boot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pppcar.spring.boot.dao.AuthorRepository;
import com.pppcar.spring.boot.pojo.Author;
import com.pppcar.spring.boot.service.AuthorServiceI;

@Service
public class AuthorServiceImpl implements AuthorServiceI {
	public static final String DEMO_CACHE_NAME = "author";
	public static final String CACHE_KEY = "'demoInfo'";
	@Autowired
	private AuthorRepository authorRepository;

	@Override
	public List<Author> findAll() {
		return this.authorRepository.findAll();
	}

	@Cacheable(value = DEMO_CACHE_NAME, key = CACHE_KEY+"+#id") // 缓存,这里没有指定key.
	@Override
	public Author findAuthor(Long id) {
		System.err.println("authorRepository.findAuthor()=========从数据库中进行获取的....id=" + id);
		return this.authorRepository.findAuthor(id);
	}

	@CacheEvict(value = DEMO_CACHE_NAME, key = CACHE_KEY+"+#id")
	@Override
	public void delete(Long id) {
		System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
		this.authorRepository.delete(id);
	}
	@CacheEvict(value = DEMO_CACHE_NAME,key = CACHE_KEY+"+#author.getId()")
	@Override
	public void saveAuthor(Author author) {
		this.authorRepository.save(author);
	}
	@CachePut(value = DEMO_CACHE_NAME,key = CACHE_KEY+"+#id")
	@Override
	public void updateAuthor(Optional<Author> author) throws Exception {
		Author author2 = author.get(); 
		author = this.authorRepository.findOne(author2.getId());
		if (author == null) {
			throw new Exception("没有当前对却");
		}
		author2.setNickName("update");
		author2.setRealName("realname update");
		this.authorRepository.save(author2);

	}
}
