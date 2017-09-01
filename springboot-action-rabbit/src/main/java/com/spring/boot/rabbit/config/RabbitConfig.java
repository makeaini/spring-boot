package com.spring.boot.rabbit.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by shining on 2017-09-01.
 */
@Configuration
public class RabbitConfig {
//    @Bean
//    public Queue helloQueue() {
//        return new Queue("hello");
//    }
    @Bean
    public Queue Queue() {
        return new Queue("user");
    }

}
