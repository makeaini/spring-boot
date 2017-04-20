package com.pppcar.spring.boot.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.pppcar.spring.boot.service.UserServiceI;
@Service
@Profile("dev")
public class UserServiceImpl2 implements UserServiceI{

	@Override
	public void send() {
		System.out.println("dev开发环境");
	}

}
