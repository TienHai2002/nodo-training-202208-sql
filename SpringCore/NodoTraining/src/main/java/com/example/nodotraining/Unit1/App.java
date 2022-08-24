package com.example.nodotraining.Unit1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
        obj.printMessage();
        HelloClazz obj2 = (HelloClazz) context.getBean("helloJavaClazz");
        obj2.printMessage();
        System.out.println(obj2 == obj2);
        context.registerShutdownHook();
        HelloWorld obj3 = (HelloWorld) context.getBean("helloWorld");
        obj3 = (HelloWorld) context.getBean("helloWorld");
        obj3.sayHello();

        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
        System.out.println("map implements is " + clazz.getStudents().getClass());
        System.out.println("there are " + clazz.getStudents().size()+ "in the class");
        System.out.println("total classes is " + obj.getClazzes().size());
    }
}
