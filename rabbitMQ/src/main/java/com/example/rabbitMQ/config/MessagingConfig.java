package com.example.rabbitMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public Queue queue(){
        return new Queue("message_queue");
    }

    public TopicExchange exchange(){
        return new TopicExchange("message_queue");
    }

    public Binding binding(Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("message_routingKey");
    }
}
