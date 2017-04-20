package com.pppcar.spring.boot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pppcar.spring.boot.pojo.Author;

@Repository
public class AuthorDaoImpl implements AuthorDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int add(Author author) {
	return jdbcTemplate.update("insert into t_author(real_name, nick_name) values(?, ?)", author.getRealName(),
				author.getNickName());
	}

	@Override
	public int update(Author author) {
		return jdbcTemplate.update("update t_author set real_name = ?, nick_name = ? where id = ?",
				new Object[] { author.getRealName(), author.getNickName(), author.getId() });
	}

	@Override
	public int delete(Long id) {
		/*return jdbcTemplate.update("delete from t_author where id = ?", id);*/
		return 0;
	}

	@Override
	public Author findAuthor(Long id) {
		List<Author> list = jdbcTemplate.query("select * from t_author where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<Author>(Author.class));
		if (null != list && list.size() > 0) {
			Author auhtor = list.get(0);
			return auhtor;
		} else {
			return null;
		}
	}

	@Override
	public List<Author> findAuthorList() {
		List<Author> list = jdbcTemplate.query("select * from t_author", new Object[] {},
				new BeanPropertyRowMapper<Author>(Author.class));
		return list;
	}
}