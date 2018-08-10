package com.convergence.mq.rabbit;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;


@Component
public class RabbitConsumer {

    @RabbitListener(
            //declare queue binding
            bindings = @QueueBinding(value = @Queue(value = "skyeye-queue", durable = "false"),
            //declare exchange
            exchange = @Exchange(name = "skyeye-exchange", durable = "false", type = "direct", ignoreDeclarationExceptions = "true"),
            //routing key
            key = "sky-eye-key"))
    @RabbitHandler
    public <T> void handle(Message<T> message, Channel channel) {
        System.err.println("消费端Payload: " + message.getPayload());
        Long deliveryTag = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        try {
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("something is wrong with it");
        }

    }


}
