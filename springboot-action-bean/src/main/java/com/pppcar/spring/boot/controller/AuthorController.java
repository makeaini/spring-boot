package com.pppcar.spring.boot.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pppcar.spring.boot.service.AuthorServiceI;

@RestController
public class AuthorController {
	@Autowired
	@Qualifier(value="authorServiceI")
	private AuthorServiceI authorServiceI;
	@Resource(name = "authorServiceI2")
	private AuthorServiceI authorServiceI2;
	@RequestMapping("/test")
	public String test() {
		authorServiceI.display();
		authorServiceI2.display();
		return "ok";
	}

}
