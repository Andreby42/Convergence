package com.convergence.mq.rabbit;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.convergence.support.util.SnowFlake;

@Component
public class RabbitPublisher {

    @Resource
    private RabbitTemplate rabbitTemplate;


    /**
     * A callback for publisher confirmations.
     */
    final ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.err.println("correlationData: " + correlationData);
            System.err.println("ack: " + ack);
            if (!ack) {
                System.err.println("异常处理....");
            }
        }
    };
    /**
     * A callback for returned messages
     */
    final ReturnCallback returnCallback = new RabbitTemplate.ReturnCallback() {

        @Override
        public void returnedMessage(org.springframework.amqp.core.Message message, int replyCode, String replyText, String exchange, String routingKey) {
            System.err.println("return exchange: " + exchange + ", routingKey: " + routingKey + ", replyCode: " + replyCode + ", replyText: " + replyText);
        }
    };

    /**
     * 
     * @doc:构建消息,发送消息
     * @author Andreby
     * @param <T>
     * @param <T>
     * @date 2018年8月10日 下午4:12:30
     * @param message
     * @param headers
     */
    public <T> void publish(T message, Map<String, Object> headers) {
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        Message<T> msg = MessageBuilder.createMessage(message, messageHeaders);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback); // id + 时间戳 全局唯一 CorrelationData
        CorrelationData correlationData = new CorrelationData(SnowFlake.getId());
        rabbitTemplate.convertAndSend("skyeye-exchange", "sky-eye-key", msg, correlationData);
    }


}
