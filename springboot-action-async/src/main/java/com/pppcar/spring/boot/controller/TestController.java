package com.pppcar.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class TestController {
	@Autowired
	private Task task;

	@RequestMapping("/task")
	public String task2() throws Exception {
		task.doTaskOne();
		task.doTaskTwo();
		task.doTaskThree();
		return "task";
	}

}
