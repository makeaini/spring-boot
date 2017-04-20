package com.pppcar.spring.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pppcar.spring.boot.pojo.User;
import com.pppcar.spring.boot.service.UserServiceI;

@RestController
@RequestMapping("/users")
public class TestController {
	@Autowired
	private User user;
	@Autowired
	private UserServiceI userServiceI;
    List<User> users= new ArrayList<User>();
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> r = new ArrayList<User>(users);
		r.add(user);
		System.out.println(users);
		userServiceI.send();
		return r;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postUser(@RequestBody User user) {
		users.add(user);
		return "success";
	}
	/*
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return users.get(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@RequestBody User user) {
		User u = users.get(user.getId());
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(user.getId(),u);
		return "success";
	}
**/
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)  
    public String deleteUser(@PathVariable int id) {  
        users.remove(id);  
        return "success";  
    }
}
