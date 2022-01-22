package com.retrolad.ch05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml.xml");
        NewDocumentarist documentarist = ctx.getBean("documentarist", NewDocumentarist.class);

        documentarist.execute();
    }
}
