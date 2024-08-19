package com.example.rabbitMQ.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitMQ.config.MessagingConfig;
import com.example.rabbitMQ.dto.OrderStatus;

@Component
public class User {
    
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void cnsumeMessageFromQueue(OrderStatus orderStatus){
        System.out.println("Message received from Queue: "+ orderStatus);
    }
}
