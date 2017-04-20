package com.pppcar.spring.boot.pojo;

import java.io.Serializable;

public class Author implements Serializable {

	private static final long serialVersionUID = 5414101611095230705L;

	private Long id;

	private String realName;

	private String nickName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Author(Long id, String realName, String nickName) {
		super();
		this.id = id;
		this.realName = realName;
		this.nickName = nickName;
	}
	public Author() {
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", realName=" + realName + ", nickName=" + nickName + "]";
	}

}
