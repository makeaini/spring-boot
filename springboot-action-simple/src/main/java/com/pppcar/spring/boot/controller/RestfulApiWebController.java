package com.pppcar.spring.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestfulApiWebController {
	@RequestMapping("/")
	String home(String name) {
		return "Hello World!";
	}
	@RequestMapping("/a")
	String home1(String name) {
		throw new NullPointerException();
	}

}
