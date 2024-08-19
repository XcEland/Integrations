package com.example.emailConsumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.emailConsumer.config.MessagingConfig;
import com.example.emailConsumer.dto.Email;

@Service
public class EmailService {
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void recieveMessage(Email email){
        
        System.out.println("Received Email: "+ email.toString());

        System.out.println("Email Sent");

    }
}
