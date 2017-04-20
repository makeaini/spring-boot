package com.pppcar.spring.boot.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.pppcar.spring.boot.service.UserServiceI;
@Service
@Profile("prod")
public class UserServiceImpl implements UserServiceI{

	@Override
	public void send() {
		System.out.println("prod生产环境");
	}

}
