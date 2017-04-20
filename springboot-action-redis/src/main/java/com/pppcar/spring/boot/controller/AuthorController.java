package com.pppcar.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pppcar.spring.boot.pojo.Author;
import com.pppcar.spring.boot.service.AuthorServiceI;

@RestController
public class AuthorController {
	// ：后面表示如果前面值为null就用后面的值
	@Value("${application.hello:fjkfkdfk}")
	private String hello;
	@Autowired
	private AuthorServiceI authorServiceI;

	@RequestMapping("/test")
	public String test() {
		Author loaded = authorServiceI.findAuthor(1L);
		System.out.println("loaded=" + loaded);
		Author cached = authorServiceI.findAuthor(1L);
		System.out.println("cached=" + cached);
		/*loaded = authorServiceI.findAuthor(2L);
		System.out.println("loaded2=" + loaded);*/
		return "ok";
	}

	@RequestMapping("/delete")
	public String delete(long id) {
		authorServiceI.delete(id);
		return "ok";
	}
}
