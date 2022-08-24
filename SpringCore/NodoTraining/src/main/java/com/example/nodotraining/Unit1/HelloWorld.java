package com.example.nodotraining.Unit1;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
    @Autowired(required = true)
    @Qualifier("helloJavaClazz2")
    private HelloClazz clazz;
    private final static Logger LOGGER = Logger.getLogger(HelloWorld.class);
    String message;

    public HelloWorld(String name, HelloClazz clazz) {
        message = "From HelloWorld contructor : " + name + ":" + clazz.getMessage();
    }

    public HelloWorld() {

    }

@Required
    public void setMessage(String value) {
        this.message = value;
    }

    public void sayHello() {

        LOGGER.info("From HelloWorld " + message);
    }

    public void setClazz(HelloClazz clazz) {
        this.clazz=clazz;
    }
}
