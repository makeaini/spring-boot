package com.pppcar.spring.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pppcar.spring.boot.mapper.AuthorMapper;
import com.pppcar.spring.boot.pojo.Author;
import com.pppcar.spring.boot.service.AuthorServiceI;

@Service
public class AuthorServiceImpl implements AuthorServiceI {
	@Autowired
	private AuthorMapper authorMapper;

	@Override
	public Author findById(Long userId) {
		return authorMapper.selectById(userId);
	}

	@Override
	public PageInfo<Author> findPageList(int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Author> list = authorMapper.selectAllPageList();
		PageInfo<Author> pageInfo = new PageInfo<Author>(list);
		return pageInfo;
	}

}
