package com.retrolad.ch04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PlaceholderDemo {
    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-xml.xml");
        AppProperty appProperty = ctx.getBean(AppProperty.class);

        System.out.println(appProperty.getApplicationHome());
        System.out.println(appProperty.getUserHome());
    }
}
