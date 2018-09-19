package com.convergence.mq.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component("customKafkaConsumer")
public class CustomKafkaConsumer {
    @KafkaListener(id = "gs1-1", topics = {"test"})
    public void listen(String data) {
        System.out.println("SimpleConsumer收到消息：" + data);
    }
}
