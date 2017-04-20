package com.pppcar.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class ApplicationDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationDemo.class, args);
		for (String string : applicationContext.getBeanDefinitionNames()) {
			System.out.println(string);
		}
	}
}
