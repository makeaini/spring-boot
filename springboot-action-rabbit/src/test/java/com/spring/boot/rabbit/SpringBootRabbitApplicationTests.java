package com.spring.boot.rabbit;

import com.spring.boot.rabbit.fanout.FanoutSender;
import com.spring.boot.rabbit.obj.SenderObj;
import com.spring.boot.rabbit.pojo.User;
import com.spring.boot.rabbit.sender.Sender;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitApplicationTests {

	@Autowired
	private SenderObj senderObj;
	@Autowired
	private Sender sender;
	@Autowired
	private FanoutSender fanoutSender;


	@Test
	@Ignore
	public void sendObj() throws Exception {
			User user = new User();
			user.setId(1);
			user.setName("name");
			senderObj.sendObj(user);
	}
	@Test
	@Ignore
	public  void sender(){
		sender.send2();
		//sender.send3();
	}
	@Test
	public  void senderFanout(){
		fanoutSender.sender();
	}

}
