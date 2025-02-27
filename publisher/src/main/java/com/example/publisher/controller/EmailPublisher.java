package com.example.publisher.controller;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.publisher.config.MessagingConfig;
import com.example.publisher.dto.Email;
import com.example.publisher.dto.EmailStatus;


@RestController
@RequestMapping("/email")
public class EmailPublisher {
    
    @Autowired
    private RabbitTemplate template; 
    
    @PostMapping("/{departmentName}")
    public String bookOrder(@RequestBody Email email, @PathVariable String departmentName){
        email.setEmailId(UUID.randomUUID().toString());
        EmailStatus orderStatus = new EmailStatus(email, "PROGRESS","Email placed successfully"+departmentName);
        template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTING_KEY,orderStatus);
        return  "Success!";
    }
}

