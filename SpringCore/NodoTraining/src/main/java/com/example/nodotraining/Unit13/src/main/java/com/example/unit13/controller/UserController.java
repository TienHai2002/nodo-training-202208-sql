package com.example.unit13.controller;

import com.example.unit13.model.Message;
import com.example.unit13.model.User;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class UserController {
    @MessageMapping("/user")
    @SendTo("/topic/chat")
    public Message add(User user) {
        System.out.println("user: " + user.getUsername() + "-email " + user.getEmail());
        return new Message(user.getUsername());
    }
}
