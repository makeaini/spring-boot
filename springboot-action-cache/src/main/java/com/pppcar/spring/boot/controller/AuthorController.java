package com.pppcar.spring.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pppcar.spring.boot.pojo.Author;
import com.pppcar.spring.boot.service.AuthorServiceI;

@RestController
public class AuthorController {
	// ：后面表示如果前面值为null就用后面的值
	@Value("${application.hello:fjkfkdfk}")
	private String hello;
	@Autowired
	private AuthorServiceI authorServiceI;

	@RequestMapping("/test")
	public String test() throws Exception {
		Long id = 4L;
		Author author=new Author();
		author.setNickName("save nickname");
		author.setRealName("save realname");
		authorServiceI.saveAuthor(author);
		Author loaded = authorServiceI.findAuthor(id);
		System.out.println("loaded=" + loaded);
		Author cached = authorServiceI.findAuthor(id);
		System.out.println("cached=" + cached);
		Optional<Author> optional =Optional.of(author);
		authorServiceI.updateAuthor(optional);
		Author update = authorServiceI.findAuthor(id);
		System.out.println("update=" + update);
		authorServiceI.delete(id);
		Author deleteCached = authorServiceI.findAuthor(id);
		System.out.println("cached=" + deleteCached);
		return "ok";
	}

}
