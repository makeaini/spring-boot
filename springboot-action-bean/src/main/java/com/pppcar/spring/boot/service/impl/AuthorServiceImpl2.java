package com.pppcar.spring.boot.service.impl;

import com.pppcar.spring.boot.service.AuthorServiceI;

public class AuthorServiceImpl2 implements AuthorServiceI {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void display() {
		System.out.println(name);
		System.out.println("AuthorServiceImpl2");
	}

}
