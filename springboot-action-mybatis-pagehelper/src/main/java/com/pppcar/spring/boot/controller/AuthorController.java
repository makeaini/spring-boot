package com.pppcar.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.pppcar.spring.boot.pojo.Author;
import com.pppcar.spring.boot.service.AuthorServiceI;

@RestController
public class AuthorController {
	@Autowired
	private AuthorServiceI authorServiceI;

	@GetMapping("/test")
	public PageInfo<Author> selectPage(Integer pageNum, Integer pageSize) {
		return authorServiceI.findPageList(pageNum, pageSize);
	}

}
