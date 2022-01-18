package com.retrolad.ch03.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FieldInjection {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");

        ctx.getBean(Singer.class).sing();
    }
}
