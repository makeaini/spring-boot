package com.spring.boot.rabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * Created by shining on 2017-09-01.
 */
@Component
@RabbitListener(queues = "topic.message")
public class Receiver {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1 : " + hello);
    }
}
