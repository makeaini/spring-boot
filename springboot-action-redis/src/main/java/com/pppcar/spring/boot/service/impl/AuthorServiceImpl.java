package com.pppcar.spring.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.pppcar.spring.boot.dao.AuthorRepository;
import com.pppcar.spring.boot.pojo.Author;
import com.pppcar.spring.boot.service.AuthorServiceI;

@Service
public class AuthorServiceImpl implements AuthorServiceI {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Override
	public List<Author> findAll() {
		return this.authorRepository.findAll();
	}

	@Cacheable(value = "demoInfo",key = "#id + 'findById'") // 缓存,这里没有指定key.
	@Override
	public Author findAuthor(Long id) {
		System.err.println("authorRepository.findAuthor()=========从数据库中进行获取的....id=" + id);
		return this.authorRepository.findAuthor(id);
	}

	@Override
	public Author findOne(Long key) {
		ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
		Author author = new Author(100L, "realName", "nickName");
		valueOperations.set(key.toString(), author);
		return (Author) valueOperations.get(key.toString());
	}

	@CacheEvict(value = "demoInfo",key="#id + 'findById'")
	@Override
	public void delete(Long id) {
		System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
	}
}
