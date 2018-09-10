package com.convergence.mq.rabbit;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class TestRabbitMq {

    @Resource
    private RabbitPublisher rabbitPublisher;
    
//    @PostConstruct
    public void sendMsgTest(){
        rabbitPublisher.publish("Hello Rabbit", null);
        
    }
}
