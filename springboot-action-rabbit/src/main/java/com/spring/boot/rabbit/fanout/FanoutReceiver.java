package com.spring.boot.rabbit.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by shining on 2017-09-01.
 */
@Component
public class FanoutReceiver {
    private static final Logger logger = LoggerFactory.getLogger(FanoutReceiver.class);
    // 接收者A
    @RabbitListener(queues = "fanout.a")
    public void process(String message) {
        logger.info(String.format("receive fanout a message: %s", message));
    }
    // 接收者B
    @RabbitListener(queues = "fanout.b")
    public void process1(String message) {
        logger.info(String.format("receive fanout b message: %s", message));
    }
    // 接收者C
    @RabbitListener(queues = "fanout.c")
    public void process2(String message) {
        logger.info(String.format("receive fanout c message: %s", message));
    }

}
