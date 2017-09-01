package com.spring.boot.rabbit.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shining on 2017-09-01.
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender() {
        String context = "hi, i am messages 1";
        rabbitTemplate.convertAndSend("fanoutExchange", "", context);
    }

}
