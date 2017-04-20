package com.pppcar.spring.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class TestController {
	private static final Logger LOG=LoggerFactory.getLogger(TestController.class);
	@RequestMapping(method = RequestMethod.GET)
	public void test(){
		LOG.info("info");
		LOG.error("error");
		LOG.debug("debug");
		LOG.trace("trace");
	}
	
}
