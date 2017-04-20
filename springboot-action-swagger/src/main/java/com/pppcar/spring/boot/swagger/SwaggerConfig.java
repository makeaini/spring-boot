package com.pppcar.spring.boot.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket demoApi() {
		 return new Docket(DocumentationType.SWAGGER_2)  
	                .apiInfo(apiInfo())  
	                .select()  
	                .apis(RequestHandlerSelectors.basePackage("com.pppcar.spring.boot.controller"))  
	                .paths(PathSelectors.any())  
	                .build();  
	}


	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Demo相关接口", // 大标题
				"Demo相关接口，获取个数，获取列表，注意：", // 小标题
				"1.0", // 版本
				"http://412887952-qq-com.iteye.com/", "Angel", // 作者
				"北京知远信息科技有限公司", // 链接显示文字
				"http://www.kfit.com.cn/"// 网站链接
		);
	/*	ApiInfo apiInfo =new ApiInfoBuilder().title("SpringMVC中使用Swagger2构建RESTful APIs")
				.termsOfServiceUrl("http://")
				.description("这是一个Swagger2测试")
				.version("1.0.0").build();*/
		return apiInfo;
	}

}
