package com.retrolad.ch03.xml;

import com.retrolad.ch03.annotated.Singer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DependsOnDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-01.xml");
        ctx.getBean("singer", Singer.class).sing();
    }
}
