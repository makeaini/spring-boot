package com.pppcar.spring.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pppcar.spring.boot.mapper")
public class Application {
	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(Application.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
		/*
		 * for (String string : applicationContext.getBeanDefinitionNames()) {
		 * System.out.println(string); }
		 */
	}
}
