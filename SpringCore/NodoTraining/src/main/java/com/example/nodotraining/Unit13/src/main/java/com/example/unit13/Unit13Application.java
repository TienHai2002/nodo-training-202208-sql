package com.example.unit13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.unit13","com.example.unit13.controller"})
public class Unit13Application {

    public static void main(String[] args) {
        SpringApplication.run(Unit13Application.class, args);
    }

}
