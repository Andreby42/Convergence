package com.convergence.mq.rabbit;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class TestRabbitMq {

    @Resource
    private RabbitPublisher rabbitPublisher;
    
    public void sendMsgTest(){
        rabbitPublisher.publish("Hello Rabbit"+UUID.randomUUID(), null);
    }
}
