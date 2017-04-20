package com.pppcar.spring.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pppcar.spring.boot.pojo.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class TestController {
	static Map<Long, User> users =  new HashMap<Long,User>();
    static{
    	for (int i = 0; i < 10; i++) {
    		User u = new User();
    		u.setAge(12);
    		u.setId(Long.valueOf(i));
    		u.setName("222");
    		users.put(Long.valueOf(i), u );
		}
    }

	@ApiOperation(value = "获取用户列表", notes = "获取用户列表")
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public List<User> getUserList() {
		List<User> r = new ArrayList<User>(users.values());
		return r;
	}

	@ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String postUser(@RequestBody User user) {
		users.put(user.getId(), user);
		return "success";
	}

	@ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		return users.get(id);
	}

	@ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
	@ApiImplicitParams({@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")})
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@RequestBody User user) {
		User u = users.get(user.getId());
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(user.getId(),u);
		return "success";
	}

	@ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
	@ApiImplicitParams({	
	@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "String", paramType = "path"),
	@ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String", paramType = "path")})
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)  
    public String deleteUser(@PathVariable Long id) {  
        users.remove(id);  
        return "success";  
    }
}
