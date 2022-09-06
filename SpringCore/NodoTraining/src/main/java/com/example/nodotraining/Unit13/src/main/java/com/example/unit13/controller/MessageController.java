package com.example.unit13.controller;

import com.example.unit13.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/chat")
    public Message say(Message message, Principal principal){
        return new Message(principal.getName()+ " : "+message.getContent()+"!");
    }
}
