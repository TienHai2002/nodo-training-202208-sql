package com.example.nodotraining.Unit1;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClazz implements DisposableBean {
    String message;
    List<JavaClazz> clazzes;
    public HelloClazz(int person) {
        message = "Form Constructor : Say Hello to " + person + "person(s)!";

    }

    public List<JavaClazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<JavaClazz> clazzes) {
        this.clazzes = clazzes;
    }

    public HelloClazz(HelloClazz clazz) {
        message = clazz.message;
    }

    private void initMessage() {

        System.out.println("Calling init Method ...");
        message = "Form init method : Say hello beans!";
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Call Form Setter : " + message;
    }

    public HelloClazz() {

    }

    public void printMessage() {
        System.out.println("Your Message : " + message);
    }

    private void release() {
        message = null;
        System.out.println("Message is null");
    }

    @Override
    public void destroy() throws Exception {
        message = null;
        System.out.println("message is null");
    }

}
