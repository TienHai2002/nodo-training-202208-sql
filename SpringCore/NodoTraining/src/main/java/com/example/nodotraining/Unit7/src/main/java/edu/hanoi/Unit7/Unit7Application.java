package edu.hanoi.Unit7;

import org.apache.catalina.startup.ContextConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:config.xml")
public class Unit7Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) SpringApplication.run(Unit7Application.class, args);
        ctx.start();
    }

}
