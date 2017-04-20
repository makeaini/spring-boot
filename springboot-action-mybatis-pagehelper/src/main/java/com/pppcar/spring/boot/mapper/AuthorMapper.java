package com.pppcar.spring.boot.mapper;

import java.util.List;

import com.pppcar.spring.boot.pojo.Author;
public interface AuthorMapper {
    Author selectById(Long id);
    List<Author> selectAllPageList();
}
