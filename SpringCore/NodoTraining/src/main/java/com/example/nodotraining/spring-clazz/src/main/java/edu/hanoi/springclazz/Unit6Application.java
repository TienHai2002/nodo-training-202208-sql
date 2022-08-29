package edu.hanoi.springclazz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication

public class Unit6Application {

	public static void main(String[] args) {
		SpringApplication.run(Unit6Application.class, args);
		System.out.println("hello");
	}

}
