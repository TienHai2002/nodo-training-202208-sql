package edu.hanoi.Unit7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@ImportResource("classpath:config.xml")
public class Unit7Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Unit7Application.class,args);
        ctx.start();
    }

}
