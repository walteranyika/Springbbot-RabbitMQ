package com.walter.rabitmqdemo.controllers;

import com.walter.rabitmqdemo.models.User;
import com.walter.rabitmqdemo.services.RabbitMqSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ProducerController {
    private RabbitMqSender rabbitMqSender;

    @Value("${app.message}")
    private String message;

    public ProducerController(RabbitMqSender rabbitMqSender) {
        this.rabbitMqSender = rabbitMqSender;
    }

    @PostMapping("user")
    public String addUser(@RequestBody User user){
        rabbitMqSender.send(user);
        return  message;
    }
}
