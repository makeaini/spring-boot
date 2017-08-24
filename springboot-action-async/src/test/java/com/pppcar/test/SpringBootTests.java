package com.pppcar.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pppcar.spring.boot.Application;
import com.pppcar.spring.boot.controller.Task;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class SpringBootTests {
	@Autowired
	private Task task;
	@Test
	public void a() throws Exception{
		task.doTaskThree();
		Thread.sleep(100000);
	}

}
