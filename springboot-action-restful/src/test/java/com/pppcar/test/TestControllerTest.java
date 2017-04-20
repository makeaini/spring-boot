package com.pppcar.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alibaba.fastjson.JSON;
import com.pppcar.spring.boot.Application;
import com.pppcar.spring.boot.controller.TestController;
import com.pppcar.spring.boot.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TestControllerTest {
	private MockMvc mvc;
	@Before
	public void setup(){
		mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
	}
	@Test
	@Ignore
	public void testGetController() throws Exception{
		RequestBuilder request = null;
		request = MockMvcRequestBuilders.get("/users");
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("[]"));
	}
	@Test
	public void testPostController() {
		try {
			RequestBuilder request = null;
			User user = new User(1L,"aljd",11);
			String content = JSON.toJSONString(user);
			request = MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).
					content(content);
			mvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("success"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}

}
