package com.retrolad.ch03.annotated;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AnnotatedDependsOnDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-02.xml");
        ctx.getBean(Singer.class).sing();
    }
}
