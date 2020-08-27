package com.geekbrains.book.store.controllers;

import com.geekbrains.book.store.entities.Order;
import com.geekbrains.book.store.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class SimpleMessageReceiver {
    private RabbitTemplate rabbitTemplate;
    private OrderService orderService;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void receiveMessage(byte[] message) {
        System.out.println(new String(message));
        Optional<Order> order = orderService.getById(Long.parseLong(new String(message)));
        if(order.isPresent()){
            Order order1 = order.get();
            order1.setIsready(true);
            orderService.saveOrder(order1);
        }
        System.out.println("Finish order <" + new String(message) + ">");
    }
}