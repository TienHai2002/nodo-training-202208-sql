package com.example.nodotraining.Unit2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

public class JDBCApp {
    public static void main(String[] args) {

           ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
           StudentJDBCDAO jdbcdao = (StudentJDBCDAO) context.getBean("studentJDBCDAO");
           System.out.println("create bean " +jdbcdao);

    }
}
