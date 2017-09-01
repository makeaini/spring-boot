package com.spring.boot.rabbit.obj;

import com.spring.boot.rabbit.pojo.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shining on 2017-09-01.
 */
@Component
public class SenderObj {
    @Autowired
    private AmqpTemplate amqpTemplate;
    public void sendObj(User user){
        System.out.println("sender:"+user);
        amqpTemplate.convertAndSend("user",user);
    }
}
