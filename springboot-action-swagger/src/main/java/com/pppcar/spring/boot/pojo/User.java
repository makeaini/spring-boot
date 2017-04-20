package com.pppcar.spring.boot.pojo;

import io.swagger.annotations.ApiModelProperty;

public class User {
	@ApiModelProperty(value = "id", required = true)
	private Long id;
	@ApiModelProperty(value = "用户名", required = true)
	private String name;
	@ApiModelProperty(value = "年龄",required = true)
	private Integer age;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User() {
	}

	public User(Long id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

}
