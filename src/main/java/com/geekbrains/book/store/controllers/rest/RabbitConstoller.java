package com.geekbrains.book.store.controllers.rest;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitConstoller {
    public static final String EXCHANGE_FOR_PROCESSING_TASK = "processingExchanger";

    private RabbitTemplate rabbitTemplate;


    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/{message}")
    public String sendMessage(@PathVariable String message) {
        rabbitTemplate.convertAndSend(RabbitConstoller.EXCHANGE_FOR_PROCESSING_TASK, null, "Task from Server: " + message);
        return "OK";
    }

}
