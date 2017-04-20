package com.pppcar.spring.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
public class ControllerAdviceTest {

	@ExceptionHandler(NumberFormatException.class)
	public String processClassCastException(NumberFormatException e) {
		System.out.println(e.getMessage());
		return null;
	}

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String processUnauthenticatedException(NullPointerException e) {
		System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行");
		return null;
	}
}