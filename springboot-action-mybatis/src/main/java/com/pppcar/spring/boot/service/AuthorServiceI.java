package com.pppcar.spring.boot.service;

import com.github.pagehelper.PageInfo;
import com.pppcar.spring.boot.pojo.Author;

public interface AuthorServiceI {

	Author findById(Long userId);
	
	PageInfo<Author> findPageList(int pageNum,int pageSize);

	

}
