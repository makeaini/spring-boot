package com.pppcar.spring.boot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	//：后面表示如果前面值为null就用后面的值 
	@Value("${application.hello:fjkfkdfk}")
	private String hello;

	@RequestMapping("/a")
	public String home(Map<String, Object> map) {
		System.out.println(hello);
		map.put("hello", hello);
		return "hello";
	}

}
