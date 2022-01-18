package com.retrolad.ch04;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

public class SingerWithJSR250 {
    private static final String DEFAULT_NAME = "Abel Makkonen Tesfaye";

    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing bean");

        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property" +
                    "of any bean of type " + SingerWithJSR250.class);
        }
    }

    @Override
    public String toString() {
        return "SingerWithInterface{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new GenericXmlApplicationContext("spring/app-context-annotation.xml");

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
    }

    public static SingerWithJSR250 getBean(String beanName, ApplicationContext ctx) {
        try {
            SingerWithJSR250 singer = ctx.getBean(beanName, SingerWithJSR250.class);
            System.out.println(singer);
            return singer;
        } catch(BeanCreationException ex) {
            System.out.println("An error occurred in bean " +
                    "configuration: " + ex.getMessage());
            return null;
        }
    }
}
