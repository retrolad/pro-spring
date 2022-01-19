package com.retrolad;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml.xml");
        MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
        digester.digest("Hello, World");
    }
}
