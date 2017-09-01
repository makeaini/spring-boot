package com.spring.boot.rabbit.obj;

import com.spring.boot.rabbit.pojo.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by shining on 2017-09-01.
 */
@RabbitListener(queues = "user")
@Component
public class ReceiverObj {
    @RabbitHandler
    public void process(User user) {
        System.out.println("Receiver object : " + user);
    }
}
